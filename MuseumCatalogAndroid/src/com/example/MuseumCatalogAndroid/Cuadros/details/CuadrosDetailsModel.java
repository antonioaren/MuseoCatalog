package com.example.MuseumCatalogAndroid.Cuadros.details;

import com.example.MuseumCatalogAndroid.Cuadros.database.I_CuadrosDatabase;
import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.catalog.android.core.detail.DetailModel;

/**
 * Created by PedroAntonio on 06/05/2015.
 */
public class CuadrosDetailsModel extends DetailModel implements I_CuadrosDetailsModel {

    public CuadrosDetailsModel(I_CatalogData data) {
        super(data);
    }

    @Override
    public I_CatalogData getData() {
        return null;
    }

    @Override
    public void setData(I_CatalogData _data) {

    }

    @Override
    public I_CuadrosDatabase getDatabase() {
        return null;
    }

   /* @Override
    public I_CatalogData getRelationalData() {
        return null;
    }*/
}
