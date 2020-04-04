package pl.kamiljacko.lambdaexpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Stream;

public class Challanges {
    public static void main(String[] args) {
        //1.
        Runnable runnable = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String p : parts) {
                System.out.println(p);
            }
        };
        runnable.run();

        //2.
        Function<String, String> sth = source -> {
            StringBuilder ret = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    ret.append(source.charAt(i));
                }
            }
            return ret.toString();
        };

        System.out.println(sth.apply("1234567890"));

        //3.4.5.
        System.out.println(everySecondCharacter(sth, "1234567890"));

        //6.
        Supplier<String> supp = () -> "IloveJava";

        //7.
        Supplier<String> suppResoult = supp;
        String suppResV2 = supp.get();
        System.out.println(suppResoult.get());
        System.out.println(suppResV2);

        //9.10.
        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "oliver",
                "Charlie",
                "jacob"
        );

        List<String> sortedNames = new ArrayList<>();
        topNames2015.forEach(names -> sortedNames.add(names.substring(0, 1).toUpperCase() + names.substring(1)));
        sortedNames.sort(String::compareTo);
        sortedNames.forEach(name -> System.out.println(name));


        /////////////////////////

        Supplier<Object> objectCreator = Object::new;
        // same as new Object()

        Object objectInstance = objectCreator.get();
        System.out.println(objectInstance);

        Predicate<Object> equalsMethodOnObject = objectInstance::equals;
        // same as objectInstace.equals(new Ojbect())
        System.out.println(equalsMethodOnObject.test(new Object()));

        BiPredicate<Object, Object> equalsMethodOnClass = Object::equals;
        // same as objectInstace.equals(new Ojbect())
        System.out.println(equalsMethodOnClass.test(objectInstance, new Object()));


        BiFunction<String,Integer,Employee> employee = Employee::new;
        Employee employee1 = employee.apply("Kamil",23);
        System.out.println(employee1.getName()+", "+employee1.getAge());

    }

    public static String everySecondCharacter(Function<String, String> s, String source) {
        return s.apply(source);
    }
}
