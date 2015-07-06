package es.ulpgc.eite.da.framework.core.config;


import es.ulpgc.eite.da.framework.core.mediator.I_MediatorSingleton;

public interface I_ConfigDatabase  {

    public void setMediator(I_MediatorSingleton mediator);
    public I_MediatorSingleton getMediator();
    public abstract void configDatabase();
}
