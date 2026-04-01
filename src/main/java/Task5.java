public class Task5 {
    public static boolean isSumBetween10And20(int a, int b) {
        int sum = a + b;  // a,b задаются ПРИ ВЫЗОВЕ
        return sum >= 10 && sum <= 20;
    }
    public static void main(String[] args) {  // задаем значения
        System.out.println(isSumBetween10And20(5, 6));   // a=5, b=6
        System.out.println(isSumBetween10And20(1, 2));   // a=1, b=2
        System.out.println(isSumBetween10And20(10, 10)); // a=10,b=10
    }
}
