package oopfinal;
import java.util.Scanner;

class MainStaff {

    public static void staff() {
        Scanner input = new Scanner(System.in);
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

    private static void staffRegister() {
    }

    private static void staffLogin() {
    }
}
