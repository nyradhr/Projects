package it.accenture.designpatterns.strategy;

public class RightPlayer extends AbstractPlayer {

    AttackStrategy attackStrategy;
    DefenseStrategy defenseStrategy;

    public RightPlayer() {
        attackStrategy = new StrategicAttack();
        defenseStrategy = new StrategicDefense();
    }

    @Override
    public void changeStrategy(int teamPoints) {
        if(teamPoints > 15) {
            attackStrategy = new AggressiveAttack();
            defenseStrategy = new AggressiveDefense();
        }
    }
}
