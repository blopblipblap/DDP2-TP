package assignments.assignment2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MahasiswaTest {
    @Test
    public void testGetKomponenPenilaian() {
        KomponenPenilaian kuis = new KomponenPenilaian("Kuis", 2, 40);
        KomponenPenilaian pr = new KomponenPenilaian("PR", 2, 40);
        KomponenPenilaian[] komponen = { kuis, pr };
        Mahasiswa mahasiswa = new Mahasiswa("151", "Kishi Bashi", komponen);
        assertEquals(pr, mahasiswa.getKomponenPenilaian("PR"));
    }

    @Test
    public void testToString() {
        Mahasiswa mahasiswa = new Mahasiswa("321", "Andrew Bird", new KomponenPenilaian[0]);
        assertEquals("321 - Andrew Bird", mahasiswa.toString());
    }

    @Test
    public void testCompareToGreaterThan() {
        Mahasiswa mahasiswa1 = new Mahasiswa("1960", "Andrew Ryan", new KomponenPenilaian[0]);
        Mahasiswa mahasiswa2 = new Mahasiswa("1912", "Comstock", new KomponenPenilaian[2]);
        assertEquals(true, mahasiswa1.compareTo(mahasiswa2) > 0);
    }

    @Test
    public void testCompareToLessThan() {
        Mahasiswa mahasiswa1 = new Mahasiswa("1960", "Andrew Ryan", new KomponenPenilaian[0]);
        Mahasiswa mahasiswa2 = new Mahasiswa("1912", "Comstock", new KomponenPenilaian[2]);
        assertEquals(true, mahasiswa2.compareTo(mahasiswa1) < 0);
    }

    @Test
    public void testCompareToEquals() {
        Mahasiswa mahasiswa1 = new Mahasiswa("1912", "Elizabeth", new KomponenPenilaian[0]);
        Mahasiswa mahasiswa2 = new Mahasiswa("1912", "Comstock", new KomponenPenilaian[2]);
        assertEquals(true, mahasiswa2.compareTo(mahasiswa1) == 0);
    }
}
