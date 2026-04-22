public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Бобик");
        dog.run(150);
        dog.swim(5);

        Cat[] cats = {
                new Cat("Василий", 20),
                new Cat("Бомбило", 15),
                new Cat("Снежок", 10)
        };

        Plate plate = new Plate(25);
        System.out.println("Начало: " + plate);

        for (Cat cat : cats) {
            cat.eat(plate);
        }

        System.out.println("После кормления котов:");
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " сыт: " + cat.isSatiety());
        }
        System.out.println("Остаток: " + plate);
        plate.addFood(15);
        System.out.println("Добавили еду: " + plate);

        System.out.println("Животных: " + Animal.getAnimalsCount() +
                ", Собаки: " + Dog.getDogsCount() +
                ", Коты: " + Cat.getCatsCount());
    }
}