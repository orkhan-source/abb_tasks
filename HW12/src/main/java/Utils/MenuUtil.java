package Utils;

import DAO.FamilyController;
import Exceptions.FamilyOverflowException;
import Humans.Family;
import Humans.Human;
import Humans.Man;
import Humans.Woman;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MenuUtil {
    public static Scanner sc = new Scanner(System.in);

     public static void displayMenu(FamilyController familyController){
         while(true){
             System.out.println(TextUtil.menuOption);
             int option = sc.nextInt();
             switch (option) {
                 case 1 -> testData(familyController);
                 case 2 -> displayAllFamilies(familyController);
                 case 3 -> displayGreaterThan(familyController);
                 case 4 -> displayLessThan(familyController);
                 case 5 -> calculateFamily(familyController);
                 case 6 -> createFamily(familyController);
                 case 7 -> deleteFamilyByIndex(familyController);
                 case 8 -> editFamily(familyController);
                 case 9 -> removeAllChildren(familyController);
                 case 10 -> System.exit(0);
                 default -> System.out.println("Invalid choice! ");
             }
         }

    }

    public static void testData(FamilyController familyController){

        Human mother = new Human("Laura", "Boff", "20/08/1972");
        Human father = new Human("Alex", "Boff", "21/09/1970");
        Human mother1 = new Human("Aziza", "Aliyev", "20/08/1973");
        Human father1 = new Human("Aziz", "Aliyev", "21/09/1971");

        familyController.createNewFamily(father, mother);
        familyController.createNewFamily(father1, mother1);

     }

    public static void displayAllFamilies(FamilyController familyController){
        familyController.displayAllFamilies();
    }

    public static void displayGreaterThan(FamilyController familyController){

        System.out.print("Enter number: ");
        int num = MenuUtil.sc.nextInt();
        familyController.getFamiliesBiggerThan(num).forEach(Family::prettyFormat);
    }


    public static void displayLessThan(FamilyController familyController){

        System.out.print("Enter number: ");
        int num = MenuUtil.sc.nextInt();
        familyController.getFamiliesLessThan(num).forEach(Family::prettyFormat);
    }

    public static void calculateFamily(FamilyController familyController){
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        System.out.printf("Number of family is %d ", familyController.countFamiliesWithMemberNumber(num));

    }

    public static void createFamily(FamilyController familyController){
        Human father = humanCreation("father");
        Human mother = humanCreation("mother");
        familyController.createNewFamily(father, mother);
    }


    public static Human humanCreation(String parentType){

        try{
            System.out.printf("Enter %s's name: ", parentType);
            String name = sc.nextLine();
            System.out.printf("Enter %s's last name: ", parentType);
            String lastName = sc.nextLine();
            System.out.printf("Enter %s's birth year: ", parentType);
            int birthYear = sc.nextInt();
            System.out.printf("Enter %s's birth month: ", parentType);
            int birthMonth = sc.nextInt();
            System.out.printf("Enter %s's birth day: ", parentType);
            int birthDay = sc.nextInt();
            System.out.printf("Enter %s's IQ: ", parentType);
            int iq = sc.nextInt();
            String birthDate = birthDay + "/" + birthMonth + "/" + birthYear;
            return new Human(name, lastName, birthDate, iq);
        }
        catch (Exception e){
            System.out.println("Given parameters is not valid! ");
            return humanCreation(parentType);
        }

    }


    public static void deleteFamilyByIndex(FamilyController familyController){

        int index = sc.nextInt();
        familyController.deleteFamilyByIndex(index);
    }


    public static void editFamily(FamilyController familyController){
        System.out.println("Choose options: \n" +
                "1. Give birth to a baby \n" +
                "2. Adopt a child ");

        int option = sc.nextInt();

        switch (option) {
            case 1 -> bornChild(familyController);
            case 2 -> adoptChild(familyController);
            case 3 -> displayMenu(familyController);
            default -> {
                System.out.println("Choice is not valid!");
                editFamily(familyController);
            }
        }

    }

    public static void bornChild(FamilyController familyController){

        int index;
        String girlName, boyName;
        try {
            System.out.println("Enter family id");
            index = sc.nextInt();
            System.out.println("Enter girl name");
            girlName = sc.nextLine();
            System.out.println("Enter boy name");
            boyName = sc.nextLine();


        }
        catch (Exception e){
            System.out.println("Entered data  is not valid!");
            return;
        }

        try {
            Family family = familyController.getFamilyById(index);
            familyController.bornChild(family, boyName, girlName);
        }catch (Exceptions.FamilyOverflowException e){
            throw new FamilyOverflowException("Out of family");
        }

    }

    public static void adoptChild(FamilyController familyController){

        int index, iq;
        boolean gender;
        String name, surname, birthdate;
        try{
            System.out.println("Enter family id: ");
            index = sc.nextInt();
            System.out.println("Enter gender(true/false): ");
            gender = sc.nextBoolean();
            System.out.println("Enter name: ");
            name = sc.nextLine();
            System.out.println("Enter surname: ");
            surname = sc.nextLine();
            System.out.println("Enter birth date: ");
            birthdate = sc.nextLine();
            System.out.println("Enter iq");
            iq = sc.nextInt();
        }
        catch (Exception e){
            System.out.println("Entered data is not valid!");
            return;
        }

        Human child = gender ? new Man(name, surname, birthdate, iq) : new Woman(name, surname, birthdate, iq);

        try {
            Family family = familyController.getFamilyById(index);
            familyController.adoptChild(family, child);
        }catch (Exceptions.FamilyOverflowException e){
            throw new FamilyOverflowException("Out of family");
        }



    }



    public static void removeAllChildren(FamilyController familyController){
        int age = sc.nextInt();
        familyController.deleteAllChildrenOlderThen(age);
    }


}
