package it.accenture.javaFundamentals.bank;

public class GoldAccount extends Account {

    protected int fidelityPoints;

    public GoldAccount(double balance, int fidelityPoints) {
        super(balance);
        this.fidelityPoints = fidelityPoints;
    }

    public GoldAccount(double balance) {
        this(balance, 0);
    }

    public double convertFidelityPoints() {
        balance += fidelityPoints;
        fidelityPoints = 0;
        return balance;
    }

    @Override
    public double deposit(double amount) {
        //super.deposit(amount);
        balance += amount;
        fidelityPoints++;
        return balance;
    }
}
