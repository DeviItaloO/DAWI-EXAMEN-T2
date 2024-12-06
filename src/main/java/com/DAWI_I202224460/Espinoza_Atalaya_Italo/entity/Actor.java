package com.DAWI_I202224460.Espinoza_Atalaya_Italo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer actorId;

    private String firstName;
    private String lastName;
    private Date lastUpdate;
}
