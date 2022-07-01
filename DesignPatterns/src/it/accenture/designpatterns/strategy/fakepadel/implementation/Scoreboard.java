package it.accenture.designpatterns.strategy.fakepadel.implementation;

public class Scoreboard {

    protected static int teamOneScore;
    protected static int teamTwoScore;

    public static void scorePoint(String team) {
        if(team.equals("teamOne")) {
            teamOneScore++;
        } else if(team.equals("teamTwo")) {
            teamTwoScore++;
        }
    }

    public static void concedePoint(String team) {
        if(team.equals("teamOne")) {
            teamTwoScore++;
        } else if(team.equals("teamTwo")){
            teamOneScore++;
        }
    }

    public static void resetPoints() {
        teamOneScore = 0;
        teamTwoScore = 0;
    }

    public static int getTeamOneScore(){
        return teamOneScore;
    }

    public static int getTeamTwoScore(){
        return teamTwoScore;
    }

}
