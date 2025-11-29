package ma.emsi.fetheddine.coursservice.repositories;

import ma.emsi.fetheddine.coursservice.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "students")
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}