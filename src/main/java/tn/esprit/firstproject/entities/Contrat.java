package tn.esprit.firstproject.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idContrat;

    LocalDate dateDebutContrat;
    LocalDate dateFinContract;
    @Enumerated(EnumType.STRING)
    Specialite specialite;
    Boolean archive;
    Integer montantContrat;

    @ManyToOne(/*cascade = CascadeType.ALL*/)
    Etudiant etudiant;
}
