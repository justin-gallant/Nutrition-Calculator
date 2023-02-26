package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DietTest {
    Person test;
    Diet testDiet;

    @BeforeEach
    public void runBefore() {
        test = new Person("Test", "M", 18, 175, 80);
        testDiet = new Diet(test, "M");
    }

    @Test
    public void testCalculateCalorie() {
        Diet diet = new Diet(test, "L");
        double multiplier = 0.9;
        assertEquals(diet.calculateCalorie(multiplier), 2077.875);
        Diet diet1 = new Diet(test, "M");
        multiplier = 1.15;
        assertEquals(diet1.calculateCalorie(multiplier), 2655.0625);
        Diet diet2 = new Diet(test, "G");
        multiplier = 1.35;
        assertEquals(diet2.calculateCalorie(multiplier), 3116.8125);
    }

    @Test
    public void testCalculateProtein() {
        Diet diet = new Diet(test, "L");
        double multiplier = (2.2 * 1.15);
        assertEquals(diet.calculateProtein(multiplier), 202.39999999999998);
        Diet diet1 = new Diet(test, "M");
        multiplier = (2.2 * 0.95);
        assertEquals(diet1.calculateProtein(multiplier), 167.2);
        Diet diet2 = new Diet(test, "G");
        multiplier = (2.2 * 1.15);
        assertEquals(diet2.calculateProtein(multiplier), 202.39999999999998);
    }

    @Test
    public void testGetCalories() {
        assertEquals(testDiet.getCalories(), 2655.0625);
        testDiet.setCalories(2650);
        assertEquals(testDiet.getCalories(), 2650);
    }

    @Test
    public void testGetProtein() {
        assertEquals(testDiet.getProtein(), 167.2);
        testDiet.setProtein(165);
        assertEquals(testDiet.getProtein(), 165);
    }

    @Test
    public void testGetCarbohydrates() {
        assertEquals(testDiet.getCarbohydrates(), 331.8828125);
        testDiet.setCarbohydrates(330);
        assertEquals(testDiet.getCarbohydrates(), 330);
    }

    @Test
    public void testGetName() {
        assertEquals(testDiet.getName(), "Maintenance");
        testDiet.setName("somethingElse");
        assertEquals(testDiet.getName(), "somethingElse");
    }

    @Test
    public void testGetType() {
        assertEquals(testDiet.getType(), "M");
    }

    @Test
    public void testFemale() {
        Person female = new Person("TestF", "F", 18, 165, 50);
        Diet femaleDiet = new Diet(female, "C");
        assertEquals(femaleDiet.getCalories(), 1780.25);
        assertEquals(femaleDiet.getProtein(), 110.00000000000001);
        assertEquals(femaleDiet.getCarbohydrates(), 222.53125);
        femaleDiet.setCarbohydrates(1);
    }

}
