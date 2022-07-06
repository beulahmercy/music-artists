package com.music.app.util;

import java.util.function.Function;
import java.util.stream.*;
import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.*;

public class CountOccuranceOfChar3
{
    public static void main(String args[])
    {
        String str= "Communication";
        Arrays.stream(str.split("")).forEach(System.out::println);
        Map<String, Long> result = Arrays.stream(str.split(""))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()));
        System.out.println(result);

        List<Integer> numbers = Arrays.asList(11, 2, 3, 4, 5, 6, 7, 5);

                numbers.stream()
                        .filter(n -> {
                            //System.out.println("filtering " + n);
                            return n % 2 == 0;
                        })
                        .map(n -> {
                            //System.out.println("mapping " + n);
                            return n * n;
                        })
                        .sorted(Comparator.reverseOrder())
                        //.limit(3)
                        .collect(Collectors.toList());

        Map sorted = result
                .entrySet() .stream() .sorted(comparingByKey())
                .collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));


        String i = "aasd";
        String e = "435345";

        System.out.println(i.equals(e));
        System.out.println(i == e);

        List<String> listOfStrings = Arrays.asList("Beulah", "Add1", "Add", "Mercy");
        Map<String, Long> results = listOfStrings.stream()
                .collect(groupingBy(Function.identity(), LinkedHashMap::new, counting() ));
        System.out.println(results);

        listOfStrings.stream().sorted(comparing(String::toString)).forEach(System.out::println);
                //.entrySet().stream().forEach(System.out::println);

        int b = 10;
        System.out.println(b >> 1);
    }
}  