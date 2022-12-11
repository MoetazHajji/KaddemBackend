package tn.esprit.firstproject.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.firstproject.entities.Departement;
import tn.esprit.firstproject.entities.Universite;

import java.util.List;

public interface IUniversiteRepository extends CrudRepository<Universite,Integer> {

    List<Departement> findUniversiteAndAndDepartementOrderByIdUniv(Integer idUni);
}
