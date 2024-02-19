package assignments.assignment3;

/** Class Manusia. **/
public abstract class Manusia extends Carrier {
    private static int jumlahSembuh = 0;
    
    /** Constructor untuk manusia. **/
    public Manusia(String nama) {
        super(nama, "Manusia");
    }
    
    /** Untuk menambah nilai jumlahSembuh. **/
    public void tambahSembuh() {
        jumlahSembuh++;
    }

    /** Mengembalikan jumlahSembuh. **/
    public static int getJumlahSembuh() {
        return jumlahSembuh;
    }
}