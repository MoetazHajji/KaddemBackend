package tn.esprit.firstproject.services;

import tn.esprit.firstproject.entities.DetailEquipe;

import java.util.List;

public interface IDetailEquipeService {

    List<DetailEquipe> retrieveAllDE();

    DetailEquipe updateDE (DetailEquipe de);

    DetailEquipe addDE (DetailEquipe de);

    DetailEquipe retrieveDE (Integer idDE);

    void removeDE(Integer idDE);

    DetailEquipe assignEquipeToDetailEquipe(Integer idDe , Integer idEq);
}
