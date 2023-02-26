package model;

import java.util.ArrayList;

public abstract class Nutrient {
    String name;
    double goal;

    void setGoal(double newGoal) {
        this.goal = newGoal;
    }

    double getGoal() {
        return this.goal;
    }

}
