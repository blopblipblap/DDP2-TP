package assignments.assignment3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PekerjaJasaTest {
    @Test
    public void testToString(){
        PekerjaJasa pekerjaJasa = new PekerjaJasa("BangLaundry");

        assertEquals("PEKERJA JASA BangLaundry", pekerjaJasa.toString());
    }
}