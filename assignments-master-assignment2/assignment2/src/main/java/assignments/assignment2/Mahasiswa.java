package assignments.assignment2;

public class Mahasiswa implements Comparable<Mahasiswa> {
    private String npm;
    private String nama;
    private KomponenPenilaian[] komponenPenilaian;

    /** Constructor Mahasiswa. **/
    public Mahasiswa(String npm, String nama, KomponenPenilaian[] komponenPenilaian) {
        // TODO: buat constructor untuk Mahasiswa.
        // Note: komponenPenilaian merupakan skema penilaian yang didapat dari GlasDOS.
        this.npm = npm;
        this.nama = nama;
        this.komponenPenilaian = komponenPenilaian;
    }

    /** Mengembalikan KomponenPenilaian yang bernama NamaKomponen. **/
    public KomponenPenilaian getKomponenPenilaian(String namaKomponen) {
        // TODO: kembalikan KomponenPenilaian yang bernama namaKomponen.
        // Note: jika tidak ada, kembalikan null atau lempar sebuah Exception.
        for (KomponenPenilaian komponen : komponenPenilaian) {
            if (komponen.getNama().equals(namaKomponen)) {
                return komponen;
            }
        }
        return null;
    }

    /** Mengembalikan NPM mahasiswa. **/
    public String getNpm() {
        // TODO: kembalikan NPM mahasiswa.
        return this.npm;
    }
    
    public String getNama() {
        return this.nama;
    }

    /**
     * Mengembalikan huruf berdasarkan nilai yang diberikan.
     * @param nilaiAkhir nilai untuk dicari hurufnya.
     * @return huruf dari nilai.
     */
    private static String getHuruf(double nilai) {
        return nilai >= 85 ? "A" :
            nilai >= 80 ? "A-" :
            nilai >= 75 ? "B+" :
            nilai >= 70 ? "B" :
            nilai >= 65 ? "B-" :
            nilai >= 60 ? "C+" :
            nilai >= 55 ? "C" :
            nilai >= 40 ? "D" : "E";
    }

    /**
     * Mengembalikan status kelulusan berdasarkan nilaiAkhir yang diberikan.
     * @param nilaiAkhir nilai akhir mahasiswa.
     * @return status kelulusan (LULUS/TIDAK LULUS).
     */
    private static String getKelulusan(double nilaiAkhir) {
        return nilaiAkhir >= 55 ? "LULUS" : "TIDAK LULUS";
    }
    
    /** Mengembalikan total nilai akhir. **/
    public double getNilaiAkhir() {
        double sumAkhir = 0.0;
        for (KomponenPenilaian komponen : komponenPenilaian) {
            sumAkhir += komponen.getNilai();
        }
        return sumAkhir;
    }

    /** Mengembalikan rekap nilai. **/
    public String rekap() {
        // TODO: kembalikan rekapan sesuai dengan permintaan soal.
        String stringRekap = "";
        for (KomponenPenilaian rekap : komponenPenilaian) {
            stringRekap += String.format("Rerata %s: %.2f\n", rekap.getNama(), rekap.getRerata());
        }
        stringRekap += String.format("Nilai akhir: %.2f\n", this.getNilaiAkhir());
        stringRekap += String.format("Huruf: %s\n", this.getHuruf(this.getNilaiAkhir()));
        stringRekap += String.format("%s", this.getKelulusan(this.getNilaiAkhir()));
        return stringRekap;
    }

    /** Format print Mahasiswa. **/
    public String toString() {
        // TODO: kembalikan representasi String dari Mahasiswa sesuai permintaan soal.
        return String.format(this.npm + " - " + this.nama);
    }

    /** Mengembalikan detail dari Mahasiswa. **/
    public String getDetail() {
        // TODO: kembalikan detail dari Mahasiswa sesuai permintaan soal.
        String detailMahasiswa = "";
        for (KomponenPenilaian komponen : komponenPenilaian) {
            detailMahasiswa += komponen.getDetail();
            detailMahasiswa += "\n";
        }
        detailMahasiswa += String.format("Nilai akhir: %.2f\n", this.getNilaiAkhir());
        detailMahasiswa += String.format("Huruf: %s\n", this.getHuruf(this.getNilaiAkhir()));
        detailMahasiswa += String.format("%s\n", this.getKelulusan(this.getNilaiAkhir()));
        return detailMahasiswa;
    }

    @Override
    /** Membandingkan mahasiswa dengan mahasiswa lain berdasarkan NPM. **/
    public int compareTo(Mahasiswa other) {
        // TODO: definisikan cara membandingkan seorang mahasiswa dengan mahasiswa lainnya.
        // Hint: bandingkan NPM-nya, String juga punya method compareTo.
        return this.npm.compareTo(other.npm);
    }
}
