import client.models.UserModel;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {

    private static final List<UserModel> users = new ArrayList<>();

    public static void main(String[] args) {
        chooseMenu();
    }

    public static void chooseMenu() {
        System.out.println("""
                Welcome to TestOrg, please choose Enter anyone of the Options\s
                 1. Register a Member\s
                 2. Get userInfo\s
                 3. Exist\s
                """);
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        boolean wrongOption = false;
        while (!wrongOption) {
            switch (option) {
                case 1 -> {
                    onBoardingForm();
                    wrongOption = true;
                }
                case 2 -> {
                    getUsersInfo();
                    wrongOption = true;
                }
                case 0 -> {
                    exitMessage();
                    wrongOption = true;
                }
                default -> {
                    inputWrongMessage();
                    option = scan.nextInt();
                }
            }
        }
        wrongOption = false;
    }

    public static void exitMessage() {
        System.out.println("Thank you for Participation");
    }

    public static void inputWrongMessage() {
        System.out.println("Your Option is Wrong please retry again!, and 0 is to Exit");
    }

    private static void welcomeOnBoardMessage(String userName, int age) {
        if (age >= 22) {
            System.out.println("Welcome to the team, " + userName);
        } else if (age <= 21 && age >= 16) {
            System.out.println("Your appointed as intern");
        } else {
            System.out.println("Hey buddy, you has a great Future");
        }
    }

    public static void onBoardingForm() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your Name:\n");
        String name = scan.nextLine();
        System.out.println("Enter your Age:\n");
        int age = scan.nextInt();
        if (name != null && age > 0) {
            UserModel user = new UserModel(name, age);
            users.add(user);
        }
        welcomeOnBoardMessage(name, age);
        System.out.println("Type 0 to return to main menu");
        int option = scan.nextInt();
        boolean optionFlag = true;
        while (optionFlag) {
            if (option == 0) {
                chooseMenu();
                optionFlag = false;
            } else {
                inputWrongMessage();
                option = scan.nextInt();
            }
        }
        optionFlag = true;
    }

    public static void getUsersInfo() {
        Scanner scan = new Scanner(System.in);
        if (users.size() >= 1) {
            for (UserModel user : users) {
                user.getUserInfo();
            }
        } else {
            System.out.println("There are no users, Do you want ot register?(Y/N)");
            String option = scan.nextLine();
            boolean optionFlag = true;
            while (optionFlag) {
                try {
                    if (option.equalsIgnoreCase("Y")) {
                        onBoardingForm();
                        optionFlag = false;
                    } else if (option.equalsIgnoreCase("N")) {
                        inputWrongMessage();
                        optionFlag = false;
                    } else {
                        System.out.println("Your input is wrong pls try again");
                        option = scan.nextLine();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Your input is mismatched, pls try again");
                    option = scan.nextLine();
                }
            }
            optionFlag = true;
        }
    }
}
