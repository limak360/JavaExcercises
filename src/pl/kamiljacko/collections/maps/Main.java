package pl.kamiljacko.collections.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, String> names = new HashMap<>();
        String x, y;

        for (; ; ) {
            System.out.print("Podaj imiona pary : ");
            x = in.nextLine();
            y = in.nextLine();
            if (!x.equals("-") || !y.equals("-")) {
                names.put(x, y);
            } else break;
        }
        System.out.print("Podaj dowolne imie pary : ");
        x = in.nextLine();
        if (names.containsKey(x)) {
            System.out.println(names.get(x));
        } else if (names.containsValue(x)) {
            for (String i : names.values()) {
                System.out.println(names.entrySet());
            }
        } else {
            System.out.println("nie znaleziono imienia");
        }
    }
}