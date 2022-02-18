// 1. `extends` pulls all non-private members from Person
// into Student.
public class Student{

    private String studentId;

    public String getStudentId() {
        return studentId;
    }


    public Student(Student studentId){
        this.studentId = studentId;
    }

//    public void setStudentId(String studentId) {
//        this.studentId = studentId;
//    }
//
//    public Student(String firstName, String lastName, String studentId) {
//        // 2. call the constructor on the "super" (or parent) class
//        super(firstName, lastName);
//        this.studentId = studentId;
//    }
//    // 1. Override annotation isn't required, but is polite.
//    @Override
//    public String getFullName() {
//        // 2. Call the parent's `getFullName` method.
//        String personFullName = super.getFullName();
//        // append the student id to the person's full name
//        return String.format("%s, ID: %s", personFullName, studentId);
//    }

//    Student s = new Student("Bale", "Packmann", "100-A29-WER");
//    String fullName = s.getFullName();
// System.out.println(fullName);         // Bale Packmann
// System.out.println(s.getStudentId()); // 100-A29-WER

}