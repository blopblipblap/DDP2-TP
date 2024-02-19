package assignments.assignment3;

public class Negatif implements Status {
    
    /** Mengembalikan status dalam bentuk String. **/
    public String getStatus() {
        return "Negatif";
    }

    /** Implementasi jika objek Penular melakukan interaksi dengan objek Tertular. **/
    public void tularkan(Carrier penular, Carrier tertular) {
        return;
    }
}