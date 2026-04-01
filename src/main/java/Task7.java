public class Task7 {
    public static boolean isNegative(int number) {
        return number < 0;
    }
    public static void main(String[] args) {
        System.out.println(isNegative(5));   // 5 < 0 = false
        System.out.println(isNegative(-3));  // -3 < 0 = true
        System.out.println(isNegative(0));   // 0 < 0 = false
    }
}
