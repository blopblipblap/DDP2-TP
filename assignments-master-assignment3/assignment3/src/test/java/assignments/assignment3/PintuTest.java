package assignments.assignment3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PintuTest {
    @Test
    public void testTambahPersentase(){
        Pintu pintu = new Pintu("Lawang");
        pintu.tambahPersentase();

        assertEquals(30, pintu.getPersentaseMenular());
    }

    @Test
    public void testToString(){
        Pintu pintu = new Pintu("Lawang");

        assertEquals("PINTU Lawang", pintu.toString());
    }
}