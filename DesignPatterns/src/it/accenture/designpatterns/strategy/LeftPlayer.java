package it.accenture.designpatterns.strategy;

public class LeftPlayer extends AbstractPlayer {

    public LeftPlayer() {
        this.attackStrategy = new AggressiveAttack();
        this.defenseStrategy = new AggressiveDefense();
    }

    @Override
    public void changeStrategy(int teamPoints) {
        if(teamPoints < 16) {
            this.attackStrategy = new StrategicAttack();
            this.defenseStrategy = new StrategicDefense();
        }
    }
}
