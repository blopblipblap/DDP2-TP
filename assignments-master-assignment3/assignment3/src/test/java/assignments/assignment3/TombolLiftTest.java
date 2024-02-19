package assignments.assignment3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TombolLiftTest {
    @Test
    public void testTambahPersentase(){
        TombolLift tombolLift = new TombolLift("Button");
        tombolLift.tambahPersentase();

        assertEquals(20, tombolLift.getPersentaseMenular());
    }

    @Test
    public void testToString(){
        TombolLift tombolLift = new TombolLift("Button");

        assertEquals("TOMBOL LIFT Button", tombolLift.toString());
    }
}