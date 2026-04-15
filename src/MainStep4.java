public class MainStep4 {
    public static void main(String[] args) {
        try {
            int[] a = {1, 2, 3};
            System.out.println(a[3]); // индексы только 0..2
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймали ArrayIndexOutOfBoundsException: " + e);
        }
    }
}
