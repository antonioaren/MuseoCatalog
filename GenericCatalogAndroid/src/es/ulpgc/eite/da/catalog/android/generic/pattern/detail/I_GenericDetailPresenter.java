package es.ulpgc.eite.da.catalog.android.generic.pattern.detail;


import es.ulpgc.eite.da.catalog.android.core.detail.I_DetailPresenter;

public interface I_GenericDetailPresenter extends I_DetailPresenter {

    public void onDetailButtonClick(int code);

    public String getDetailSubtitle();
}
