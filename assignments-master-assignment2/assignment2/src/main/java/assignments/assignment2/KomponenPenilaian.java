package assignments.assignment2;

public class KomponenPenilaian {
    private String nama;
    private ButirPenilaian[] butirPenilaian;
    private int bobot;

    /** Constructor KomponenPenilaian. **/
    public KomponenPenilaian(String nama, int banyakButirPenilaian, int bobot) {
        // TODO: buat constructor untuk KomponenPenilaian.
        // Note: banyakButirPenilaian digunakan untuk menentukan panjang butirPenilaian saja
        // (tanpa membuat objek-objek ButirPenilaian-nya).
        this.nama = nama;
        this.bobot = bobot;
        this.butirPenilaian = new ButirPenilaian[banyakButirPenilaian];
    }

    /**
     * Membuat objek KomponenPenilaian baru berdasarkan bentuk KomponenPenilaian templat.
     * @param templat templat KomponenPenilaian.
     */
    private KomponenPenilaian(KomponenPenilaian templat) {
        this(templat.nama, templat.butirPenilaian.length, templat.bobot);
    }

    /**
     * Mengembalikan salinan skema penilaian berdasarkan templat yang diberikan.
     * @param templat templat skema penilaian sebagai sumber.
     * @return objek baru yang menyerupai templat.
     */
    public static KomponenPenilaian[] salinTemplat(KomponenPenilaian[] templat) {
        KomponenPenilaian[] salinan = new KomponenPenilaian[templat.length];
        for (int i = 0; i < salinan.length; i++) {
            salinan[i] = new KomponenPenilaian(templat[i]);
        }
        return salinan;
    }

    /** Memasukkan butir ke butirPenilaian pada index ke-idx. **/
    public void masukkanButirPenilaian(int idx, ButirPenilaian butir) {
        // TODO: masukkan butir ke butirPenilaian pada index ke-idx.
        butirPenilaian[idx] = butir;
    }

    /** Mengembalikan nama KomponenPenilaian. **/
    public String getNama() {
        // TODO: kembalikan nama KomponenPenilaian.
        return this.nama;
    }

    /** Mengembalikan nilai rata-rata. **/
    public double getRerata() {
        // TODO: kembalikan rata-rata butirPenilaian.
        double sumNilai = 0.0;
        int jumlahButir = 0;
        for(ButirPenilaian butir : butirPenilaian) {
           if (butir == null) {
               sumNilai += 0.0;
           } else {
               sumNilai += butir.getNilai();
               jumlahButir++;
           }
        }
        if (jumlahButir != 0) {
            return sumNilai / jumlahButir;
        } else {
            return 0.0;
        }
    }

    /** Mengembalikan nilai rata-rata dikali bobot. **/
    public double getNilai() {
        // TODO: kembalikan rerata yang sudah dikalikan dengan bobot.
        return this.getRerata() * (this.bobot / 100.0);
    }

    /** Mengembalikan bobot. **/
    public int getBobot() {
        return this.bobot;
        
    }
    
    /** Mengembalikan detail KomponenPenilaian. **/
    public String getDetail() {
        // TODO: kembalikan detail KomponenPenilaian sesuai permintaan soal.
        String detailKomponen = "";
        int nomorUrut = 1;
        int length = butirPenilaian.length;
        detailKomponen += String.format("~~~ %s (%s%s) ~~~\n", this.nama, this.bobot, "%");
        for (ButirPenilaian butirNilai : butirPenilaian) {
            if (length > 1) {
                if (butirNilai == null) {
                    continue;
                } else {
                    detailKomponen += String.format("%s %s: %s\n", this.nama, nomorUrut, butirNilai.toString());
                    nomorUrut++;
                }
            } else if (butirNilai == null) {
                continue;
            } else {
                detailKomponen += String.format("%s: %s\n", this.nama, butirNilai.toString());
            }
        }
        if (length > 1) {
            detailKomponen += String.format("Rerata: %.2f\n", this.getRerata());
            detailKomponen += String.format("Kontribusi nilai akhir: %.2f\n", this.getNilai());
        } else {
            detailKomponen += String.format("Kontribusi nilai akhir: %.2f\n", this.getNilai());  
        }
        return detailKomponen;
    }

    @Override
    /** Format print KomponenPenilaian. **/
    public String toString() {
        // TODO: kembalikan representasi String sebuah KomponenPenilaian sesuai permintaan soal.
        return String.format("Rerata %s: %.2f", this.getNama(), this.getRerata());
    }

}
