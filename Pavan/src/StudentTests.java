import java.util.Scanner;

class Student {

    private String name;
    private int marks;

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(int marks) {
        if (marks >= 0 && marks <= 100)
            this.marks = marks;
        else
            System.out.println("Invalid Marks!");
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public String getGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 50) return "C";
        else return "Fail";
    }
}

public class StudentTests {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Student[] students = new Student[3];

        for (int i = 0; i < 3; i++) {
            students[i] = new Student();

            System.out.print("Enter Name: ");
            students[i].setName(sc.next());

            System.out.print("Enter Marks: ");
            students[i].setMarks(sc.nextInt());
        }

        System.out.println("\n--- STUDENT DETAILS ---");
        for (Student s : students) {
            System.out.println(s.getName() + " | " + s.getMarks() + " | " + s.getGrade());
        }

        sc.close();
    }
}