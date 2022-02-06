package Film;

import Film.Acteur.Acteur;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "Film")
public class Film {
    @Id
    @SequenceGenerator(
            name = "film_sequence",
            sequenceName = "film_sequence",
            allocationSize = 1
    )
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "film_sequence")
    private Long id;
    private String nom;
    private int duree;
    @ManyToMany
    @JoinTable(
            name = "Joue",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name= "acteur_id")
    )
    private List<Acteur> distribution = new ArrayList<>();

    public Film(String nom, int duree) {
        this.nom = nom;
        this.duree = duree;
    }

    public void addActeurToFilm(Acteur acteur){
        distribution.add(acteur);
    }
}
