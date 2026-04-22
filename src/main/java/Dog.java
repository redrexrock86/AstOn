public class Dog extends Animal {
    public static int dogsCount = 0;

    public Dog(String name) {
        super(name);
        dogsCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может бежать больше 500 м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может плыть больше 10 м.");
        }
    }

    public static int getDogsCount() {
        return dogsCount;
    }
}