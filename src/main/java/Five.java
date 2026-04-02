public class Five {
    public static void main(String[] args) {
        //  объявляем массив объектов
        Product[] productsArray = new Product[5];
        //  заполняем каждую ячейку объектом
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("iPhone 17 Pro", "15.09.2025",
                "Apple Inc.", "USA", 6499, false);
        productsArray[2] = new Product("Sony WH-1000XM7", "10.11.2024",
                "Sony", "Japan", 1499, false);
        productsArray[3] = new Product("Dyson V16", "05.05.2025",
                "Dyson", "UK", 2199, true);
        productsArray[4] = new Product("Xiaomi Scooter 5", "20.03.2025",
                "Xiaomi", "China", 1299, false);
        // пример использования метода вывода
        for (Product p : productsArray) {
            p.printInfo();
        }
    }
}
