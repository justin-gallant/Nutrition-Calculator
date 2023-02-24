package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Person {
    private String name;
    private char sex;
    private int age;
    private int height;
    private int weight;
    private int dietSetting = 0;

    ArrayList<Diet> diets = new ArrayList<Diet>();
    Scanner scanner  = new Scanner(System.in);

    public Person() {
        System.out.println("Thank you for using CalorieCounter.");
        System.out.println("We can now begin setting up your profile. Please fill in the information below:");
        setUp();
        System.out.println("Profile has been set up.");
    }

    // MODIFIES: this
    // EFFECTS: sets up a person with all fields.
    public void setUp() {
        System.out.println("What is your name?");
        this.name = scanner.next();
        System.out.println("What is your sex?");
        this.sex = scanner.next().charAt(0);
        System.out.println("How old are you?");
        this.age = scanner.nextInt();
        System.out.println("What is your height (cm)?");
        this.height = scanner.nextInt();
        System.out.println("How much do you weigh (kg)?");
        this.weight = scanner.nextInt();
        System.out.println("Thank you for your input. Setting up Account now...");
    }

    // GETTERS AND SETTERS

    public int getDietSetting() {
        return dietSetting;
    }

    public void setDietSetting(int dietSetting) {
        this.dietSetting = dietSetting;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}
