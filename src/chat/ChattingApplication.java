package chat;

import java.net.InetAddress;

public class ChattingApplication {

    public static void main(String[] args) {

        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println(ip.getHostAddress());
            if (ip.getHostAddress().equals("192.168.1.245")) {
                
                Thread serverThread = new Thread(() -> {
                    new Server();
                });
                serverThread.start();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("pinged for client creation");
            } else {
                System.out.println("Server error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        new Frame();
        

    }
}
