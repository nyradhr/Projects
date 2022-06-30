package it.accenture.designpatterns.strategy;

import java.util.Random;

public class AggressiveDefense implements DefenseStrategy {
    //testare corretto funzionamento del metodo, doppio check su Math.random() non mi convince
    @Override
    public void defend(String team) { //change with Scoreboard
        Random random = new Random();
        if(random.nextDouble() < 0.20) {
            Scoreboard.scorePoint(team);
        } else if(random.nextDouble() < 0.40) {
            Scoreboard.concedePoint(team);
        }
    }
}
