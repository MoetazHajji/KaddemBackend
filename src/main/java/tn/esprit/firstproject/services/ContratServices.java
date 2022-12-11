package tn.esprit.firstproject.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Contrat;
import tn.esprit.firstproject.entities.Equipe;
import tn.esprit.firstproject.entities.Etudiant;
import tn.esprit.firstproject.entities.Specialite;
import tn.esprit.firstproject.repositories.IContratRepository;
import tn.esprit.firstproject.repositories.IEquipeRepository;
import tn.esprit.firstproject.repositories.IEtudiantRepository;

import javax.transaction.Transactional;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.*;

@AllArgsConstructor
@Service
@Slf4j
public class ContratServices implements IContratServices {

    IContratRepository iContratRepository;

    IEtudiantRepository iEtudiantRepository;

    IEquipeRepository iEquipeRepository;

    @Override
    public List<Contrat> retrieveAllContrats() {
        List<Contrat> contratList = new ArrayList<>();
        iContratRepository.findAll().forEach(contratList::add);
        return contratList;
    }

    @Override
    public Contrat updateContrat(Contrat ce) {
        return iContratRepository.save(ce);
    }

    @Override
    public Contrat addContrat(Contrat ce) {
        return iContratRepository.save(ce);
    }

    @Override
    public Contrat retrieveContrat(Integer idContrat) {
        return iContratRepository.findById(idContrat).orElse(null);
    }

    @Override
    public void removeContrat(Integer idContrat) {
        iContratRepository.deleteById(idContrat);
    }

    @Override
    public Contrat assignContratToEt(Integer idContrat, Integer idEt) {
        Etudiant e = iEtudiantRepository.findById(idEt).orElse(null);
        Contrat c= iContratRepository.findById(idContrat).orElse(null);
        c.setEtudiant(e);
        return iContratRepository.save(c);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
        Etudiant e = iEtudiantRepository.findEtudiantsByNomEAndPrenomE(nomE,prenomE);
        ce.setEtudiant(e);
        iContratRepository.save(ce);
        return ce;
    }

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        List<Contrat> contrats = new ArrayList<>();
        contrats = (List<Contrat>) iContratRepository.findAll();
        int monthes=((endDate.getYear()-startDate.getYear())*12)+(endDate.getMonth()-startDate.getMonth())+((endDate.getDay()-startDate.getDay())/30);
        for (Specialite specialite:Specialite.values()){
            if(specialite.toString().equals("IA")){
                float prixIa=contrats.stream().filter(e -> e.getSpecialite().toString().equals(Specialite.IA) && e.getArchive()==false
                        && e.getDateDebutContrat().equals(startDate) && e.getDateFinContract().equals(endDate)).count();
                return prixIa*300*monthes;
            }
            if (specialite.toString().equals("RESEAUX")){
                float prixReseaux=contrats.stream().filter(e->e.getSpecialite().toString().equals(Specialite.RESEAUX) && e.getArchive()==false
                && e.getDateDebutContrat().equals(startDate) && e.getDateFinContract().equals(endDate)).count();
                return prixReseaux*350*monthes;
            }
            if(specialite.toString().equals("CLOUD")){
                float prixCloud=contrats.stream().filter(e->e.getSpecialite().toString().equals(Specialite.CLOUD) && e.getArchive()==false
                        && e.getDateDebutContrat().equals(startDate) && e.getDateFinContract().equals(endDate)).count();
                return prixCloud*400*monthes;
            }
            if(specialite.toString().equals("SECURITE")){
                float prixSecurite=contrats.stream().filter(e->e.getSpecialite().toString().equals(Specialite.SECURITE) && e.getArchive()==false
                        && e.getDateDebutContrat().equals(startDate) && e.getDateFinContract().equals(endDate)).count();
                return prixSecurite*400*monthes;
            }
        }
        return 0;
    }
    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
        Set<Contrat> contrats= new HashSet<>();
        Contrat contrat = iContratRepository.findById(idContrat).orElse(null);
        Equipe equipe= iEquipeRepository.findById(idEquipe).orElse(null);
        if (e.getEquipes()==null){
            Set<Equipe> equipes = new HashSet<Equipe>();
            equipes.add(equipe);
            e.setEquipes(equipes);
        }else{
            e.getEquipes().add(equipe);
        }
        contrats.add(contrat);
        contrat.setEtudiant(e);
        iEtudiantRepository.save(e);
        return e;
    }

    @Scheduled(cron = "* * * * * *")
    @Override
    @Transactional // yassuri le deroulement du fonction
    public String retrieveAndUpdateStatusContrat() {
        Contrat c = new Contrat();
        c.getDateFinContract();

        log.warn("");
        return null;
    }

    @Override
    public Integer countByArchiveIsFalseAndDateDebutContratBetween(Date startDate, Date endDate) {
        return iContratRepository.countByArchiveIsFalseAndDateDebutContratBetween(startDate,endDate);
    }

    @Override
    public Integer countByArchiveIsFalseAndEtudiant_NomEAndEtudiant_PrenomE(String nom, String prenom) {
        return iContratRepository.countByArchiveIsFalseAndEtudiant_NomEAndEtudiant_PrenomE(nom,prenom);
    }


}
