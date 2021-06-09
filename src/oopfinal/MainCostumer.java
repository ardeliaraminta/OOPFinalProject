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
            if (!validation) {
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
            File custLog = new File("custLog.txt");
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
            case 1 -> doctorSchedule(); // see available doctors
            case 2 -> viewAppointment(); // details of appointment
            case 3 -> addAppointment();
            case 4 -> viewProfile(); // view costumer and pet profile
            case 5 -> addAquaticPet();
            // register the pet
            default -> {
                System.out.println(" Invalid choice ");
                MainStaff.staff();
            }
        }

    }

    private static void doctorSchedule() throws IOException {
        Doctors doctor1 = new Doctors("Dr.Killjoy");
        Doctors doctor2 = new Doctors("Dr.Sage");
        Doctors doctors3 = new Doctors("Dr.Reyna");

        // make an arraylist of doctors available at certain time for checkup schedule
        List<Doctors> doctor1000 = new ArrayList<Doctors>(Arrays.asList(doctor2,doctor2, doctor2,doctor1,doctor1, doctor2));
        List<Doctors> doctor1100 = new ArrayList<Doctors>(Arrays.asList(doctor1,doctor1, doctor2,doctor2,doctor1, doctor1));
        List<Doctors> doctor1300 = new ArrayList<Doctors>(Arrays.asList(doctor2,doctor2, doctor2,doctor1,doctor1, doctor2));
        List<Doctors> doctor1600 = new ArrayList<Doctors>(Arrays.asList(doctor2,doctor2, doctor2,doctor1,doctor1, doctor2));
        List<Doctors> doctor1800 = new ArrayList<Doctors>(Arrays.asList(doctor2,doctor2, doctor2,doctor1,doctor1, doctor2));
        List<Doctors> doctor2000 = new ArrayList<Doctors>(Arrays.asList(doctor2,doctor2, doctor2,doctor1,doctor1, doctor2));
        List<Doctors> doctor2200 = new ArrayList<Doctors>(Arrays.asList(doctor2,doctor2, doctor2,doctor1,doctor1, doctor2));



        List<ScheduleTime> time = new ArrayList<>(Arrays.asList(new ScheduleTime(1000, doctor1000),
                new ScheduleTime(1200, doctor1100), new ScheduleTime(1400, doctor1300), new ScheduleTime(1600, doctor1600),
                new ScheduleTime(1800, doctor1800), new ScheduleTime(2000, doctor2000), new ScheduleTime(2200, doctor2200)));

        System.out.println("\t\t Schedule Timetable");
        System.out.println("\t\t __________________");
        System.out.println();
        System.out.println("Week:\t |Monday\t |Tuesday\t |Wednesday\t |Thursday\t |Friday\t |Saturday\t |Sunday");

        for(int i=0;i<time.size();i++){
            String line = "";

            for(int j=0;j<time.get(i).getDoctors().size();j++){
                if(j != (time.get(i).getDoctors().size()-1)){line += time.get(i).getDoctors().get(j).getDoctors() + "\t |";
                } else{line += time.get(i).getDoctors().get(j).getDoctors();}
            }

            System.out.println(time.get(i).getScheduleTime()+"\t |Close \t |"+line);
        }

        customerMenu();
    }

    private static void viewAppointment() {

    }

    private static void addAppointment() {
    }

    private static void viewProfile() {
    }

    private static void addAquaticPet() {
        Scanner scan = new Scanner(System.in);

        try {
            File pet = new File("pet.txt");
            BufferedWriter petBW = new BufferedWriter(new FileWriter("pet.txt",true));

            if(pet.createNewFile()){}else{petBW.newLine();}

            System.out.println("Please choose yours pet species: ");
            System.out.println("1) Whale");
            System.out.println("2) Shark");
            System.out.println("3) Others");

            System.out.println();
            System.out.print("Enter Choice           : ");
            int opt = scan.nextInt();
            scan.nextLine();

            switch (opt) {
                case 1   :  Whale whale = new Whale();

                    System.out.println("Enter your Pet name: ");
                    whale.setPetName(scan.nextLine());
                    System.out.println("Enter your Pet age: ");
                    whale.setPetAge(Integer.parseInt(scan.nextLine()));
                    whale.setPetOwner(Main.getUsername());
                    whale.setPetSpecies("Blue Whale");
                    System.out.println("Pet Behaviour; Aggressive/ Soft ");
                    whale.setBehaviour(scan.nextLine());
                    System.out.println("Any particular allergies: ");
                    whale.setAllergies(scan.nextLine());

                    petBW.write(whale.getPetName()+"\t"+whale.getPetAge()+"\t"+whale.getPetOwner()+"\t"+whale.getPetSpecies()+"\t"+whale.getBehaviour()+"\t" + whale.getAllergies());
                    break;

                case 2   :  Shark shark = new Shark();

                    System.out.println("Enter your Pet name: ");
                    shark.setPetName(scan.nextLine());
                    System.out.println("Enter your Pet age: ");
                    shark.setPetAge(Integer.parseInt(scan.nextLine()));
                    shark.setPetOwner(Main.getUsername());
                    shark.setPetSpecies("Blue Whale");
                    System.out.println("Pet Behaviour; Aggressive/ Soft ");
                    shark.setBehaviour(scan.nextLine());
                    System.out.println("Any particular allergies: ");
                    shark.setAllergies(scan.nextLine());

                    petBW.write(shark.getPetName()+"\t"+shark.getPetAge()+"\t"+shark.getPetOwner()+"\t"+shark.getPetSpecies()+"\t"+shark.getBehaviour()+"\t" + shark.getAllergies());
                    break;
                    //case 3 for other species -> Others
                case 3   :

                default  :  System.out.println("Invalid");
                    MainStaff.staff();
            }

            petBW.close();
            System.out.println("\n Success writing to the file !\n");
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}












