package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Diet {
    String type;
    Person operateOn;
    Calories calories = new Calories();
    Protein protein = new Protein();
    Carbohydrates carbohydrates = new Carbohydrates();

    ArrayList<Nutrient> nutrients = new ArrayList<>();
    Scanner scanner  = new Scanner(System.in);

    // CONSTRUCTOR
    public Diet(Person person, String type) {
        operateOn = person;
        this.type = type;
        if (type.equals("L")) {
            setUpLoss();
        } else if (type.equals("M"))  {
            setUpMaintenance();
        } else if (type.equals("G")) {
            setUpGain();
        }
        printDiet();
        System.out.println("\nSuccessfully created Diet!");
    }

    // EFFECTS: prints out the diet
    public void printDiet() {
        System.out.println("Printing Diet for " + operateOn.getName());
        System.out.print("Daily recommended calorie intake: ");
        System.out.println(calories.getGoal());

        System.out.print("Daily recommended protein intake: ");
        System.out.println(protein.getGoal());

        System.out.print("Daily recommended carbohydrate intake: ");
        System.out.println(protein.getGoal());
    }

    // MODIFIES: this
    // EFFECTS: sets up a diet for weight loss
    public void setUpLoss() {
        double calorieMultiplier = 0.9;
        double proteinMultiplier = (2.2 * 1.15);

        double calorieGoal = calculateCalorie(calorieMultiplier);
        calories.setGoal(calorieGoal);
        protein.setGoal(calculateProtein(proteinMultiplier));
        carbohydrates.setGoal(calculateCarbohydrates(calorieGoal));
    }

    // MODIFIES: this
    // EFFECTS: sets up a diet for weight retention
    public void setUpMaintenance() {
        double calorieMultiplier = 1.15;
        double proteinMultiplier = (2.2 * 0.95);

        double calorieGoal = calculateCalorie(calorieMultiplier);
        calories.setGoal(calorieGoal);
        protein.setGoal(calculateProtein(proteinMultiplier));
        carbohydrates.setGoal(calculateCarbohydrates(calorieGoal));
    }

    // MODIFIES: this
    // EFFECTS: sets up a diet for weight gain
    public void setUpGain() {
        double calorieMultiplier = 1.35;
        double proteinMultiplier = (2.2 * 1.15);

        double calorieGoal = calculateCalorie(calorieMultiplier);
        calories.setGoal(calorieGoal);
        protein.setGoal(calculateProtein(proteinMultiplier));
        carbohydrates.setGoal(calculateCarbohydrates(calorieGoal));
    }

    // REQUIRES: multiplier > 0
    // EFFECTS: calculates caloric intake
    public double calculateCalorie(double multiplier) {
        return (bmrCalculator() * multiplier + 500);
    }

    // REQUIRES:
    //      - sex = "M" or "F"
    //      - age > 0
    //      - weight > 0
    //      - height > 0
    // EFFECTS: calculates the baseline caloric intake for the person
    public double bmrCalculator() {
        String sex = operateOn.getSex();
        int age = operateOn.getAge();
        int weight = operateOn.getWeight();
        int height = operateOn.getHeight();
        double bmr;

        if (sex.equals("M")) {
            bmr = (10 * weight) + (6.25 * height) - (5 * age) + 5;
        } else {
            bmr = (10 * weight) + (6.25 * height) - (5 * age) - 161;
        }
        return bmr;
    }

    // REQUIRES: multiplier > 0, weight > 0
    // EFFECTS: returns the protein needed in grams.
    public double calculateProtein(double multiplier) {
        int weight = operateOn.getWeight();
        return (weight * multiplier);
    }

    // REQUIRES: multiplier > 0, weight > 0
    // EFFECTS: returns the carbohydrates needed in grams.
    public double calculateCarbohydrates(double calorieGoal) {
        int ratio = (300 / 2000);
        return (calorieGoal * ratio);
    }
}
