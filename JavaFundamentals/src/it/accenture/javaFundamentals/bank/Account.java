package it.accenture.javaFundamentals.bank;

public abstract class Account {

    protected double balance;

    public Account(double bal) {
        balance = bal;
    }

    public abstract double deposit(double amount);

    public double withdraw(double amount) {
        balance -= amount;
        return balance;
    }

    public double transfer (double amount, Account other) {
        this.withdraw(amount);
        other.deposit(amount);
        return balance;
    }




}
