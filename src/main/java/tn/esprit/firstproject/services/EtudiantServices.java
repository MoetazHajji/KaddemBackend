package tn.esprit.firstproject.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.*;
import tn.esprit.firstproject.repositories.IContratRepository;
import tn.esprit.firstproject.repositories.IDepartementRepository;
import tn.esprit.firstproject.repositories.IEquipeRepository;
import tn.esprit.firstproject.repositories.IEtudiantRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
@Slf4j
public class EtudiantServices implements IEtudiantServices {

    IEtudiantRepository iEtudiantRepository;
    IDepartementRepository iDepartementRepository;
    IEquipeRepository iEquipeRepository;

    IContratRepository iContratRepository;

    @Override
    public List<Etudiant> retreiveByOption(Option option) {
        return iEtudiantRepository.findByOp(option);
    }

    @Override
    public List<Etudiant> retreiveByDepartement(Integer idDepartement){
        return iEtudiantRepository.findByDepartement_IdDepart(idDepartement);
    }

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        List<Etudiant> etudiantList = new ArrayList<>();
        iEtudiantRepository.findAll().forEach(etudiantList::add);
        return etudiantList;
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return iEtudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return iEtudiantRepository.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Integer idEtudiant) {
        return iEtudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public void removeEtudiant(Integer idEtudiant) {
         iEtudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public Etudiant asignDepToEt(Integer idEt, Integer idDep) {
        Etudiant e= iEtudiantRepository.findById(idEt).orElse(null);
        Departement d = iDepartementRepository.findById(idDep).orElse(null);
                e.setDepartement(d);
       return iEtudiantRepository.save(e);
    }

    @Override
    public Etudiant asignEtudiantToDepartement(Etudiant etudiant) {
        return iEtudiantRepository.save(etudiant);
    }

    @Override
    public Etudiant asignEtToEq(Integer idEt, Integer idEq) {
        Etudiant e= iEtudiantRepository.findById(idEt).orElse(null);
        Equipe eq= iEquipeRepository.findById(idEq).orElse(null);
        if (e.getEquipes()==null){
            Set<Equipe> equipes = new HashSet<Equipe>();
            equipes.add(eq);
            e.setEquipes(equipes);
        }else{
        e.getEquipes().add(eq);
        }
        return iEtudiantRepository.save(e);
    }

    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
        e = iEtudiantRepository.save(e);

        Contrat contrat = iContratRepository.findById(idContrat).orElse(null);
        Equipe equipe= iEquipeRepository.findById(idEquipe).orElse(null);

        contrat.setEtudiant(e);
        iContratRepository.save(contrat);
        if (e.getEquipes()==null){
            Set<Equipe> equipes = new HashSet<Equipe>();
            equipes.add(equipe);
            e.setEquipes(equipes);
        }else{
            e.getEquipes().add(equipe);
        }
        return e;
    }

    //@Scheduled(cron = "*/15 * * * * *")
    /*public void hello(){
        log.debug("message DEBUG");
        log.info("message INFO");
        log.error("message ERROR");
        log.warn("message WARN");
    }*/


}
