package tn.esprit.firstproject.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.firstproject.entities.Contrat;
import tn.esprit.firstproject.entities.Departement;

import java.util.List;

public interface IDepartementRepository extends CrudRepository<Departement,Integer> {

    @Query("select s from Universite s where s.departements= :opt ")
    List<Departement> retreiveDepartmentsByUniversite(@Param("opt") Integer idUnisite);


}
