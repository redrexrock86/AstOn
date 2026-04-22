public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int amount) {
        if (food >= amount) {
            food -= amount;
            return true;
        }
        return false;
    }

    public void addFood(int amount) {
        food += amount;
    }

    public int getFood() {
        return food;
    }

    @Override
    public String toString() {
        return "в миске " + food + " еды";
    }
}