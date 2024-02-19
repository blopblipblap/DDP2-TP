package assignments.assignment2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class KomponenPenilaianTest {
    @Test
    public void testRerataComplete() {
        KomponenPenilaian komponen = new KomponenPenilaian("k", 2, 40);
        ButirPenilaian butir = new ButirPenilaian(100, false);
        ButirPenilaian butir2 = new ButirPenilaian(90, false);
        komponen.masukkanButirPenilaian(0, butir);
        komponen.masukkanButirPenilaian(1, butir2);
        assertEquals(95.00, komponen.getRerata());
    }

    @Test
    public void testRerataIncomplete() {
        KomponenPenilaian komponen = new KomponenPenilaian("k", 3, 40);
        ButirPenilaian butir = new ButirPenilaian(100, false);
        ButirPenilaian butir2 = new ButirPenilaian(80, false);
        komponen.masukkanButirPenilaian(0, butir);
        komponen.masukkanButirPenilaian(2, butir2);
        assertEquals(90.00, komponen.getRerata());
    }

    @Test
    public void testRerataEmpty() {
        KomponenPenilaian komponen = new KomponenPenilaian("k", 4, 40);
        assertEquals(0.00, komponen.getRerata());
    }

    @Test
    public void testRerataCompleteWithZero() {
        KomponenPenilaian komponen = new KomponenPenilaian("k", 2, 40);
        ButirPenilaian butir = new ButirPenilaian(70, false);
        ButirPenilaian butir2 = new ButirPenilaian(0, false);
        komponen.masukkanButirPenilaian(0, butir);
        komponen.masukkanButirPenilaian(1, butir2);
        assertEquals(35.00, komponen.getRerata());
    }

    @Test
    public void testRerataIncompleteWithZero() {
        KomponenPenilaian komponen = new KomponenPenilaian("k", 5, 40);
        ButirPenilaian butir = new ButirPenilaian(100, false);
        ButirPenilaian butir2 = new ButirPenilaian(0, false);
        komponen.masukkanButirPenilaian(0, butir);
        komponen.masukkanButirPenilaian(1, butir2);
        assertEquals(50.00, komponen.getRerata());
    }

    @Test
    public void testNilai() {
        KomponenPenilaian komponen = new KomponenPenilaian("k", 2, 40);
        ButirPenilaian butir = new ButirPenilaian(100, true);
        ButirPenilaian butir2 = new ButirPenilaian(20, false);
        komponen.masukkanButirPenilaian(0, butir);
        komponen.masukkanButirPenilaian(1, butir2);
        assertEquals(20.00, komponen.getNilai());
    }

    @Test
    public void testToString() {
        KomponenPenilaian komponen = new KomponenPenilaian("Tugas", 3, 40);
        ButirPenilaian butir = new ButirPenilaian(100, false);
        ButirPenilaian butir2 = new ButirPenilaian(80, false);
        komponen.masukkanButirPenilaian(0, butir);
        komponen.masukkanButirPenilaian(2, butir2);
        assertEquals("Rerata Tugas: 90.00", komponen.toString());
    }
}
