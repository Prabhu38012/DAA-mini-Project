import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
    int id;
    int preferenceScore;

    // Constructor
    public Student(int id, int preferenceScore) {
        this.id = id;
        this.preferenceScore = preferenceScore;
    }
}

public class SeatingAllocation {

    // Method to allocate seats based on preference scores
    public static List<Student> allocateSeats(List<Student> students, int totalSeats) {
        // Sort students by preference score in descending order
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s2.preferenceScore, s1.preferenceScore);
            }
        });

        // Allocate seats up to the limit
        List<Student> allocatedStudents = new ArrayList<>();
        int totalScore = 0;

        for (int i = 0; i < totalSeats && i < students.size(); i++) {
            Student student = students.get(i);
            allocatedStudents.add(student);
            totalScore += student.preferenceScore;
        }

        // Display allocated students and total preference score
        System.out.println("Allocated Seats:");
        for (Student student : allocatedStudents) {
            System.out.println("Student ID: " + student.id + ", Preference Score: " + student.preferenceScore);
        }
        System.out.println("Total Preference Score: " + totalScore);

        return allocatedStudents;
    }

    public static void main(String[] args) {
        // Sample data for students
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, 10));  // Student ID 1 with preference score 10
        students.add(new Student(2, 5));   // Student ID 2 with preference score 5
        students.add(new Student(3, 8));   // Student ID 3 with preference score 8
        students.add(new Student(4, 12));  // Student ID 4 with preference score 12
        students.add(new Student(5, 7));   // Student ID 5 with preference score 7

        int totalSeats = 3;  // Total seats available for the event

        // Allocate seats
        allocateSeats(students, totalSeats);
    }
}
