package learn;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {

        StudentDataStore ds = new StudentDataStore();
        List<Student> students = ds.all();

        // 0. Print all students
        // iteration solution
//        for (Student student : students) {
//            System.out.println(student);
//        }

        // stream solution
       // students.stream().forEach(System.out::println);

        // 1. Print students from Argentina

        // iteration solution
//        for(Student student : students){
//            if(student.getCountry().equals("Argentina")){
//                System.out.println(student);
//            }
//        }

        // stream solution
//        Stream<Student> totalStudents = students.stream();
//        Stream<Student> argentinaStudents = totalStudents.filter(
//                student -> student.getCountry().equals("Argentina")
//        );
//        argentinaStudents.forEach(System.out::println);

        // 2. Print students whose last names starts with 'T'.

        // iteration solution
//        for(Student student : students){
//            char initialOfLastName = student.getLastName().charAt(0);
//            if(initialOfLastName == 'T'){
//                System.out.println(student);
//            }
//        }

        // stream solution
//        Stream<Student> totalStudents = students.stream();
//        Stream<Student> studentsWithLastNameStartingWithLetterT = totalStudents.filter(
//                student -> student.getLastName().substring(0, 1).equals("T")
//        );
//        studentsWithLastNameStartingWithLetterT.forEach(System.out::println);

        // 3. Print students from Argentina, ordered by GPA

        // iteration solution
//        for(Student student : students){
//            if(student.getCountry().equals("Argentina")){
//                System.out.println(student);
//            }
//        }

          //   stream solution
//        Stream<Student> sortedGPA = students.stream().filter(
//                student -> student.getCountry().equals("Argentina")
//        );
//        ourSort(students, (a, b) ->
//                a.getGpa().compareTo(b.getGpa()));
//        sortedGPA.forEach(System.out::println);

        // 4. Print the bottom 10% (100 students) ranked by GPA.

        // iteration solution

        // stream solution
//        ourSort(students, (a, b) ->
//                a.getGpa().compareTo(b.getGpa()));

//        Stream<Student> bottomTenPercent = students.stream().limit(10);
//
//        bottomTenPercent.forEach(System.out::println);



        // 5. Print the 4th - 6th ranked students by GPA from Argentina

        // iteration solution

        // stream solution
//        ourSort(students, (a, b) ->
//                a.getGpa().compareTo(b.getGpa()));


//        List<Student> totalStudents = students.stream().collect(Collectors.toList());
        //.students.stream().sorted((a, b) -> a.getGpa().compareTo(b.getGpa()));
//        Stream<Student> argentinaStudentsRanked = students.stream().filter(
//                student -> student.getCountry().equals("Argentina")
//        ).sorted((a, b) -> b.getGpa().compareTo(a.getGpa())).skip(3).limit(3);
//            argentinaStudentsRanked.forEach(System.out::println);


        // 6. Is anyone from Maldives?

        // iteration solution

        // stream solution
//        Stream<Student> isFromMaldives = students.stream().filter(
//                student -> student.getCountry().equals("Maldives")
//
//        );

//        List<Student> isFromMaldives = ourFilter(students, student -> student.getCountry().equals("Maldives"));
//        isFromMaldives.forEach(System.out::println);

        // 7. Does everyone have a non-null, non-empty email address?

        // iteration solution

        // stream solution
//        boolean allGoodEmails = !students.stream().anyMatch(s ->  s.getEmailAddress() == null || s.getEmailAddress().isEmpty());
//        System.out.println(allGoodEmails);

        // 8. Print students who are currently registered for 5 courses.

        // iteration solution

        // stream solution
//        Stream<Student> hasFiveCourses = students.stream().filter(
//                student -> student.getRegistrations().size() == 5);
//        hasFiveCourses.forEach(System.out::println);

        // 9. Print students who are registered for the course "Literary Genres".

        // iteration solution

        // stream solution
//        System.out.println("Students registered for Literary Genres: ");
//        students.stream()
//                .filter(
//                i -> i.getRegistrations().stream()
//                        .anyMatch(r -> r.getCourse().equalsIgnoreCase("Literary Genres"))
//        ).forEach(System.out::println);


        // 10. Who has the latest birthday? Who is the youngest?

        // iteration solution

        // stream solution
//        System.out.println("Who is the youngest? ");
//        LocalDate youngest = students.stream()
//                .map(y -> y.getBirthDate()).sorted(Comparator.reverseOrder())
//                .findFirst().orElse(LocalDate.MIN);
//
//        students.stream()
//                .sorted(Comparator.comparing(Student::getBirthDate)
//                        .reversed())
//                .takeWhile(i -> i.getBirthDate().equals(youngest))
//                .forEach(System.out::println);



        // 11. Who has the highest GPA? There may be a tie.

        // iteration solution

        // stream solution
//        System.out.println("Who has the highest GPA?");
//        BigDecimal maxGPA = students.stream()
//                .map(i -> i.getGpa()).sorted(Comparator.reverseOrder())
//                .findFirst().orElse(BigDecimal.ZERO);
//
//        students.stream()
//                .sorted(Comparator.comparing(Student::getGpa)
//                        .reversed())
//                .takeWhile(i -> i.getGpa().equals(maxGPA))
//                .forEach(System.out::println);

        // 12. Print every course students are registered for, including repeats.

        // iteration solution

        // stream solution
//        students.stream()
//                .flatMap(
//                        r -> r.getRegistrations().stream()
//                )
//                .map(
//                        Registration::getCourse
//                        // c->c.getCourse()
//                )
//                .forEach(System.out::println);

        // 13. Print a distinct list of courses students are registered for.

        // iteration solution

        // stream solution


        // 14. Print a distinct list of courses students are registered for, ordered by name.

        // iteration solution

        // stream solution

        // 15. Count students per country.

        // iteration solution

        // stream solution
//        int studentStream = students.stream().mapToInt(
//            student -> student.getCountry()
//        );

        // 16. Count students per country. Order by most to fewest students.

        // iteration solution

        // stream solution

        // 17. Count registrations per course.

        // iteration solution

        // stream solution

        // 18. How many registrations are not graded (GradeType == AUDIT)?

        // iteration solution

        // stream solution

        // 19. Create a new type, StudentSummary with fields for Country, Major, and IQ.
        //     Map Students to StudentSummary, then sort and limit by IQ (your choice of low or high).

        // 20. What is the average GPA per country (remember, it's random fictional data).

        // 21. What is the maximum GPA per country?

        // 22. Print average IQ per Major ordered by IQ ascending.

        // 23. STRETCH GOAL!
        // Who has the highest pointPercent in "Sacred Writing"?
    }




    public static void ourSort(List<Student> students, Comparator<Student> decider){
        boolean sorted = true;

        do{
            sorted = true;
            for(int i = 0; i < students.size() - 1; i++){
                Student a = students.get(i);
                Student b = students.get(i + 1);

                int compareResult = decider.compare(a, b);

                if(compareResult > 0){
                    students.set(i + 1, a);
                    students.set(i, b);
                    sorted = false;
                }
            }
        }while(!sorted);
    }


    public static List<Student> ourFilter(List<Student> collection, Predicate<Student> decider){
        List<Student> toReturn = new ArrayList<>();

        for(Student toCheck : collection){
            if(decider.test(toCheck)){
                toReturn.add(toCheck);
            }
        }
        return toReturn;
    }
}
