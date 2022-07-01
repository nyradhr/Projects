package it.accenture.designpatterns.strategy.fakepadel.implementation;

import it.accenture.designpatterns.strategy.fakepadel.abstraction.players.AbstractPlayer;
import it.accenture.designpatterns.strategy.fakepadel.implementation.players.LeftPlayer;
import it.accenture.designpatterns.strategy.fakepadel.implementation.players.RightPlayer;

import java.util.Random;

public class FakePadelMatch {
    protected static Team servingTeam;
    protected static Team receivingTeam;
    protected static AbstractPlayer server;
    protected static Random random = new Random();

    public static void match() {

        Team t1 = new Team(new RightPlayer(), new LeftPlayer(),"teamOne");
        Team t2 = new Team(new RightPlayer(), new LeftPlayer(), "teamTwo");

        Scoreboard.resetPoints();

        chooseServer(t1,t2);

        System.out.println("Match start!");

        server.attack(servingTeam.getName());

        playFirstHalf(t1,t2);

        System.out.println("Change fields!");
        System.out.println("Team One score: "+Scoreboard.getTeamOneScore());
        System.out.println("Team Two score: "+Scoreboard.getTeamTwoScore());

        changeStrategy(t1,t2); //teams change strategy after one of them reaches 16 pts

        System.out.println("Match resumes!");

        playSecondHalf(t1,t2);

        System.out.println("End of Match!");
        System.out.println("Team One score: "+Scoreboard.getTeamOneScore());
        System.out.println("Team Two score: "+Scoreboard.getTeamTwoScore());
        if(Scoreboard.getTeamOneScore() > 20) {
            System.out.println("Team One Wins!");
        } else {
            System.out.println("Team Two Wins!");
        }
    }

    public static boolean firstHalfIsNotOver() {
        return !(Scoreboard.getTeamOneScore() > 15 || Scoreboard.getTeamTwoScore() > 15);
    }

    public static boolean gameIsNotOver() {
        return !(Scoreboard.getTeamOneScore() > 20 || Scoreboard.getTeamTwoScore() > 20);
    }

    public static void chooseServer(Team t1, Team t2) {
        boolean teamOneStarts = random.nextInt(2) == 0; // 1/2 chance
        boolean rightPlayerStarts = random.nextInt(2) == 0; // 1/2 chance

        if(teamOneStarts && rightPlayerStarts) {
            server = t1.getRightPlayer();
            servingTeam = t1;
        } else if(teamOneStarts) {
            server = t1.getLeftPlayer();
            servingTeam = t1;
        } else if(rightPlayerStarts) {
            server = t2.getRightPlayer();
            servingTeam = t2;
        } else {
            server = t2.getLeftPlayer();
            servingTeam = t2;
        }

        if(servingTeam == t1) {
            receivingTeam = t2;
        } else {
            receivingTeam = t1;
        }

        System.out.println("Serving team: "+servingTeam.getName());
        System.out.println("Receiving team: "+receivingTeam.getName());
    }

    public static void playFirstHalf(Team t1, Team t2) {
        while(firstHalfIsNotOver())  {
            if(receivingTeam == t1) {
                if(random.nextInt(2) == 0) {
                    t1.getRightPlayer().defend(t1.getName());
                    if(firstHalfIsNotOver()) {
                        t1.getRightPlayer().attack(t1.getName());
                    }
                } else {
                    t1.getLeftPlayer().defend(t1.getName());
                    if(firstHalfIsNotOver()) {
                        t1.getLeftPlayer().attack(t1.getName());
                    }
                }
                receivingTeam = t2;
            } else {
                if(random.nextInt(2) == 0) {
                    t2.getRightPlayer().defend(t2.getName());
                    if(firstHalfIsNotOver()) {
                        t2.getRightPlayer().attack(t2.getName());
                    }
                } else {
                    t2.getLeftPlayer().defend(t2.getName());
                    if(firstHalfIsNotOver()) {
                        t2.getLeftPlayer().attack(t2.getName());
                    }
                }
                receivingTeam = t1;
            }
        }
    }

    public static void changeStrategy(Team t1, Team t2) {
        if(Scoreboard.getTeamOneScore() > 15){
            t1.getRightPlayer().changeStrategy();
            t2.getLeftPlayer().changeStrategy();
        } else {
            t2.getRightPlayer().changeStrategy();
            t1.getLeftPlayer().changeStrategy();
        }
    }

    public static void playSecondHalf(Team t1, Team t2) {
        while (gameIsNotOver()) {
            if (receivingTeam == t1) {
                if (random.nextInt(2) == 0) {
                    t1.getRightPlayer().defend(t1.getName());
                    if (gameIsNotOver()) {
                        t1.getRightPlayer().attack(t1.getName());
                    }
                } else {
                    t1.getLeftPlayer().defend(t1.getName());
                    if (gameIsNotOver()) {
                        t1.getLeftPlayer().attack(t1.getName());
                    }
                }
                receivingTeam = t2;
            } else {
                if (random.nextInt(2) == 0) {
                    t2.getRightPlayer().defend(t2.getName());
                    if (gameIsNotOver()) {
                        t2.getRightPlayer().attack(t2.getName());
                    }
                } else {
                    t2.getLeftPlayer().defend(t2.getName());
                    if (gameIsNotOver()) {
                        t2.getLeftPlayer().attack(t2.getName());
                    }
                }
                receivingTeam = t1;
            }
        }
    }

}
