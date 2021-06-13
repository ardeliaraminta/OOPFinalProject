package oopfinal;

public class ClinicStaff implements StaffDetails {
    private String StaffName;
    private String StaffEmail;
    private String StaffPassword;
    private int StaffID;
    private int StaffPhoneNumber;
    private boolean isFullTime;

    public ClinicStaff() {
    }

    ;

    public ClinicStaff(int id, String name, String mail, String pass, int phone) {
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

    public void setStaffPassword(String sPassword) {
        StaffPassword = sPassword;
    }

    public void setStaffID(int id) {
        StaffID = id;
    }

    public void setStaffPhoneNumber(int phone) {
        StaffPhoneNumber = phone;
    }

    public String getStaffName() {
        return StaffName;
    }

    public String getStaffEmail() {
        return StaffEmail;
    }

    public String getStaffPassword() {
        return StaffPassword;
    }

    public int getStaffID() {
        return StaffID;
    }

    public int getStaffPhoneNumber() {
        return StaffPhoneNumber;
    }

    @Override
    public void status() {
        System.out.println(" I'm working for a whole day ! ");
    }

    @Override
    public void setFullTime(boolean fullTime) {
        isFullTime = fullTime;
    }

    @Override
    public boolean isFullTime() {
        return isFullTime;
    }

    @Override
    public String staffStatus() {
        if (isFullTime()) {
            return "Full-Time Staff";
        } else {
            return "Part-Time Staff";
        }
    }

    @Override
    public void checkStatus() {
        if (isFullTime()) {
            status();
        } else {
            System.out.println("Only part-timing");

        }
    }
}
