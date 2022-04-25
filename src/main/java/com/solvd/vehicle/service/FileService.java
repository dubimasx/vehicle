package com.solvd.vehicle.service;

import com.solvd.vehicle.exceptions.FileServiceException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.LoggingPermission;
import java.util.stream.Stream;


public class FileService {
    private static final Logger LOGGER = LogManager.getLogger(FileService.class);

    public static void writeUniqueWordsCountToFile(String sourcePath, String writePath) {
       String content;
        try {
            content = FileUtils.readFileToString(new File(sourcePath), StandardCharsets.UTF_8).toLowerCase().replaceAll("[^\\da-zA-Zа-яёА-ЯЁ ]", "");
            if(content.length() == 0){
                throw new FileServiceException("File is empty");
            }

        } catch (IOException | FileServiceException e) {
            LOGGER.error("No file found");
            throw new RuntimeException("No file found");
        }
        String[] words = StringUtils.split(content, " ");
        Map<String, Integer> map = new HashMap<>();
        try (Stream<String> stream = Arrays.stream(words)){
            stream.forEach(i -> {
                int count = StringUtils.countMatches(content, i);
                map.put(i, count);
            });
        } catch (Exception e) {
            LOGGER.error("Unable to iterate stream");
        }
        map.forEach((k, v) -> {
            try {
                FileUtils.writeStringToFile(new File(writePath), k + " - " + v + "\n", StandardCharsets.UTF_8, true);
            } catch (IOException e) {
                LOGGER.error("Unable to write file to " + writePath);
                throw new RuntimeException("Unable to write file to " + writePath);
            }
        });
    }
}

