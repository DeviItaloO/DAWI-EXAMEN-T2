package com.DAWI_I202224460.Espinoza_Atalaya_Italo.repository;

import com.DAWI_I202224460.Espinoza_Atalaya_Italo.entity.FilmCategory;
import com.DAWI_I202224460.Espinoza_Atalaya_Italo.entity.FilmCategoryId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmCategoryRepository extends CrudRepository<FilmCategory, FilmCategoryId> {
}
