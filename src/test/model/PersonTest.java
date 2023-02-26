package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {
    Person test;
    Diet testDiet;

    @BeforeEach
    public void runBefore() {
        test = new Person("Test", "M", 18, 175, 80);
        testDiet = new Diet(test, "C");
        test.addDiet(testDiet);
    }

    @Test
    public void testGetDietAtIndex() {
        assertEquals(test.getDietAtIndex(0), testDiet);
        Diet testDiet2 = new Diet(test, "G");
        test.addDiet(testDiet2);
        assertEquals(test.getDietAtIndex(1), testDiet2);
    }

    @Test
    public void testGetDiets() {
        ArrayList<Diet> testList = new ArrayList<>();
        testList.add(testDiet);
        assertEquals(test.getDiets(), testList);
        testList.remove(0);
        test.remove(0);
        assertEquals(test.getDiets(),testList);
    }

    @Test
    public void testGetName() {
        assertEquals(test.getName(), "Test");
    }

    @Test
    public void testGetDietSetting() {
        assertEquals(test.getDietSetting(), 0);
        test.addDiet(testDiet);
        test.setDietSetting(1);
        assertEquals(test.getDietSetting(),1);
    }

}