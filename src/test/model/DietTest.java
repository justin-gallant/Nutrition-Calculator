package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DietTest {
    Person test;

    @BeforeEach
    public void runBefore() {
        test = new Person("Test", "M", 18, 175, 80);
    }

    @Test
    public void testLoss() {
        Diet diet = new Diet(test, "M");
    }

    @Test
    public void testMaintenance() {
        Diet diet = new Diet(test, "M");
    }

    @Test
    public void testGain() {
        Diet diet = new Diet(test, "M");
    }

}
