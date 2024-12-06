package com.DAWI_I202224460.Espinoza_Atalaya_Italo.dto;

import java.util.Date;

public record InventoryDTO(
        Integer inventoryId,
        Integer filmId,
        Integer storeId,
        Date lastUpdate
) {}
