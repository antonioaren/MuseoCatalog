package es.ulpgc.eite.da.framework.core.platform;



public interface I_PlatformMediator {

    public void _debug(String method);
    public void _debug(String method, String var, Object val);

    public abstract void _createMediator();

}
