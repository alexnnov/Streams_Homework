package com.streams_homework;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordWithVowelsPrinter {
    private static boolean isAlphabetic(String word) {
        long count = Arrays.stream(word.split("")).flatMap(s -> Arrays.stream(vowels).
                map(s1 -> s1.equals(s))).filter(aBoolean -> aBoolean.equals(true)).count();
        if (count >= 5)
            return true;
        else
            return false;

    }

    private static String[] vowels = {"а", "у", "е", "о", "я", "и", "ю", "э","ы"};

    public static void printWords(String fileString){


        try (Stream<String> stream = Files.lines(Paths.get(fileString))) {
            List<String> allWords = stream.flatMap(s -> Arrays.stream(s.split(" "))).
                    filter(s -> isAlphabetic(s)).collect(Collectors.toList());
            allWords.forEach(s -> System.out.println(" " + s + " "));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
