package contacts;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInterface {
    private Scanner scanner;
    private ContactBook contactBook;

    public UserInterface(Scanner scanner, ContactBook contactBook){
        this.contactBook = contactBook;
        this.scanner = scanner;
    }

    public void start(){

        while(true){
            System.out.print("[menu] Enter action (add, list, search, count, exit): ");
            String input = this.scanner.nextLine().toLowerCase();
            if(input.equals("add")){
                System.out.print("Enter the type (person, organization): ");
                String type = this.scanner.nextLine();
                add(type);
                System.out.println("");
            } else if(input.equals("list")){
                listAll();
                System.out.println("");
                System.out.print("[list] Enter action ([number], back): ");
                String option = this.scanner.nextLine();
                boolean checker = recordOptionChecker(option);
                if(checker){
                    Contact contact = this.contactBook.getContact(Integer.parseInt(option) - 1);
                    info(contact);
                    recordMenu(contact);
                }

            } else if(input.equals("search")){
                    searchMethod();

            } else if(input.equals("count")){
                count();
            } else if(input.equals("exit")){
                break;
            }
        }
    }

    public void searchMethod() {

        ArrayList<Contact> foundContacts = search();
        System.out.println("");
        if(foundContacts != null) {
            System.out.print("[search] Enter action ([number]), back, again): ");
            String action = this.scanner.nextLine();
            boolean checker = recordOptionChecker(action);
            if (checker) {
                Contact contact = this.contactBook.getContact(Integer.parseInt(action) - 1);
                info(contact);
                recordMenu(contact);
            }else if(action.equals("again")){
                searchMethod();
            }
        }
    }
    public void recordMenu(Contact contact){
        while(true){
            System.out.println("");
            System.out.print("[record] Enter action (edit, delete, menu): ");
            String action = this.scanner.nextLine();
            if(action.equals("edit")){
                edit(contact);
                info(contact);
            }else if(action.equals("delete")){
                delete(contact);
                break;
            }else{
                System.out.println("");
                break;
            }
        }

    }

    public boolean recordOptionChecker(String option){
        try{

            if(Integer.parseInt(option) > 0 && Integer.parseInt(option) <= this.contactBook.getContactBook().size()){
                return true;

            }else {
                System.out.println("Wrong option");
                return false;
            }
        }catch(NumberFormatException e){
            return false;
        }
    }

    public void add(String type){
        if (type.equals("person")) {
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
            this.contactBook.addContact(new Person(name, surName, birth, gender, number));
        }else if(type.equals("organization")){
            System.out.print("Organization name: ");
            String name = this.scanner.nextLine();
            System.out.print("Address: ");
            String address = this.scanner.nextLine();
            System.out.print("Number: ");
            String number = this.scanner.nextLine();
            this.contactBook.addContact(new Organization(name, address, number));
        }
    }


    public void info(Contact contact){
        String[] fields = contact.getFields();
        for(String field : fields){
            switch(field){
                case "name":
                    System.out.println("Name: " + contact.getField("name"));
                    break;

                case "surname":
                    System.out.println("Surname: " + contact.getField("surname"));
                    break;

                case "birth":
                    System.out.println("Birth date: " + contact.getField("birth"));
                    break;

                case "gender":
                    System.out.println("Gender: "+ contact.getField("gender"));
                    break;

                case "number":
                    System.out.println("Number: " + contact.getField("number"));
                    break;

                case "orgname":
                    System.out.println("Organization name: " + contact.getField("orgname"));
                    break;

                case "address":
                    System.out.println("Address: " + contact.getField("address"));
                    break;
            }
        }
        System.out.println("Time created: " + contact.getCreated());
        System.out.println("Time last edit: " + contact.getModified());
    }

    public void info(ArrayList<Contact> list, int index){
        String[] fields = list.get(index).getFields();
        for(String field : fields){
            switch(field){
                case "name":
                    System.out.println("Name: " + list.get(index).getField("name"));
                    break;

                case "surname":
                    System.out.println("Surname: " + list.get(index).getField("surname"));
                    break;

                case "birth":
                    System.out.println("Birth date: " + list.get(index).getField("birth"));
                    break;

                case "gender":
                    System.out.println("Gender: "+ list.get(index).getField("gender"));
                    break;

                case "number":
                    System.out.println("Number: " + list.get(index).getField("number"));
                    break;

                case "orgname":
                    System.out.println("Organization name: " + list.get(index).getField("orgname"));
                    break;

                case "address":
                    System.out.println("Address: " + list.get(index).getField("address"));
                    break;
            }
        }
        System.out.println("Time created: " + list.get(index).getCreated());
        System.out.println("Time last edit: " + list.get(index).getModified());
        System.out.println("");
    }

    public void listAll(){
        list(this.contactBook.getContactBook());

        }


    public void list(ArrayList<Contact> list){
        if(this.contactBook.isEmpty()){
            System.out.println("No records to list!");
        } else {
            for(int i = 0; i < list.size(); i++){
                System.out.println(i+1 + ". "+ list.get(i).toString());
            }
        }
    }

    public void delete(Contact contact){
        this.contactBook.deleteContact(contact);
    }


    public void edit(Contact contact){
        boolean edited = true;
                String[] fields = contact.getFields();
                StringBuilder options = new StringBuilder();
                options.append("Select a field ( ");
                for(String field : fields){
                    options.append(field);
                    options.append(", ");
                }
                String sub = options.substring(0, options.length() -2);
                sub = sub + "): ";
                System.out.print(sub);
                String editField = this.scanner.nextLine();

                switch(editField){
                    case "name":
                        System.out.print("Enter name: ");
                        String name = this.scanner.nextLine();
                        contact.changeField("name", name);
                        break;
                    case "surname":
                        System.out.print("Enter surname: ");
                        String surName = this.scanner.nextLine();
                        contact.changeField("surname", surName);
                        break;
                    case "birth":
                        System.out.print("Enter birth date: ");
                        String birth = this.scanner.nextLine();
                        contact.changeField("birth",birth);
                        break;

                    case "gender":
                        System.out.print("Enter gender: ");
                        String gender = this.scanner.nextLine();
                        contact.changeField("gender", gender);
                        break;

                    case "number":
                        System.out.print("Enter number: ");
                        String number = this.scanner.nextLine();
                        contact.changeField("number", number);
                        break;

                    case "address":
                        System.out.print("Enter address: ");
                        String address = this.scanner.nextLine();
                        contact.changeField("address", address);
                        break;

                    case "orgname":
                        System.out.print("Enter Organization name: ");
                        String orgName = this.scanner.nextLine();
                        contact.changeField("orgname", orgName);
                        break;

                    default:
                        edited =false;
                }

                if(edited){
                    System.out.println("Saved");
                }


    }


    public ArrayList<Contact> search() {
        System.out.print("Enter the search query: ");
        String search = this.scanner.nextLine();
        Pattern pattern = Pattern.compile(search, Pattern.CASE_INSENSITIVE);
        ArrayList<Contact> finds = new ArrayList<>();
        for (Contact contact : this.contactBook.getContactBook()) {
            String[] fields = contact.getFields();
            for(String field : fields){
                Matcher matcher = pattern.matcher(contact.getField(field));
                if(matcher.find()){
                    finds.add(contact);
                }
            }
        }
        if (finds.size() == 0) {
            System.out.println("No results found.");
            return null;
        } else {
            System.out.println("Found " + finds.size() + " results: ");
            list(finds);
            return finds;
        }
    }

    public void count(){
        System.out.println("The Phone Book has " + this.contactBook.count() + " records.");
        System.out.println("");
    }

}
