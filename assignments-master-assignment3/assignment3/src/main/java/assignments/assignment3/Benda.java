package assignments.assignment3;


public abstract class Benda extends Carrier{
  
    protected int persentaseMenular;

    public Benda(String nama) {
        super(nama, "Benda");
    }

    public abstract void tambahPersentase();

    public int getPersentaseMenular() {
        return this.persentaseMenular;
    }
    
    public void setPersentaseMenular(int persentase) {
        this.persentaseMenular = persentase;
    }
    
    public abstract String toString();
    
}