package assignments.assignment3;

/** Class PeganganTangga. **/
public class PeganganTangga extends Benda {
    
    /** Constructor PeganganTangga. **/
    public PeganganTangga(String nama) {
        super(nama);
    }
    
    /** Menambah persentase sebanyak 20%. **/
    public void tambahPersentase() {
        this.setPersentaseMenular(this.getPersentaseMenular() + 20);
    }
    
    /** Method toString() dari PeganganTangga. **/
    public String toString() {
        return String.format("PEGANGAN TANGGA %s", this.getNama());
    }
}