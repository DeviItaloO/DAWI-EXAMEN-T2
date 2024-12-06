package com.DAWI_I202224460.Espinoza_Atalaya_Italo.repository;

import com.DAWI_I202224460.Espinoza_Atalaya_Italo.entity.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Integer> {
    Optional<Language> findByName(String name);
}
