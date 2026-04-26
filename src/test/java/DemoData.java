import java.util.*;

public class DemoData {
    public static Set<Student> createStudents() {
        Set<Student> students = new HashSet<>();

        // 1 курс
        students.add(new Student("Пётр", "IU7-11", 1,
                Map.of("Математика", 2, "Физика", 3, "Информатика", 2)));
        students.add(new Student("Ольга", "IU7-12", 1,
                Map.of("Математика", 5, "Физика", 4, "Информатика", 5)));
        students.add(new Student("Дмитрий", "IU7-13", 1,
                Map.of("Математика", 4, "Физика", 4, "Информатика", 3)));
        students.add(new Student("Сергей", "IU7-14", 1,
                Map.of("Математика", 2, "Физика", 2, "Информатика", 2)));

        // 2 курс
        students.add(new Student("Иван", "IU7-21", 2,
                Map.of("Математика", 5, "Физика", 4, "Информатика", 5)));
        students.add(new Student("Мария", "IU7-22", 2,
                Map.of("Математика", 3, "Физика", 3, "Информатика", 4)));
        students.add(new Student("Кирилл", "IU7-23", 2,
                Map.of("Математика", 2, "Физика", 3, "Информатика", 2)));

        // 3 курс
        students.add(new Student("Анна", "IU7-31", 3,
                Map.of("Математика", 3, "Физика", 3, "Информатика", 3)));
        students.add(new Student("Елена", "IU7-32", 3,
                Map.of("Математика", 5, "Физика", 5, "Информатика", 5)));

        return students;
    }
}