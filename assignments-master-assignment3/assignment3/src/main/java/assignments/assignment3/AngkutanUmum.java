package assignments.assignment3;

/** Class AngkutanUmum. **/
public class AngkutanUmum extends Benda {
    
    /** Constructor AngkutanUmum. **/
    public AngkutanUmum(String nama) {
        super(nama);
    }
    
    /** Menambah persentase sebanyak 35%. **/
    public void tambahPersentase() {
        this.setPersentaseMenular(this.getPersentaseMenular() + 35);
    }
    
    /** Method toString() dari AngkutanUmum. **/
    public String toString() {
        return String.format("ANGKUTAN UMUM %s", this.getNama());
    }
}