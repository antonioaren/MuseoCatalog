package es.ulpgc.eite.da.catalog.android.generic.category.detail;


import es.ulpgc.eite.da.catalog.android.generic.category.database.I_CategoryDatabase;
import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.catalog.android.core.detail.I_DetailModel;

import java.util.List;

public interface I_CategoryDetailModel extends I_DetailModel {

    public I_CategoryDatabase getDatabase();
    public List<? extends I_CatalogData> getRelationalCollection();
}
