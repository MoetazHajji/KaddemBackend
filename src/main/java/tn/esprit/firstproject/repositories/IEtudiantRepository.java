package tn.esprit.firstproject.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import tn.esprit.firstproject.entities.Departement;
import tn.esprit.firstproject.entities.Etudiant;
import tn.esprit.firstproject.entities.Option;

import java.util.List;

public interface IEtudiantRepository extends CrudRepository<Etudiant,Integer> {
    List<Etudiant> findByOp(Option option);
    List<Etudiant> findByDepartement_IdDepart(Integer idDepartement);

    Etudiant findEtudiantsByNomEAndPrenomE(String nom, String prenom);

    @Query("select s from Etudiant s where s.op= :opt")
    List<Etudiant> retreiveStudentsByOp(@Param("opt") Option option);

    @Query("select d from Etudiant d where d.departement=:dep")
    List<Etudiant> retreiveStudentsByDepartment(@Param("dep")Departement departement);


}
