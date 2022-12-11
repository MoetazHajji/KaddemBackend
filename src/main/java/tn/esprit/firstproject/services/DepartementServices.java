package tn.esprit.firstproject.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.firstproject.entities.Departement;
import tn.esprit.firstproject.entities.Universite;
import tn.esprit.firstproject.repositories.IDepartementRepository;
import tn.esprit.firstproject.repositories.IUniversiteRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class DepartementServices implements IDepartementServices {

    IDepartementRepository iDepartementRepository;
    IUniversiteRepository iUniversiteRepository;

    @Override
    public List<Departement> retrieveAllDepartements() {
        List<Departement> departementList = new ArrayList<>();
        iDepartementRepository.findAll().forEach(departementList::add);
        return departementList;
    }

    @Override
    public Departement addDepartement(Departement d) {
        return iDepartementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {
        return iDepartementRepository.save(d);
    }

    @Override
    public Departement retrieveDepartement(Integer idDepart) {
        return iDepartementRepository.findById(idDepart).orElse(null);
    }

    @Override
    public List<Departement> retreiveDepartmentsByUnivesite(Integer idUniversity) {
        return iDepartementRepository.retreiveDepartmentsByUniversite(idUniversity);
    }

}
