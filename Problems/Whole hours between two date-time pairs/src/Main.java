import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        LocalDateTime dateOne = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime dateTwo = LocalDateTime.parse(scanner.nextLine());
        TemporalUnit unit;
        long result = dateOne.until(dateTwo, ChronoUnit.HOURS);
        System.out.println(result);
    }
}