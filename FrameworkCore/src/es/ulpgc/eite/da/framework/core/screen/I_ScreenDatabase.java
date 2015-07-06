package es.ulpgc.eite.da.framework.core.screen;


import es.ulpgc.eite.da.framework.core.config.I_ConfigDatabase;

public interface I_ScreenDatabase extends I_ConfigDatabase {

    public void debug(String method);
    public void debug(String method, String var, Object val);


}
