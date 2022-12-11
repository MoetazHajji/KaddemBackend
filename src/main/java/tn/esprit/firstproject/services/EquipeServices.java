package tn.esprit.firstproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.DetailEquipe;
import tn.esprit.firstproject.entities.Equipe;
import tn.esprit.firstproject.entities.Etudiant;
import tn.esprit.firstproject.repositories.IDetailEquipeRepository;
import tn.esprit.firstproject.repositories.IEquipeRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class EquipeServices implements IEquipeServices {

    IEquipeRepository iEquipeRepository;
    IDetailEquipeRepository iDetailEquipeRepository;


    @Override
    public List<Equipe> retrieveAllEquipes() {
        List<Equipe> equipeList = new ArrayList<>();
        iEquipeRepository.findAll().forEach(equipeList::add);
        return equipeList;
    }

    @Override
    public Equipe addEquipe(Equipe e) {
        return iEquipeRepository.save(e);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {
        return addEquipe(e);
    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return iEquipeRepository.findById(idEquipe).orElse(null);
    }

    @Override
    public Equipe addEquipeAndAsign(Equipe equipe) {
        DetailEquipe detailEquipe = equipe.getDetailEquipe();
        detailEquipe.setEquipe(equipe);
        iDetailEquipeRepository.save(detailEquipe);

        for (Etudiant etudiant:equipe.getEtudiants()){
            if (etudiant.getEquipes()==null){
                Set<Equipe> equipes = new HashSet<>();
                equipes.add(equipe);
                etudiant.setEquipes(equipes);
            }
            else {
                etudiant.getEquipes().add(equipe);
            }
            iEquipeRepository.save(equipe);
        }
        return equipe;
    }
}
