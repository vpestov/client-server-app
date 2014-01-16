package com.client_server.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;

public class    ChatServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChatServer.class);

    public void createServer(int port){
        try{
            ServerSocket serverSocket = new ServerSocket(port);
        }catch (IOException e ){
            LOGGER.error("Could not open server socket with port : {}", port);
        }

    }

}
