package com.streams_homework;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args) throws IOException {
        String pathToWandP=System.getProperty("user.dir")+"/src/voyna-i-mir-tom-1.txt";
        WordPrinter.printFirstWords(pathToWandP);
        WordPrinter.printTenPopularWords(System.getProperty(pathToWandP));
        AverageLengthPrinter.printAverageLength(pathToWandP);
        MaxLengthStringPrinter.printMaxLengthStrings(pathToWandP);
        WordWithVowelsPrinter.printWords(System.getProperty(pathToWandP));
       PrimeNumbers.primeFounder(500);
        //Time stream: 7171
        //Time stream Parallel: 4380
        LongWords.printLongWords(pathToWandP);

        List<Integer> listWithDuplicates = new ArrayList<>();
        listWithDuplicates.addAll(Arrays.asList(1, 1, 2, 2, 3, 3));
        listWithDuplicates.stream()
                .distinct()
                .collect(Collectors.toList()).forEach(System.out::println);


    }
    public static <T> boolean isFinite(Stream<T> stream) {
        return stream.findFirst().isPresent();
    }
}
