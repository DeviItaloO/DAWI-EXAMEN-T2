package com.DAWI_I202224460.Espinoza_Atalaya_Italo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(FilmCategoryId.class)
public class FilmCategory {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "film_id", nullable = false)
    private Film filmId;

    @Id
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category categoryId;

    @Column(name = "last_update")
    private Date lastUpdate;

}
