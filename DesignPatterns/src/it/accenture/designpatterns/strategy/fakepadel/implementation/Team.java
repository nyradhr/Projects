package it.accenture.designpatterns.strategy.fakepadel.implementation;

import it.accenture.designpatterns.strategy.fakepadel.abstraction.players.AbstractPlayer;

public class Team {
    protected AbstractPlayer rightPlayer;
    protected AbstractPlayer leftPlayer;
    protected String teamName;

    public Team(AbstractPlayer rp, AbstractPlayer lp, String name) {
        rightPlayer = rp;
        leftPlayer = lp;
        teamName = name;
    }

    public String getName() {
        return teamName;
    }
    public AbstractPlayer getRightPlayer() {
        return rightPlayer;
    }
    public AbstractPlayer getLeftPlayer() {
        return leftPlayer;
    }
}
