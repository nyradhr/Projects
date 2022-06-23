package it.accenture.javaFundamentals.bank;

public abstract class Account {

    protected double balance;

    public Account(double bal) {
        balance = bal;
    }

    public abstract double deposit(double amount);

    public double withdraw(double amount) throws InsufficientBalanceException {
        /*
        //brutto, no thx
        if(amount > balance){
            System.out.println("saldo non disponibile");
            return balance;
        }

         */

        if(amount > balance){
            throw new InsufficientBalanceException("Saldo non disponibile", balance, amount);
        }
        balance -= amount;
        return balance;
    }

    public double transfer (double amount, Account other) throws InsufficientBalanceException {
        this.withdraw(amount);
        other.deposit(amount);
        return balance;
    }




}
