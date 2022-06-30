package it.accenture.designpatterns.strategy;

public class LeftPlayer extends AbstractPlayer {

    AttackStrategy attackStrategy;
    DefenseStrategy defenseStrategy;

    public LeftPlayer() {
        attackStrategy = new AggressiveAttack();
        defenseStrategy = new AggressiveDefense();
    }

    @Override
    public void changeStrategy(int teamPoints) {
        if(teamPoints < 16) {
            attackStrategy = new StrategicAttack();
            defenseStrategy = new StrategicDefense();
        }
    }
}
