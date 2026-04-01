public class Task6 {
    public static void printSign(int number) {  // ПАРАМЕТР
        if (number >= 0) {
            System.out.println("положительное");
        } else {
            System.out.println("отрицательное");
        }
    }

    public static void main(String[] args) {
        printSign(5);   // Передаем 5
        printSign(-3);  // Передаем -3
        printSign(0);   // Передаем 0
    }
}