package contacts;

import java.util.ArrayList;

public class Organization extends Contact {
    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<String> fields;

    public Organization(){
        super();
        this.fields = new ArrayList<>();
        this.fields.add("name");
        this.fields.add("address");
        this.fields.add("number");
    }
    public Organization(String name,String address, String phoneNumber){
        super();
        this.name = name;
        this.phoneNumber = checkNumber(phoneNumber);
        this.address = address;
        this.fields = new ArrayList<>();
        this.fields.add("orgname");
        this.fields.add("address");
        this.fields.add("number");
    }
    @Override
    public boolean hasField(String field){
        return this.fields.contains(field);
    }

    @Override
    public String[] getFields(){
        String[] fieldsArr = new String[this.fields.size()];
        fieldsArr = this.fields.toArray(fieldsArr);
        return fieldsArr;
    }

    @Override
    public void changeField(String field, String value){

        switch(field){
            case "orgname":
                setName(value);
                break;
            case "address":
                setAddress(value);
                break;
            case "number":
                setPhoneNumber(value);
                break;
        }
    }

    @Override
    public String getField(String field){
        switch(field){
            case "orgname":
                return getName();
            case "address":
                return getAddress();
            case "number":
                return getPhoneNumber();
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = checkNumber(phoneNumber);
    }

    @Override
    public String toString(){
        return this.name;
    }
}
