package assignments.assignment3;

import java.util.ArrayList;
import java.util.List;

/**Class Carrier. **/
public abstract class Carrier {

    private String nama;
    private String tipe;
    private Status statusCovid;
    private int aktifKasusDisebabkan;
    private int totalKasusDisebabkan;
    private List<Carrier> rantaiPenular;

    /** Constructor Carrier. **/
    public Carrier(String nama,String tipe) {
        this.nama = nama;
        this.tipe = tipe;
        this.statusCovid = new Negatif();
        this.totalKasusDisebabkan = 0;
        this.aktifKasusDisebabkan = 0;
        this.rantaiPenular = new ArrayList<Carrier>();
    }

    /** Mengembalikan atribut nama. **/
    public String getNama() {
        return this.nama;
    }

    /** Mengembalikan atribut tipe. **/
    public String getTipe() {
        return this.tipe;
    }

    /** Mengembalikan atribut statusCovid. **/
    public String getStatusCovid() {
        return this.statusCovid.getStatus();
    }

    /** Mengembalikan atribut aktifKasusDisebabkan. **/
    public int getAktifKasusDisebabkan() {
        return this.aktifKasusDisebabkan;
    }
    
    /** Mengurangi value atribut aktifKasusDisebabkan. **/
    public void kurangAktifKasusDisebabkan() {
        for (Carrier list : this.rantaiPenular) {
            if (list != this) {
                list.aktifKasusDisebabkan--;
            }
        }
    }

    /** Mengembalikan atribut totalKasusDisebabkan. **/
    public int getTotalKasusDisebabkan() {
        return this.totalKasusDisebabkan;
    }
    
    /** Menambahkan atribut totalKasusDisebabkan dan aktifKasusDisebabkan. **/
    public void tambahAktifDanTotal() {
        List<Carrier> noDuplicate = new ArrayList<>();
        for (Carrier carrier : this.rantaiPenular) {
            if (!noDuplicate.contains(carrier)) {
                noDuplicate.add(carrier);
            }
        }
        for (Carrier carrier2 : noDuplicate) {
            carrier2.totalKasusDisebabkan++;
            carrier2.aktifKasusDisebabkan++;
        }
    }

    /**Mengembalikan nilai dari atribut rantaiPenular. **/
    public List<Carrier> getRantaiPenular() throws BelumTertularException {
        if (this.getStatusCovid().equals("Positif")) {
            return rantaiPenular;
        } else {
            throw new BelumTertularException(this.toString()+" berstatus negatif");
        }
    }
    
    /**Menghapus isi nilai dari rantaiPenular. **/
    public void clearRantai() {
        this.rantaiPenular.removeAll(this.rantaiPenular);
    }

    /** Mengubah atribut dari statusCovid. **/
    public void ubahStatus(String status) {
        if (status.equals("Positif")) {
            Positif positif = new Positif();
            this.statusCovid = positif;
        } else {
            Negatif negatif = new Negatif();
            this.statusCovid = negatif;
        }
    }

    /** Ketika objek berinteraksi dengan objek lain. **/
    public void interaksi(Carrier lain) {
            this.statusCovid.tularkan(this, lain);
            if (this.getStatusCovid().equals("Positif") && lain.getStatusCovid().equals("Positif")) {
                if (this.rantaiPenular.size() > 0) {
                    for (Carrier carrier : this.rantaiPenular) {
                        lain.rantaiPenular.add(carrier);
                    }
                    tambahAktifDanTotal();
                    lain.rantaiPenular.add(lain);
                } else {
                    this.totalKasusDisebabkan++;
                    this.aktifKasusDisebabkan++;
                    this.rantaiPenular.add(this);
                    lain.rantaiPenular.add(this);
                    lain.rantaiPenular.add(lain);
                }
           }
    }

    /** Method toString. **/
    public abstract String toString();

}
