package assignments.assignment3;

/**Class untuk Petugas Medis. **/
public class PetugasMedis extends Manusia {
    
    private int jumlahDisembuhkan;

    /** Constructor petugas media. **/
    public PetugasMedis(String nama) {
        super(nama);
    }

    /** Apabila petugas medis menyembuhkan manusia. **/
    public void obati(Manusia manusia) {
        manusia.ubahStatus("Negatif");
        manusia.tambahSembuh();
        this.jumlahDisembuhkan++;
        manusia.kurangAktifKasusDisebabkan();
        manusia.clearRantai();
    }

    /** Mengembalikan jumlah manusia yang disembuhkan. **/
    public int getJumlahDisembuhkan() {
        return this.jumlahDisembuhkan;
    }
    
    /** Method toString() untuk PetugasMedis. **/
    public String toString() {
        return String.format("PETUGAS MEDIS %s", this.getNama());
    }
}