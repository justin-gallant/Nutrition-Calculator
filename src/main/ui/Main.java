package ui;

import model.Diet;
import model.Person;

public class Main {
    public static void main(String[] args) {
        Person profile1 = new Person();
        System.out.println("Person has now been set up. Please set up a new diet");
        Diet diet1 = new Diet(profile1);
    }
}
