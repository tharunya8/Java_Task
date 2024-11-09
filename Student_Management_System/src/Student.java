public class Student {
    private String name;
    private int id;
    private int age;
    private String dept;

    // Constructor
    public Student(String name, int id, int age, String dept) {
        if (isValidName(name) && isValidId(id) && isValidAge(age) && isValidDept(dept)) {
            this.name = name;
            this.id = id;
            this.age = age;
            this.dept = dept;
        } else {
            System.out.println("Invalid data. Student not created.");
        }
    }

    // Validation methods
    private boolean isValidName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    private boolean isValidId(int id) {
        return id > 0; // ID should be positive
    }

    private boolean isValidAge(int age) {
        return age >= 17 && age <= 30; // Assume students are aged 17-30
    }

    private boolean isValidDept(String dept) {
        return dept != null && !dept.trim().isEmpty();
    }

    // Display method
    public void display() {
        if (name != null) {
            System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Dept: " + dept);
        } else {
            System.out.println("No valid student data available.");
        }
    }
}
