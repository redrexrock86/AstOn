import java.util.Map;

public class Student {
    private final String name;
    private final String group;
    private int course;
    private final Map<String, Integer> grades; // предмет -> оценка

    public Student(String name, String group, int course, Map<String, Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public String getName() { return name; }
    public String getGroup() { return group; }
    public int getCourse() { return course; }
    public Map<String, Integer> getGrades() { return grades; }

    public double getAverageGrade() {
        if (grades == null || grades.isEmpty()) return 0.0;
        int sum = 0;
        for (int g : grades.values()) sum += g;
        return (double) sum / grades.size();
    }

    public void promoteToNextCourse() {
        this.course++;
    }
}