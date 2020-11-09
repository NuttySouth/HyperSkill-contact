import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        LocalDateTime input = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime added = input.plusHours(11);
        LocalDate result = added.toLocalDate();
        System.out.println(result);
    }
}