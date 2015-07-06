package com.example.MuseumCatalogAndroid.Cuadros.details;

import com.example.MuseumCatalogAndroid.Cuadros.database.I_CuadrosDatabase;
import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.catalog.android.core.detail.I_DetailModel;

/**
 * Created by PedroAntonio on 06/05/2015.
 */
public interface I_CuadrosDetailsModel extends I_DetailModel{
    public I_CuadrosDatabase getDatabase();
    //public I_CatalogData getRelationalData();
}
