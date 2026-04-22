public class Cat extends Animal {
    public static int catsCount = 0;
    private boolean satiety = false;
    private int appetite = 10;  // Порция для еды

    public Cat(String name) {
        super(name);
        catsCount++;
    }

    public Cat(String name, int appetite) {
        super(name);
        this.appetite = appetite;
        catsCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может бежать больше 200 м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public boolean eat(Plate plate) {
        if (!satiety && plate.decreaseFood(appetite)) {
            satiety = true;
            return true;
        }
        return false;
    }

    public boolean isSatiety() {
        return satiety;
    }

    public static int getCatsCount() {
        return catsCount;
    }
}