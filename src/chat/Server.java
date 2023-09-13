package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Server {

    private ServerSocket ss;
    private final Set<PrintWriter> clientWriters = Collections.synchronizedSet(new HashSet<>());

    public Server() {
        try {
            System.out.println("Waiting for clients...");
            ss = new ServerSocket(9806);

            while (true) {
                Socket soc = ss.accept();
                System.out.println("Connection established with: " + soc.getInetAddress().getHostAddress());

                PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
                synchronized(clientWriters) {
                    clientWriters.add(out);
                }
                new Thread(new ClientHandler(soc, out)).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void broadcastMessage(String message) {
        synchronized(clientWriters) {
            for (PrintWriter writer : clientWriters) {
                writer.println(message);
            }
        }
    }

    private class ClientHandler implements Runnable {
        private Socket clientSocket;
        private PrintWriter clientOut;

        public ClientHandler(Socket socket, PrintWriter out) {
            this.clientSocket = socket;
            this.clientOut = out;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String str;
                while ((str = in.readLine()) != null) {
                    System.out.println("Received: " + str);
                    broadcastMessage(str);
                }

                synchronized(clientWriters) {
                    clientWriters.remove(clientOut);
                }
                clientSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}