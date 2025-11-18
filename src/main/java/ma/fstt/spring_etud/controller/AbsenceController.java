package ma.fstt.spring_etud.controller;

import lombok.Builder;
import lombok.Data;
import ma.fstt.spring_etud.entity.Absence;
import ma.fstt.spring_etud.service.AbsenceService;
import ma.fstt.spring_etud.service.EtudiantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/absences")
@RequiredArgsConstructor
@Data @Builder
public class AbsenceController {

    private final AbsenceService absenceService;
    private final EtudiantService etudiantService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("absences", absenceService.findAll());
        return "absence/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("absence", new Absence());
        model.addAttribute("etudiants", etudiantService.findAll());
        return "absence/form";
    }

    @PostMapping
    public String save(@ModelAttribute Absence absence) {
        absenceService.save(absence);
        return "redirect:/absences";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("absence", absenceService.findById(id));
        model.addAttribute("etudiants", etudiantService.findAll());
        return "absence/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        absenceService.deleteById(id);
        return "redirect:/absences";
    }

    // Bonus : voir les absences d'un étudiant
    @GetMapping("/etudiant/{etudiantId}")
    public String parEtudiant(@PathVariable Long etudiantId, Model model) {
        model.addAttribute("absences", absenceService.findByEtudiantId(etudiantId));
        model.addAttribute("etudiant", etudiantService.findById(etudiantId));
        return "absence/par-etudiant";
    }
}