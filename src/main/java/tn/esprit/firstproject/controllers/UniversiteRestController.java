package tn.esprit.firstproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.Departement;
import tn.esprit.firstproject.entities.Equipe;
import tn.esprit.firstproject.entities.Universite;
import tn.esprit.firstproject.services.IUniversiteServices;

import java.util.List;

@RestController
@RequestMapping("/universite")
public class UniversiteRestController {

    IUniversiteServices iUniversiteServices;

    @Autowired
    public UniversiteRestController(IUniversiteServices iUniversiteServices) {
        this.iUniversiteServices = iUniversiteServices;
    }

    @GetMapping("/all")
    public List<Universite> getAllUniversite() {
        return iUniversiteServices.retrieveAllUniversites();
    }

    @PutMapping("/update")
    public Universite updateUniversite(@RequestBody Universite u) {
        return iUniversiteServices.updateUniversite(u);
    }

    @PostMapping("/add")
    public Universite addUniversite(@RequestBody Universite u) {
        return iUniversiteServices.addUniversite(u);
    }

    @GetMapping("get/{id}")
    public Universite getUniversite(@PathVariable("id") Integer idUniversite)
    {
        return iUniversiteServices.retrieveUniversite(idUniversite);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUniversity(@PathVariable("id") Integer id){
        iUniversiteServices.deleteUniversity(id);
    }

    @PutMapping("/assignUnToDep/{idDepart}/{idUn}")
    public Universite assignUnToDep(@PathVariable("idDepart") Integer idDepart , @PathVariable("idUn") Integer idUn ){
        return iUniversiteServices.assignUnToDep(idDepart,idUn);
    }
}
