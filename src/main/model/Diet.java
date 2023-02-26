package model;

public class Diet {
    String name;
    String type;
    Person operateOn;
    Calories calories = new Calories();
    Protein protein = new Protein();
    Carbohydrates carbohydrates = new Carbohydrates();

    // CONSTRUCTOR
    public Diet(Person person, String type) {
        operateOn = person;
        this.type = type;
        if (type.equals("L")) {
            name = "Loss";
            setUpLoss();
        } else if (type.equals("M"))  {
            name = "Maintenance";
            setUpMaintenance();
        } else if (type.equals("G")) {
            name = "Gain";
            setUpGain();
        } else if (type.equals("C")) {
            setUpCustom();
        }
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

    // MODIFIES: this
    // EFFECTS: sets up a custom diet
    public void setUpCustom() {
        double calorieGoal = calculateCalorie(1);
        calories.setGoal(calorieGoal);
        protein.setGoal(calculateProtein(1));
        carbohydrates.setGoal(calculateCarbohydrates(calorieGoal));
    }

    // REQUIRES: multiplier > 0
    // EFFECTS: calculates caloric intake
    public double calculateCalorie(double multiplier) {
        return ((bmrCalculator() + 500) * multiplier);
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
        double ratio = 0.125;
        System.out.println(calorieGoal);
        System.out.println(ratio);
        System.out.println((calorieGoal * ratio));
        return (calorieGoal * ratio);
    }

    // MODIFIES: this
    // EFFECTS: sets the calorie goal
    public void setCalories(double calorieGoal) {
        calories.setGoal(calorieGoal);
    }

    // MODIFIES: this
    // EFFECTS: sets the protein goal
    public void setProtein(double proteinGoal) {
        protein.setGoal(proteinGoal);
    }

    // MODIFIES: this
    // EFFECTS: sets the carbohydrate goal
    public void setCarbohydrates(double carbohydrateGoal) {
        carbohydrates.setGoal(carbohydrateGoal);
    }

    // EFFECTS: returns the calorie goal
    public double getCalories() {
        return calories.getGoal();
    }

    // EFFECTS: returns the protein goal
    public double getProtein() {
        return protein.getGoal();
    }

    // EFFECTS: returns the carbohydrate goal
    public double getCarbohydrates() {
        return carbohydrates.getGoal();
    }

    // GETTER AND SETTER
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

}
