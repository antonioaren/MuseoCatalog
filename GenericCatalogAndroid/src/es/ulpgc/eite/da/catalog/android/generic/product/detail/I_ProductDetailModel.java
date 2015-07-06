package es.ulpgc.eite.da.catalog.android.generic.product.detail;


import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.catalog.android.core.detail.I_DetailModel;
import es.ulpgc.eite.da.catalog.android.generic.product.database.I_ProductDatabase;

public interface I_ProductDetailModel extends I_DetailModel {

    public I_ProductDatabase getDatabase();
    public I_CatalogData getRelationalData();
}
