package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Person {
    private String name;
    private String sex;
    private int age;
    private int height;
    private int weight;
    private int dietSetting = 0;

    ArrayList<Diet> diets = new ArrayList<>();
    Scanner scanner  = new Scanner(System.in);

    // CONSTRUCTOR
    public Person(String name, String sex, int age, int height, int weight) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.height = height;
        this.weight = weight;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
