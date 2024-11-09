import java.util.Scanner;

public class Employee {
    // Attributes
    private String name;
    private int age;
    private double salary;
    private String department;
    private double performanceRating;


    // Constructor
    public Employee(String name, int age, double salary, String department, double performanceRating) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
        this.performanceRating = performanceRating;
    }

    // Method to display employee details
    public void displayEmployeeDetails() {
        System.out.println("Employee Details:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: $" + salary);
        System.out.println("Department: " + department);
        System.out.println("Performance Rating: " + performanceRating);
    }

    // Method to update the salary based on performance rating
    public void updateSalary() {
        if (performanceRating >= 5) {
            salary += salary * 0.30; // 30% increase
        } else if (performanceRating > 3) {
            salary += salary * 0.15; // 15% increase
        } else if (performanceRating > 1) {
            salary += salary * 0.05; // 5% increase
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Getting dynamic input from the user
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee age: ");
        int age = scanner.nextInt();

        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();

        scanner.nextLine(); // Consume the newline

        String[] dep = {"web","testing","development","intern"};
        for(int i = 0; i < dep.length; i++) {
            System.out.println(dep[i]);
        }
        System.out.print("Enter employee department: ");
        String department = scanner.nextLine();

        System.out.print("Enter employee performance rating (1 to 5): ");
        double performanceRating = scanner.nextDouble();

        // Create an Employee object with dynamic inputs
        Employee emp = new Employee(name, age, salary, department, performanceRating);

        // Display employee details before salary update
        emp.displayEmployeeDetails();

        // Update the salary based on performance rating
        emp.updateSalary();

        // Display employee details after salary update
        System.out.println("\nAfter Salary Update:");
        emp.displayEmployeeDetails();

        scanner.close();
    }
}