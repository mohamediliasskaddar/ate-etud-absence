package ma.fstt.spring_etud.service;

import ma.fstt.spring_etud.entity.Etudiant;
import ma.fstt.spring_etud.repository.EtudiantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EtudiantService {

    private final EtudiantRepository repository;

    public List<Etudiant> findAll() { return repository.findAll(); }
    public Etudiant findById(Long id) { return repository.findById(id).orElseThrow(); }
    public Etudiant save(Etudiant e) { return repository.save(e); }
    public void deleteById(Long id) { repository.deleteById(id); }
}