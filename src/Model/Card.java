package Model;

import java.io.File;

public class Card {
    
    private String nama;
    private String jenisKelamin;
    private String tanggalLahir;
    private String tanggalPembuatan;
    private String masaBerlaku;
    private String nomorMember;
    private File fotoMember;
    
    public Card() {

    }

    public Card(String nama, String tanggalLahir, String tanggalPembuatan, File fotoMember, String jenisKelamin, String masaBerlaku) {
        this.nama = nama;
        this.tanggalLahir = tanggalLahir;
        this.tanggalPembuatan = tanggalPembuatan;
        this.fotoMember = fotoMember;
        this.jenisKelamin = jenisKelamin;
        this.masaBerlaku = masaBerlaku;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getMasaBerlaku() {
        return masaBerlaku;
    }

    public void setMasaBerlaku(String masaBerlaku) {
        this.masaBerlaku = masaBerlaku;
    }

    public String getNomorMember() {
        return nomorMember;
    }

    public void setNomorMember(String nomorMember) {
        this.nomorMember = nomorMember;
    }

    public File getFotoMember() {
        return fotoMember;
    }

    public void setFotoMember(File fotoMember) {
        this.fotoMember = fotoMember;
    }

    public String getTanggalPembuatan() {
        return tanggalPembuatan;
    }

    public void setTanggalPembuatan(String tanggalPembuatan) {
        this.tanggalPembuatan = tanggalPembuatan;
    }

}
