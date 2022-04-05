package com.nsofttask.util;

import com.google.gson.Gson;
import com.nsofttask.model.Market;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.file.Files;

public class FileReader {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileReader.class.getName());

    public static String getResourceFileAsString(String fileName) {

        String content = null;
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:data/" + fileName);
        } catch (Exception e) {
            LOGGER.error("File " + fileName + " not found");
            e.printStackTrace();
        }


        try {
            content = new String(Files.readAllBytes(file.toPath()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }

}
