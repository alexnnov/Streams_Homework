package com.streams_homework;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class MaxLengthStringPrinter {
    public static String[] getWordsOfMaxLength(Stream<String> wordsStream) {
        String[] words = wordsStream.toArray(String[]::new);
        Supplier<Stream<String>> wordsSupplier = () -> Stream.of(words);

        Optional<String> max = wordsSupplier.get().max(Comparator.comparingInt(String::length));
        int maxLen = max.orElse("").length();
        return wordsSupplier.get().filter(s -> s.length() == maxLen).toArray(String[]::new);
    }
    public static void printMaxLengthStrings(String path){
        try {
            String contents = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
            Stream<String> words = Pattern.compile("[\\P{L}]+").splitAsStream(contents);
            System.out.println(Arrays.toString(getWordsOfMaxLength(words)));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
