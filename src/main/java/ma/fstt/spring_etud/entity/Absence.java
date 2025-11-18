package ma.fstt.spring_etud.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "absences")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate dateAbsence;

    private String matiere;
    private Integer nbrHeures;

    private boolean justifiee = false;

    // Relation ManyToOne vers Etudiant (obligatoire ici)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "etudiant_id", nullable = false)
    private Etudiant etudiant;
}