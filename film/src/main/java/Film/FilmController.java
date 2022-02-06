package Film;

import Film.Acteur.Acteur;
import Film.Acteur.ActeurService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/film")
@AllArgsConstructor

public class FilmController {

    @Autowired
    private final FilmService filmService;

    @Autowired
    private final ActeurService acteurService;

    @GetMapping
    public List<Film> getFilms(){
            return filmService.getFilms();
    }

    @PostMapping
    public void addFilm(@RequestBody Film film){
        filmService.save(film);
    }

    @PutMapping("/{filmId}/acteur/{acteurId}")
    Film addActeur(
            @PathVariable Long filmId,
            @PathVariable Long acteurId
            ){
        Film film = filmService.getFilmById(filmId);
        Acteur acteur = acteurService.getActeurById(acteurId);
        film.addActeurToFilm(acteur);
        return filmService.save(film);
    }
}
