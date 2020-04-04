package pl.kamiljacko.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Challanges {
    public static void main(String[] args) {

        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "oliver",
                "Charlie",
                "jacob"
        );

        //11.
        topNames2015.stream()
                .map(names -> names.substring(0, 1).toUpperCase() + names.substring(1))
                .sorted()
                .forEach(System.out::println);

        //12.
        Long resoult = topNames2015.stream()
                .map(names -> names.substring(0, 1).toUpperCase() + names.substring(1))
                .filter(names -> names.toUpperCase().startsWith("A"))
                .distinct()
                .count();

        System.out.println(resoult);

        /////////////////
        List<List<String>> listOfLists = Arrays.asList(
                Arrays.asList("1", "2", "3"),
                Arrays.asList("a", "b", "c"),
                Arrays.asList("A", "B", "C"),
                Arrays.asList("!", "@", "#")
        );
        List<String> flatten = flatten(listOfLists);
        System.out.println(flatten);
    }

    private static <T> List<T> flatten(List<List<T>> listOfLists) {
        return listOfLists.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
