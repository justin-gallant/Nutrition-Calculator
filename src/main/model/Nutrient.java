package model;

public abstract class Nutrient {
    String name;
    int goal;
    int current = 0;

    // REQUIRES: toAdd > 0
    // MODIFIES: nutrient
    // EFFECTS: adds the amount to the goal
    void addtoCurrent(int toAdd) {
        this.current += toAdd;
    }

    void setGoal(int newGoal) {
        this.goal = newGoal;
    }

    int getGoal() {
        return this.goal;
    }

}
