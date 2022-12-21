import java.util.HashMap;

public class Course {

    private String name;
    private int courseCredit;
    private String lecturer;
    private final HashMap<Student, Integer> participants;

    public Course(String name, int courseCredit, String lecturer) {
        this.name = name;
        this.courseCredit = courseCredit;
        this.lecturer = lecturer;
        this.participants = new HashMap<>();
    }

    /**
     * Palauttaa kurssin nimen.
     * @.pre true
     * @.post RESULT == this.name;
     */
    public String getName() {
        return name;
    }

    /**
     * Asetusmetodi kurssin nimelle
     * @.pre true
     * @.post RESULT == this.name == name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Palauttaa kurssin opintopisteiden määrän.
     * @.pre true
     * @.post RESULT == this.courseCredit
     */
    public int getCourseCredit() {
        return courseCredit;
    }

    /**
     * Asetus metodi opintopisteille, mikäli se on väliltä 0 - 100.
     * @.pre courseCredit >= 0 && courseCredit <= 100
     * @.post RESULT == this.courseCredit == courseCredit
     */
    public void setCourseCredit(int courseCredit) {
        if (courseCredit >= 0 && courseCredit <= 100) {
            this.courseCredit = courseCredit;
        }
    }

    /**
     * Palauttaa kurssin luennoitsijan
     * @.pre true
     * @.post RESULT == this.lecturer
     */
    public String getLecturer() {
        return lecturer;
    }

    /**
     * Asetusmetodi kurssin luennoitsijalle
     * @.pre true
     * @.post RESULT == this.lecturer == lecturer
     */
    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    /**
     * Tulostaa kurssin osallistujien nimen sekä hänen sen hetkisen arvioinnin.
     * @.pre participants != null
     * @.post RESULT == participants.keySet() && participants.get(var)
     */
    public void getParticipants() {
        for (var student : participants.keySet()) {
            System.out.println(student.getStudentName() + ": evaluation " + participants.get(student));
        }
    }

    /**
     * Lisää opiskelija kurssille
     * @.pre student != null && !participants.containsKey(student)
     * @.post RESULT == participants.put(student, 0)
     */
    public void addStudentToCourse(Student student) throws StudentEnrollException {
        if (participants.containsKey(student)) {
            throw new StudentEnrollException("Student: " + student.getStudentName() + " has already enrolled.");
        } else {
            participants.put(student, 0);
        }
    }

    /**
     * Asetetaan halutulle opiskelijalle kurssiarvosana.
     * @.pre Integer grade <= 5 && grade >= 0
     * @.post RESULT == participants.put(student, grade)
     */
    public void setGrade(Student student, int grade) {
        for (var s : participants.keySet()) {
            if (student.equals(s)) {
                if (grade >= 0 && grade <= 5) {
                    participants.put(student, grade);
                }
            }
        }
    }

    /**
     * Tulostaa kurssin nimen, osallistujoiden määrän sekä arvosanojen keskiarvon.
     * @.pre true
     * @.post RESULT.name() == this.name() && RESULT.size() == participants.size()
     */
    public void courseReport() {
        float avg;
        float all = 0;
        for (Integer s : participants.values()) {
            all += s;
        }
        avg = all / participants.size();
        System.out.println("Course name: " + this.getName());
        System.out.println("Number of students: " + participants.size());
        System.out.println("Average evaluation: " + avg);
    }

}
