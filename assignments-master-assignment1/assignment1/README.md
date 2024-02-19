# Tugas Pemrograman 1: Kode-Kode Privab

CSGE601021 Dasar-Dasar Pemrograman 2 @ Fakultas Ilmu Komputer Universitas Indonesia,
Semester Genap 2019/2020

Dokumen ini berisi deskripsi dan informasi umum yang dibutuhkan untuk menyelesaikan
Tugas Pemrograman 1 mata kuliah DDP 2. Tugas Pemrograman ini didesain untuk
mengimplementasikan algoritme yang diterapkan pada [Hamming Code][hamming code].

Tugas Pemrograman ini mencakup materi berikut:

- Pemrosesan I/O dasar (memproses *standard input* dan *standard output*)
- Percabangan dan perulangan
- *Methods*
- Manipulasi *string*

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

Silakan baca [dokumen soal][dokumen tp1].

## Persiapan

Silakan ikuti persiapan yang ada pada berkas [`README.md`][root-readme] di
*root* repositori ini.

## Menjalankan dan menguji program

> Catatan: ubah `gradlew.bat` dengan `./gradlew` dan `\` dengan `/` jika kamu
> menggunakan Linux/Mac.

Kamu bisa menjalankan beberapa *task* dengan Gradle melalui IDE atau
terminal/Command Prompt.

Untuk menjalankan program:

```bash
> gradlew.bat :assignment1:run --console plain
```

Untuk menguji program dengan *test case* yang disediakan:

```bash
> gradlew.bat :assignment1:test
```

(Bonus) Untuk memeriksa kode kamu terhadap aturan Checkstyle yang diterapkan:

```bash
> gradlew.bat :assignment1:checkstyleMain
```

> Tips: kamu bisa memeriksa hasil tes dalam bentuk dokumen HTML. Lihat dokumen
> HTML tersebut di dalam folder `build\reports` yang ada di direktori ini.

Jika kamu tidak ingin menggunakan Gradle, kamu juga bisa melakukan kompilasi
dan menjalankan program dengan `javac` dan `java` seperti biasa. Masuk ke
direktori `src\main\java`, *compile* semua berkas `.java` kamu, dan jalankan
*main class*-nya.

```bash
> cd src\main\java
src\main\java> javac assignments\assignment1\*.java
src\main\java> java assignments.assignment1.HammingCode
```

Kamu juga bisa memeriksa kebenaran program kamu dengan membandingkan nilai
*return* dari *method* `encode` dan `decode` dengan nilai *return* yang
diharapkan. Terdapat beberapa *test case* yang bisa kamu lihat di dalam
berkas `src\test\java\assignments\assignment1\HammingCodeTest.java`.

Kode seperti berikut:

```java
assertEquals(HammingCode.encode("10011010"), "011100101010");
```

artinya jika *method* `encode` kamu dipanggil dengan argumen `""10011010"`,
maka ia harus mengembalikan nilai yang setara dengan `"011100101010"`.

## Pengumpulan

Simpan pekerjaan kamu, lalu lakukan `git add`, `git commit`, dan `git push`
sebagaimana dijelaskan pada dokumen
[Getting Started with a Java Project][getting-started].
*Push* solusi kamu **sebelum 24 Februari 2020 pukul 23.55**. Disarankan untuk
*push* **sebelum pukul 22.00** untuk mengantisipasi antrean pada GitLab
Pipelines.

Jangan lupa untuk menambahkan asdos kamu sebagai *member* di repositori kamu.
Tim pengajar hanya akan menilai pekerjaan kamu berdasarkan ***commit* terbaru**
yang **sudah di-*push* sebelum waktu dan tanggal yang ditentukan**. *Commit*
tersebut diidentifikasi dengan memeriksa GitLab Pipelines.

> Catatan: *timestamp* pada GitLab Pipelines tidak pernah bohong.
> *So, no funny business, please :)*

## Daftar pekerjaan

### Daftar pekerjaan wajib

- [ ] Buat sekurang-kurangnya 1 *commit* yang mengandung progres kamu dalam
      mengerjakan Tugas Pemrograman 1.
- [ ] *Push* *commit* kamu ke repositori Git *online* yang ada pada proyek
      GitLab kamu.
- [ ] Implementasikan method `encode` dengan benar.
- [ ] Implementasikan method `decode` dengan benar.
- [ ] Demonstrasikan program kamu ke asdos kamu.

### Daftar pekerjaan bonus (opsional)

<sup><sub>Yeey, ada bonus!</sub></sup>

- [ ] Pastikan kode kamu sesuai dengan aturan Checkstyle yang diterapkan.
      Aturan tersebut dibuat berdasarkan
      [Google Java Style Guide][google-styleguide] yang telah diadaptasi
      agar menggunakan indentasi 4 spasi (bukan 2 spasi).

## Penilaian

- 60% kebenaran program
- 30% demonstransi program
- 10% kerapian dan dokumentasi
- +5% kesesuaian kode dengan aturan Checkstyle yang diberikan (bonus)

[hamming code]: https://en.wikipedia.org/wiki/Hamming_code
[dokumen tp1]: https://docs.google.com/document/d/1rNEholraIZV_e9hJGXlUVYwhZSctVJGV3JjPZsdB7HU/export?format=pdf&attachment=false
[root-readme]: ../README.md#memulai
[getting-started]: https://docs.google.com/document/d/1_HswwjG9qoUL1hHoQu0McqXYkYdRtT0d-nZA7yCYLpc/export?format=pdf&attachment=false
[google-styleguide]: https://google.github.io/styleguide/javaguide.html
