package com.streams_homework;

import java.math.BigInteger;
import java.util.stream.Stream;

public class PrimeNumbers {
    public static void primeFounder(int count){
        Stream<BigInteger> stream = Stream.iterate(new BigInteger("10000000000000000000000000000000000000000000000000"),
                bigInteger -> bigInteger.add(BigInteger.ONE)).filter(bigInteger -> bigInteger.isProbablePrime(1)).
                limit(count);
        Stream<BigInteger> streamParallel = Stream.iterate(new BigInteger("10000000000000000000000000000000000000000000000000"),
                bigInteger -> bigInteger.add(BigInteger.ONE)).parallel().filter(bigInteger -> bigInteger.isProbablePrime(1)).
                limit(count);
        long timeStartStream = System.currentTimeMillis();
        stream.forEach(bigInteger -> System.out.print(" " + bigInteger + " "));
        long timeStopStream = System.currentTimeMillis();
        long timeStartStreamParallel = System.currentTimeMillis();
        streamParallel.forEach(bigInteger -> System.out.print(" " + bigInteger + " "));
        long timeStopStreamParallel = System.currentTimeMillis();

        System.out.print("\nTime stream: " + (timeStopStream - timeStartStream) + "\n" +
                "Time stream Parallel: " + (timeStopStreamParallel - timeStartStreamParallel) + "\n");

    }

}
