package ui;

import model.Diet;
import model.Person;

import java.util.Scanner;

public class DietaryCalculator {
    private Scanner input;
    private Person profile1;

    // CONSTRUCTOR
    public DietaryCalculator() {
        runCalculator();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    public void runCalculator() {
        boolean run = true;
        String command;

        firstStartUp();

        while (run) {
            menu();
            command = input.next();
            if (command.equals("Q")) {
                run = false;
            } else {
                runCommand(command);
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: starts the program and runs the original set up.
    public void firstStartUp() {
        input = new Scanner(System.in);
        System.out.println("Please Set Up a Profile");
        profile1 = personSetUp();
        System.out.println("Person Has Been Set Up! Please set up a diet!");
        Diet diet1 = dietSetUp(profile1);
        System.out.println("Diet has been set up!");
    }

    // MODIFIES: this
    // EFFECTS: creates a new person
    public Person personSetUp() {
        System.out.println("What is your name?");
        String name = input.next();
        System.out.println("What is your sex? (\"M\" or \"F\")");
        String sex = input.next();
        System.out.println("How old are you?");
        int age = input.nextInt();
        System.out.println("What is your height (cm)?");
        int height = input.nextInt();
        System.out.println("How much do you weigh (kg)?");
        int weight = input.nextInt();
        System.out.println("Thank you for your input. Setting up Account now...");
        return new Person(name, sex, age, height, weight);
    }

    // EFFECTS: Runs the command
    public void runCommand(String command) {
        if (command.equals("C")) {
            dietSetUp(profile1);
        } else if (command.equals("D")) {
            deleteDiet(profile1);
        } else if (command.equals("M")) {
            dietModify(profile1.getDietAtIndex(profile1.getDietSetting()));
        } else if (command.equals("P")) {
            printDiet(profile1.getDietAtIndex(profile1.getDietSetting()));
        } else if (command.equals("S")) {
            setActiveDiet(profile1);
        } else {
            System.out.println("Invalid Input.");
        }
    }

    // EFFECTS: shows all the functions.
    public void menu() {
        System.out.println("Functions:");
        System.out.println("\t\"C\" - Create another diet");
        System.out.println("\t\"D\" - Delete a diet");
        System.out.println("\t\"M\" - Modify Active Diet");
        System.out.println("\t\"P\" - Print Active Diet");
        System.out.println("\t\"S\" - Set Active Diet\n");
        System.out.println("\t\"Q\" - Quit the system");
    }


    // MODIFIES: this
    // EFFECTS: creates a new diet
    public Diet dietSetUp(Person person) {
        System.out.println("Select the purpose of this diet: "
                + "\nL - Weight Loss\nM - Maintenance\nG - Weight Gain\nC - Custom");
        String type = input.next();
        if (!type.equals("L") && !type.equals("M") && !type.equals("G") && !type.equals("C")) {
            System.out.println("Invalid Input.");
            type = "C";
        }
        Diet diet1 = new Diet(person, type);
        if (type.equals("C")) {
            System.out.println("Creating Custom Diet.");
            diet1 = customDiet(diet1);
            profile1.addDiet(diet1);
            return diet1;
        } else {
            printDiet(diet1);
            profile1.addDiet(diet1);
            return diet1;
        }
    }

    // REQUIRES: Diet to be of type Custom
    // MODIFIES: this
    // EFFECTS: CREATES A CUSTOM DIET
    public Diet customDiet(Diet diet) {
        System.out.println("Enter a name for this diet: ");
        String name = input.next();
        diet.setName(name);
        dietModify(diet);
        return diet;
    }

    // MODIFIES: this, diet
    // EFFECTS: modifies the diet.
    public Diet dietModify(Diet diet) {
        System.out.println("Please enter a calorie goal: ");
        double calorieGoal = input.nextDouble();
        diet.setCalories(calorieGoal);
        System.out.println("Please enter a protein goal: ");
        double proteinGoal = input.nextDouble();
        diet.setProtein(proteinGoal);
        System.out.println("Please enter a carbohydrate goal: ");
        double carbohydrateGoal = input.nextDouble();
        diet.setCarbohydrates(carbohydrateGoal);
        printDiet(diet);
        return diet;
    }

    // REQUIRES: person.getDiets().size() > 1
    // MODIFIES: this
    // EFFECTS: deletes a diet
    public void deleteDiet(Person person) {
        System.out.println("Listing Diets to Remove:");
        displayListOfDiets(person);
        System.out.println("Please enter the index of the diet you would like to remove: ");
        int remove = input.nextInt();
        person.remove(remove);
    }

    // REQUIRES: person.getDiets().size() >= 1
    // EFFECTS: displays the name of diets and their index in array
    public void displayListOfDiets(Person person) {
        int count = 0;
        for (Diet diet : person.getDiets()) {
            System.out.println(person.getDietAtIndex(count).getName());
            System.out.println("Diet at index: " + count);
            count++;
        }
    }

    // EFFECTS: prints out the diet
    public void printDiet(Diet diet) {
        System.out.println("Printing Diet for " + profile1.getName());
        System.out.println("Name: " + diet.getName());
        System.out.println("Type: " + diet.getType());
        System.out.println("Calorie Goal: " + diet.getCalories());
        System.out.println("Protein Goal: " + diet.getProtein());
        System.out.println("Carbohydrate Goal: " + diet.getCarbohydrates());
    }

    // REQUIRES: person.getDiets().size() >= 1
    // MODIFIES: this
    // EFFECTS: changes the active diet
    public void setActiveDiet(Person person) {
        System.out.println("Listing Diets to Set Active:");
        displayListOfDiets(person);
        System.out.println("Please enter the index of the diet you would like to set as active: ");
        int active = input.nextInt();
        person.setDietSetting(active);
    }

}
