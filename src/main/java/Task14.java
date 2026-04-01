public class Task14 {
    public static int[] createArray(int len, int initialValue) {
        int[] array = new int[len];     // [0,0,0,...,0]

        for (int i = 0; i < len; i++) {
            array[i] = initialValue;    // Заполняем initialValue
        }
        return array;  // Возвращаем массив
    }

    public static void main(String[] args) {
        int[] result = createArray(4, 7);  // len=4, initialValue=7
        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}