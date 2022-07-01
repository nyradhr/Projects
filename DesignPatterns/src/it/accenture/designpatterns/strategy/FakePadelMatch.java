package it.accenture.designpatterns.strategy;

import java.util.Random;

public class FakePadelMatch {

    public static void main(String[] args) {
        RightPlayer rp1 = new RightPlayer();
        LeftPlayer lp1 = new LeftPlayer();
        RightPlayer rp2 = new RightPlayer();
        LeftPlayer lp2 = new LeftPlayer();
        Random random = new Random();
        boolean teamOneStarts;
        boolean rightPlayerStarts;

        rp1.setTeam("teamOne");
        lp1.setTeam("teamOne");
        rp2.setTeam("teamTwo");
        lp2.setTeam("teamTwo");

        teamOneStarts = random.nextDouble() < 0.5;
        rightPlayerStarts = random.nextDouble() < 0.5;

        AbstractPlayer server = null;
        String servingTeam = "";
        String receivingTeam = "";

        if(teamOneStarts && rightPlayerStarts) {
            server = rp1;
            servingTeam = rp1.getTeam();
        } else if(teamOneStarts && !rightPlayerStarts) {
            server = lp1;
            servingTeam = lp1.getTeam();
        } else if(!teamOneStarts && rightPlayerStarts) {
            server = rp2;
            servingTeam = rp2.getTeam();
        } else if(!teamOneStarts && !rightPlayerStarts){
            server = lp2;
            servingTeam = lp2.getTeam();
        }

        if(servingTeam.equals("teamOne")) {
            receivingTeam = "teamTwo";
        } else if(servingTeam.equals("teamTwo")) {
            receivingTeam = "teamOne";
        }

        System.out.println("Serving team: "+servingTeam);
        System.out.println("Receiving team: "+receivingTeam);

        Scoreboard.resetPoints();

        System.out.println("Match start!");

        server.attack(servingTeam);

        while(Scoreboard.teamOneScore < 16 && Scoreboard.teamTwoScore < 16)  {
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

        System.out.println("Change fields!");
        System.out.println("Team One score: "+Scoreboard.teamOneScore);
        System.out.println("Team Two score: "+Scoreboard.teamTwoScore);
        System.out.println("Match resumes!");

        //teams change strategy after one of them reaches 16 pts
        rp1.changeStrategy(Scoreboard.teamOneScore);
        rp2.changeStrategy(Scoreboard.teamTwoScore);
        lp1.changeStrategy(Scoreboard.teamOneScore);
        lp2.changeStrategy(Scoreboard.teamTwoScore);

        //match resumes
        while(isGameNotOver())  {
            if(receivingTeam.equals("teamOne")) {
                if(random.nextDouble() < 0.5) {
                    rp1.defend(rp1.getTeam());
                    if (isGameNotOver()) {
                        rp1.attack(rp1.getTeam());
                    }
                } else {
                    lp1.defend(lp1.getTeam());
                    if (isGameNotOver()) {
                        lp1.attack(lp1.getTeam());
                    }
                }
                receivingTeam = "teamTwo";
            } else if(receivingTeam.equals("teamTwo")) {
                if(random.nextDouble() < 0.5) {
                    rp2.defend(rp2.getTeam());
                    if (isGameNotOver()) {
                        rp2.attack(rp2.getTeam());
                    }
                } else {
                    lp2.defend(lp2.getTeam());
                    if (isGameNotOver()) {
                        lp2.attack(lp2.getTeam());
                    }
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

    public static boolean isGameNotOver() {
        return !(Scoreboard.teamOneScore > 20 || Scoreboard.teamTwoScore > 20);
    }
}
