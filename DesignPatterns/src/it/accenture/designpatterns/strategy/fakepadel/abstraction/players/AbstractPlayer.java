package it.accenture.designpatterns.strategy.fakepadel.abstraction.players;

import it.accenture.designpatterns.strategy.fakepadel.abstraction.strategies.AttackStrategy;
import it.accenture.designpatterns.strategy.fakepadel.abstraction.strategies.DefenseStrategy;

public abstract class AbstractPlayer {
    protected AttackStrategy attackStrategy;
    protected DefenseStrategy defenseStrategy;

    public void attack(String team) {
        attackStrategy.attack(team);
    }
    public void defend(String team){
        defenseStrategy.defend(team);
    }
    public abstract void changeStrategy();
    public void setAttackStrategy(AttackStrategy as){
        attackStrategy = as;
    }
    public void setDefenseStrategy(DefenseStrategy ds) {
        defenseStrategy = ds;
    }
}
