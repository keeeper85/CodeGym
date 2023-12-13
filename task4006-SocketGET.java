package com.codegym.task.task40.task4006;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;

/* 
Rewrite the implementation of the getSite method.
It must explicitly create and use a Socket connection with the server.
The server address and parameters for the GET request should be retrieved from the url parameter.
Use the default port for HTTP (80). Don't use HttpURLConnection, HttpClient, etc. Don't leave commented code.

*/

public class Solution {
    public static void main(String[] args) throws Exception {
        getSite(new URL("http://codegym.cc"));
    }

    public static void getSite(URL url) {
        String server = url.getHost();
        String path = url.getPath();

        try (Socket socket = new Socket(server, 80);
             PrintStream out = new PrintStream(socket.getOutputStream());
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println("GET " + path);
            out.println();

            String line = in.readLine();
            while (line != null) {
                System.out.println(line);
                line = in.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}