import java.util.Scanner;

public class ArithmeticTwoIntsProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите целое a: ");
        int a = sc.nextInt();
        System.out.print("Введите целое b: ");
        int b = sc.nextInt();

        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));

        if (b == 0) {
            System.out.println("a / b = Ошибка (деление на 0)");
        } else {
            System.out.println("a / b = " + (a / b)); // целочисленное деление
        }
    }
}
