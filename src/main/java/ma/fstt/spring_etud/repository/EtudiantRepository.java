package ma.fstt.spring_etud.repository;

import ma.fstt.spring_etud.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}