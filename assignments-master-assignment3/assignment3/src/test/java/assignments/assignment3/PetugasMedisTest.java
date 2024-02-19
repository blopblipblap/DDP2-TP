package assignments.assignment3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PetugasMedisTest {
    @Test
    public void testGetJumlahDisembuhkanAwal(){
        PetugasMedis petugasMedis= new PetugasMedis("GardaTerdepan");

        assertEquals(0, petugasMedis.getJumlahDisembuhkan());
    }

    @Test
    public void testObati(){
        PetugasMedis petugasMedis= new PetugasMedis("GardaTerdepan");
        Jurnalis jurnalis = new Jurnalis("Najwa");

        jurnalis.ubahStatus("positif");
        petugasMedis.obati(jurnalis);

        assertEquals(true, jurnalis.getStatusCovid().equalsIgnoreCase("negatif"));
    }

    @Test
    public void testGetJumlahDisembuhkanAfterObati(){
        PetugasMedis petugasMedis= new PetugasMedis("GardaTerdepan");
        Jurnalis jurnalis = new Jurnalis("Najwa");

        jurnalis.ubahStatus("positif");
        petugasMedis.obati(jurnalis);

        assertEquals(1, petugasMedis.getJumlahDisembuhkan());
    }

    @Test
    public void testToString(){
        PetugasMedis petugasMedis = new PetugasMedis("GardaTerdepan");
        
        assertEquals("PETUGAS MEDIS GardaTerdepan", petugasMedis.toString());
    }
}