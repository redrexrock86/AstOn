public class Task10 {
    public static void invertArray() {
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        // Инвертируем каждый элемент
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;  // 0→1, 1→0
        }

        // Выводим результат
        for (int value : array) {
            System.out.print(value + " ");
        }
    }

    public static void main(String[] args) {
        invertArray();
    }
}
