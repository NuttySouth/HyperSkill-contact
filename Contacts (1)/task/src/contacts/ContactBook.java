package contacts;

import java.io.Serializable;
import java.util.ArrayList;

public class ContactBook implements Serializable {

    private static final long serialVersionUID = 1L;

    private ArrayList<Contact> list;

    public ContactBook(){
        this.list = new ArrayList<>();
    }

    public void addContact(Contact contact){
        this.list.add(contact);
    }

    public void deleteContact(int index){
        this.list.remove(index + 1);
    }

    public void deleteContact(Contact contact){ this.list.remove(contact);}

    public int count(){
        return this.list.size();
    }

    public Contact getContact(int index){
        return this.list.get(index);
    }

    public boolean isEmpty(){
        return this.list.size() < 1;
    }

    public ArrayList<Contact> getContactBook(){
        return new ArrayList<>(list);
    }
}
