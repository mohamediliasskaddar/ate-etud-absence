package ma.fstt.spring_etud.service;

import ma.fstt.spring_etud.entity.Absence;
import ma.fstt.spring_etud.entity.Etudiant;
import ma.fstt.spring_etud.repository.AbsenceRepository;
import ma.fstt.spring_etud.repository.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AbsenceService {

    private final AbsenceRepository absenceRepo;
    private final EtudiantRepository etudiantRepo;

    public List<Absence> findAll() { return absenceRepo.findAll(); }
    public List<Absence> findByEtudiantId(Long etudiantId) { return absenceRepo.findByEtudiantId(etudiantId); }
    public Absence findById(Long id) { return absenceRepo.findById(id).orElseThrow(); }

    public Absence save(Absence absence) {
        // On s'assure que l'étudiant existe
        Etudiant etudiant = etudiantRepo.findById(absence.getEtudiant().getId())
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));
        absence.setEtudiant(etudiant);
        return absenceRepo.save(absence);
    }

    public void deleteById(Long id) { absenceRepo.deleteById(id); }
}