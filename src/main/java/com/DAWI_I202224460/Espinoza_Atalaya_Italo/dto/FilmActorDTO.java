package com.DAWI_I202224460.Espinoza_Atalaya_Italo.dto;

import java.util.Date;

public record FilmActorDTO (
        Integer filmId,
        Integer actorId,
        Date lastUpdate
) {}
