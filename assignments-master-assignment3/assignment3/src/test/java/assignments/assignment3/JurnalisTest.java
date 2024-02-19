package assignments.assignment3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class JurnalisTest {
    @Test
    public void testToString(){
        Jurnalis jurnalis = new Jurnalis("Najwa");

        assertEquals("JURNALIS Najwa", jurnalis.toString());
    }
}