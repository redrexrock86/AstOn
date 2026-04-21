import java.util.Scanner;

public class FactorialProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите целое n (n >= 0): ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Ошибка: факториал определён только для n >= 0.");
            return;
        }

        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }

        System.out.println(n + "! = " + fact);
    }
}
