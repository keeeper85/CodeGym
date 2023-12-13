package com.codegym.task.task40.task4005;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/* 
Socket server and client

You have a server that receives incoming messages from clients and responds using echo.
You have clients that read messages from the keyboard and send them to the server.
The program starts, but it doesn't work.
Figure out what the problem is and make the smallest possible changes to the code to make it work.

*/

public class Client {
    private Connection connection;

    private String getServerAddress() {
        return "localhost";
    }

    private int getServerPort() {
        return 4444;
    }

    public void run() {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        try {
            connection = new Connection(new Socket(getServerAddress(), getServerPort()));

            SocketThread socketThread = new SocketThread();
            socketThread.setDaemon(true);
            socketThread.start();

            while (true) {
                String text = bis.readLine();
                if (text.equalsIgnoreCase("exit"))
                    break;
                connection.send(text);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    public class SocketThread extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    String message = connection.receive();
                    System.out.println(message);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}