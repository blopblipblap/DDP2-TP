package assignments.assignment3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BendaTest {
    @Test
    public void testGetPersentaseMenularAwal(){
        AngkutanUmum angkutanUmum = new AngkutanUmum("Angkot");

        assertEquals(0, angkutanUmum.getPersentaseMenular());
    }

    @Test
    public void testSetPersentaseMenular(){
        PeganganTangga peganganTangga = new PeganganTangga("Pacil");

        peganganTangga.setPersentaseMenular(10);

        assertEquals(10, peganganTangga.getPersentaseMenular());
    }
}