package com.DAWI_I202224460.Espinoza_Atalaya_Italo.repository;

import com.DAWI_I202224460.Espinoza_Atalaya_Italo.entity.FilmActor;
import com.DAWI_I202224460.Espinoza_Atalaya_Italo.entity.FilmActorId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmActorRepository extends CrudRepository<FilmActor, FilmActorId> {
}
