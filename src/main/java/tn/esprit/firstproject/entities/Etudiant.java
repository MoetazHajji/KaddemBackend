package tn.esprit.firstproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idEtudiant;
    @NonNull
    String prenomE;
    @NonNull
    String nomE;
    @Enumerated(EnumType.STRING)
    Option op;

    @JsonIgnore
    @OneToMany
    Set<Contrat> contrats;

    @ManyToOne(fetch = FetchType.EAGER ,cascade = {CascadeType.PERSIST , CascadeType.REMOVE})
    Departement departement;


    @JsonIgnore
    @ManyToMany(cascade = CascadeType.PERSIST)
    Set<Equipe> equipes;
}
