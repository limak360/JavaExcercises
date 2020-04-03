package pl.kamiljacko.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> someNumbs = Arrays.asList("B21", "b13", "I22", "B17",
                "B66", "b99", "I41");

        someNumbs.stream()
                .map(String::toUpperCase)
                .filter(b->b.startsWith("B"))
                .sorted()
                .forEach(System.out::println);

        Stream<String> cbNumberStream = Stream.of("C12","C78","B11","B39");
        Stream<String> gbNumberStream = Stream.of("B11","B39","G32","G54");
        Stream<String> concatStream = Stream.concat(cbNumberStream,gbNumberStream);
        System.out.println("*******************");
        System.out.println(concatStream
                            .distinct()
                            .peek(System.out::println)
                            .count());
    }
}
