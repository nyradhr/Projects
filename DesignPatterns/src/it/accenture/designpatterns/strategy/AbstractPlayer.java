package it.accenture.designpatterns.strategy;

public abstract class AbstractPlayer {
    AttackStrategy attackStrategy;
    DefenseStrategy defenseStrategy;
    String team;

    public void attack(String team) {
        attackStrategy.attack(team);
    }

    public void defend(String team){
        defenseStrategy.defend(team);
    }

    public abstract void changeStrategy(int teamPoints);

    public String getTeam() {
        return team;
    };

    public void setTeam(String team) {
        this.team = team;
    }

    public AttackStrategy getAttackStrategy() {
        return this.attackStrategy;
    }

}
