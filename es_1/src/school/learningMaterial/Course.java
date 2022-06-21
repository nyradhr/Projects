package school.learningMaterial;

public class Course {
	private String courseTitle;
	private int courseDuration;
	public Course(String title, int duration){
		courseTitle = title;
		courseDuration = duration;
	}
	public String getTitle(){
		return this.courseTitle;
	}
	public int getDuration(){
		return this.courseDuration;
	}
}