package com.DAWI_I202224460.Espinoza_Atalaya_Italo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(FilmActorId.class)
@Table(name = "film_actor")
public class FilmActor {

    @Id
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film filmId;

    @Id
    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actorId;

    private Date lastUpdate;
}
