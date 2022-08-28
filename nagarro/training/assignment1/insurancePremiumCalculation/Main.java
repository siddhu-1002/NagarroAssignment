package com.nagarro.training.assignment1.insurancePremiumCalculation;
import java.util.Scanner;


public class Main {

    // Function to convert the string the strings to Title case
    public static String capitalize(String word){
        word = word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
        return word;
    }


    public static void main(String[] args) {

        boolean calculate = true;

        while(calculate == true) {
            Scanner sc = new Scanner(System.in);

            System.out.println("\nEnter the details of your car");

            System.out.print("Enter the model of your car : ");
            String carModel = sc.next();
            carModel = capitalize(carModel);


            // Checking the carType for valid input
            boolean flag = false;
            String carType = null;
            while (flag == false) {
                System.out.print("Enter your car type(Hatchback/Sedan/SUV) : ");
                carType = sc.next();
                carType = capitalize(carType);
                flag = carType.contains("Hatchback") || carType.contains("Sedan") || carType.contains("Suv");
                if (flag == false) {
                    System.out.println("Enter Valid Input");
                }
            }


            // Checking valid input for Car price
            flag = true;
            int carPrice = 0;
            while (flag == true) {
                try {
                    System.out.print("Enter the price of your car : ");
                    carPrice = Integer.parseInt(sc.next());
                    flag = false;
                } catch (Exception NumberFormatException) {
                    System.out.println("Enter Numeric Value");
                }
            }


            // Checking insuranceType for valid input
            flag = false;
            String insuranceType = null;
            while (flag == false) {
                System.out.print("Enter the type of insurance(Basic/Premium) : ");
                insuranceType = sc.next();
                insuranceType = capitalize(insuranceType);
                flag = insuranceType.contains("Basic") || insuranceType.contains("Premium");
                if (flag == false) {
                    System.out.println("Enter Valid Input");
                }
            }

            // Creating an object for calculateInsurance class
            CalculateInsurance cI = new CalculateInsurance(carModel, carType,
                    carPrice, insuranceType);

            System.out.println("\n\n");
            System.out.println("Your model is : " + cI.getModel());
            System.out.println("Your car price is : " + cI.getPrice());
            System.out.print("Total insurance to be paid : Rs ");
            System.out.println(cI.calculateInsuranceAmount());

            System.out.println("\nDo you want to enter details of any other car(Y/N)?");
            String choice = sc.next();
            if (choice == "Y" || choice == "y") {
                calculate = true;
            }
            else {
                calculate = false;
                System.out.println("Closing the system\nHave a Great Day!");
            }
        }
    }
}
