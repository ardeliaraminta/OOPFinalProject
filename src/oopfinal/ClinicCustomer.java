package oopfinal;

class ClinicCustomer {
    private String userName, password, fullName, email, homeAddress;
    private int phoneNumber;
    private AquaticPet pets;

    public ClinicCustomer() {
    }

    ;

    // assign values to details of Customer
    public void setUserName(String usr) {
        userName = usr;
    }

    public void setPassword(String pwd) {
        password = pwd;
    }

    public void setFullName(String fName) {
        fullName = fName;
    }

    public void setEmail(String mail) {
        email = mail;
    }

    public void setPhoneNumber(int phone) {
        phoneNumber = phone;
    }

    public void setHomeAddress(String add) {
        homeAddress = add;
    }


    // getters of details of the Customer

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getHomeAddress() {
        return homeAddress;
    }
}