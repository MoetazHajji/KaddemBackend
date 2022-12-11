package tn.esprit.firstproject.entities;

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
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idUniv;
    String nomUniv;

    @OneToMany(cascade = {CascadeType.PERSIST , CascadeType.REMOVE},fetch = FetchType.EAGER)
    Set<Departement> departements;
}
