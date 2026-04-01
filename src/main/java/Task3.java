public class Task3 {
    public static void printColor () {
        int value = 50;  // Тесовое значение
        if (value <= 0) {  // Краснный (- ∞...0]
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {  //  Проверяется только если if выше ложный - Жёлтый (0...100]
            System.out.println("Жёлтый");
        } else {  // Без условия, срабатывает если ничего выше не подошло - Зеленый: (100...+∞)
            System.out.println("Зелёный");
        }
    }

        public static void main(String[] args) {
            printColor();
    }
}
