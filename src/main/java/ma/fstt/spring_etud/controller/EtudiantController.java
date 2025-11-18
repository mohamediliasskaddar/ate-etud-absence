package ma.fstt.spring_etud.controller;

import ma.fstt.spring_etud.entity.Etudiant;
import ma.fstt.spring_etud.service.EtudiantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/etudiants")
@RequiredArgsConstructor
public class EtudiantController {

    private final EtudiantService service;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("etudiants", service.findAll());
        return "etudiant/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("etudiant", new Etudiant());
        return "etudiant/form";
    }

    @PostMapping
    public String save(@ModelAttribute Etudiant etudiant) {
        service.save(etudiant);
        return "redirect:/etudiants";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("etudiant", service.findById(id));
        return "etudiant/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/etudiants";
    }
}