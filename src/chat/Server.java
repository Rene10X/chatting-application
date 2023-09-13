package chat;

import java.io.InputStreamReader;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket ss;

    public Server() {
        try {
            System.out.println("Waiting for clients...");
            ss = new ServerSocket(9806);

            while (true) {
                Socket soc = ss.accept();
                System.out.println("Connection established with: " + soc.getInetAddress().getHostAddress());

                new Thread(new ClientHandler(soc)).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String str;
                while ((str = in.readLine()) != null) {
                    out.println(str);
                }

                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}