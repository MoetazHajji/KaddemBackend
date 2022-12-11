package tn.esprit.firstproject.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Contrat;
import tn.esprit.firstproject.entities.Departement;
import tn.esprit.firstproject.entities.Etudiant;
import tn.esprit.firstproject.entities.Option;
import tn.esprit.firstproject.services.IEtudiantServices;

import java.util.List;

@Tag(name="Student Mangement")
@RestController
@RequestMapping("/etudiant")
public class EtudiantRestController {

   IEtudiantServices iEtudiantServices;


   @Autowired
    public EtudiantRestController(IEtudiantServices iEtudiantServices) {
        this.iEtudiantServices = iEtudiantServices;
    }

    @Operation(description = "Retreive all students")
    @GetMapping("/all")
    public List<Etudiant> getAllEtudiant() {
        return iEtudiantServices.retrieveAllEtudiants();
    }

    @Operation(description = "Update Student")
    @PutMapping("/update")
    public Etudiant updateEtudiant(@RequestBody Etudiant e) {
        return iEtudiantServices.updateEtudiant(e);
    }

    @Operation(description = "Add Student")
    @PostMapping("/add")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        return iEtudiantServices.addEtudiant(e);
    }

    @Operation(description = "Get student byId")
    @GetMapping("get/{id}")
    public Etudiant getEtudiant(@PathVariable("id") Integer idEtudiant) {
        return iEtudiantServices.retrieveEtudiant(idEtudiant);
    }

    @Operation(description = "Delete Student")
    @DeleteMapping("/delete/{id}")
    public void deleteEtudiant(@PathVariable("id") Integer idContrat)
    {
        iEtudiantServices.removeEtudiant(idContrat);
    }

    @Operation(description = "Assign Students to department")
    @PutMapping("assign/{idEt}/{idDep}")
    public Etudiant asignDepToEt(@PathVariable("idEt")Integer idEt,@PathVariable("idDep") Integer idDep){
       return  iEtudiantServices.asignDepToEt(idEt,idDep);
   }

    @Operation(description = "Assign Student To team ")
    @PutMapping("assignEtToEq/{idEt}/{idEq}")
    public Etudiant asignEtuToEqq(@PathVariable("idEt")Integer idEt,@PathVariable("idEq") Integer idEq){
       return iEtudiantServices.asignEtToEq(idEt, idEq);
    }

    @PostMapping("/addAndAssign")
    public Etudiant addAndAssign(Etudiant etudiant){
       return iEtudiantServices.asignEtudiantToDepartement(etudiant);
    }

    @GetMapping("/getByOption/{opt}")
    public List<Etudiant> getStudents(@PathVariable("opt") Option option){
       return  iEtudiantServices.retreiveByOption(option);
    }

    @GetMapping("/retreiveEtByDep/{idDep}")
    public List<Etudiant> retreiveEtudiantsByDepartmet(@PathVariable("idDep") Integer idDepartement){
       return iEtudiantServices.retreiveByDepartement(idDepartement);
    }

    @PostMapping("/addAndAssign/{idE}/{idC}")
    public Etudiant affecteratudiantcontratequipe(@PathVariable("idE") Integer idE,@PathVariable("idC") Integer idC,@RequestBody Etudiant e){
       return iEtudiantServices.addAndAssignEtudiantToEquipeAndContract(e,idC,idE);
    }
}
