import java.util.*;

public class PhoneBook {

    /** Фамилия → список телефонов (у однофамильцев несколько номеров) */
    private final Map<String, List<String>> book = new HashMap<>();

    /** Добавить запись: фамилия и телефон */
    public void add(String surname, String phone) {
        if (surname == null || surname.isBlank() || phone == null || phone.isBlank()) {
            return;
        }
        String key = surname.trim();
        book.computeIfAbsent(key, k -> new ArrayList<>()).add(phone.trim());
    }

    /**
     * Найти все телефоны по фамилии.
     * Возвращает копию списка, чтобы снаружи нельзя было сломать внутреннее хранилище.
     */
    public List<String> get(String surname) {
        if (surname == null || surname.isBlank()) {
            return Collections.emptyList();
        }
        List<String> phones = book.get(surname.trim());
        if (phones == null || phones.isEmpty()) {
            return Collections.emptyList();
        }
        return new ArrayList<>(phones);
    }
}