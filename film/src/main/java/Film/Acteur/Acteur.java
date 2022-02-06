package Film.Acteur;

import Film.Film;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Acteur")
public class Acteur {
    @Id
    @SequenceGenerator(
            name = "acteur_sequence",
            sequenceName = "acteur_sequence",
            allocationSize = 1
    )
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acteur_sequence")
    private Long id;
    private String nom;
    private String prenom;
    @Enumerated(EnumType.STRING)
    private Role role;

    public Acteur() {
    }

    public Acteur(Long id, String nom, String prenom, Role role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
    }

    @JsonIgnore
    @ManyToMany(mappedBy = "distribution")
    private List<Film> filmList = new ArrayList<>();

}
