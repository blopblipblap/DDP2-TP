package assignments.assignment3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PeganganTanggaTest {
    @Test
    public void testTambahPersentase(){
        PeganganTangga peganganTangga = new PeganganTangga("Pacil");
        peganganTangga.tambahPersentase();

        assertEquals(20, peganganTangga.getPersentaseMenular());
    }

    @Test
    public void testToString(){
        PeganganTangga peganganTangga = new PeganganTangga("Pacil");

        assertEquals("PEGANGAN TANGGA Pacil", peganganTangga.toString());
    }
}