package it.accenture.designpatterns.strategy.fakepadel.implementation.strategies.defense;

import it.accenture.designpatterns.strategy.fakepadel.implementation.Scoreboard;
import it.accenture.designpatterns.strategy.fakepadel.abstraction.strategies.DefenseStrategy;

import java.util.Random;

public class AggressiveDefense implements DefenseStrategy {
    @Override
    public void defend(String team) {
        Random random = new Random();
        if(random.nextDouble(5) == 0) { // 1/5 chance
            Scoreboard.scorePoint(team);
        } else if(random.nextInt(5) < 2) { // 2/5 chance
            Scoreboard.concedePoint(team);
        }
    }
}
