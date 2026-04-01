public class Task9 {
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        else if (year % 100 == 0) {
            return false;
        }
        else return year % 4 == 0;
    }

    public static void main(String[] args) {
        System.out.println(isLeapYear(2024));  // true
        System.out.println(isLeapYear(1900));  // false
        System.out.println(isLeapYear(2000)); // true
    }
}