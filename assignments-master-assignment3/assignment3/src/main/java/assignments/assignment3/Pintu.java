package assignments.assignment3;

/** Class Pintu. **/
public class Pintu extends Benda {
    
    /** Constructor Pintu. **/
    public Pintu(String nama) {
        super(nama);
    }
    
    /** Menambah persentase sebanyak 30%. **/
    public void tambahPersentase() {
        this.setPersentaseMenular(this.getPersentaseMenular() + 30);
    }
    
    /** Method toString() untuk Pintu. **/
    public String toString() {
        return String.format("PINTU %s", this.getNama());
    }
}