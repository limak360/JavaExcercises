package pl.kamiljacko.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

//        List<String> someNumbs = Arrays.asList("B21", "b13", "I22", "B17",
//                "B66", "b99", "I41");
//
//        someNumbs.stream()
//                .map(String::toUpperCase)
//                .filter(b -> b.startsWith("B"))
//                .sorted()
//                .forEach(System.out::println);
//
//        Stream<String> cbNumberStream = Stream.of("C12", "C78", "B11", "B39");
//        Stream<String> gbNumberStream = Stream.of("B11", "B39", "G32", "G54");
//        Stream<String> concatStream = Stream.concat(cbNumberStream, gbNumberStream);
//        System.out.println("*******************");
//        System.out.println(concatStream
//                .distinct()
//                .peek(System.out::println)
//                .count());
//
//        System.out.println("*******************");
//        List<String> sortedBNumbs = someNumbs
//                .stream()
//                .map(String::toUpperCase)
//                .filter(n -> n.startsWith("B"))
//                .sorted()
//                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
//
//        sortedBNumbs.forEach(System.out::println);

        //collectors arrays
        List<Integer> ints = Arrays.asList(12, 33, 57, 11);
        List<Integer> sorted = ints.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sorted);

    }
}
