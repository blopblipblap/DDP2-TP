package assignments.assignment3;

/** Class TombolLift. **/
public class TombolLift extends Benda {
    
    /** Constructor TombolLift. **/
    public TombolLift(String nama) {
        super(nama);
    }
    
    /** Menambah persentase sebanyak 20%. **/
    public void tambahPersentase() {
        this.setPersentaseMenular(this.getPersentaseMenular() + 20);
    }
    
    /** Method toString() untuk TombolLift. **/
    public String toString() {
        return String.format("TOMBOL LIFT %s", this.getNama());
    }
}