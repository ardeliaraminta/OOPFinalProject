package oopfinal;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainCostumer {

    // redirected to login or register page
    public static void customer() {
        Scanner in = new Scanner(System.in);
        System.out.println("\n\tCustomer");
        System.out.println("-------------------------------------");
        System.out.println("1)Login");
        System.out.println("2) Register");

        System.out.println();
        System.out.print("Enter Choice           : ");
        int choice = in.nextInt();

        switch (choice) {
            case 1 -> customerLogin();
            case 2 -> customerRegistration();
            default -> {
                System.out.println("Invalid Key!");
                customer();
            }
        }
    }

    public static void customerLogin() {
        String username, password, line;
        Scanner scan = new Scanner(System.in);

        //customer login page: Username and Password entry

        System.out.println("\t-----------( LOGIN )--------------");
        System.out.println("\t__________________________________");
        System.out.println();
        System.out.println("\tUsername: ");
        username = scan.next();
        System.out.println("\tPassword: ");
        password = scan.next();

        try {
            BufferedReader br = new BufferedReader(new FileReader("custLog.txt"));
            boolean validation = false;

            // while loop, if the line is not empty (txt)  and contains username and password
            // proceed to the customer menu

            while ((line = br.readLine()) != null) {
                if (line.contains(username) && line.contains(password)) {
                    validation = true;
                    Main.setUserName(username);
                    customerMenu();
                }
            }

            // if the password is false
            if (validation == false) {
                System.out.println("Password entered is wrong. ");
            }

            br.close();
        }
        // if the data not found
        catch (IOException ex) {
            System.out.println("File Not Found");
        }

    }


    public static void customerRegistration() {
        try {

            // written in the text file
            Scanner sc = new Scanner(System.in);
            File cust = new File("customer.txt");
            File custLog = new File("customerLog.txt");
            BufferedWriter custBW = new BufferedWriter(new FileWriter("customer.txt", true));
            BufferedWriter logBW = new BufferedWriter(new FileWriter("custLog.txt", true));
            ClinicCustomer customer = new ClinicCustomer();

            if (cust.createNewFile()) {
            } else {
                custBW.newLine();
            }
            if (custLog.createNewFile()) {
            } else {
                logBW.newLine();
            }
            // enter data of the customer
            System.out.println("Enter your user name: ");
            customer.setUserName(sc.nextLine());
            System.out.println("Password: ");
            customer.setPassword(sc.nextLine());
            System.out.println("Full name:");
            customer.setFullName(sc.nextLine());
            System.out.println("Email:");
            customer.setEmail(sc.nextLine());
            System.out.println("Enter your phone number: ");
            customer.setPhoneNumber(Integer.parseInt(sc.nextLine()));
            System.out.println("Enter your address: ");
            customer.setHomeAddress(sc.nextLine());

            custBW.write(customer.getUserName() + "\t" + customer.getPassword() + "\t" + customer.getFullName() + "\t" + customer.getEmail() + "\t" + customer.getPhoneNumber() + "\t" + customer.getHomeAddress() + "\t");
            logBW.write(customer.getUserName() + "\t" + customer.getPassword());

            custBW.close();
            logBW.close();

            System.out.println("\n Data written in the file.\n");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void customerMenu() throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n\tMenu");
        System.out.println("-------------------------------------");
        System.out.println(" 1) Clinic Schedule");
        System.out.println(" 2) View Appointment");
        System.out.println(" 3) Add New Appointment");
        System.out.println(" 4) View Profile");
        System.out.println(" 5) Add Pet Data");

        System.out.println();
        System.out.print("Enter Choice           : ");
        int options = sc.nextInt();

        switch (options) {
            case 1:
                doctorSchedule();
                break;
            case 2:
                viewAppointment();
                break;
            case 3:
                addAppointment();
                break;
            case 4:
                viewProfile();
                break;
            case 5:
                addAquaticPet();
                break;
            default:
                System.out.println(" Invalid choice ");
                MainStaff.staff();
        }

    }

    private static void doctorSchedule() {
        Doctors doctor1 = new Doctors("Dr.Olivia");
        Doctors doctor2 = new Doctors("Dr.Ariana");

        // make an arraylist of doctors available at certain time for checkup schedule
        List<Doctors> doctor1000 = new ArrayList<Doctors>(Arrays.asList(doctor2,doctor2, doctor2,doctor1,doctor1, doctor2));
        List<Doctors> doctor1100 = new ArrayList<Doctors>(Arrays.asList(doctor1,doctor1, doctor2,doctor2,doctor1, doctor1));
        List<Doctors> doctor1300 = new ArrayList<Doctors>(Arrays.asList(doctor2,doctor2, doctor2,doctor1,doctor1, doctor2));
        List<Doctors> doctor1600 = new ArrayList<Doctors>(Arrays.asList(doctor2,doctor2, doctor2,doctor1,doctor1, doctor2));
        List<Doctors> doctor1800 = new ArrayList<Doctors>(Arrays.asList(doctor2,doctor2, doctor2,doctor1,doctor1, doctor2));
        List<Doctors> doctor2000 = new ArrayList<Doctors>(Arrays.asList(doctor2,doctor2, doctor2,doctor1,doctor1, doctor2));
        List<Doctors> doctor2200 = new ArrayList<Doctors>(Arrays.asList(doctor2,doctor2, doctor2,doctor1,doctor1, doctor2));



        List<ScheduleTime> time = new ArrayList<ScheduleTime>(Arrays.asList(new ScheduleTime(1000,doctor1000),
                new ScheduleTime(1200,doctor1100),new ScheduleTime(1400,doctor1300),new ScheduleTime(1600,doctor1600),
                new ScheduleTime(1800,doctor1800),new ScheduleTime(2000,doctor2000),new ScheduleTime(2200,doctor2200)));

        System.out.println("\t\t Schedule Timetable");
        System.out.println("\t\t __________________");
        System.out.println();
        System.out.println("Week:\\t |Monday\t |Tuesday\t |Wednesday\t |Thursday\t |Friday\t |Saturday\t |Sunday");
    }

    private static void viewAppointment() {
    }

    private static void addAppointment() {
    }

    private static void viewProfile() {
    }

    private static void addAquaticPet() {
    }
}












