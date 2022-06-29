package it.accenture.stream;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class StreamExamples {
    public static void main(String[] args) {
        Developer d1 = new Developer(1L, "Andrea", "Rossi", LocalDate.now(),
                "Java", 25, Sex.MALE, 2500);
        Developer d2 = new Developer(2L, "Sara", "Bianchi", LocalDate.of(1970, 5,20),
                "C++", 30, Sex.FEMALE, 3000);
        Developer d3 = new Developer(3L, "Fabio", "De Luigi", LocalDate.now(),
                "Python",20, Sex.MALE, 2000);
        Developer d4 = new Developer(4L, "Marika", "Lombardi", LocalDate.now(),
                "Java", 5, Sex.FEMALE, 1500);
        Developer d5 = new Developer(5L, "Janette", "Dubois", LocalDate.now(),
                "Rust", 10, Sex.FEMALE,1800);

        List<Developer> ld = List.of(d1,d2,d3,d4,d5);

        System.out.println("Income inequality flag is set to:");
        System.out.println(salaryDifferenceBetweenMalesAndFemales(ld));

        System.out.println("C++ developer older than 30 average salary:");
        System.out.println(olderThan30CPlusPlusDevAverageSalary(ld));

        System.out.println("The three most experienced developers:");
        List<Developer> topThree = (threeMostExperiencedDevs(ld));
        for (Developer developer : topThree) {
            System.out.println(developer.getFirstName());
        }

        System.out.println("The two most used languages:");
        List<String> ls = mostPopularLanguages(ld);
        for (String language : ls) {
            System.out.println(language);
        }

        System.out.println("Median of salaries:");
        System.out.println(salaryMedian(ld));

        System.out.println("Modal value of salaries:");
        System.out.println(salaryModalValue(ld));



    }

    public static double femaleOver30YearsSalarySum(List<Developer> ld) {
        double sum = 0;
        for(Developer d: ld) {
            if(d.getSex() == Sex.FEMALE && d.isOlderThan(30)) {
                sum += d.getSalary();
            }
        }
        return sum;
    }

    public static double streamFemaleOver30YearsSalarySum(List<Developer> ld) {
        return ld.stream().filter(d -> d.getSex()==Sex.FEMALE && d.isOlderThan(30))
                .mapToDouble(Developer::getSalary).sum();
        /*
        Predicate<Developer> pd = new Predicate<Developer>() {
            @Override
            public boolean test(Developer developer) {
                return false;
            }
        };
        */

    }

    public static double topNSeniorFemaleSalarySum(List<Developer> ld) {
        return ld.stream().filter(d -> d.getSex()==Sex.FEMALE && d.isOlderThan(30))
                .mapToDouble(Developer::getSalary).sorted().limit(10).sum(); //sum() operatore terminale
    }

    public static List<Developer> malesExpertInCPlusPlus(List<Developer> ld) {
        return ld.stream().filter(d -> d.getSex()==Sex.MALE &&
                d.getFavouriteLanguage().equals("C++")).collect(Collectors.toList());
        //double salarySum = x.stream().mapToDouble(Developer::getSalary).reduce(0, (d1,d2) -> d1+d2);
        //int ageProduct = x.stream().mapToInt(Developer::getAge).reduce(1, (d1,d2) -> d1*d2);
        //OptionalInt ageProduct2 = x.stream().mapToInt(Developer::getAge).reduce((d1, d2) -> d1*d2);

        //var y = x.limit(3); //stream sono detti "lazy"
        //var z = y.findFirst(); //operatore terminale
        //var w = y.collect(Collectors.toList()); //operatore terminale
        //riutilizzare uno stream impatta sulla performance
    }


    public static DeveloperSummaryData calculateSummaryData(List<Developer> ld) {

        return ld.stream().reduce(new DeveloperSummaryData(),
                DeveloperSummaryData::addDeveloper, DeveloperSummaryData::combine);
        /*
        DeveloperSummaryData result = x.stream()
                .reduce(new DeveloperSummaryData(),
                        (dsd, d) -> DeveloperSummaryData.addDeveloper(dsd, d),
                        (dsd1, dsd2) -> DeveloperSummaryData.combine(dsd1, dsd2));
         */
        // reduce(oggetto allo stato iniziale, lambda/method reference per accumulatore,
        // lambda/mf per combinatore se parallelismo)
    }


    //Diamo per scontato che ci siano almeno due elementi nella lista
    public static boolean salaryDifferenceBetweenMalesAndFemales(List<Developer> ld) {

        OptionalDouble femaleSalary = ld.stream()
                .filter(d -> d.getSex() == Sex.FEMALE)
                .mapToDouble(Developer::getSalary)
                .max();
        OptionalDouble maleSalary = ld.stream()
                .filter(d -> d.getSex() == Sex.MALE)
                .mapToDouble(Developer::getSalary)
                .min();

        return maleSalary.isPresent() && femaleSalary.isPresent()
                && maleSalary.getAsDouble() > femaleSalary.getAsDouble();
    }

    //Diamo per scontato che ci siano almeno due elementi nella lista
    public static double olderThan30CPlusPlusDevAverageSalary(List<Developer> ld) {
        OptionalDouble averageSalary = ld.stream()
                .filter(d -> d.getFavouriteLanguage().equals("C++") && d.isOlderThan(30))
                .mapToDouble(Developer::getSalary).average();
        return averageSalary.isPresent() ? averageSalary.getAsDouble() : 0;
    }

    //Diamo per scontato che ci siano almeno due elementi nella lista
    public static List<Developer> threeMostExperiencedDevs(List<Developer> ld) {
        return ld.stream()
                .sorted(Comparator.comparing(Developer::getYearsOfExperience).reversed())
                .limit(3)
                .toList();
    }

    //Diamo per scontato che ci siano almeno due elementi nella lista
    //e che i linguaggi di programmazione, se diversi, non siano
    //misspelling o altri modi di scrivere lo stesso nome
    //e.g. lowercase/Uppercase
    public static List<String> mostPopularLanguages(List<Developer> ld) {
        return ld.stream()
                .collect(Collectors.groupingBy(Developer::getFavouriteLanguage))
                .entrySet()
                .stream()
                .sorted((kv1, kv2) -> kv2.getValue().size() - kv1.getValue().size())
                .limit(2)
                .map(Map.Entry::getKey)
                .toList();
    }

    //Diamo per scontato che ci siano almeno due elementi nella lista
    public static double salaryMedian(List<Developer> ld) {
        double[] salaries = ld.stream().mapToDouble(Developer::getSalary).sorted().toArray();
        if(salaries.length % 2 != 0){
            return salaries[(salaries.length)/2];
        } else {
            return (( salaries[(salaries.length/2)-1] + salaries[(salaries.length)/2] ) / 2) ;
        }
    }

    //Diamo per scontato che ci siano almeno due elementi nella lista
    public static double salaryModalValue(List<Developer> ld) {
        var x = ld.stream()
                .collect(Collectors.groupingBy(Developer::getSalary))
                .entrySet()
                .stream()
                .max(Comparator.comparingInt(kv -> kv.getValue().size()));
        return x.isPresent() ? x.get().getKey() : 0;
    }
}
