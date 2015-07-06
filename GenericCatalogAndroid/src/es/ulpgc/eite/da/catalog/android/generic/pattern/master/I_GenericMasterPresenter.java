package es.ulpgc.eite.da.catalog.android.generic.pattern.master;


import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.catalog.android.core.master.I_MasterPresenter;
import es.ulpgc.eite.da.catalog.android.core.state.DetailState;

public interface I_GenericMasterPresenter extends I_MasterPresenter {

    public DetailState updateMasterModel(I_CatalogData data, int code);
}
