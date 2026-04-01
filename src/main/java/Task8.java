public class Task8 {
    public static void printStringNTimes(String str, int times) {
        for (int i = 0; i < times; i++) {  // i=0,1,2 (3 раза)
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        printStringNTimes("Hello", 3);
    }
}