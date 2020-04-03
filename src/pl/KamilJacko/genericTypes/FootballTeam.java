package pl.KamilJacko.genericTypes;

public class FootballTeam
        extends Team {
    private String name;
    private int points;

    public FootballTeam(String name, int points) {
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
