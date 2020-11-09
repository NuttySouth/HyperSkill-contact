class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        // write your code here
        this.firstName = firstName == null ? "" : firstName;
    }

    public void setLastName(String lastName) {
        // write your code here
        this.lastName = lastName == null ? "" : lastName;
    }

    public String getFullName() {
        if(this.firstName.isBlank() && this.lastName.isBlank()){
            return "Unknown";
        }
        if(this.firstName.isBlank() && !this.lastName.isBlank()){
            return this.lastName;
        }
        if(!this.firstName.isBlank() && this.lastName.isBlank()){
            return this.firstName;
        }

        return (this.firstName + " " + this.lastName);
    }
}