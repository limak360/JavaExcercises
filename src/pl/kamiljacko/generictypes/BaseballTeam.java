package pl.kamiljacko.generictypes;

public class BaseballTeam extends Team {
    private String name;
    private int points;

    BaseballTeam(String name, int points) {
        this.name = name;
        this.points = points;
    }

    @Override
    String getName() {
        return this.name;
    }

    @Override
    int getPoints() {
        return this.points;
    }

    @Override
    public String toString() {
        return name;
    }
}
