public class Task2 {
    public static void chekSumSing () {
        int a = 5;
        int b = -3; // 5 + (-3) = 2
        int sum = a + b;
        if (sum >= 0) { // Условие: сумма >= 0
            System.out.println("Сумма положиельная");
        } else { // Иначе (sum < 0)
            System.out.println("Сумма отрицательная");
        }
    }
public static void main(String[] args) {
        chekSumSing();
    }
}
