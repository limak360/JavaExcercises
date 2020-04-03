package pl.KamilJacko.genericTypes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SportLeagueTable<T extends Team> {

    private List<T> leauge = new ArrayList<>();

    public void addTeams(T leauge) {
        this.leauge.add(leauge);
    }

    public void printTeams() {
        Collections.sort(leauge, (o1, o2) -> {
            if (o1.getPoints() > o2.getPoints()) return -1;
            else if (o1.getPoints() < o2.getPoints()) return 1;
            else return 0;
        });
        System.out.println(leauge);
    }
}
