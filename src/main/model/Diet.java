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

    }

    // MODIFIES: this
    // EFFECTS: sets up a diet for weight retention
    public void setUpMaintenance() {

    }

    // MODIFIES: this
    // EFFECTS: sets up a diet for weight gain
    public void setUpGain() {

    }
}
