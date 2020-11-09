import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String part = scanner.nextLine();
        String line = scanner.nextLine();

        Pattern patter = Pattern.compile("(?i)\\b[a-zA-Z]+" + part+"\\b|\\b"+part+ "[a-zA-Z]*\\b");
        Matcher matcher = patter.matcher(line);
        boolean matches = matcher.find();
        System.out.println(matches ? "YES" : "NO");

        // write your code here
    }
}