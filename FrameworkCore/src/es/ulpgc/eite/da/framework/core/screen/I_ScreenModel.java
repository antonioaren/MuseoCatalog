package es.ulpgc.eite.da.framework.core.screen;


import es.ulpgc.eite.da.framework.core.config.I_ConfigModel;

public interface I_ScreenModel extends I_ConfigModel {

    public void debug(String method);
    public void debug(String method, String var, Object val);

    public I_ScreenPresenter getScreenPresenter();
    public I_ScreenDatabase getScreenDatabase();
    public I_ScreenStorage getScreenStorage();
}
