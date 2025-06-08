import java.util.*;

public class Student {
    private Map<String, Map<String, Integer>> semesterCourses;

    public Student() {
        semesterCourses = new LinkedHashMap<>();
    }

    public void addCourse(String semester, String course, int marks) {
        semesterCourses.putIfAbsent(semester, new LinkedHashMap<>());
        semesterCourses.get(semester).put(course, marks);
    }

    public void displayCourses() {
        for (String semester : semesterCourses.keySet()) {
            System.out.println("Semester: " + semester);
            Map<String, Integer> courses = semesterCourses.get(semester);
            for (Map.Entry<String, Integer> entry : courses.entrySet()) {
                System.out.println("  Course: " + entry.getKey() + ", Marks: " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student sc = new Student();

        System.out.print("Enter number of semesters: ");
        int semCount = scanner.nextInt();
        scanner.nextLine(); // clear newline

        for (int i = 1; i <= semCount; i++) {
            System.out.println("\nEnter courses for Semester " + i + ":");
            System.out.print("Enter number of courses: ");
            int courseCount = scanner.nextInt();
            scanner.nextLine(); // clear newline

            for (int j = 1; j <= courseCount; j++) {
                System.out.print("Enter course name: ");
                String course = scanner.nextLine();
                System.out.print("Enter marks: ");
                int marks = scanner.nextInt();
                scanner.nextLine(); // clear newline

                sc.addCourse("Semester " + i, course, marks);
            }
        }

        System.out.println("\n--- Student Course Information ---");
        sc.displayCourses();
    }
}
