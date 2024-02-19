package assignments.assignment3;

/** Class Positif. **/
public class Positif implements Status {
    
    /** Mengembalikan status dalam bentuk String. **/
    public String getStatus() {
        return "Positif";
    }

    /** Implementasi jika objek Penular melakukan interaksi dengan objek Tertular. **/
    public void tularkan(Carrier penular, Carrier tertular) {
        if (penular.getTipe().equalsIgnoreCase("Manusia") && tertular.getTipe().equalsIgnoreCase("Manusia")) {
            tertular.ubahStatus("Positif");
        } else if (penular.getTipe().equals("Benda") && tertular.getTipe().equals("Manusia")) {
            Benda b = (Benda)penular;
            if (b.getPersentaseMenular() >= 100) {
                tertular.ubahStatus("Positif");
            } else
                return;
        } else if (penular.getTipe().equals("Manusia") && tertular.getTipe().equals("Benda")) {
            Benda b = (Benda)tertular;
            b.tambahPersentase();
            if (b.getPersentaseMenular() >= 100) {
                tertular.ubahStatus("Positif");
            } else {
                return;
            }
        } else {
            return;
        }
    }
}