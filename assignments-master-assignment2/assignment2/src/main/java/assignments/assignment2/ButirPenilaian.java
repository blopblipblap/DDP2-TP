package assignments.assignment2;

public class ButirPenilaian {
    private static final int PENALTI_KETERLAMBATAN = 20;
    private double nilai;
    private boolean terlambat;

    /** Constructor ButirPenilaian. **/
    public ButirPenilaian(double nilai, boolean terlambat) {
        // TODO: buat constructor untuk ButirPenilaian.
        this.nilai = nilai;
        this.terlambat = terlambat;
        if (nilai < 0) {
            this.nilai = 0;
        }
    }

    /** Mengembalikan nilai yang sudah dikali dengan PENALTI_KETERLAMBATAN. **/
    public double getNilai() {
        // TODO: kembalikan nilai yang sudah disesuaikan dengan keterlambatan.
        if (terlambat) {
            return (this.nilai - ((PENALTI_KETERLAMBATAN / 100.0) * this.nilai));
        } else {
            return this.nilai;
        }
    }

    @Override
    /** Format print ButirPenilaian. **/
    public String toString() {
        // TODO: kembalikan representasi String dari ButirPenilaian sesuai permintaan soal.
        if (this.terlambat == true) {
            return String.format("%.2f (T)", this.getNilai());  
        } else {
            return String.format("%.2f", this.getNilai());  
        }
    }
}
