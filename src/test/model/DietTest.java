package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DietTest {
    Person test;

    @BeforeEach
    public void runBefore() {
        test = new Person("Test", "M", 18, 175, 80);
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
    public void testBmrCalculator() {
        Diet diet = new Diet(test, "M");
    }

    @Test
    public void testGain() {
        Diet diet = new Diet(test, "G");
    }

}
