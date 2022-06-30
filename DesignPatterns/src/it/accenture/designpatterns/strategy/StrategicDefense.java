package it.accenture.designpatterns.strategy;

import java.util.Random;

public class StrategicDefense implements DefenseStrategy {
    @Override
    public void defend(String team) {
        Random random = new Random();
        if (random.nextDouble() < 0.20) {
            Scoreboard.scorePoint(team);
        }
    }
}
