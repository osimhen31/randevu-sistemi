package com.randevu.randevusistemi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

@Controller
@RequestMapping("/randevular")
public class RandevuController {

    @Autowired
    private RandevuRepository randevuRepository;

    // FORM SAYFASINI AÇ
    @GetMapping("/form")
    public String formGoster(Model model) {
        model.addAttribute("randevu", new Randevu()); // Form için boş nesne
        model.addAttribute("mesaj", null); // Mesaj başlangıçta boş
        return "randevu-form";
    }

    // FORM GÖNDERİLDİĞİNDE VERİYİ AL VE KAYDET (VALIDATION'LI)
    @PostMapping("/kaydet")
    public String kaydet(@Valid @ModelAttribute Randevu randevu,
                         BindingResult result,
                         Model model) {

        if (result.hasErrors()) {
            model.addAttribute("mesaj", "❗Lütfen tüm alanları doldurun.");
            return "randevu-form";
        }

        randevuRepository.save(randevu);
        model.addAttribute("mesaj", "✅ Randevu başarıyla kaydedildi.");
        return "randevu-form";
    }

    // TÜM RANDEVULARI LİSTELE
    @GetMapping("/liste")
    public String randevuListesi(Model model) {
        model.addAttribute("randevular", randevuRepository.findAll());
        return "randevu-liste";
    }

    // RANDEVU SİL
    @GetMapping("/sil/{id}")
    public String randevuSil(@PathVariable Long id) {
        randevuRepository.deleteById(id);
        return "redirect:/randevular/liste";
    }

    // RANDEVU DÜZENLEME SAYFASINI AÇ
    @GetMapping("/duzenle/{id}")
    public String randevuDuzenle(@PathVariable Long id, Model model) {
        Randevu randevu = randevuRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Geçersiz ID: " + id));
        model.addAttribute("randevu", randevu);
        return "randevu-duzenle";
    }

    // RANDEVUYU GÜNCELLE
    @PostMapping("/guncelle")
    public String randevuGuncelle(@ModelAttribute Randevu randevu) {
        randevuRepository.save(randevu);
        return "redirect:/randevular/liste";
    }
}