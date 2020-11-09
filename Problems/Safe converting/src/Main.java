import java.util.Scanner;

public class Main {

    public static int convert(Long val) {
        // write your code here
        String value = "";
        if(val == null || val.equals("null")){
            value = "0";
        }else if(val> Integer.MAX_VALUE){
            value = String.valueOf(Integer.MAX_VALUE);
        } else if(val < Integer.MIN_VALUE){
            value = String.valueOf(Integer.MIN_VALUE);
        }else {
            value = String.valueOf(val);
        }

        return Integer.valueOf(value);

    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String val = scanner.nextLine();
        Long longVal = "null".equals(val) ? null : Long.parseLong(val);
        System.out.println(convert(longVal));
    }
}