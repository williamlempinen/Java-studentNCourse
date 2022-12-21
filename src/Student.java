public class Student {

    private String name;
    private Integer studentId;

    public Student(String name, Integer studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    public void setStudentName(String name) {
        this.name = name;
    }

    public String getStudentName() {
        return this.name;
    }

    public void setStudentId(Integer id) {
        this.studentId = id;
    }

    public Integer getStudentId() {
        return this.studentId;
    }

    public boolean equals(Object opiskelija) {
        if (!(opiskelija instanceof Student)) {
            return false;
        }
        return this.studentId.intValue() == ((Student) opiskelija).getStudentId().intValue();
    }
}


