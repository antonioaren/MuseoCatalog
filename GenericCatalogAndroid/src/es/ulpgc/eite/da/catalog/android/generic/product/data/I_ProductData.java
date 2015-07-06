package es.ulpgc.eite.da.catalog.android.generic.product.data;


import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;

public interface I_ProductData extends I_CatalogData {

    public Long getParentId();
    public void setParentId(Long dataId);
}
