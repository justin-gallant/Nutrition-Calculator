package model;

import java.util.ArrayList;

public abstract class Nutrient {
    String name;
    ArrayList<Double> goal = new ArrayList<>();

    void setGoal(double newGoal, Person person) {
        goal.set(person.getDietSetting(), newGoal);
    }

    double getGoal(Person person) {
        return goal.get(person.getDietSetting());
    }

}
