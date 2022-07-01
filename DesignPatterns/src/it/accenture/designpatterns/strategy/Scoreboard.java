package it.accenture.designpatterns.strategy;

public class Scoreboard {

    static int teamOneScore;
    static int teamTwoScore;

    public static void scorePoint(String team) {
        if (team.equals("teamOne")) {
            teamOneScore++;
        } else if (team.equals("teamTwo")) {
            teamTwoScore++;
        }
    }

    public static void concedePoint(String team) {
        if (team.equals("teamOne")) {
            teamTwoScore++;
        } else if(team.equals("teamTwo")){
            teamOneScore++;
        }
    }

    public static void resetPoints() {
        teamOneScore = 0;
        teamTwoScore = 0;
    }

}
