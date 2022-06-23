package it.accenture.javaFundamentals.bank;

public class InsufficientBalanceException extends Exception{
    private double balance;
    private double requestedAmount;

    public InsufficientBalanceException(String message, double balance, double requestedAmount) {
        super(message);
        this.balance = balance;
        this.requestedAmount = requestedAmount;
    }

    public double getBalance() {
        return balance;
    }

    public double getRequestedAmount() {
        return requestedAmount;
    }
}
