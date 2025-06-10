package com.randevu.randevusistemi;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "randevu")
public class Randevu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Ad Soyad boş bırakılamaz")
    private String adSoyad;

    @NotBlank(message = "Tarih boş bırakılamaz")
    private String tarih;

    @NotBlank(message = "Saat boş bırakılamaz")
    private String saat;

    @NotBlank(message = "Açıklama boş bırakılamaz")
    private String aciklama;

    public Randevu() {
    }

    public Randevu(String adSoyad, String tarih, String saat, String aciklama) {
        this.adSoyad = adSoyad;
        this.tarih = tarih;
        this.saat = saat;
        this.aciklama = aciklama;
    }

    public Long getId() {
        return id;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getSaat() {
        return saat;
    }

    public void setSaat(String saat) {
        this.saat = saat;
    }

    public String getAciklama() {
        return aciklama;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }
}