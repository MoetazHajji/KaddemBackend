package tn.esprit.firstproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Contrat;
import tn.esprit.firstproject.entities.Etudiant;
import tn.esprit.firstproject.services.IContratServices;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/contrat")
public class ContratRestController {

    IContratServices iContratServices;


    @Autowired
    public ContratRestController(IContratServices iContratServices) {
        this.iContratServices = iContratServices;
    }

    @GetMapping("/all")
    public List<Contrat> getAllContrats() {
        return iContratServices.retrieveAllContrats();
    }

    @PutMapping("/update")
    public Contrat updateContrat(@RequestBody Contrat c) {
        return iContratServices.updateContrat(c);
    }

    @PostMapping("/add")
    public Contrat addContrat(@RequestBody Contrat c) {
        return iContratServices.addContrat(c);
    }

    @GetMapping("get/{id}")
    public Contrat getContrat(@PathVariable("id") Integer idContrat)
    {
        return iContratServices.retrieveContrat(idContrat);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteContrat(@PathVariable("id") Integer idContrat)
    {
        iContratServices.removeContrat(idContrat);
    }

    @PutMapping("/assignCntToEt/{idCon}/{idEt}")
    public Contrat assignCntToEt(@PathVariable("idCon") Integer idCon,@PathVariable("idEt") Integer idEt){
        return iContratServices.assignContratToEt(idCon,idEt);
    }

    @PutMapping("/affectConToEtu/{nom}/{prenom}")
    public Contrat affectConToEtu(@RequestBody Contrat ce ,@PathVariable("nom") String nom,@PathVariable("prenom") String prenom){
        return iContratServices.affectContratToEtudiant(ce,nom,prenom);
    }

    @GetMapping("/getChiffreAffaire/{dateDebut}/{dateFin}")
    public float getChiffreAffaireEntreDeuxDate(@PathVariable("dateDebut") Date startDate,@PathVariable("dateFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return iContratServices.getChiffreAffaireEntreDeuxDate(startDate,endDate);
    }

    @PostMapping("/addAndAssign/{idE}/{idC}")
    public Etudiant affecteratudiantcontratequipe(@PathVariable("idE") Integer idE, @PathVariable("idC") Integer idC, @RequestBody Etudiant e){
        return iContratServices.addAndAssignEtudiantToEquipeAndContract(e,idC,idE);
    }

    @GetMapping("/countByStartDate/{d1}/{d2}")
    public Integer countByArchiveIsFalseAndDateDebutContratBetween(@PathVariable("d1") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                                   @PathVariable("d2") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return iContratServices.countByArchiveIsFalseAndDateDebutContratBetween(startDate,endDate);
    }
}