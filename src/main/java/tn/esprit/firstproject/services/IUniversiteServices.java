package tn.esprit.firstproject.services;

import tn.esprit.firstproject.entities.Universite;

import java.util.List;

public interface IUniversiteServices {
    List<Universite> retrieveAllUniversites();

    Universite addUniversite (Universite u);

    Universite updateUniversite (Universite u);

    Universite retrieveUniversite (Integer idUniversite);

    void deleteUniversity(Integer idUniversite);
    Universite assignUnToDep(Integer idDepart, Integer idUn);
}
