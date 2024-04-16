class Student {
    private static int studentCounter = 1;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String indexNumber;
    private String status;
    private int currentSemester;
    private List<String> subjects = new ArrayList<>();

    public Student(String firstName, String lastName, String email, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.indexNumber = "s" + studentCounter++;
        this.status = "candidate";
    }

    public void enrollStudent() {
        this.currentSemester = 1;
    }

    public void addSubject(String subject) {
        subjects.add(subject);
    }

    public void promoteToNextSemester() {
        if (currentSemester < 7) {
            currentSemester++;
            if (currentSemester == 7) {
                status = "graduate";
            }
        }
    }

    public void displayInfo() {
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Index Number: " + indexNumber);
        System.out.println("Status: " + status);
        System.out.println("Current Semester: " + currentSemester);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
    }
}

class Students {
    private static List<Student> studentList = new ArrayList<>();

    public static void enrollStudent(Student student) {
        student.enrollStudent();
        studentList.add(student);
    }

    public static void promoteAllStudents() {
        for (Student student : studentList) {
            student.promoteToNextSemester();
        }
    }

    public static void displayInfoAboutAllStudents() {
        for (Student student : studentList) {
            student.displayInfo();
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student("John", "Doe", "doe@wp.pl", "Warsaw, Zlota 12");
        Students.enrollStudent(s);

        s.addSubject("PGO");
        s.addSubject("APBD");

        Students.promoteAllStudents();
        Students.displayInfoAboutAllStudents();
    }
}