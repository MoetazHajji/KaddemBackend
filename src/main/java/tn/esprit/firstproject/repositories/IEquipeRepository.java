package tn.esprit.firstproject.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.firstproject.entities.Equipe;
import tn.esprit.firstproject.entities.Etudiant;
import tn.esprit.firstproject.entities.Option;

import java.util.List;

public interface IEquipeRepository extends CrudRepository<Equipe,Integer> {

}
