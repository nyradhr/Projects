package it.accenture.codeSchool.learningMaterial;

public class Course {
    protected String title = "JavaForDummies";
    protected int duration = 200;

    public Course(String title, int duration) {
        //errore no op
        //title = title;
        this.title = title;
        this.duration = duration;
    }

    public Course(){}

    public String getTitle() {
        return title;
    }

    public int getDuration(){
        return duration;
    }
}
