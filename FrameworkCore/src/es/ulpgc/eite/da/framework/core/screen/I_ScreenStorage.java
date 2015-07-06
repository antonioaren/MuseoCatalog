package es.ulpgc.eite.da.framework.core.screen;


import es.ulpgc.eite.da.framework.core.config.I_ConfigStorage;

public interface I_ScreenStorage extends I_ConfigStorage {

    public void debug(String method);
    public void debug(String method, String var, Object val);

}
