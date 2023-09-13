package chat;

import java.io.*;
import java.net.Socket;

public class Client{
    
    private static Socket soc;
    private static BufferedReader in;
    private static PrintWriter out;
    private int position = 0;
    
    private MessageReceivedListener messageListener;

    Client(MessageReceivedListener listener) {
    	
    	this.messageListener = listener;
        
        try {
            System.out.println("Client started");
            soc = new Socket("192.168.1.245", 9806);

            in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            out = new PrintWriter(soc.getOutputStream(), true);

            new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = in.readLine()) != null) {
                    	messageListener.onMessageReceived(serverMessage, position);						
                        position++;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public static void sendMessage(String text) throws IOException {
        if (out != null) {
            out.println(text);
        } else {
            System.out.println("Error: Unable to send message. Connection might be closed.");
        }
    }



}
