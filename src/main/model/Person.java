package model;

import java.util.ArrayList;

public class Person {
    private String name;
    private String sex;
    private int age;
    private int height;
    private int weight;
    private int dietSetting = 0;

    private ArrayList<Diet> diets = new ArrayList<>();

    // CONSTRUCTOR
    public Person(String name, String sex, int age, int height, int weight) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    // REQUIRES: index >= 0 && index <= diets.size()
    // EFFECTS: returns the diet at provided index
    public Diet getDietAtIndex(int index) {
        return diets.get(index);
    }

    // MODIFIES: this
    // EFFECTS: adds a diet to the profile
    public ArrayList<Diet> getDiets() {
        return diets;
    }

    // MODIFIES: this
    // EFFECTS: adds a diet to the profile
    public void addDiet(Diet diet) {
        this.diets.add(diet);
    }

    // MODIFIES: this
    // EFFECTS: adds a diet to the profile
    public void remove(int index) {
        this.diets.remove(index);
    }

    // DEFAULT GETTERS AND SETTERS
    public int getDietSetting() {
        return dietSetting;
    }

    public void setDietSetting(int dietSetting) {
        this.dietSetting = dietSetting;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

}
