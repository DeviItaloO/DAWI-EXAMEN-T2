package com.DAWI_I202224460.Espinoza_Atalaya_Italo.dto;

import java.util.Date;

public record FilmDetailDTO(
        Integer filmId,
        String title,
        String description,
        Integer releaseYear,
        Integer rentalDuration,
        Double rentalRate,
        Integer length,
        Double replacementCost,
        String rating,
        String specialFeatures,
        Date lastUpdate,
        String language
) {
}
