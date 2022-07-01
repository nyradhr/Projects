package it.accenture.designpatterns.strategy;

public class RightPlayer extends AbstractPlayer {

    public RightPlayer() {
        this.attackStrategy = new StrategicAttack();
        this.defenseStrategy = new StrategicDefense();
    }

    @Override
    public void changeStrategy(int teamPoints) {
        if(teamPoints > 15) {
            this.attackStrategy = new AggressiveAttack();
            this.defenseStrategy = new AggressiveDefense();
        }
    }
}
