package es.ulpgc.eite.da.framework.core.screen;


import es.ulpgc.eite.da.framework.core.config.I_ConfigView;

public interface I_ScreenView extends I_ConfigView {

    public void debug(String method);
    public void debug(String method, String var, Object val);

    public I_ScreenPresenter getScreenPresenter();

}
