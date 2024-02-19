# Tugas Pemrograman 3: Corona

CSGE601021 Dasar-Dasar Pemrograman 2 @ Fakultas Ilmu Komputer Universitas Indonesia,
Semester Genap 2019/2020

Dokumen ini berisi deskripsi dan informasi umum yang dibutuhkan untuk menyelesaikan
Tugas Pemrograman 3 mata kuliah DDP 2. Tugas Pemrograman ini didesain untuk
mengimplementasikan konsep Pemrograman Berorientasi Objek dengan memanfaatkan
*abstract classes* dan *interfaces* serta melakukan *exception handling* dan
*text I/O*.

Tugas Pemrograman ini mencakup materi berikut:

- Materi yang dicakup Tugas Pemrograman 2
- *Abstract Classes & Interfaces*
- *Inheritance & Polymorphism*
- *Exception Handling*
- *Text I/O*

## Daftar Isi

1. [Latar belakang dan deskripsi](#latar-belakang-dan-deskripsi)
2. [Persiapan](#persiapan)
3. [Menjalankan dan menguji program](#menjalankan-dan-menguji-program)
4. [Pengumpulan](#pengumpulan)
5. [Daftar pekerjaan](#daftar-pekerjaan)
   1. [Daftar pekerjaan wajib](#daftar-pekerjaan-wajib)
   2. [Daftar pekerjaan bonus (opsional)](#daftar-pekerjaan-bonus-opsional)
6. [Penilaian](#penilaian)


## Latar belakang dan deskripsi

Silakan baca [dokumen soal][dokumen tp3].

## Persiapan

Lakukan `git pull upstream master` seperti yang diinstruksikan pada
[`README.md`][root-readme] di *root* repositori ini. Lalu, silakan kerjakan
soal menggunakan *starter code* yang disediakan.

## Menjalankan dan menguji program

> Catatan: ubah `gradlew.bat` dengan `./gradlew` dan `\` dengan `/` jika kamu
> menggunakan Linux/Mac.

Kamu bisa menjalankan beberapa *task* dengan Gradle melalui IDE atau
terminal/Command Prompt.

Untuk menjalankan program:

```bash
gradlew.bat :assignment3:run --console plain --quiet
```

Untuk menguji program dengan *unit test* yang disediakan:

```bash
gradlew.bat :assignment3:test
```

> Tips: kamu bisa memeriksa hasil *unit test* dalam bentuk dokumen HTML. Lihat dokumen
> HTML tersebut di dalam folder `build\reports` yang ada di direktori ini.

Untuk melihat output program dengan input kasus uji yang disediakan, jalankan:

```bash
gradlew.bat :assignment3:run --console plain --quiet
```

Lalu gunakan mode input `TEXT` dan ketik [`testcases\InputTC1.txt`][input-tc1]
untuk menggunakan kasus uji yang pertama. Terdapat 5 buah kasus uji yang
diberikan, yakni `InputTC{1..5}.txt`. Kamu bisa membandingkan *output*-nya
dengan berkas `OutputTC{1..5}.txt`.

Jika kamu tidak ingin menggunakan Gradle, kamu juga bisa melakukan kompilasi
dan menjalankan program dengan `javac` dan `java` seperti biasa. Masuk ke
direktori `src\main\java`, *compile* semua berkas `.java` kamu, dan jalankan
*main class*-nya (dalam hal ini adalah `Simulator.java`).

```bash
cd src\main\java
javac assignments\assignment3\*.java
java assignments.assignment3.Simulator
```

Namun, perlu diperhatikan bahwa jika menggunakan Gradle, *path* berkas yang
kamu berikan akan relatif terhadap direktori [`assignment3`][assignment3] (yang
di dalamnya terdapat folder `src` dan `testcases`). Jika tidak menggunakan
Gradle, maka *path* berkas yang kamu berikan akan relatif terhadap direktori
[`src/main/java`][src-main-java].

Jika tidak yakin, kamu bisa menggunakan *absolute path* seperti contoh berikut:

- di Windows

  ```
  C:\Users\username\folderku\inputPunyaku.txt
  ```

- di Mac

  ```
  /Users/username/folderku/inputPunyaku.txt
  ```

- di Linux

  ```
  /home/username/folderku/inputPunyaku.txt
  ```

Cara dengan *absolute path* seperti di atas pasti bisa digunakan baik dengan
Gradle maupun tidak.

Aturan yang sama juga berlaku untuk berkas *output*.

## Pengumpulan

Simpan pekerjaan kamu, lalu lakukan `add`, `commit`, dan `push` dengan Git.
*Push* solusi kamu **sebelum 10 Mei 2020 pukul 23.55**. Disarankan untuk
*push* **sebelum pukul 22.00** untuk mengantisipasi antrean pada GitLab
Pipelines.

## Daftar pekerjaan

### Daftar pekerjaan wajib

- [ ] Buat sekurang-kurangnya 1 *commit* yang mengandung progres kamu dalam
      mengerjakan Tugas Pemrograman 3.
- [ ] *Push* *commit* kamu ke repositori Git *online* yang ada pada proyek
      GitLab kamu.
- [ ] Implementasikan *class* `World` dengan benar.
- [ ] Implementasikan *class* `InputOutput` dengan benar.
- [ ] Implementasikan *class* `Carrier` dengan benar.
- [ ] Implementasikan *class* `Status` dengan benar.
- [ ] Implementasikan *class* `Benda` dengan benar.
- [ ] Implementasikan *class* `Manusia` dengan benar.
- [ ] Implementasikan *class* yang merupakan subclass dari *class* `Benda`, yaitu
      `AngkutanUmum`, `PeganganTangga`, `Pintu`, dan `TombolLift` dengan benar.
- [ ] Implementasikan *class* yang merupakan subclass dari *class* `Manusia`, yaitu
      `CleaningService`, `Jurnalis`, `PekerjaJasa`, `PetugasMedis`, dan `Ojol` dengan benar.
- [ ] Implementasikan *class* yang merupakan subclass dari *class* `Status`, yaitu
      `Positif` dan `Negatif` dengan benar.
- [ ] Implementasikan *class* `BelumTertularException` dengan benar.
- [ ] Demonstrasikan program kamu ke asdos kamu.

### Daftar pekerjaan bonus (opsional)

<sup><sub>Yeey, ada bonus!</sub></sup>

- [ ] Implementasikan GUI untuk program ini.\
      Tidak ada ketentuan khusus mengenai GUI program. Silakan berkreasi dalam
      implementasi *layout*, *widgets*, dsb. Usahakan untuk memanfaatkan ulang
      (*reuse*) kode yang sudah ada sebaik mungkin agar kamu tidak perlu
      mengimplementasikan ulang fitur-fitur yang ada. Kamu boleh mengimplementasikan
      GUI hanya untuk sebagian fitur saja (misalnya seleksi antara *output*
      `TEXT`/`TERMINAL`), tetapi nilai sempurna hanya akan diberikan jika tiap
      *query* dapat dilakukan melalui GUI.\
      **Pastikan program asli (tanpa GUI) tetap bekerja sebagaimana mestinya
      dan tetap lulus tes**.

## Penilaian

- 10% Implementasi interface Status dan Concrete Classnya
- 30% Implementasi class Carrier
- 20% implementasi Class InputOutput
- 10% Impelementasi concrete class dari Carrier
- 20% Demostrasi
- 10% Kerapihan dan Dokumentasi
- +10% implementasi bonus

[dokumen tp3]: https://docs.google.com/document/d/1qJxGpnxWUHWyeRbyOXP0rkGheilOUGk8r9jvJxRRbOk/export?format=pdf&attachment=false
[root-readme]: ../README.md#memulai
[input-tc1]: assignment3/testcases/InputTC1.txt
[assignment3]: assignment3
[src-main-java]: assignment3/src/main/java
