import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] data = input.split(" ");
        LocalDateTime date = LocalDateTime.parse(data[0]).plusDays(Integer.valueOf(data[1])).minusHours(Integer.valueOf(data[2]));
        System.out.println(date);


    }
}