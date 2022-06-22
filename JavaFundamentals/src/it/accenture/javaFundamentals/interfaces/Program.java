package it.accenture.javaFundamentals.interfaces;

public class Program {
    public static void main(String[] args) {
        Developer d1 = new Developer();
        Superhero s1 = new Superhero();
        listenTo(d1);
        listenTo(s1);
        Developer d2 = new Developer();
        Iterable<Developer> devs = d2.recruit();
        for(Developer d: devs) {
            //stuff
        }

    }

    //polymorphic method, thanks to Person interface
    public static void listenTo(Person p) {
        p.speak();
    }
}
