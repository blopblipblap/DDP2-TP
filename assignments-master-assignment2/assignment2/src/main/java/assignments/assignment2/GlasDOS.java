package assignments.assignment2;

import java.util.Scanner;

public class GlasDOS {
    private static final int INPUT_NUM = 1;
    private static final int DETAIL_NUM = 2;
    private static final int REKAP_NUM = 3;
    private static final int UBAH_NUM = 4;
    private static final int KELUAR_NUM = 99;
    private AsistenDosen[] asistenDosen;
    private Mahasiswa[] mahasiswa;
    private KomponenPenilaian[] templatSkemaPenilaian;
    private Scanner input = new Scanner(System.in);

    /** Pesan awal GlasDos. **/
    private void initPesan() {
        System.out.println("Selamat datang di Global Asdos Data Organizing System!");
        System.out.println("====================== GlasDOS =======================");
        System.out.println();
    }

    /** Inisialisasi skema penilaian. **/
    private void initSkemaPenilaian() {
        System.out.println("Mari buat skema penilaian!");
        System.out.println("Masukkan banyaknya komponen penilaian:");
        int numKomponen = Integer.parseInt(input.nextLine());
        templatSkemaPenilaian = new KomponenPenilaian[numKomponen];
        for (int i = 1; i <= numKomponen; i++) {
            System.out.println("> Komponen Penilaian " + i);
            System.out.println("Masukkan nama komponen penilaian " + i + ": ");
            String namaKomponen = input.nextLine();
            System.out.println("Masukkan banyaknya butir penilaian " + namaKomponen + ":");
            int numButir = Integer.parseInt(input.nextLine());
            System.out.println("Masukkan bobot penilaian " + namaKomponen + " (dalam persen):");
            int bobot = Integer.parseInt(input.nextLine());
            templatSkemaPenilaian[i - 1] = new KomponenPenilaian(namaKomponen, numButir, bobot);
        }
        System.out.println("Skema penilaian berhasil dibuat!");
        System.out.println();
    }

    /** Inisialisasi asisten dosen dan mahasiswa. **/
    private void initAsdosMahasiswa() {
        System.out.println("Mari masukkan data asdos dan mahasiswa!");
        System.out.println("Masukkan banyaknya asdos:");
        int numAsistenDosen = Integer.parseInt(input.nextLine());
        asistenDosen = new AsistenDosen[numAsistenDosen];
        for (int i = 1; i <= numAsistenDosen; i++) {
            System.out.println("Data asdos " + i + ":");
            String[] dataAsdos = input.nextLine().split(" ", 2);
            AsistenDosen newAsdos = new AsistenDosen(dataAsdos[0].toUpperCase(), dataAsdos[1]);
            asistenDosen[i - 1] = newAsdos;
            System.out.println("Masukkan banyaknya mahasiswa dengan kode asdos " + dataAsdos[0].toUpperCase() + ":");
            int numAsdosan = Integer.parseInt(input.nextLine());
            for (int j = 1; j <= numAsdosan; j++) {
                System.out.println("Data mahasiswa " + j + ":");
                String[] dataMhs = input.nextLine().split(" ", 2);
                KomponenPenilaian[] skema = KomponenPenilaian.salinTemplat(templatSkemaPenilaian);
                Mahasiswa baru = new Mahasiswa(dataMhs[0], dataMhs[1], skema);
                System.out.println(baru);
                newAsdos.addMahasiswa(baru);
            }
        }
        System.out.println();
    }

    /** Mengembalikan AsistenDosen yang memiliki kode tertentu. **/
    private AsistenDosen getAsistenDosen(String kode) {
        // TODO: kembalikan AsistenDosen yang memiliki kode tertentu.
        for (AsistenDosen asdos : asistenDosen) {
            if (asdos.getKode().equals(kode)) {
                return asdos;
            }
        }
        return null;
    }

    /** Mengembalikan Mahasiswa dengan kode asdos dan NPM tertentu. **/
    private Mahasiswa getMahasiswa(String kodeAsdos, String npm) {
        // TODO: kembalikan Mahasiswa dengan NPM dan kodeAsdos tertentu.
        AsistenDosen asdos = getAsistenDosen(kodeAsdos);
        if (asdos == null) {
            return null;
        } else {
            return asdos.getMahasiswa(npm);
        }
    }

    /** Mengembalikan KomponenPenilaian dengan kode asdos, NPM, dan nama komponen tertentu. **/
    private KomponenPenilaian getKomponenPenilaian(String kodeAsdos, String npm, String namaKomponen) {
        // TODO: kembalikan KomponenPenilaian dengan namaKomponen tertentu
        //  dari seorang Mahasiswa dengan NPM tertentu dan kodeAsdos tertentu.
        AsistenDosen asdos = getAsistenDosen(kodeAsdos);
        Mahasiswa mhs = getMahasiswa(kodeAsdos, npm);
        if (asdos == null) {
            return null;
        } else if (mhs == null) {
            return null;
        } else {
            return asdos.getMahasiswa(npm).getKomponenPenilaian(namaKomponen);
        }
    }

