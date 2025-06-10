package com.randevu.randevusistemi;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RandevuRepository extends JpaRepository<Randevu, Long> {

    // Ad Soyad içinde geçenleri büyük/küçük harfe duyarsız olarak ara
    List<Randevu> findByAdSoyadContainingIgnoreCase(String keyword);
}