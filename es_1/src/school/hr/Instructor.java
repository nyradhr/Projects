package school.hr;
import school.learningMaterial.*;

public class Instructor {
	public String name = "Riccardo";
	public Course assignedCourse = new Course("JavaForDummies", 200);
	public void showCourse() {
		System.out.println(assignedCourse.getTitle());
	}
}