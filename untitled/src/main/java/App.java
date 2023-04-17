import client.models.UserModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private static final List<UserModel> users = new ArrayList<>();

    public static void main(String[] args) {

        onBoardingForm();
        App app = new App();
        app.usersInfo();
    }

    public static void chooseMenu() {
        System.out.println("Welcome to TestOrg, please choose Enter anyone of the Options \n " +
                "1. Register a Member \n " +
                "2. Get userInfo \n " +
                "3. Exist");
        Scanner scan = new Scanner(System.in);
        int option = scan.nextInt();
        switch (option) {
            case 1 -> onBoardingForm();
            case 2 -> getUsersInfo();
            case 3 -> exitMessage();
            default -> chooseMenu();
        }
    }

    public static void exitMessage() {
        System.out.println("Thank you for Participation");
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
        scan.close();
        welcomeOnBoardMessage(name, age);
    }

    public static void getUsersInfo() {
        for (UserModel user : users) {
            user.getUserInfo();
        }
    }
}
