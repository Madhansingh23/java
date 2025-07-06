import java.util.*;

class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> list = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.printf("Enter name and marks for student %d: ", i + 1);
            String name = sc.next();
            double marks = sc.nextDouble();
            list.add(new Student(name, marks));
        }

        list.sort((s1, s2) -> Double.compare(s2.marks, s1.marks)); // Descending

        System.out.println("\nStudent Rankings:");
        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);
            System.out.printf("%d. %s - %.2f%n", i + 1, s.name, s.marks);
        }

        sc.close();
    }
}
