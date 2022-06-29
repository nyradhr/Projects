package it.accenture.stream;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExamples {
    public static void main(String[] args) {
        Developer md = new Developer(1L, "Andrea", "Rossi", LocalDate.now(),
                "Java", 25, Sex.MALE, 2000);
        Developer fd = new Developer(2L, "Sara", "Bianchi", LocalDate.now(),
                "PHP", 30, Sex.FEMALE, 3000);

        List<Developer> ld = List.of(md,fd);



    }

    public double femaleOver30YearsSalarySum(List<Developer> ld) {
        double sum = 0;
        for(Developer d: ld) {
            if(d.getSex() == Sex.FEMALE && d.isOlderThan(30)) {
                sum += d.getSalary();
            }
        }
        return sum;
    }

    public double streamFemaleOver30YearsSalarySum(List<Developer> ld) {
        /*
        Predicate<Developer> pd = new Predicate<Developer>() {
            @Override
            public boolean test(Developer developer) {
                return false;
            }
        };
        */
        return ld.stream().filter(d -> d.getSex()==Sex.FEMALE && d.isOlderThan(30))
                .mapToDouble(Developer::getSalary).sum();
    }

    public double topNSeniorFemaleSalarySum(List<Developer> ld) {
        return ld.stream().filter(d -> d.getSex()==Sex.FEMALE && d.isOlderThan(30))
                .mapToDouble(d -> d.getSalary()).sorted().limit(10).sum(); //sum() operatore terminale
    }

    public List<Developer> malesExpertInCPlusPlus(List<Developer> ld) {
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


    public DeveloperSummaryData calculateSummaryData(List<Developer> ld) {

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
}
