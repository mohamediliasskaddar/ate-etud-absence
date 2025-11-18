package ma.fstt.spring_etud.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "etudiants")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    private String cne;         // optionnel
    private String filiere;

    // Une relation OneToMany vers Absence (facultatif mais pratique)
    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Absence> absences = new ArrayList<>();
}