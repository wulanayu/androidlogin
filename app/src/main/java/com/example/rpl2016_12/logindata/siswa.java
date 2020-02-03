package com.example.rpl2016_12.logindata;

public class siswa {
    private String id;
    private String Nama;
    private String Buku;
    private String KodePinjam;
    private String Petugas;
    private String Peminjaman;
    private String Pengembalian;

    public siswa(String id, String Nama, String Buku, String KodePinjam, String Petugas,
                 String Peminjaman, String Pengembalian) {
        this.setId(id);
        this.setNama(Nama);
        this.setBuku(Buku);
        this.setKodePinjam(KodePinjam);
        this.setPetugas(Petugas);
        this.setPeminjaman(Peminjaman);
        this.setPengembalian(Pengembalian);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getBuku() {
        return Buku;
    }

    public void setBuku(String buku) {
        Buku = buku;
    }

    public String getKodePinjam() {
        return KodePinjam;
    }

    public void setKodePinjam(String kodePinjam) {
        KodePinjam = kodePinjam;
    }

    public String getPetugas() {
        return Petugas;
    }

    public void setPetugas(String petugas) {
        Petugas = petugas;
    }

    public String getPeminjaman() {
        return Peminjaman;
    }

    public void setPeminjaman(String peminjaman) {
        Peminjaman = peminjaman;
    }

    public String getPengembalian() {
        return Pengembalian;
    }

    public void setPengembalian(String pengembalian) {
        Pengembalian = pengembalian;
    }
}