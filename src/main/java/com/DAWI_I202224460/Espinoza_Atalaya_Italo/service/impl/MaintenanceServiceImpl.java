package com.DAWI_I202224460.Espinoza_Atalaya_Italo.service.impl;

import com.DAWI_I202224460.Espinoza_Atalaya_Italo.dto.FilmDTO;
import com.DAWI_I202224460.Espinoza_Atalaya_Italo.dto.FilmDetailDTO;
import com.DAWI_I202224460.Espinoza_Atalaya_Italo.dto.LanguageDTO;
import com.DAWI_I202224460.Espinoza_Atalaya_Italo.entity.Film;
import com.DAWI_I202224460.Espinoza_Atalaya_Italo.entity.Language;
import com.DAWI_I202224460.Espinoza_Atalaya_Italo.repository.*;
import com.DAWI_I202224460.Espinoza_Atalaya_Italo.service.interfaces.MaintenanceService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private LanguageRepository languageRepository;

    @Override
    @Cacheable(value = "filmsCache", key = "'allFilms'")
    public List<FilmDTO> findAllFilms() {
        List<FilmDTO> films = new ArrayList<>();
        Iterable<Film> iterable = filmRepository.findAll();
        iterable.forEach(film -> {
            String language = film.getLanguage() != null ? film.getLanguage().getName() : "Desconocido";
            FilmDTO filmDTO = new FilmDTO(
                    film.getFilmId(),
                    film.getTitle(),
                    film.getDescription(),
                    film.getReleaseYear(),
                    film.getLanguage().getLanguageId(),
                    film.getRentalDuration(),
                    film.getRentalRate(),
                    film.getLength(),
                    film.getReplacementCost(),
                    film.getRating(),
                    film.getSpecialFeatures(),
                    film.getLastUpdate(),
                    film.getLanguage().getLanguageId(),
                    language
            );
            films.add(filmDTO);
        });
        return films;
    }

    @Override
    public List<LanguageDTO> findAllLanguages() {
        Iterable<Language> languagesIterable = languageRepository.findAll();

        List<Language> languages = StreamSupport.stream(languagesIterable.spliterator(), false)
                .collect(Collectors.toList());

        List<LanguageDTO> languageDTOs = languages.stream()
                .map(language -> new LanguageDTO(
                        language.getLanguageId(),
                        language.getName(),
                        language.getLastUpdate()))
                .collect(Collectors.toList());

        return languageDTOs;
    }


    @Override
    @Cacheable(value = "filmsCache", key = "'film_' + #id")
    public FilmDetailDTO findDetailById(Integer id) {
        Optional<Film> optional = filmRepository.findById(id);
        return optional.map(
                film -> new FilmDetailDTO(
                        film.getFilmId(),
                        film.getTitle(),
                        film.getDescription(),
                        film.getReleaseYear(),
                        film.getRentalDuration(),
                        film.getRentalRate(),
                        film.getLength(),
                        film.getReplacementCost(),
                        film.getRating(),
                        film.getSpecialFeatures(),
                        film.getLastUpdate(),
                        film.getLanguage().toString())
        ).orElse(null);
    }

    @Override
    @CacheEvict(value = "filmsCache", key = "'allFilms'")
    public void createFilm(FilmDetailDTO filmDetailDTO) {
        Film film = new Film();
        film.setTitle(filmDetailDTO.title());
        film.setDescription(filmDetailDTO.description());
        film.setReleaseYear(filmDetailDTO.releaseYear());
        film.setRentalDuration(filmDetailDTO.rentalDuration());
        film.setRentalRate(filmDetailDTO.rentalRate());
        film.setLength(filmDetailDTO.length());
        film.setReplacementCost(0.0);
        film.setRating(filmDetailDTO.rating());
        film.setSpecialFeatures(filmDetailDTO.specialFeatures());
        film.setLastUpdate(new Date());

        Language language = languageRepository.findByName(filmDetailDTO.language())
                .orElse(null);
        film.setLanguage(language);

        filmRepository.save(film);
    }

    @Override
    @CacheEvict(value = "filmsCache", key = "'film_' + #id")
    @CachePut(value = "filmsCache", key = "'film_' + #id")
    public void updateFilm(Integer id, FilmDetailDTO filmDetailDTO) {
        Optional<Film> optionalFilm = filmRepository.findById(id);
        if (optionalFilm.isPresent()) {
            Film film = optionalFilm.get();
            film.setTitle(filmDetailDTO.title());
            film.setDescription(filmDetailDTO.description());
            film.setReleaseYear(filmDetailDTO.releaseYear());
            film.setRentalDuration(filmDetailDTO.rentalDuration());
            film.setRentalRate(filmDetailDTO.rentalRate());
            film.setLength(filmDetailDTO.length());
            film.setReplacementCost(0.0);
            film.setRating(filmDetailDTO.rating());
            film.setSpecialFeatures(filmDetailDTO.specialFeatures());
            film.setLastUpdate(new Date());

            Language language = languageRepository.findByName(filmDetailDTO.language())
                    .orElse(null);
            film.setLanguage(language);

            filmRepository.save(film);
        }
    }

    @Transactional
    @Override
    @CacheEvict(value = "filmsCache", key = "'allFilms'")
    public void deleteFilm(Integer id) {
        filmRepository.deleteById(id);
    }
}
