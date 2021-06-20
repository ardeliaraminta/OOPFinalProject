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
        System.out.println(" ------------------------------------");
        System.out.println("\n\t\t\tCustomer");
        System.out.println(" ------------------------------------");
        System.out.println("1) Login");
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
        System.out.println("\t__________________________________");
        System.out.println("\t|          | LOGIN |              |");
        System.out.println("\t__________________________________");
        System.out.println();
        System.out.println("\tUsername: ");
        username = scan.next();
        System.out.println("\tPassword: ");
        password = scan.next();

        try {
            //read the custLog.txt file
            BufferedReader br = new BufferedReader(new FileReader("custLog.txt"));
            boolean validation = false;

            // while loop, if the line is not empty (txt)  and if  contains username and password
            // it checks with the validation, and proceed to the customer menu

            while ((line = br.readLine()) != null) {
                if (line.contains(username) && line.contains(password)) {
                    // if it matched for both password and username
                    validation = true;
                    // set data for that specific user and proceed to the menu
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

            // initiate file writer for different text file, in this case
            // custBW is to store the details of the customer that register
            // logBW is to store username and password of customer ( for login verification)
            BufferedWriter custBW = new BufferedWriter(new FileWriter("customer.txt", true));
            BufferedWriter logBW = new BufferedWriter(new FileWriter("custLog.txt", true));
            ClinicCustomer customer = new ClinicCustomer();

            // if there is txt file already write on new line
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
            // password
            System.out.println("Password: ");
            customer.setPassword(sc.nextLine());
            // fullname
            System.out.println("Full name:");
            customer.setFullName(sc.nextLine());
            // email
            System.out.println("Email:");
            customer.setEmail(sc.nextLine());
            System.out.println("Enter your phone number: ");
            // phone number
            customer.setPhoneNumber(Integer.parseInt(sc.nextLine()));
            //address
            System.out.println("Enter your address: ");
            customer.setHomeAddress(sc.nextLine());

            // write in text file the above entries
            // customer.txt
            custBW.write(customer.getUserName() + "\t" + customer.getPassword() + "\t" + customer.getFullName() + "\t" + customer.getEmail() + "\t" + customer.getPhoneNumber() + "\t" + customer.getHomeAddress() + "\t");
            // custLog.txt
            logBW.write(customer.getUserName() + "\t" + customer.getPassword());

            custBW.close();
            logBW.close();

            System.out.println("\n Done \n");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void customerMenu() throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("              Menu              ");
        System.out.println("--------------------------------");
        System.out.println(" 1) Clinic Schedule");
        System.out.println(" 2) View Appointment");
        System.out.println(" 3) Add New Appointment");
        System.out.println(" 4) Add Pet Data");

        System.out.println();
        System.out.print("Enter Choice           : ");
        int options = sc.nextInt();

        switch (options) {
            case 1 -> doctorSchedule(); // see available doctors
            case 2 -> viewDetailsAppointment(); // details of appointment
            case 3 -> addAppointment(); // add new appointment
            case 4 -> addAquaticPet(); // register new customer pet
            default -> {
                System.out.println(" Invalid choice ");
                MainStaff.staff();
            }
        }

    }

    private static void doctorSchedule() throws IOException {

        // create an instance of the doctors
        Doctors doctor1 = new Doctors("Dr.Killjoy");
        Doctors doctor2 = new Doctors("Dr.Sage");
        Doctors doctor3 = new Doctors("Dr.Reyna");

        // make an arraylist of doctors available at certain time for checkup schedule
        List<Doctors> doctor1000 = new ArrayList<>(Arrays.asList(doctor3, doctor2, doctor2, doctor1, doctor1, doctor3));
        List<Doctors> doctor1100 = new ArrayList<>(Arrays.asList(doctor1, doctor1, doctor2, doctor2, doctor1, doctor1));
        List<Doctors> doctor1300 = new ArrayList<>(Arrays.asList(doctor3, doctor3, doctor2, doctor1, doctor1, doctor2));
        List<Doctors> doctor1600 = new ArrayList<>(Arrays.asList(doctor2, doctor2, doctor2, doctor3, doctor1, doctor2));
        List<Doctors> doctor1800 = new ArrayList<>(Arrays.asList(doctor2, doctor3, doctor2, doctor1, doctor1, doctor2));
        List<Doctors> doctor2000 = new ArrayList<>(Arrays.asList(doctor3, doctor2, doctor2, doctor3, doctor1, doctor2));
        List<Doctors> doctor2200 = new ArrayList<>(Arrays.asList(doctor2, doctor2, doctor2, doctor1, doctor1, doctor2));


        // make an arraylist of time
        List<ScheduleTime> time = new ArrayList<>(Arrays.asList(new ScheduleTime(1000, doctor1000),
                new ScheduleTime(1200, doctor1100), new ScheduleTime(1400, doctor1300), new ScheduleTime(1600, doctor1600),
                new ScheduleTime(1800, doctor1800), new ScheduleTime(2000, doctor2000), new ScheduleTime(2200, doctor2200)));

        System.out.println("\t\t Schedule Timetable");
        System.out.println("\t\t __________________");
        System.out.println();
        System.out.println("Time:\t |Monday\t |Tuesday\t |Wednesday\t |Thursday\t |Friday\t |Saturday\t |Sunday");

        for (ScheduleTime scheduleTime : time) {
            StringBuilder line = new StringBuilder();

            // for loop for the schedule time:  obtain doctors available on that specific time and display on the days
            for (int j = 0; j < scheduleTime.getDoctors().size(); j++) {
                if (j != (scheduleTime.getDoctors().size() - 1)) {
                    line.append(scheduleTime.getDoctors().get(j).getDoctors()).append("\t |");
                } else {
                    line.append(scheduleTime.getDoctors().get(j).getDoctors());
                }
            }

            // monday close
            System.out.println(scheduleTime.getScheduleTime() + "\t |Close \t |" + line);
        }

        customerMenu();
    }


    private static void addAppointment() throws IOException {
        // initiate the first id of the appointment
        LineNumberReader reader = null;
        int id = 0;
        try {
            // create a new file for appointment details
            Scanner scan = new Scanner(System.in);
            File appointment = new File("Appointment.txt");
            BufferedWriter appointmentBW = new BufferedWriter(new FileWriter("appointment.txt", true));
            BufferedReader appointmentBR = new BufferedReader(new FileReader("appointment.txt"));

            // if there is no file to be overwritten then make a new file else add a new line or create a new line.
            if (appointment.createNewFile()) {
            } else {
                appointmentBW.newLine();
            }

            reader = new LineNumberReader(new FileReader("appointment.txt"));
            // Read file till the end
            while ((reader.readLine()) != null) {
                id = reader.getLineNumber() + 1;
            }

            // read the pet.txt file to get information and details of the pet
            String line = "invalid";
            String petName = "invalid";
            String petAllergies = "invalid";
            String petSpecies = "invalid";
            BufferedReader br = new BufferedReader(new FileReader("pet.txt"));

            // while the line is not empty and it contains the username, split each of words and
            // according to the index assign the species and pet name

            while ((line = br.readLine()) != null) {
                if (line.contains(Main.getUsername())) {
                    String[] text = line.split("\t");

                    // assign values taken from pet.txt based on index
                    petSpecies = text[3];
                    petName = text[0];
                    petAllergies = text[5];
                }
            }

            br.close();

            //appointment details

            System.out.println("Appointment id: " + id);
            System.out.println("Enter Appointment Date (dd/mm/yyyy): ");
            String date = scan.nextLine();
            System.out.println("Enter Appointment Time (exp: 1430): ");
            String time = scan.nextLine();
            System.out.println("Username: " + Main.getUsername());
            String name = Main.getUsername();
            System.out.println("Pet Species: " + petSpecies);
            String petS = petSpecies;
            System.out.println("Pet Name: " + petName);
            String petN = petName;
            String petA = petAllergies;
            System.out.println("Pet Allergies: " + petAllergies);
            System.out.println("Appointment Reason: ");
            String reason = scan.nextLine();

            appointmentBW.write(id + "\t" + date + "\t" + time + "\t" + name + "\t" + petN + "\t" + petS + "\t" + petA + "\t" + reason);
            appointmentBW.close();
            System.out.println("\n Done!\n");
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        customerMenu();
    }

    public static void viewDetailsAppointment() {
        try {
            Scanner myReader = new Scanner(new File("appointment.txt"));

            // if there is data, print the following
            if (myReader.hasNextLine()) {
                System.out.println("\n\nAppointment Data\n");
                System.out.println("ID\tPet Name\tDate\t\t\tTime\t\tPet Owner\t\tPet Species\t\tReason Visit \t\tApproval");
                System.out.println("___________________________________________________________________________________________________________");
            } else {
                System.out.println("\n\nNo appointment is found.\n");
            }

            // while there is line, split the words by tabs
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] text = data.split("\t");

                // if there is data of the user create a new instance
                if (data.contains(Main.getUsername())) {

                    AppointmentDetails appoint = new AppointmentDetails(Integer.parseInt(text[0]), text[1], text[2], text[3], text[4]);

                    // if the words length is 8, get data based on the index
                    if (text.length == 8) {
                        System.out.println(appoint.getId() + "\t" + appoint.getDateTime() + "\t\t" + appoint.getPetOwner() + "\t\t" + appoint.getPetSpecies() + "\t\t" + appoint.getReasonOfVisit()+ "\t\t" + text[5] + "\t\t" + text[7] );
                    } else {
                        System.out.println(appoint.getId() + "\t" + appoint.getDateTime() + "\t\t" + appoint.getPetOwner() + "\t\t" + "\t\t" + appoint.getPetSpecies() + "\t\t" + appoint.getReasonOfVisit()  + "\t\t" + text[5] + "\t\t" + text[6] +"\t\t" + text[7] + "\t\t" + text[8]);
                    }
                }
            }
            System.out.println("\n\n");
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }//end of addAppointment

    private static void addAquaticPet() throws IOException {
        Scanner scan = new Scanner(System.in);

        try {
            // write in text file
            File pet = new File("pet.txt");
            BufferedWriter petBW = new BufferedWriter(new FileWriter("pet.txt", true));

            // if there is no text file create new, if there is existing file write a new line
            if (pet.createNewFile()) {
            } else {
                petBW.newLine();
            }

            // choose pet species
            System.out.println("Please choose yours pet species: ");
            System.out.println("1) Whale");
            System.out.println("2) Shark");
            System.out.println("3) Others");

            // choose 1/2/3
            System.out.println();
            System.out.print("Enter Choice           : ");
            int opt = scan.nextInt();
            scan.nextLine();

            // switch statement for the selected pet species
            //write in text file the details
            //case 3 for other species -> Others
            switch (opt) {
                case 1 -> {
                    Whale whale = new Whale();
                    System.out.println("Enter your Pet name: ");
                    whale.setPetName(scan.nextLine());
                    System.out.println("Enter your Pet age: ");
                    whale.setPetAge(Integer.parseInt(scan.nextLine()));
                    whale.setPetOwner(Main.getUsername());
                    System.out.println("Enter your Pet species: ");
                    whale.setPetSpecies(scan.nextLine() + "Whale");
                    System.out.println("Pet Behaviour; Aggressive/ Soft ");
                    whale.setBehaviour(scan.nextLine());
                    System.out.println("Any particular allergies: ");
                    whale.setAllergies(scan.nextLine());
                    petBW.write(whale.getPetName() + "\t" + whale.getPetAge() + "\t" + whale.getPetOwner() + "\t" + whale.getPetSpecies() + "\t" + whale.getBehaviour() + "\t" + whale.getAllergies());
                }
                case 2 -> {
                    Shark shark = new Shark();
                    System.out.println("Enter your Pet name: ");
                    shark.setPetName(scan.nextLine());
                    System.out.println("Enter your Pet age: ");
                    shark.setPetAge(Integer.parseInt(scan.nextLine()));
                    shark.setPetOwner(Main.getUsername());
                    System.out.println("Enter your Pet species: ");
                    shark.setPetSpecies(scan.nextLine() + "Shark");
                    System.out.println("Pet Behaviour; Aggressive/ Soft ");
                    shark.setBehaviour(scan.nextLine());
                    System.out.println("Any particular allergies: ");
                    shark.setAllergies(scan.nextLine());
                    petBW.write(shark.getPetName() + "\t" + shark.getPetAge() + "\t" + shark.getPetOwner() + "\t" + shark.getPetSpecies() + "\t" + shark.getBehaviour() + "\t" + shark.getAllergies());
                }
                case 3 -> {
                    Others other = new Others();
                    System.out.println("Enter your Pet name: ");
                    other.setPetName(scan.nextLine());
                    System.out.println("Enter your Pet age: ");
                    other.setPetAge(Integer.parseInt(scan.nextLine()));
                    other.setPetOwner(Main.getUsername());
                    System.out.println("Enter your Pet species: ");
                    other.setPetSpecies(scan.nextLine());
                    System.out.println("Pet Behaviour; Aggressive/ Soft ");
                    other.setBehaviour(scan.nextLine());
                    System.out.println("Any particular allergies: ");
                    other.setAllergies(scan.nextLine());
                    petBW.write(other.getPetName() + "\t" + other.getPetAge() + "\t" + other.getPetOwner() + "\t" + other.getPetSpecies() + "\t" + other.getBehaviour() + "\t" + other.getAllergies());
                }
                default -> {
                    System.out.println("Invalid");
                    MainStaff.staff();
                }
            }

            petBW.close();
            System.out.println("\n  Done! \n");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        customerMenu();
    }
}












