package com.DAWI_I202224460.Espinoza_Atalaya_Italo.repository;

import com.DAWI_I202224460.Espinoza_Atalaya_Italo.entity.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Integer> {
}
