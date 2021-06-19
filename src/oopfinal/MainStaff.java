package oopfinal;
import java.io.*;
import java.util.Scanner;

class MainStaff {
    private static Scanner input;

    public static void staff() {
        // staff main menu ( register or login )
        input = new Scanner(System.in);
        System.out.println(" ------------------------------------");
        System.out.println("\n\t\t\tStaff");
        System.out.println(" ------------------------------------");
        System.out.println("1)Register");
        System.out.println("2)Login");

        System.out.println();
        System.out.println("Enter Choice   : ");
        int option = input.nextInt();

        switch (option) {
            case 1 -> staffRegister();
            case 2 -> staffLogin();
            default -> {
                System.out.println("invalid choice !");
                staff();
            }
        }
    }

    //new staff register
    private static void staffRegister() {
        try {
            // create a file for the details of teh staff and staff verification
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

            // enter staff details
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
            System.out.println("Status: Full-Time / Part-Time");
            st.setStaffStatus(scan.nextLine());

            // write in the txt
            staffBW.write(st.getStaffID() + "\t" + st.getStaffName() + "\t" + st.getStaffEmail() + "\t" + st.getStaffPassword() + "\t" + st.getStaffPhoneNumber()+ "\t" + st.getStaffStatus());
            logbw.write(st.getStaffID() + "\t" + st.getStaffPassword());
            staffBW.close();
            logbw.close();

            System.out.println("\nSuccessfully wrote to the file.\n");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void staffLogin() {
        String password, line;
        String id;

        System.out.println("\t__________________________________");
        System.out.println("\t|          | LOGIN |              |");
        System.out.println("\t__________________________________");
        System.out.println();
        System.out.println("\tEnter your Staff ID: ");
        id = input.next();
        System.out.println("\tEnter your Password: ");
        password = input.next();


        try {
            // to read a file staffLog for login verification
            BufferedReader br = new BufferedReader(new FileReader("staffLog.txt"));
            boolean authenticated = false;

            // when the text file is not empty split text by tab
            while ((line = br.readLine()) != null) {
                String[] text = line.split("\t");

                // if the first index = id entered or registered and second index = password
                // proceed open staff menu
                if (text[0].equals(id) && text[1].equals(password)) {
                    // if the data matched open staff menu
                    authenticated = true;
                    Main.setStaffID(id);
                    staffMenu();
                }
            }
            //if either doesn't match
            if (!authenticated) {
                System.out.println("Wrong Password");
            }

            br.close();
        } catch (IOException ex) {
            System.out.println("File Not Found");
        }

    }

    // option for the staff menu
    public static void staffMenu() {

        System.out.println("              Menu              ");
        System.out.println("--------------------------------");
        System.out.println(" 1) View User Profile");
        System.out.println(" 2) Cancel or Approve Appointment");

        System.out.println();
        System.out.println(" Enter choice        :");
        int options = input.nextInt();

        switch (options) {
            case 1 -> viewStaffProfile(); // to see the user profile
            case 2 -> editAppointment(); // approve or decline incoming appointment from the customer
            default -> {
                System.out.println("Invalid Key!");
                MainStaff.staff();
            }
        }
    }

    private static void editAppointment() {
        try {
            // scanner to read the file
            Scanner appoint = new Scanner(new File("appointment.txt"));
            StringBuilder buffer = new StringBuilder();
            Scanner scan = new Scanner(System.in);
            int count = 0;

            // if there is data read per lines and split by tabs
            while (appoint.hasNextLine()) {
                String data = appoint.nextLine();
                String[] text = data.split("\t");

                // if the text file consist of 7 words it allows the staff to decline or accept the appointment
                // to check if the data required is available

                if (text.length == 7) {
                    System.out.println(data);
                    System.out.println("\nApprove/Reject: ");
                    String status = scan.next();
                    buffer.append(data).append("\t").append(status);
                } else {
                    buffer.append(data);
                }
                count++;
                if (count > 0) {
                    buffer.append("\n");
                }
            }

            FileOutputStream output = new FileOutputStream("appointment.txt");
            output.write(buffer.toString().getBytes());
            output.close();
            appoint.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // to see the details of the staff
    private static void viewStaffProfile() {
        try {
            // to obtain the data
            Scanner myReader = new Scanner(new File("staff.txt"));

            // to split the words in the text file
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] text = data.split("\t");

                // if there is data containing the staff id, get the password and encrypt it ***** ( confidential )
                if (data.contains(Main.getStaffID())) {
                    StringBuilder pwd = new StringBuilder();
                    for (int i = 0; i < text[1].length(); i++) {
                        pwd.append("*");
                    }

                    ClinicStaff staff = new ClinicStaff(Integer.parseInt(text[0]), text[1], text[2], text[3], Integer.parseInt(text[4]));
                    // print the staff details
                    System.out.println("\n\n\tProfile Data\n");
                    System.out.println("ID\t: " + staff.getStaffID());
                    System.out.println("Name\t: " + staff.getStaffName());
                    System.out.println("Email\t\t: " + staff.getStaffEmail());
                    System.out.println("Phone Number\t: 0" + staff.getStaffPhoneNumber());
                    System.out.println("Password\t: " + pwd);
                }
            }
            System.out.println("\n\n");
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}

