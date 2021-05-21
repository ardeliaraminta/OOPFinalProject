package oopfinal;

public class ClinicStaff {
    private String StaffName;
    private String StaffEmail;
    private String StaffPassword;
    private int StaffID;
    private int StaffPhoneNumber;

    public ClinicStaff(){};

    public ClinicStaff(int id, String name,String mail, String pass, int phone  ){
        StaffID = id;
        StaffName = name;
        StaffEmail = mail;
        StaffPassword = pass;
        StaffPhoneNumber = phone;
    }
    //getters setters

    public void setStaffName(String sName) {
        StaffName = sName;
    }

    public void setStaffEmail(String sEmail) {
        StaffEmail = sEmail;
    }

    public void setStaffPassword(String sPassword){
        StaffPassword = sPassword;
    }

    public void setStaffID(int id) {
        StaffID = id;
    }

    public void setStaffPhoneNumber(int phone){
        StaffPhoneNumber = phone;
    }

    public String getStaffName(){
        return StaffName;
    }

    public String getStaffEmail(){
        return StaffEmail;
    }

    public String getStaffPassword(){
        return StaffPassword;
    }

    public int getStaffID() {
        return StaffID;
    }

    public int getStaffPhoneNumber() {
        return StaffPhoneNumber;
    }

}
