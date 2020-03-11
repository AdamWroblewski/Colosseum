package test;

import com.company.model.gladiators.Gladiator;
import com.company.model.gladiators.Swordsman;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GladiatorTest {
    private static Gladiator gladiator;

    @BeforeAll
    public static void init() {
        gladiator = new Swordsman("Adam");
    }

    @Test
    public void test() {
        assertEquals("Adam", gladiator.getName());
    }
}