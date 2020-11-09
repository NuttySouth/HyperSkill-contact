import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        // write your code here
        int difference = Integer.MAX_VALUE;
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        String inputNumbers = scanner.nextLine();
        numbers = Arrays.stream(inputNumbers.split(" ")).mapToInt(Integer::valueOf).boxed().collect(Collectors.toList());
        int search = Integer.valueOf(scanner.nextLine());
        List<Integer> results = new ArrayList<>();
        for (Integer number : numbers) {
            if (search == number) {
                difference = 0;
                break;
            } else if (Math.abs(search - number) < difference) {
                difference = Math.abs(search - number);
            }
        }

        for (Integer element : numbers) {
            if (Math.abs(search - element) == difference) {
                results.add(element);
            }
        }

        Collections.sort(results);
        results.forEach(e -> System.out.print(e + " "));
    }
}