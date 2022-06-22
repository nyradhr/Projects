package it.accenture.javaFundamentals.bank;

public class ProgrammerAccount extends Account{

    public ProgrammerAccount(double balance) {
        super(balance);
    }

    @Override
    public double deposit(double amount) {
        balance += 0.9*amount;
        return balance;
    }
}
