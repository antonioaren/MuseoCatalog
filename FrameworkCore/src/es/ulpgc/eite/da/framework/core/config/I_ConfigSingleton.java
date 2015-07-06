package es.ulpgc.eite.da.framework.core.config;


import es.ulpgc.eite.da.framework.core.mediator.MediatorConfig;

public interface I_ConfigSingleton {

    public void setCustomConfig(MediatorConfig config);
    public abstract void createMediator();

}
