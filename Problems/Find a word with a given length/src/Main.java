import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();

        Pattern pattern = Pattern.compile("\\b[A-Za-z]{"+ size + "}\\b");
        Matcher matcher = pattern.matcher(line);
        String test = matcher.find() ? "YES" : "NO";
        System.out.println(test);
        // write your code here
    }
}