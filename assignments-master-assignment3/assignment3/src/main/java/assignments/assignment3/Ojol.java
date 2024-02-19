package assignments.assignment3;

/** Class Ojol. **/
public class Ojol extends Manusia {
    
    /** Constructor Ojol. **/
    public Ojol(String nama) {
        super(nama);
    }
    
    /** Method toString() dari Ojol. **/
    public String toString() {
        return String.format("OJOL %s", this.getNama());
    }
}