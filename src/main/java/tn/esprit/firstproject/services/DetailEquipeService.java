package tn.esprit.firstproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.DetailEquipe;
import tn.esprit.firstproject.entities.Equipe;
import tn.esprit.firstproject.repositories.IDetailEquipeRepository;
import tn.esprit.firstproject.repositories.IEquipeRepository;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class DetailEquipeService implements IDetailEquipeService{
    IDetailEquipeRepository detailEquipeRepository;

    IEquipeRepository iEquipeRepository;


    @Override
    public List<DetailEquipe> retrieveAllDE() {
        List<DetailEquipe> equipes = new ArrayList<>();
        detailEquipeRepository.findAll().forEach(equipes::add);
        return equipes;
    }

    @Override
    public DetailEquipe updateDE(DetailEquipe de) {
        return detailEquipeRepository.save(de);
    }

    @Override
    public DetailEquipe addDE(DetailEquipe de) {
        return detailEquipeRepository.save(de);
    }

    @Override
    public DetailEquipe retrieveDE(Integer idDE) {
        return detailEquipeRepository.findById(idDE).orElse(null);
    }

    @Override
    public void removeDE(Integer idDE) {
        detailEquipeRepository.deleteById(idDE);
    }

    @Override
    public DetailEquipe assignEquipeToDetailEquipe(Integer idDe , Integer idEq) {
        DetailEquipe detailEquipe = detailEquipeRepository.findById(idDe).orElse(null);
        Equipe equipe = iEquipeRepository.findById(idEq).orElse(null);
        detailEquipe.setEquipe(equipe);
        return detailEquipeRepository.save(detailEquipe);
    }


}
