package contacts;

import java.util.ArrayList;

public class Person extends Contact {
    private String firstName;
    private String surName;
    private String phoneNumber;
    private String birthDate;
    private String gender;
    private ArrayList<String> fields;

    public Person(){
        super();
        this.fields = new ArrayList<>();
        this.fields.add("name");
        this.fields.add("surname");
        this.fields.add("birth");
        this.fields.add("gender");
        this.fields.add("number");
    }
    public Person(String firstName, String surName, String birthDate, String gender,String phoneNumber ){
        super();
        this.firstName = firstName;
        this.surName = surName;
        this.birthDate = checkBirthDate(birthDate);
        this.gender = checkGender(gender);
        this.phoneNumber = checkNumber(phoneNumber);
        this.fields = new ArrayList<>();
        this.fields.add("name");
        this.fields.add("surname");
        this.fields.add("birth");
        this.fields.add("gender");
        this.fields.add("number");
    }

    public String getFirstName() {
        return firstName;
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
                case "name":
                    setFirstName(value);
                    break;
                case "surname":
                    setSurName(value);
                    break;
                case "birth":
                    setBirthDate(value);
                    break;
                case "gender":
                    setGender(value);
                    break;
                case "number":
                    setPhoneNumber(value);
                    break;
            }
    }

    @Override
    public String getField(String field){
        switch(field){
            case "name":
                return getFirstName();
            case "surname":
                return getSurName();
            case "birth":
                return getBirthDate();
            case "gender":
                return getGender();
            case "number":
                return getPhoneNumber();
            }
        return null;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = checkNumber(phoneNumber);
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = checkBirthDate(birthDate);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = checkGender(gender);
    }

    public String checkBirthDate(String birthDate){
        if(birthDate.isEmpty()){
            return "[no data]";
        }else {
            return birthDate;
        }
    }

    public String checkGender(String gender){
        if(gender.equals("M") || gender.equals("F")){
            return gender;
        }else {
            return "[no data]";
        }
    }

    @Override
    public String toString(){
        return this.firstName + " " + this.surName;
    }
}
