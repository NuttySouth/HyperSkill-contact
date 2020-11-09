import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^[+,-]?(?:[1-9]\\d*|0)(?:[\\.\\,](?:0$|[0-9]*[^0]$))*$";

        String number = scanner.nextLine();
        System.out.println(number.matches(regex) ? "YES" : "NO");


//[-+]?(?:[0-9]{0,30}\\.)?[0-9]{1,30}$
        //^[+,-]?(?:[1-9]\d*|0)(?:[\\.\\,](?:0$|[0-9]*[^0]$))*$

    }
}