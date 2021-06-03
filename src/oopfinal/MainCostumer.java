package oopfinal;

import java.util.Scanner;

public class MainCostumer {
    private static Scanner in;

    public static void customer() {
        in = new Scanner(System.in);
        System.out.println("\n\tCustomer Login");
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
    }//end of customer

    private static void customerRegistration() {
    }

    private static void customerLogin() {
    }

}
