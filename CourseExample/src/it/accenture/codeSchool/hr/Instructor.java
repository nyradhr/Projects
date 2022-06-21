package it.accenture.codeSchool.hr;

import it.accenture.codeSchool.learningMaterial.Course;

public class Instructor {
    protected String name;
    protected Course course;

    protected int yearsOfExperience;


    //public Instructor() {}

    public Instructor(String name, String courseTitle, int courseDuration) {
        //this.name = name;
        //this.course = new Course(courseTitle, courseDuration);
        this(name,new Course(courseTitle, courseDuration));
    }

    public Instructor(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public Instructor(String name) {
        //this.name = name;
        this(name,null);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseTitle() {
        return this.course.getTitle();
    }

    public boolean isSeniorInstructor() {
        /*
        if(yearsOfExperience > 10) {
            return true;
        }
        return false;
        */
        return yearsOfExperience > 10;
    }


    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Instructor other = (Instructor) obj;

        return name.equals(other.name);
    }

    public void setCourse(Course c) {
        course = c;
    }
}
