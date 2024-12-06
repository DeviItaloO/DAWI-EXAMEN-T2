package com.DAWI_I202224460.Espinoza_Atalaya_Italo.service.interfaces;

import com.DAWI_I202224460.Espinoza_Atalaya_Italo.dto.FilmDTO;
import com.DAWI_I202224460.Espinoza_Atalaya_Italo.dto.FilmDetailDTO;
import com.DAWI_I202224460.Espinoza_Atalaya_Italo.dto.LanguageDTO;

import java.util.List;

public interface MaintenanceService {

    List<FilmDTO> findAllFilms();
    List<LanguageDTO> findAllLanguages();
    FilmDetailDTO findDetailById(Integer id);
    void createFilm(FilmDetailDTO filmDetailDTO);
    void updateFilm(Integer id,FilmDetailDTO filmDetailDTO);
    void deleteFilm(Integer id);
}
