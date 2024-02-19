package assignments.assignment3;

/** Class Jurnalis. **/
public class Jurnalis extends Manusia {
    
    /** Constructor jurnalis. **/
    public Jurnalis(String nama) {
        super(nama);
    }
    
    /** Method toString() dari Jurnalis. **/
    public String toString() {
        return String.format("JURNALIS %s", this.getNama());
    }
}