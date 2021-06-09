package oopfinal;
import java.io.*;
import java.util.Scanner;

class MainStaff {
    private static Scanner input;

    public static void staff() {
        input = new Scanner(System.in);
        System.out.println(" Staff Login");
        System.out.println("1)Login");
        System.out.println("2)Register");

        System.out.println();
        System.out.println("Enter Choice   : ");
        int option = input.nextInt();

        switch (option) {
            case 1 -> staffLogin();
            case 2 -> staffRegister();
            default -> {
                System.out.println("Invalid Key!");
                staff();
            }
        }
    }

    private static void staffLogin() {
        String password, line, username;
        String id;

        System.out.println("\t------------[ LOGIN ]-------------");
        System.out.println("\t__________________________________");
        System.out.println();
        System.out.println("\tID: ");
        id = input.next();
        System.out.println("\tPassword: ");
        password = input.next();


        try {
            BufferedReader br = new BufferedReader(new FileReader("staffLog.txt"));
            boolean authenticated = false;

            while ((line = br.readLine()) != null) {
                String[] text = line.split("\t");

                if (text[0].equals(id) && text[1].equals(password)) {
                    authenticated = true;
                    Main.setStaffID(id);
                    staffMenu();
                }
            }

            if (!authenticated) {
                System.out.println("Wrong Password");
            }

            br.close();
        } catch (IOException ex) {
            System.out.println("File Not Found");
        }

    }

    private static void staffRegister() {
        try {
            Scanner scan = new Scanner(System.in);
            File staff = new File("staff.txt");
            File custlog = new File("staffLog.txt");
            BufferedWriter staffBW = new BufferedWriter(new FileWriter("staff.txt", true));
            BufferedWriter logbw = new BufferedWriter(new FileWriter("staffLog.txt", true));
            ClinicStaff st = new ClinicStaff();

            if (staff.createNewFile()) {
            } else {
                staffBW.newLine();
            }
            if (custlog.createNewFile()) {
            } else {
                logbw.newLine();
            }

            System.out.println("Enter your ID: ");
            st.setStaffID(Integer.parseInt(scan.nextLine()));
            System.out.println("Enter your Name: ");
            st.setStaffName(scan.nextLine());
            System.out.println("Enter your Email: ");
            st.setStaffEmail(scan.nextLine());
            System.out.println("Enter your Password: ");
            st.setStaffPassword(scan.nextLine());
            System.out.println("Enter your phone number: ");
            st.setStaffPhoneNumber(Integer.parseInt(scan.nextLine()));

            // write in the txt
            staffBW.write(st.getStaffID() + "\t" + st.getStaffName() + "\t" + st.getStaffEmail() + "\t" + st.getStaffPassword() + "\t" + st.getStaffPhoneNumber());
            logbw.write(st.getStaffID() + "\t" + st.getStaffPassword());
            staffBW.close();
            logbw.close();
            System.out.println("\nSuccessfully wrote to the file.\n");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void staffMenu() {

        System.out.println(" Menu ");
        System.out.println("--------------------");
        System.out.println(" 1) View User Profile");
        System.out.println(" 2) View Appointments");
        System.out.println(" 3) Cancel or Approve Appointment");

        System.out.println();
        System.out.println(" Enter choice        :");
        int options = input.nextInt();

        switch (options) {
            case 1   :  viewProfile(); // to see the user profile
                break;
            case 2   :  viewAppointment(); // view appointment
                break;
            case 3   :  editAppointment(); // approve or decline
                break;
            default  :  System.out.println("Invalid Key!");
                        MainStaff.staff();
        }


    }

    private static void viewProfile() {
        try {
            Scanner myReader = new Scanner(new File("staff.txt"));

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] text = data.split("\t");

                if(data.contains(Main.getStaffID())){
                    String pwd = "";
                    for(int i=0;i<text[1].length();i++){pwd += "*";}

                    ClinicStaff staff = new ClinicStaff(Integer.parseInt(text[0]),text[1],text[2],text[3],Integer.parseInt(text[4]));

                    System.out.println("\n\n\tProfile Data\n");
                    System.out.println("ID\t: "+staff.getStaffID());
                    System.out.println("Name\t: "+staff.getStaffName());
                    System.out.println("Email\t\t: "+staff.getStaffEmail());
                    System.out.println("Phone Number\t: 0"+staff.getStaffPhoneNumber());
                    System.out.println("Password\t: "+pwd);
                }
            }
            System.out.println("\n\n");
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    private static void viewAppointment() {
    }


    private static void editAppointment() {


    }

}
