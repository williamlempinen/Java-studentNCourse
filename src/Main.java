public class Main {
    public static void main(String[] args) throws StudentEnrollException {
        System.out.println("Hello World");

        //student-luokan instansseja
        Student william = new Student("William", 234234);
        Student james = new Student("James", 456456);
        Student michael = new Student("Michael", 987987);
        Student franklin = new Student("Franklin", 654654);
        Student trevor = new Student("Trevor", 123123);

        //course-luokan instansseja
        Course trak = new Course("TRAK", 5, "Lasse");
        Course olio = new Course("OOJ", 5, "Jari");
        Course ohtu = new Course("OHTU", 5, "Tapani");

        trak.addStudentToCourse(william);
        trak.addStudentToCourse(trevor);
        trak.addStudentToCourse(franklin);

        olio.addStudentToCourse(michael);
        olio.addStudentToCourse(james);
        olio.addStudentToCourse(william);
        olio.addStudentToCourse(trevor);

        ohtu.addStudentToCourse(william);
        ohtu.addStudentToCourse(franklin);
        ohtu.addStudentToCourse(james);


        trak.setGrade(william, 5);
        trak.setGrade(franklin, 3);

        olio.setGrade(william, 5);
        olio.setGrade(james, 1);
        olio.setGrade(michael, 5);
        olio.setGrade(trevor,2);

        ohtu.setGrade(william, 5);


        trak.courseReport();
        olio.courseReport();
        ohtu.courseReport();


    }
}
