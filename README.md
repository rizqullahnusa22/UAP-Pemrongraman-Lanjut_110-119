# Manajemen Data Siswa

Aplikasi Manajemen Data Siswa merupakan sebuah Aplikasi berbasis GUI menggunakan Java Swing untuk mengelola data siswa di sebuah sistem manajemen.
Aplikasi ini memiliki fitur kepada pengguna untuk login, menambah, menghapus, memperbarui, dan menampilkan data siswa.
Aplikasi ini bertujuan untuk memanajemen serta mengelola data siswa agar lebih terstrukutur dan jelas


## Fitur Utama

1. **Login**: Pengguna harus memasukkan username dan password untuk mengakses menu utama. Username dan password yang valid adalah `admin` dan `admin123`.

2. **Tambah Siswa**: Menambahkan data siswa baru dengan memasukkan NIS, Nama, Kelas, Tanggal Lahir, dan Status siswa.

3. **Hapus Siswa**: Menghapus data siswa berdasarkan NIS yang dimasukkan oleh pengguna.

4. **Update Siswa**: Memperbarui data siswa berdasarkan NIS yang dimasukkan oleh pengguna.

5. **Tampilkan Data Siswa**: Menampilkan seluruh data siswa dalam bentuk tabel.

6. **Keluar**: Mengeluarkan pengguna dari menu utama dan kembali ke layar login.

## Teknologi yang Digunakan

- **Java**: Bahasa pemrograman utama untuk aplikasi ini.
- **Java Swing**: Untuk membangun antarmuka pengguna berbasis GUI.
- **JDateChooser**: Komponen untuk memilih tanggal lahir siswa.
- **DefaultTableModel**: Untuk menampilkan data siswa dalam bentuk tabel.


## Penggunaan Fitur Aplikasi

### 1. **Menu Login**
- Pengguna diminta untuk memasukkan username dan password.
- Jika login berhasil, pengguna akan diarahkan ke menu utama. Jika gagal, dialog error akan muncul.

### 2. **Menu Utama**
- Terdiri dari beberapa tombol: `Tambah Siswa`, `Hapus Siswa`, `Update Siswa`, `Tampilkan Data Siswa`, dan `Keluar`.
- Setiap tombol akan memicu aksi tertentu seperti menambah, menghapus, atau memperbarui data siswa.

### 3. **Tambah Siswa**
- Akan meminta input data siswa seperti NIS, Nama, Kelas, Tanggal Lahir, dan Status.
- Pastikan NIS hanya berisi angka dan tidak kosong.

### 4. **Update Siswa**
- Meminta NIS siswa yang ingin diupdate.
- Mengizinkan Anda untuk mengubah Nama, Kelas, dan Status siswa.

### 5. **Hapus Siswa**
- Meminta NIS siswa yang ingin dihapus.
- Jika siswa ditemukan, data akan dihapus dari aplikasi.

### 6. **Tampilkan Data Siswa**
- Menampilkan seluruh data siswa dalam bentuk tabel, lengkap dengan nomor urut yang terisi secara otomatis.

### 7. **Keluar**
- Mengonfirmasi keluar dari aplikasi.


## Pemrogram
Aplikasi ini dibuat oleh Mahasiswa Program Studi Informatika Universitas Muhammadiyah Malang
dengan Identitas :

- Rizqullah Atsir Dafa Childyasa Nusa
- Dicky Akbar Syahputra

