public class Task13 {
    public static void fillDiagonal() {
        int[][] array = new int[5][5];  // 5 строк × 5 столбцов

        // Заполняем [0][0], [1][1], [2][2], [3][3], [4][4]
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
        }

        // Выводим матрицу
        for (int[] row : array) {           // Для каждой строки
            for (int value : row) {         // Для каждого столбца
                System.out.print(value + " ");
            }
            System.out.println();           // Новая строка
        }
    }

    public static void main(String[] args) {
        fillDiagonal();
    }
}
