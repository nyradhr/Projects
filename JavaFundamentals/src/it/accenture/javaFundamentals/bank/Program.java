package it.accenture.javaFundamentals.bank;

public class Program {

    public static void main(String[] args) {
        Account a1 = new GoldAccount(1000);
        CaymanAccount c1 = new CaymanAccount(2000, "xyz");

        //spiegazione super-sub classes
        Account a2 = c1; //upcasting
        //Account a3 = new String("ciccio");
        //a3.deposit();
        //a2.deposit();
        Account a4 = new CaymanAccount(5,"o");
        //a4.evadeTaxes(); //a4 points to an Account Obj so it doesn't see this method
        CaymanAccount c2 = (CaymanAccount) a4; //downcasting
        //do not abuse downcasting
        c2.evadeTaxes();

    }
}
