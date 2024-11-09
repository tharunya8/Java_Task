import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    // Use ArrayList for dynamic capacity
    private ArrayList<Student> students;

    // Constructor
    public StudentManagementSystem() {
        students = new ArrayList<>(); // No fixed size, dynamic capacity
    }

    // Method to add a student
    public void addStudent(String name, int id, int age, String dept) {
        Student newStudent = new Student(name, id, age, dept);
        if (newStudent != null) {
            students.add(newStudent); // Adds a student to the list, resizing dynamically
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Error adding student.");
        }
    }

    // Method to display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.println("Student List:");
            for (Student student : students) {
                student.display();
            }
        }
    }

    // Main program
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem(); // No fixed size

        boolean exit = false;

        while (!exit) {
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Adding a new student
                    System.out.print("Enter student name: ");
                    String name = scanner.next();
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter student dept: ");
                    String dept = scanner.next();

                    sms.addStudent(name, id, age, dept);
                    break;

                case 2:
                    // Displaying all students
                    sms.displayAllStudents();
                    break;

                case 3:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
