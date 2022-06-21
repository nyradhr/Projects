package it.accenture.codeSchool.hr;

import it.accenture.codeSchool.learningMaterial.Course;

public class TechnicalInstructor extends Instructor {

    protected String programmingLanguage;
    protected int yearsOfCoding;

    public TechnicalInstructor() {
        super("Ciccio", null);
    };

    public TechnicalInstructor(String programmingLanguage, int yearsOfCoding, String name, Course course) {
        super(name, course);
        this.programmingLanguage = programmingLanguage;
        this.yearsOfCoding = yearsOfCoding;

        //mai fare questo
        /*
        this.name = name;
        this.course = course;
        this.programmingLanguage = programmingLanguage;
        */

    }

    @Override // compile-time annotation
    public boolean isSeniorInstructor() {
        return yearsOfCoding>5 && yearsOfExperience>10;
    }


}
