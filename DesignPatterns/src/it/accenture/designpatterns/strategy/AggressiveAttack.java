package it.accenture.designpatterns.strategy;

import java.util.Random;

public class AggressiveAttack implements AttackStrategy {
    @Override
    public void attack(String team) {
        Random random = new Random();
        if(random.nextDouble() < 0.66) { // circa 2 times out of 3
            Scoreboard.scorePoint(team);
        } else {
            Scoreboard.concedePoint(team);
        }
    }
}
