public class Product {

    private String name;                   // название товара
    private String productionDate;         // дата производства
    private String manufacturer;           // производитель
    private String country;                // страна происхождения
    private int price;                     // цена
    private boolean isReserved;            // состояние бронирования покупателем

    // Конструктор класса, заполняет все поля при создании объекта
    public Product(String name, String productionDate, String manufacturer,
                   String country, int price, boolean isReserved) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.country = country;
        this.price = price;
        this.isReserved = isReserved;
    }

    // Метод вывода информации об объекте в консоль
    public void printInfo() {
        System.out.println("Товар: " + name);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна происхождения: " + country);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Цена: " + price + " ₽");
        System.out.println("Бронирование: " + (isReserved ? "забронирован" : "свободен"));
        System.out.println("-".repeat(40));
    }


    public static void main(String[] args) {
        System.out.println("=== ПРОВЕРКА КЛАССА Product ===");

        Product example = new Product(
                "Samsung S25 Ultra",
                "01.02.2025",
                "Samsung Corp.",
                "Korea",
                55990,
                true
        );

        example.printInfo();
    }

}