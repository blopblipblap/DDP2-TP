package assignments.assignment2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ButirPenilaianTest {
    @Test
    public void testNilaiNotTerlambat() {
        ButirPenilaian butir = new ButirPenilaian(90, false);
        assertEquals(90.00, butir.getNilai());
    }

    @Test
    public void testNilaiTerlambat() {
        ButirPenilaian butir = new ButirPenilaian(90, true);
        assertEquals(72.00, butir.getNilai());
    }

    @Test
    public void testToStringNotTerlambat() {
        ButirPenilaian butir = new ButirPenilaian(90, false);
        assertEquals("90.00", butir.toString());
    }

    @Test
    public void testToStringTerlambat() {
        ButirPenilaian butir = new ButirPenilaian(90, true);
        assertEquals("72.00 (T)", butir.toString());
    }
}
