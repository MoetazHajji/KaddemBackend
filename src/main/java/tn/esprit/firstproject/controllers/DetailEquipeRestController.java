package tn.esprit.firstproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.firstproject.entities.DetailEquipe;
import tn.esprit.firstproject.services.IDetailEquipeService;

import java.util.List;

@RestController
@RequestMapping("/detailequipe")
public class DetailEquipeRestController {
    IDetailEquipeService detailEquipeService;

    @Autowired
    public DetailEquipeRestController(IDetailEquipeService detailEquipeService) {
        this.detailEquipeService = detailEquipeService;
    }

    @GetMapping("/all")
    public List<DetailEquipe> getAllDE(){
        return  detailEquipeService.retrieveAllDE();
    }

    @PutMapping("/update")
    public DetailEquipe updateDE(@RequestBody DetailEquipe detailEquipe){
        return detailEquipeService.updateDE(detailEquipe);
    }

    @PostMapping("/add")
    public DetailEquipe addDE(@RequestBody DetailEquipe detailEquipe){
        return detailEquipeService.addDE(detailEquipe);
    }

    @GetMapping("get/{idDe}")
    public DetailEquipe getDEbyId(@PathVariable("idDe") Integer idDe){
        return detailEquipeService.retrieveDE(idDe);
    }

    @DeleteMapping("/delete/{idDe}")
    public void deleteDe(@PathVariable("idDe") Integer idDe){
        detailEquipeService.removeDE(idDe);
    }

    @PutMapping("/AddDeAndAssignEquipe/{idDe}/{idEq}")
    public  DetailEquipe AddDeAndAssignEquipe(@PathVariable("idDe") Integer idDe ,@PathVariable("idEq") Integer idEq){
        return detailEquipeService.assignEquipeToDetailEquipe(idDe,idEq);
    }
}
