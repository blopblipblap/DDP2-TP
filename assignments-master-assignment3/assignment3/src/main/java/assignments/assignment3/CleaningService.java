package assignments.assignment3;

/** Class CleaningService. **/
public class CleaningService extends Manusia {
  		
    private int jumlahDibersihkan;

    /** Constructor untuk cleaning service. **/
    public CleaningService(String nama) {
        super(nama);
    }

    /** Apabila CleaningService membersihkan benda. **/
    public void bersihkan(Benda benda) {
        if (benda.getPersentaseMenular() >= 0 && benda.getPersentaseMenular() < 100) {
            benda.setPersentaseMenular(0);
        } else {
            benda.ubahStatus("Negatif");
            benda.setPersentaseMenular(0);
            benda.kurangAktifKasusDisebabkan();
        }
        this.jumlahDibersihkan++;
    }

    /** Mengembalikan jumlahDibersihkan. **/
    public int getJumlahDibersihkan() {
        return this.jumlahDibersihkan;
    }
    
    public String toString() {
        return String.format("CLEANING SERVICE %s", this.getNama());
    }
}