package contacts;

import java.util.Scanner;

public abstract class ContactFactory {
    abstract Contact createContact(String type);

    Contact orderContact(String type) throws InterruptedException{
        Contact contact = createContact(type);
        if(contact == null){
            return null;
        }
        return contact;
    }
}

class ContactStore extends ContactFactory{
    private Scanner scanner;

    public ContactStore(){
        this.scanner = new Scanner(System.in);
    }

    @Override
    Contact createContact(String type){
        if(type.equals("person")){
            System.out.print("Name: ");
            String name = this.scanner.nextLine();
            System.out.print("Surname: ");
            String surName = this.scanner.nextLine();
            System.out.print("Birth date: ");
            String birth = this.scanner.nextLine();
            System.out.print("Gender: ");
            String gender = this.scanner.nextLine();
            System.out.print("Number: ");
            String number = this.scanner.nextLine();
            return new Person(name, surName, birth,gender,number);
        }else if(type.equals("organization")){
            System.out.print("Organization name: ");
            String name = this.scanner.nextLine();
            System.out.print("Address: ");
            String address = this.scanner.nextLine();
            System.out.print("Number: ");
            String number = this.scanner.nextLine();
            return new Organization(name, address, number);
        } else {
            return null;
        }
    }
}
