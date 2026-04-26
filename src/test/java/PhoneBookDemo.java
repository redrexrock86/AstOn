public class PhoneBookDemo {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();

        pb.add("Иванов", "8-900-111-22-33");
        pb.add("Иванов", "8-900-444-55-66"); // второй однофамилец / второй номер
        pb.add("Петров", "8-901-000-00-00");

        String lastName = "Иванов";
        System.out.println("Телефоны для фамилии «" + lastName + "»:");
        for (String phone : pb.get(lastName)) {
            System.out.println(phone);
        }
    }
}

