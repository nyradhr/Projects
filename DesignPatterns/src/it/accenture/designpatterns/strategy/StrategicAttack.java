package it.accenture.designpatterns.strategy;

import java.util.Random;

public class StrategicAttack implements AttackStrategy{
    @Override
    public void attack(String team) {
        Random random = new Random();
        if(random.nextDouble() < 0.33) {
            Scoreboard.scorePoint(team);
        }
    }
}
