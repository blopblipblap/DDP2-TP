package assignments.assignment3;

/** Class PekerjaJasa. **/
public class PekerjaJasa extends Manusia {
    
    /** Constructor PekerjaJasa. **/
    public PekerjaJasa(String nama) {
        super(nama);
    }
    
    /** Method toString() dari PekerjaJasa. **/
    public String toString() {
        return String.format("PEKERJA JASA %s", this.getNama());
    }
}