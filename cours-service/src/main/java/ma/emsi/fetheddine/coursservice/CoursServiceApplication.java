package ma.emsi.fetheddine.coursservice;

import ma.emsi.fetheddine.coursservice.model.Cours;
import ma.emsi.fetheddine.coursservice.model.Etudiant;
import ma.emsi.fetheddine.coursservice.model.Professeur;
import ma.emsi.fetheddine.coursservice.repositories.CoursRepository;
import ma.emsi.fetheddine.coursservice.repositories.EtudiantRepository;
import ma.emsi.fetheddine.coursservice.repositories.ProfesseurRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CoursServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoursServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CoursRepository coursRepository,
                            EtudiantRepository etudiantRepository,
                            ProfesseurRepository professeurRepository) {
        return args -> {
            // Create Professeur
            Professeur prof = new Professeur(null, "John Doe", "john.doe@emsi.ma");
            professeurRepository.save(prof);
            System.out.println("Saved Professeur with ID: " + prof.getId());

            // Create Etudiants
            Etudiant etudiant1 = new Etudiant(null, "Alice Smith", "alice.smith@emsi.ma", null);
            Etudiant etudiant2 = new Etudiant(null, "Bob Johnson", "bob.johnson@emsi.ma", null);
            etudiantRepository.save(etudiant1);
            etudiantRepository.save(etudiant2);
            System.out.println("Saved Etudiant with ID: " + etudiant1.getId());
            System.out.println("Saved Etudiant with ID: " + etudiant2.getId());

            // Create Cours
            Cours cours = new Cours(null, "Introduction to Spring Boot", "A comprehensive course on Spring Boot", prof, List.of(etudiant1, etudiant2));
            coursRepository.save(cours);
            System.out.println("Saved Cours with ID: " + cours.getId());
        };
    }
}
