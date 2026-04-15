public class MainStep1 {

    public static void checkSize4x4(String[][] arr) throws MyArraySizeException {
        if (arr == null || arr.length != 4) {
            throw new MyArraySizeException("Нужен массив 4x4: строк должно быть 4");
        }
        for (int i = 0; i < 4; i++) {
            if (arr[i] == null || arr[i].length != 4) {
                throw new MyArraySizeException("Нужен массив 4x4: в строке " + i + " должно быть 4 элемента");
            }
        }
    }

    public static void main(String[] args) {
        String[][] arr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            checkSize4x4(arr);
            System.out.println("Размер OK (4x4)");
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        }
    }
}
