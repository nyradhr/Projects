package it.accenture.designpatterns.strategy.fakepadel.implementation.strategies.attack;

import it.accenture.designpatterns.strategy.fakepadel.implementation.Scoreboard;
import it.accenture.designpatterns.strategy.fakepadel.abstraction.strategies.AttackStrategy;

import java.util.Random;

public class StrategicAttack implements AttackStrategy {
    @Override
    public void attack(String team) {
        Random random = new Random();
        if(random.nextInt(3) == 0) { // 1/3 chance
            Scoreboard.scorePoint(team);
        }
    }
}
