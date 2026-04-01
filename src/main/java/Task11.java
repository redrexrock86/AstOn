public class Task11 {
    public static void fillArray1To100() {
        int[] array = new int[100];  // [0,0,0,...,0] (100 нулей)

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;  // array[0]=1, array[1]=2...
        }

        // Показываем первые 10
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        fillArray1To100();
    }
}