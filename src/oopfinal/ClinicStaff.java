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


}
