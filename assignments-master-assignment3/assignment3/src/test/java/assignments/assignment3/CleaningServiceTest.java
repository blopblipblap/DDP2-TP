package assignments.assignment3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CleaningServiceTest {
    @Test
    public void testGetJumlahDibersihkanAwal(){
        CleaningService cleaningService = new CleaningService("Dalgona");

        assertEquals(0, cleaningService.getJumlahDibersihkan());
    }

    @Test
    public void testBersihkan(){
        CleaningService cleaningService = new CleaningService("Dalgona");
        PeganganTangga peganganTangga = new PeganganTangga("Matcha");

        peganganTangga.ubahStatus("positif");
        cleaningService.bersihkan(peganganTangga);

        assertEquals(true, peganganTangga.getStatusCovid().equalsIgnoreCase("negatif"));
    }

    @Test
    public void testGetJumlahDibersihkanAfterBersihkan(){
        CleaningService cleaningService = new CleaningService("Dalgona");
        PeganganTangga peganganTangga = new PeganganTangga("Matcha");

        peganganTangga.ubahStatus("positif");
        cleaningService.bersihkan(peganganTangga);
        
        assertEquals(1, cleaningService.getJumlahDibersihkan());
    }

    @Test
    public void testToString(){
        CleaningService cleaningService = new CleaningService("Dalgona");
        
        assertEquals("CLEANING SERVICE Dalgona", cleaningService.toString());
    }
}