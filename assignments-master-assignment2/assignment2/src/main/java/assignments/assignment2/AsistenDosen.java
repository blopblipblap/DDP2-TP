package assignments.assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class AsistenDosen {
    private List<Mahasiswa> mahasiswa = new ArrayList<>();
    private String kode;
    private String nama;

    /** Constructor AsistenDosen. **/
    public AsistenDosen(String kode, String nama) {
        // TODO: buat constructor untuk AsistenDosen.
        this.kode = kode;
        this.nama = nama;
    }

    /** Mengembalikan kode asdos. **/
    public String getKode() {
        // TODO: kembalikan kode AsistenDosen.
        return this.kode;
    }

    /** Menambahkan mahasiswa ke dalam daftar mahasiswa dengan mempertahankan urutan. **/
    public void addMahasiswa(Mahasiswa mahasiswa) {
        // TODO: tambahkan mahasiswa ke dalam daftar mahasiswa dengan mempertahankan urutan.
        // Hint: kamu boleh menggunakan Collections.sort atau melakukan sorting manual.
        // Note: manfaatkan method compareTo pada Mahasiswa.
        this.mahasiswa.add(mahasiswa);
        Collections.sort(this.mahasiswa);
    }

    /** Mengembalikan mahasiswa dengan NPM tertentu. **/
    public Mahasiswa getMahasiswa(String npm) {
        // TODO: kembalikan objek Mahasiswa dengan NPM tertentu dari daftar mahasiswa.
        // Note: jika tidak ada, kembalikan null atau lempar sebuah Exception.
        for (Mahasiswa siswa : mahasiswa) {
            if (siswa.getNpm().equals(npm)) {
                return siswa;
            }
        }
        return null;
    }
    
    /** Method untuk menghapus mahasiswa dari list asdos awal dalam mengganti asdos. **/
    public void gantiAsdos(Mahasiswa mahasiswa) {
        this.mahasiswa.remove(mahasiswa);
    }

    /** Mengembalikan rekap AsistenDosen. **/
    public String rekap() {
        String rekapAsdos = "~~~~~~~~~~~~~~~~~~~";
        rekapAsdos += "\n";
        for (Mahasiswa siswa : mahasiswa) {
            rekapAsdos += "\n";
            rekapAsdos += siswa.toString();
            rekapAsdos += "\n";
            rekapAsdos += siswa.rekap();
            rekapAsdos += "\n";
        }
        return rekapAsdos;
    }

    /** Format print AsistenDosen. **/
    public String toString() {
        return String.format(this.kode + " - " + this.nama);
    }
}
