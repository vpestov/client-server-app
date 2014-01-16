package com.client_server.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    public static void main (String [] args){
        final String path = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        final int port = 6666;
        ServerSocket serverSocket;
        Socket socket = null;
        try {
            serverSocket = new ServerSocket(port);
            LOGGER.info("server socket created. Waiting for     a client");

            socket = serverSocket.accept();
            LOGGER.info("Got a client");

            final InputStream inputStream = socket.getInputStream();
            final OutputStream outputStream = socket.getOutputStream();

            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

            String line = null;

            while (true){
                line = dataInputStream.readUTF();
                System.out.println("client wrote :" + line);
                dataOutputStream.writeUTF("got your message : " + line);
                dataOutputStream.flush();
            }


        }catch (IOException e){
            e.printStackTrace();
            LOGGER.error("Could not create server socket with the port : {}", port);
        }finally {
            if(socket != null){
                try {
                    socket.close();
                }catch (IOException e){
                    LOGGER.error("Could not close socket");
                }
            }

        }

    }
}
