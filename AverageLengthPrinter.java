package com.streams_homework;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AverageLengthPrinter {
    public static double getAverageLength(Stream<String> words) {
        return words.collect(Collectors.summarizingInt(String::length)).getAverage();
    }
    public static void printAverageLength(String path){
        try {
            String contents = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
            Stream<String> words = Pattern.compile("[\\P{L}]+").splitAsStream(contents);
            System.out.println(getAverageLength(words));

        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
