package assignments.assignment2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AsistenDosenTest {
    @Test
    public void testAddMahasiswaSorted() {
        AsistenDosen asdos = new AsistenDosen("CJ", "Carl Johnson");
        Mahasiswa mhs1 = new Mahasiswa("777", "A", new KomponenPenilaian[0]);
        Mahasiswa mhs2 = new Mahasiswa("111", "B", new KomponenPenilaian[0]);
        Mahasiswa mhs3 = new Mahasiswa("333", "C", new KomponenPenilaian[0]);
        asdos.addMahasiswa(mhs1);
        asdos.addMahasiswa(mhs2);
        asdos.addMahasiswa(mhs3);
        assertEquals(true, asdos.rekap().matches("(?s).*111.*333.*777.*"));
    }

    @Test
    public void testGetMahasiswa() {
        AsistenDosen asdos = new AsistenDosen("CJ", "Cave Johnson");
        Mahasiswa mhs1 = new Mahasiswa("777", "A", new KomponenPenilaian[0]);
        Mahasiswa mhs2 = new Mahasiswa("111", "B", new KomponenPenilaian[0]);
        Mahasiswa mhs3 = new Mahasiswa("333", "C", new KomponenPenilaian[0]);
        asdos.addMahasiswa(mhs1);
        asdos.addMahasiswa(mhs2);
        asdos.addMahasiswa(mhs3);
        assertEquals(mhs2, asdos.getMahasiswa("111"));
    }

    @Test
    public void testToString() {
        AsistenDosen asdos = new AsistenDosen("WW", "Walter White");
        assertEquals("WW - Walter White", asdos.toString());
    }
}
