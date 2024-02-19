package assignments.assignment3;

/** Interface Status. **/
public interface Status {
    /** Method untuk mengembalikan status dalam bentuk String. **/
    public String getStatus();
    
    /** Method ketika objek Penular berinteraksi dengan objek Tertular. **/
    public void tularkan(Carrier penular, Carrier tertular);
}