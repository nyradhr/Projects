package it.accenture.designpatterns.strategy.fakepadel.implementation.players;

import it.accenture.designpatterns.strategy.fakepadel.abstraction.players.AbstractPlayer;
import it.accenture.designpatterns.strategy.fakepadel.implementation.strategies.attack.AggressiveAttack;
import it.accenture.designpatterns.strategy.fakepadel.implementation.strategies.defense.AggressiveDefense;
import it.accenture.designpatterns.strategy.fakepadel.implementation.strategies.attack.StrategicAttack;
import it.accenture.designpatterns.strategy.fakepadel.implementation.strategies.defense.StrategicDefense;

public class LeftPlayer extends AbstractPlayer {

    public LeftPlayer() {
        this.setAttackStrategy(new AggressiveAttack());
        this.setDefenseStrategy(new AggressiveDefense());
    }

    @Override
    public void changeStrategy() {
        this.setAttackStrategy(new StrategicAttack());
        this.setDefenseStrategy(new StrategicDefense());
    }
}