    /** Menu untuk menginput nilai. **/
    private void menuInput() {
        System.out.println("--- Input nilai ---");
        System.out.println("Masukkan perintah input nilai dalam format berikut:");
        System.out.println(
            "[KodeAsdos] [NPM] [KomponenPenilaian] [NomorButirPenilaian] [Nilai] [Terlambat]"
        );
        System.out.println("Contoh: SMA 1234567890 Lab 1 90.00 true");
        System.out.println("Jika sudah selesai, tulis SELESAI dan tekan tombol Enter.");
        System.out.println();
        while (!input.hasNext("(?i)SELESAI")) {
            String masukan[] = input.nextLine().split(" ");
            String kodeAsdos = masukan[0].toUpperCase();
            String npm = masukan[1];
            String namaKomponen = masukan[2];
            int idx = Integer.parseInt(masukan[3]);
            double nilaiButir = Double.parseDouble(masukan[4]);
            boolean terlambat = Boolean.parseBoolean(masukan[5]);
            ButirPenilaian butir = new ButirPenilaian(nilaiButir, terlambat);
            KomponenPenilaian komponenPenilaian = getKomponenPenilaian(kodeAsdos, npm, namaKomponen);
            if (komponenPenilaian != null) {
                komponenPenilaian.masukkanButirPenilaian(idx - 1, butir);
            } else {
                System.out.println(
                    "Komponen penilaian untuk NPM " + npm + " pada kode asdos "
                    + kodeAsdos + " tidak ditemukan!"
                );
            };
        }
        input.nextLine();
        System.out.println("Sukses! Kembali ke menu utama...");
        System.out.println();
    }

    /** Menu untuk menampilkan detail. **/
    private void menuDetail() {
        System.out.println("--- Lihat detail nilai mahasiswa ---");
        System.out.println("Masukkan data mahasiswa dalam format berikut:");
        System.out.println("[KodeAsdos] [NPM]");
        System.out.println("Contoh: SMA 134567890");
        System.out.println();
        String[] dataMhs = input.nextLine().split(" ");
        Mahasiswa mahasiswa = getMahasiswa(dataMhs[0].toUpperCase(), dataMhs[1]);
        if (mahasiswa != null) {
            System.out.println(mahasiswa);
            System.out.println(mahasiswa.getDetail());
        } else {
            System.out.println("Mahasiswa dengan kode asdos dan NPM tersebut tidak ditemukan!");
        };
        System.out.println();
        System.out.println("Kembali ke menu utama...");
        System.out.println();
    }

    /** Menu untuk menampilkan rekap. **/
    private void menuRekap() {
        System.out.println("--- Rekap ---");
        for (AsistenDosen asdos : asistenDosen) {
            System.out.println(asdos);
            System.out.println(asdos.rekap());
            System.out.println();
        }
        System.out.println("Kembali ke menu utama...");
        System.out.println();
    }
    
    /** Menu untuk mengubah asdos. **/
    private void menuUbah() {
        System.out.println("Masukkan perintah input nilai dalam format berikut:");
        System.out.println("[KodeAsdosAsal] [NPM] [KodeAsdosBaru]");
        System.out.println("Contoh: SMA 1234567890 SMP");
        String[] ubahMhs = input.nextLine().split(" ");
        String kodeAsdosAwal = ubahMhs[0];
        String npm = ubahMhs[1];
        String kodeAsdosBaru = ubahMhs[2];
        //cek asdos awal
        AsistenDosen asdosAwal = getAsistenDosen(kodeAsdosAwal);
        //cek asdos baru
        AsistenDosen asdosBaru = getAsistenDosen(kodeAsdosBaru);
        Mahasiswa siswa = getMahasiswa(kodeAsdosAwal, npm);
        //cek mahasiswa dalam asdos
        System.out.println();
        if (asdosAwal != null & siswa == null) {
            System.out.println("Mahasiswa tidak ditemukan!");
        }
        if (asdosAwal != null && asdosBaru != null) {
            if (siswa != null) {
                asdosBaru.addMahasiswa(siswa);
                asdosAwal.gantiAsdos(siswa);
                System.out.println("Perubahan sukses! Kembali ke menu utama...");
            }
        } else if (asdosBaru == null && asdosAwal != null) {
            System.out.println("Asdos dengan kode " + kodeAsdosBaru + " tidak ditemukan!");
        } else if (asdosAwal == null && asdosBaru != null) {
            System.out.println("Asdos dengan kode " + kodeAsdosAwal + " tidak ditemukan!");
        } else {
            System.out.println("Asdos dengan kode " + kodeAsdosAwal + " dan " + kodeAsdosBaru + " tidak ditemukan!");
        }
        System.out.println();
    }

    /** Menu utama. **/
    private void menu() {
        int operation = 0;
        boolean hasChosenExit = false;
        while (!hasChosenExit) {
            System.out.println("=== Menu utama ===");
            System.out.println("1. Input nilai");
            System.out.println("2. Lihat detail nilai mahasiswa");
            System.out.println("3. Rekap");
            System.out.println("4. Ubah kode asdos mahasiswa");
            System.out.println("99. Keluar");
            System.out.println("Masukkan pilihan menu:");
            try {
                operation = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                continue;
            }
            System.out.println();
            if (operation == INPUT_NUM) {
                menuInput();
            } else if (operation == DETAIL_NUM) {
                menuDetail();
            } else if (operation == REKAP_NUM) {
                menuRekap();
            } else if (operation == UBAH_NUM) {
                menuUbah();
            } else if (operation == KELUAR_NUM) {
                System.out.println("Terima kasih telah menggunakan GlasDOS!");
                hasChosenExit = true;
            }
        }
    }

    /** Untuk me-run semua inisialisasi. **/
    private void run() {
        initPesan();
        initSkemaPenilaian();
        initAsdosMahasiswa();
        System.out.println("Inisialisasi selesai!");
        System.out.println();
        menu();
        input.close();
    }

    /** Method main. **/
    public static void main(String[] args) {
        GlasDOS program = new GlasDOS();
        program.run();
    }
}
