package com.streams_homework;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.*;

public class WordPrinter {
    public static void printFirstWords(String path)  {

        try {
            String contents = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
            Stream<String> words = Pattern.compile("[\\P{L}]+").splitAsStream(contents);
            words.limit(100).forEach(System.out::println);
        } catch(IOException e){
            System.out.println(e);
        }

    }
    public static void printTenPopularWords(String path) throws IOException{
        try{
            List<String> res;
            String contents = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
            Stream<String> words = Pattern.compile("[\\P{L}]+").splitAsStream(contents);
            Map<String, Integer> frequentCount = words.collect(Collectors.toMap(String::toLowerCase, x -> 1, Integer::sum));
            res = frequentCount.entrySet().stream().sorted((x, y) -> y.getValue() == x.getValue() ? x.getKey().compareTo(y.getKey())
                    : (y.getValue() - x.getValue())).limit(10).map(Map.Entry::getKey).collect(Collectors.toList());
            res.forEach(System.out::println);

        }
        catch(IOException e){
            e.printStackTrace();
        }


    }



}
