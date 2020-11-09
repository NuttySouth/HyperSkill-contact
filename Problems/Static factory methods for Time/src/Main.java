import java.util.Scanner;

class Time {

    int hour;
    int minute;
    int second;


    public static Time noon() {
        // write your code here
        return Time.of(12, 0, 0);
    }

    public static Time midnight() {
        // write your code here
        return Time.of(0, 0, 0);
    }

    public static Time ofSeconds(long seconds) {
        // write your code here
        Time time = new Time();
        double temp = (seconds * 1.0 / 3600) % 24;
        time.hour = (int) temp;
        double temp2 = temp - time.hour;
        double temp3 = temp2 * 60;
        time.minute = (int) temp3;
        double temp4 = Math.round((temp3 - time.minute) * 60);
        time.second = (int) temp4;
        return time;

    }

    public static Time of(int hour, int minute, int second) {
        // write your code here
        Time time = new Time();
        time.hour = hour >= 0 && hour <= 23 ? hour : -1;
        time.minute = minute >= 0 && minute <= 59 ? minute : -1;
        time.second = second >= 0 && second <= 59 ? second : -1;
        if (time.hour != -1 && time.minute != -1 && time.second != -1) {
            return time;
        } else {
            return null;
        }
    }
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final String type = scanner.next();
        Time time = null;

        switch (type) {
            case "noon":
                time = Time.noon();
                break;
            case "midnight":
                time = Time.midnight();
                break;
            case "hms":
                int h = scanner.nextInt();
                int m = scanner.nextInt();
                int s = scanner.nextInt();
                time = Time.of(h, m, s);
                break;
            case "seconds":
                time = Time.ofSeconds(scanner.nextInt());
                break;
            default:
                time = null;
                break;
        }

        if (time == null) {
            System.out.println(time);
        } else {
            System.out.println(String.format("%s %s %s", time.hour, time.minute, time.second));
        }
    }
}