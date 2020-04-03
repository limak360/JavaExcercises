package pl.kamiljacko.generictypes;

public class Main {

    public static void main(String[] args) {

        Team ACMilan = new FootballTeam("ACMilan", 10);
        Team Liverpool = new FootballTeam("Liverpool", 37);

        SportLeagueTable<Team> footballLeauge = new SportLeagueTable<>();
        footballLeauge.addTeams(ACMilan);
        footballLeauge.addTeams(Liverpool);

        footballLeauge.printTeams();

        Team LosAngelesDodgers = new BaseballTeam("LosAngelesDodgers", 37);
        Team BostonRedSox = new BaseballTeam("BostonRedSox", 20);

        SportLeagueTable<Team> baseballLeauge = new SportLeagueTable<>();
        baseballLeauge.addTeams(LosAngelesDodgers);
        baseballLeauge.addTeams(BostonRedSox);

        baseballLeauge.printTeams();
    }
}
