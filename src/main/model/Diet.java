package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Diet {
    final String type;
    Person operateOn;
    Calories calories;
    Protein protein;
    Carbohydrates carbohydrates;

    ArrayList<Nutrient> nutrients = new ArrayList<>();
    Scanner scanner  = new Scanner(System.in);

    // CONSTRUCTOR
    public Diet(Person person) {
        System.out.println("Select the purpose of this diet: \nL - Weight Loss\nM - Maintenance\nG - Weight Gain");
        type = scanner.next();
        operateOn = person;
        if (type.equals("L")) {
            setUpLoss();
        } else if (type.equals("M"))  {
            setUpMaintenance();
        } else if (type.equals("G")) {
            setUpGain();
        }
    }

    // MODIFIES: this
    // EFFECTS: sets up a diet for weight loss
    public void setUpLoss() {
        double calorieMultiplier = 0.8;
        double proteinMultiplier = (2.2 * 1.15);

        double calorieGoal = calculateCalorie(calorieMultiplier);
        calories.setGoal(calorieGoal, operateOn);
        protein.setGoal(calculateProtein(proteinMultiplier), operateOn);
        carbohydrates.setGoal(calculateCarbohydrates(calorieGoal), operateOn);
    }

    // MODIFIES: this
    // EFFECTS: sets up a diet for weight retention
    public void setUpMaintenance() {
        double calorieMultiplier = 1;
        double proteinMultiplier = (2.2 * 0.95);

        double calorieGoal = calculateCalorie(calorieMultiplier);
        calories.setGoal(calorieGoal, operateOn);
        protein.setGoal(calculateProtein(proteinMultiplier), operateOn);
        carbohydrates.setGoal(calculateCarbohydrates(calorieGoal), operateOn);
    }

    // MODIFIES: this
    // EFFECTS: sets up a diet for weight gain
    public void setUpGain() {
        double calorieMultiplier = 1.2;
        double proteinMultiplier = (2.2 * 1.15);

        double calorieGoal = calculateCalorie(calorieMultiplier);
        calories.setGoal(calorieGoal, operateOn);
        protein.setGoal(calculateProtein(proteinMultiplier), operateOn);
        carbohydrates.setGoal(calculateCarbohydrates(calorieGoal), operateOn);
    }

    public double calculateCalorie(double multiplier) {
        return (bmrCalculator() * multiplier);
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
