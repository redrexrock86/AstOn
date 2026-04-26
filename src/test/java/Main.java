import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Student> students = DemoData.createStudents();

        System.out.println("Студенты 1 курса (до удаления и перевода):");
        Printer.printStudents(students, 1);

        StudentService.removeLowAverage(students);
        StudentService.promoteAllEligible(students);

        System.out.println("Студенты 2 курса (после удаления среднего < 3 и перевода):");
        Printer.printStudents(students, 2);

        System.out.println("Студенты 3 курса:");
        Printer.printStudents(students, 3);
    }
}