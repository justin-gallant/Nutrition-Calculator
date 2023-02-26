package ui;

import model.Diet;
import model.Person;

import java.util.Scanner;

public class DietaryCalculator {
    Scanner scanner  = new Scanner(System.in);

    // CONSTRUCTOR
    public DietaryCalculator() {
        Person profile1 = personSetUp();
        System.out.println("Person has now been set up. Please set up a new diet");
        Diet firstDiet = dietSetUp(profile1);
        menu();
    }

    // EFFECTS: creates a new person
    public Person personSetUp() {
        System.out.println("What is your name?");
        String name = scanner.next();
        System.out.println("What is your sex? (\"M\" or \"F\")");
        String sex = scanner.next();
        System.out.println("How old are you?");
        int age = scanner.nextInt();
        System.out.println("What is your height (cm)?");
        int height = scanner.nextInt();
        System.out.println("How much do you weigh (kg)?");
        int weight = scanner.nextInt();
        System.out.println("Thank you for your input. Setting up Account now...");
        return new Person(name, sex, age, height, weight);
    }

    public Diet dietSetUp(Person person) {
        System.out.println("Select the purpose of this diet: \nL - Weight Loss\nM - Maintenance\nG - Weight Gain");
        String type = scanner.next();
        return new Diet(person, type);
    }

    // EFFECTS: shows all the functions.
    public void menu() {
        System.out.println("Functions:");
        System.out.println("\t\"C\" - Create another diet");
        System.out.println("\t\"D\" - Delete a diet");
        System.out.println("\t\"M\" - Modify Active Diet");
        System.out.println("\t\"S\" - Set Active Diet");
    }
}
