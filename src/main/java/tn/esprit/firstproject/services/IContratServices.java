package tn.esprit.firstproject.services;

import tn.esprit.firstproject.entities.Contrat;
import tn.esprit.firstproject.entities.Etudiant;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IContratServices {

    List<Contrat> retrieveAllContrats();

    Contrat updateContrat (Contrat ce);

    Contrat addContrat (Contrat ce);

    Contrat retrieveContrat (Integer idContrat);

    void removeContrat(Integer idContrat);

    Contrat assignContratToEt(Integer idContrat ,Integer idEt);

    Contrat affectContratToEtudiant (Contrat ce, String nomE ,String prenomE);

    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);
    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe);

    String retrieveAndUpdateStatusContrat();

    Integer countByArchiveIsFalseAndDateDebutContratBetween(Date startDate , Date endDate);

    Integer countByArchiveIsFalseAndEtudiant_NomEAndEtudiant_PrenomE(String nom ,String prenom);
}
