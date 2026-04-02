public class Park {

    public class Attraction {
        private String name;
        private String startTime;
        private String endTime;
        private int price;

        public Attraction(String name, String startTime, String endTime, int price) {
            this.name = name;
            this.startTime = startTime;
            this.endTime = endTime;
            this.price = price;
        }

        public void printInfo() {
            System.out.println("Attraction: " + name);
            System.out.println("Работает с " + startTime + " до " + endTime);
            System.out.println("Стоимость: " + price + " ₽");
            System.out.println("-".repeat(40));
        }
    }

    public static void main(String[] args) {
        System.out.println("=== ПРОВЕРКА КЛАССОВ Park и Attraction (3 аттракциона) ===");

        Park park = new Park();

        Attraction rollerCoaster = park.new Attraction(
                "Горки-страшняки",
                "10:00",
                "22:00",
                800
        );

        Attraction ferrisWheel = park.new Attraction(
                "Колесо обозрения",
                "09:30",
                "23:30",
                500
        );

        Attraction hauntedHouse = park.new Attraction(
                "Дом с привидениями",
                "12:00",
                "20:00",
                600
        );

        rollerCoaster.printInfo();
        ferrisWheel.printInfo();
        hauntedHouse.printInfo();
    }
}

