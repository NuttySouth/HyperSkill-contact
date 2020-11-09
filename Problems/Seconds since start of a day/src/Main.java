import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        LocalTime time = LocalTime.ofSecondOfDay(Long.valueOf(scanner.next()));
        System.out.println(time);
    }
}