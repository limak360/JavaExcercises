package pl.KamilJacko.collections.sets;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Set<String> names = new HashSet<>();
        String x;
        while (1==1) {
            x = in.nextLine();
            if (!x.equals("-")) {
                names.add(x);
            } else break;
        }
        for (String i : names) {
            System.out.println(i);
        }
    }
}
