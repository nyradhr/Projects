package it.accenture.designpatterns.strategy;

public class Scoreboard {

    //private static Scoreboard uniqueInstance; //singleton, if it doesn't work we revert to normal
    static int teamOneScore;
    static int teamTwoScore;

    //private Scoreboard() {}

    /*
    public static Scoreboard getInstance() {
        if(uniqueInstance == null) {
            uniqueInstance = new Scoreboard();
        }
        return uniqueInstance;
    }
     */

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
