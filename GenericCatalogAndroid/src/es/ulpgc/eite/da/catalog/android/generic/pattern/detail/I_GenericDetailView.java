package es.ulpgc.eite.da.catalog.android.generic.pattern.detail;


import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.catalog.android.core.detail.I_DetailView;

public interface I_GenericDetailView extends I_DetailView {

    public void setDetailButtons();
    public boolean updateDetailButtons(int code);
    public void updateDetailButtons(int code, boolean status);

    public abstract I_CatalogData getDetailContent(I_CatalogData data);

}
