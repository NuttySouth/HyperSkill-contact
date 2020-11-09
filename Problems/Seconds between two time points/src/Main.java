import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // write your code here
        String inputOne = scanner.nextLine();
        String inputTwo = scanner.nextLine();
        LocalTime timeOne = LocalTime.parse(inputOne);
        LocalTime timeTwo = LocalTime.parse(inputTwo);
        int secondsOne = timeOne.getHour()*60*60 + timeOne.getMinute()*60 + timeOne.getSecond();
        int secondsTwo = timeTwo.getHour()*60*60 + timeTwo.getMinute()*60 + timeTwo.getSecond();
        int seconds = Math.abs(secondsOne - secondsTwo);
        System.out.println(seconds);
    }
}