package pl.KamilJacko.lambdaExpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    @FunctionalInterface
    interface Checker<T> {
        boolean check(T obj);
    }

    public static void main(String[] args) {
         final int i = 0;
        //  annonymous class (class is created)
//        Checker<Integer> ww = new Checker<Integer>() {
//            @Override
//            public boolean check(Integer obj) {
//                return obj % 2!=0;
//            }
//        };

        //lambda (only for functional interfaces)
        Checker<Integer> ww = obj -> obj % 2 != 0;
        System.out.println(ww.check(5));
        System.out.println(ww.getClass());

        //??
        List<Integer> in = new ArrayList<>();
        in.add(2);
        in.add(7);
        // System.out.println((Checker<Integer>) obj -> obj % 2 != 0);
        ww = obj -> obj % 3 == 0;
        System.out.println(ww.check(6));


        List<Integer> numbs = Arrays.asList(1, 2, 3, 4, 5);
        numbs.forEach(System.out::println);

        //////////////////
        Main.nicImpl(() -> {
//            int i = 0;
//            i++;
            System.out.println("okey");
            System.out.println(i); // i has to be final (no change) otherwise it may get out synchronized
        });                         //the value of i may change only within lambda's scope

        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Kamil", "23"));
        customers.add(new Customer("Michal", "21"));
        customers.add(new Customer("Robert", "19"));

        for (Customer customer : customers) { //for each iteration of an enhanced for loop a new local variable customer is created and remains final
            System.out.println(customer.getName());
            new Thread(() -> System.out.println(customer.getAge())).start();
        }
    }

    public static void nicImpl(nic nic1) {
        nic1.saySth();
    }
}

interface nic {
    int NUM = 0; //public static final

    void saySth();

//    default String saySthElse(){
//       return sayJustHere();
//    }
    //java 9
//    private String sayJustHere(){
//        return "private words";
//    }
}


class Customer {
    private String name;
    private String age;

    public Customer(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}