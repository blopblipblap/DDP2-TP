package assignments.assignment3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
public class OjolTest {
    @Test
    public void testToString(){
        Ojol ojol = new Ojol("KangJek");

        assertEquals("OJOL KangJek", ojol.toString());
    }
}