
import java.util.ArrayList;
import java.util.Scanner;

// Define the Student class
class Student {
    private String name;
    private int rollNumber;
    private String grade;
    private String gender;
    private int age;

    public Student(String name, int rollNumber, String grade,String gender,int age) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        this.gender=gender;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }
    public String getGender()
    {
        return gender;
    }
    public int getAge()
    {
        return age;
    }

    @Override
    public String toString() {
        return "Roll Number: " + rollNumber + ", Name: " + name + ", Grade: " + grade+", Gender: "+gender+", Age: "+age;
    }
}

// Define the StudentManagementSystem class
class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student findStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null; // Student not found
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

public class Project3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem studentSystem = new StudentManagementSystem();

        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search for Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Roll Number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Grade: ");
                    String grade = scanner.nextLine();
                    System.out.println("Enter Gender:");
                    String gender=scanner.nextLine();

                    System.out.println("Enter age:");
                    int age=scanner.nextInt();
                    scanner.nextLine();
                    Student newStudent = new Student(name, rollNumber, grade,gender,age);
                    studentSystem.addStudent(newStudent);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                    System.out.print("Enter Roll Number to remove: ");
                    int rollToRemove = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    studentSystem.removeStudent(rollToRemove);
                    System.out.println("Student removed successfully.");
                    break;

                case 3:
                    System.out.print("Enter Roll Number to search: ");
                    int rollToSearch = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Student foundStudent = studentSystem.findStudent(rollToSearch);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.println("All Students:");
                    studentSystem.displayAllStudents();
                    break;

                case 5:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
