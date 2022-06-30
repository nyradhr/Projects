package it.accenture.designpatterns.strategy;

import java.util.List;
import java.util.Random;

public class FakePadelMatch {
    //togliere main da qui, eventualmente assegnare a questa classe logica di gestione match
    //mettere scelta team nel main

    public static void main(String[] args) {
        AbstractPlayer rp1 = new RightPlayer();
        AbstractPlayer lp1 = new LeftPlayer();
        AbstractPlayer rp2 = new RightPlayer();
        AbstractPlayer lp2 = new LeftPlayer();
        Random random = new Random();
        boolean teamOneStarts = false;
        boolean rightPlayerStarts = false;

        //assigning teams; muovere nel main (Program.java)?
        rp1.setTeam("teamOne");
        lp1.setTeam("teamOne");
        rp2.setTeam("teamTwo");
        lp2.setTeam("teamTwo");

        if(random.nextDouble() < 0.5) {
            teamOneStarts = true;
        } else {
            teamOneStarts = false;
        }

        if(random.nextDouble() < 0.5){
            rightPlayerStarts = true;
        } else {
            rightPlayerStarts = false;
        }

        AbstractPlayer batter = null;
        String battingTeam = "";
        String receivingTeam = "";

        if(teamOneStarts && rightPlayerStarts) {
            batter = rp1;
            battingTeam = rp1.getTeam();
        } else if(teamOneStarts && !rightPlayerStarts) {
            batter = lp1;
            battingTeam = lp1.getTeam();
        } else if(!teamOneStarts && rightPlayerStarts) {
            batter = rp2;
            battingTeam = rp2.getTeam();
        } else if(!teamOneStarts && !rightPlayerStarts){
            batter = lp2;
            battingTeam = lp2.getTeam();
        }

        if(battingTeam.equals("teamOne")) {
            receivingTeam = "teamTwo";
        } else if(battingTeam.equals("teamTwo")) {
            receivingTeam = "teamOne";
        }

        System.out.println("Batting team: "+battingTeam);
        System.out.println("Receiving team: "+receivingTeam);

        Scoreboard.resetPoints();

        System.out.println("Match start!");

        System.out.println(batter.getClass());
        System.out.println(batter.getAttackStrategy().getClass()); //nullpointer su AttackStrategy
        batter.attack(battingTeam);

        while(Scoreboard.teamOneScore < 16 || Scoreboard.teamTwoScore < 16)  {
            if(receivingTeam.equals("teamOne")) {
                if(random.nextDouble() < 0.5) {
                    rp1.defend(rp1.getTeam());
                    rp1.attack(rp1.getTeam());
                } else {
                    lp1.defend(lp1.getTeam());
                    lp1.attack(lp1.getTeam());
                }
                receivingTeam = "teamTwo";
            } else if(receivingTeam.equals("teamTwo")) {
                if(random.nextDouble() < 0.5) {
                    rp2.defend(rp2.getTeam());
                    rp2.attack(rp2.getTeam());
                } else {
                    lp2.defend(lp2.getTeam());
                    lp2.attack(lp2.getTeam());
                }
                receivingTeam = "teamOne";
            }
        }

        System.out.println("Team One score: "+Scoreboard.teamOneScore);
        System.out.println("Team Two score: "+Scoreboard.teamTwoScore);

        //teams change strategy after one of them reaches 16 pts
        rp1.changeStrategy(Scoreboard.teamOneScore);
        rp2.changeStrategy(Scoreboard.teamTwoScore);
        lp1.changeStrategy(Scoreboard.teamOneScore);
        lp2.changeStrategy(Scoreboard.teamTwoScore);

        //match resumes
        while(Scoreboard.teamOneScore < 21 || Scoreboard.teamTwoScore < 21)  {
            if(receivingTeam.equals("teamOne")) {
                if(random.nextDouble() < 0.5) {
                    rp1.defend(rp1.getTeam());
                    rp1.attack(rp1.getTeam());
                } else {
                    lp1.defend(lp1.getTeam());
                    lp1.attack(lp1.getTeam());
                }
                receivingTeam = "teamTwo";
            } else if(receivingTeam.equals("teamTwo")) {
                if(random.nextDouble() < 0.5) {
                    rp2.defend(rp2.getTeam());
                    rp2.attack(rp2.getTeam());
                } else {
                    lp2.defend(lp2.getTeam());
                    lp2.attack(lp2.getTeam());
                }
                receivingTeam = "teamOne";
            }
        }

        System.out.println("End of Match!");
        System.out.println("Team One score: "+Scoreboard.teamOneScore);
        System.out.println("Team Two score: "+Scoreboard.teamTwoScore);
        if(Scoreboard.teamOneScore > 20) {
            System.out.println("Team One Wins!");
        } else {
            System.out.println("Team Two Wins!");
        }
    }
}
