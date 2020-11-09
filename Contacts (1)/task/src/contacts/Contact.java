package contacts;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Contact {
    private final Pattern pattern = Pattern.compile("\\+?((\\(\\w+\\)([\\s-]\\w{2,})?)|(\\w+([\\s-]\\(\\w{2,}\\))?))([\\s-]\\w{2,}){0,3}");
    private LocalDateTime created;
    private LocalDateTime modified;

    public Contact(){
        this.created = created.now();
        this.modified = modified.now();
    }


    public String checkNumber(String number){
            Matcher matcher = pattern.matcher(number);
            if (number.isEmpty()) {
                return "[no number]";
            } else if (matcher.matches()) {
                return number;
            } else {
                System.out.println("Wrong number format!");
                return "[no number]";
            }
        }

    public LocalDateTime getCreated(){
        return this.created;
    }

    public LocalDateTime getModified(){
        return this.modified;
    }

    public void update(){
        this.modified = modified.now();
    }

    abstract String[] getFields();
    abstract String getField(String field);
    abstract void changeField(String field, String value);
    abstract boolean hasField(String field);
}




