import java.util.Scanner;
import java.time.LocalDate;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String date = scanner.nextLine();
        LocalDate startDate = LocalDate.parse(date);
        int offSet = Integer.valueOf(scanner.nextLine());
        LocalDate endDate = LocalDate.ofYearDay(startDate.getYear(),startDate.lengthOfYear());

        while(startDate.isBefore(endDate) | startDate.isEqual(endDate)){
            System.out.println(startDate);
            startDate = startDate.plusDays(offSet);
        }
    }
}