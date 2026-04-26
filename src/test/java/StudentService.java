import java.util.Iterator;
import java.util.Set;

public class StudentService {

    public static void removeLowAverage(Set<Student> students) {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.getAverageGrade() < 3.0) {
                it.remove();
            }
        }
    }

    public static void promoteIfEligible(Student student) {
        if (student.getAverageGrade() >= 3.0) {
            student.promoteToNextCourse();
        }
    }

    public static void promoteAllEligible(Set<Student> students) {
        for (Student s : students) {
            promoteIfEligible(s);
        }
    }
}