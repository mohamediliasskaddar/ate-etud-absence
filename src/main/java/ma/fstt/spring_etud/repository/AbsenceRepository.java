package ma.fstt.spring_etud.repository;

import ma.fstt.spring_etud.entity.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface AbsenceRepository extends JpaRepository<Absence, Long> {
    List<Absence> findByEtudiantId(Long etudiantId);
    List<Absence> findByDateAbsenceBetween(LocalDate debut, LocalDate fin);
}