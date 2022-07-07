public class Classroom {
    private String id;
    private String name;
    private Integer capacity;
    private String platform;
    private Boolean projector;
    private Boolean teacher_pc;
    private Integer students_pc;
    private boolean is_virtual;

    public Classroom(String id, String name, Integer capacity, String platform, Boolean projector, Boolean teacher_pc, Integer students_pc, boolean is_virtual) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.platform = platform;
        this.projector = projector;
        this.teacher_pc = teacher_pc;
        this.students_pc = students_pc;
        this.is_virtual = is_virtual;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public String getPlatform() {
        return platform;
    }

    public Boolean getProjector() {
        return projector;
    }

    public Boolean getTeacher_pc() {
        return teacher_pc;
    }

    public Integer getStudents_pc() {
        return students_pc;
    }

    public boolean isIs_virtual() {
        return is_virtual;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                ", platform='" + platform + '\'' +
                ", projector=" + projector +
                ", teacher_pc=" + teacher_pc +
                ", students_pc=" + students_pc +
                ", is_virtual=" + is_virtual +
                '}';
    }
}
