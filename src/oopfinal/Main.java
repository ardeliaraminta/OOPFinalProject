package oopfinal;

import java.util.Scanner;

public class Main {

    private static Scanner Line;
    private static String user;

    public static void setStaffID(String us){
        user = us;
    }
    public static String getStaffID() {
        return user;
    }


    public static void setUserName(String us) {
        user = us;
    }

    public static String getUsername() {
        return user;
    }

    public static void main ( String[] args){

        Line = new Scanner(System.in);

        boolean cont = false;
        while ( !cont) {
            Scanner ent = new Scanner(System.in);

            System.out.println(" -------------------------------------------------------------");
            System.out.println("|                                                             |");
            System.out.println("| Welcome To Something Fishy: Ocean Animal Pet Center System  |");
            System.out.println("|                                                             |");
            System.out.println(" ------------------------------------------------------------- ");
            System.out.println("|                        A) Staff                             |");
            System.out.println("|                        B) Customer                          |");
            System.out.println("---------------------------------------------------------------");

            System.out.println();
            System.out.println("Select your choice:           ");
            String choice = ent.next();

            // direct them to customer or staff main
            if (choice.toUpperCase().charAt(0) == 'A'){
                MainStaff.staff();
            } else if (choice.toUpperCase().charAt(0) == 'B'){
                MainCostumer.customer();
            } else {
                System.out.println("Invalid Choice!");
                cont = false;
            }

            new Main();


        }

    }

}
