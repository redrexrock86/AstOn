import java.util.Scanner;

public class CompareTwoIntsProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите целое a: ");
        int a = sc.nextInt();
        System.out.print("Введите целое b: ");
        int b = sc.nextInt();

        if (a == b) {
            System.out.println("a равно b");
        } else if (a > b) {
            System.out.println("a больше b");
        } else {
            System.out.println("a меньше b");
        }
    }
}
