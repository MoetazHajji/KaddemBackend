package tn.esprit.firstproject.services;

import tn.esprit.firstproject.entities.Departement;
import tn.esprit.firstproject.entities.Etudiant;
import tn.esprit.firstproject.entities.Option;

import java.util.List;

public interface IEtudiantServices {

    List<Etudiant> retreiveByOption(Option option);
    List<Etudiant> retreiveByDepartement(Integer idDepartement);

    List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiant (Etudiant e);

    Etudiant updateEtudiant (Etudiant e);

    Etudiant retrieveEtudiant(Integer idEtudiant);

    void removeEtudiant(Integer idEtudiant);

    Etudiant asignDepToEt(Integer idEt,Integer idDep);

    Etudiant asignEtudiantToDepartement(Etudiant etudiant);

    Etudiant asignEtToEq(Integer idEt,Integer idEq);

    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe);
}
