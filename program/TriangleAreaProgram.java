import java.util.Scanner;

public class TriangleAreaProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите a: ");
        double a = sc.nextDouble();
        System.out.print("Введите b: ");
        double b = sc.nextDouble();
        System.out.print("Введите c: ");
        double c = sc.nextDouble();

        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("Ошибка: стороны должны быть положительными.");
            return;
        }

        // Проверка существования треугольника
        if (a + b <= c || a + c <= b || b + c <= a) {
            System.out.println("Ошибка: такого треугольника не существует.");
            return;
        }

        double p = (a + b + c) / 2.0;
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        System.out.println("Площадь треугольника = " + s);
    }
}
