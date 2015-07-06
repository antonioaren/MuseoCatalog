package es.ulpgc.eite.da.catalog.android.generic.category.master;


import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.catalog.android.generic.pattern.master.I_GenericMasterModel;

import java.util.List;

public interface I_CategoryMasterModel extends I_GenericMasterModel {

    public List<? extends I_CatalogData> getRelationalCollection(long dataId);

}
