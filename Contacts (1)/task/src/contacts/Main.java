package contacts;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        ContactBook contactBook = new ContactBook();
        UserInterface ui = new UserInterface(scanner,contactBook);
        System.out.println("open phonebook.db");
        System.out.println("");
        ui.start();

    }
}