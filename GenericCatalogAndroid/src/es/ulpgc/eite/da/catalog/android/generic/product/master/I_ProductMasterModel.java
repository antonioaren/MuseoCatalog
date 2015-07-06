package es.ulpgc.eite.da.catalog.android.generic.product.master;


import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.catalog.android.generic.pattern.master.I_GenericMasterModel;

public interface I_ProductMasterModel extends I_GenericMasterModel {

    public long getParentId();
    public void setParentId(long id);
    public I_CatalogData getRelationalData();

}
