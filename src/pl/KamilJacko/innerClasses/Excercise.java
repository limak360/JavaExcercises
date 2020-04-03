package pl.KamilJacko.innerClasses;

import java.util.*;

public class Excercise {

    public static void main(String[] args) {

        List<String> list = new ArrayList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("add words");
        while (list.size() < 5) {
            list.add(scanner.nextLine());
        }

        System.out.println(list.toString());

        //sorted
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        System.out.println(list.toString());
    }
}
