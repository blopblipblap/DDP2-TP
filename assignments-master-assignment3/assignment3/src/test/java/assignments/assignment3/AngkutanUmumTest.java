package assignments.assignment3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AngkutanUmumTest {
    @Test
    public void testTambahPersentase(){
        AngkutanUmum angkutanUmum = new AngkutanUmum("Angkot");
        angkutanUmum.tambahPersentase();

        assertEquals(35, angkutanUmum.getPersentaseMenular());
    }

    @Test
    public void testToString(){
        AngkutanUmum angkutanUmum = new AngkutanUmum("Angkot");

        assertEquals("ANGKUTAN UMUM Angkot", angkutanUmum.toString());
    }
}