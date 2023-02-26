package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonTest {
    Person test;

    @BeforeEach
    public void runBefore() {
        test = new Person("Test", "M", 18, 175, 80);
        Diet testDiet = new Diet(test, "C");
        test.addDiet(testDiet);
    }

    @Test
    public void test() {

    }

}