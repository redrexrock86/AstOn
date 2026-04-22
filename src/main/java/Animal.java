public class Animal {
    public static int animalsCount = 0;
    protected String name;

    public Animal(String name) {
        this.name = name;
        animalsCount++;
    }

    public String getName() {
        return name;
    }

    public void run(int distance) {
        System.out.println(name + " не может бежать на такую дистанцию.");
    }

    public void swim(int distance) {
        System.out.println(name + " не умеет плавать.");
    }

    public static int getAnimalsCount() {
        return animalsCount;
    }
}