package com.client_server.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    public static void main (String [] args){
        final String path = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        final int i = 15;
        LOGGER.info("testing Logger : {}",i);
        System.out.println(path);
    }
}
