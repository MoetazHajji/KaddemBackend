package tn.esprit.firstproject.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.firstproject.entities.Contrat;

import java.time.LocalDate;
import java.util.Date;

public interface IContratRepository extends CrudRepository<Contrat,Integer> {
    Integer countByArchiveIsFalseAndDateDebutContratBetween(Date startDate , Date endDate);

    Integer countByArchiveIsFalseAndEtudiant_NomEAndEtudiant_PrenomE(String nom ,String prenom);

}
