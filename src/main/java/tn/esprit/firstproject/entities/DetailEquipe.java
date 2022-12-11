package tn.esprit.firstproject.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DetailEquipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idDetailEquipe;
    Integer salle;
    String thematique;

    @OneToOne(cascade = {CascadeType.PERSIST , CascadeType.REMOVE})
    Equipe equipe;
}
