package es.ulpgc.eite.da.framework.core.config;


import es.ulpgc.eite.da.framework.core.mediator.I_MediatorSingleton;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenView;

public interface I_ConfigModel {

    public void setMediator(I_MediatorSingleton mediator);
    public I_MediatorSingleton getMediator();
    public void setViewClass(Class<? extends I_ScreenView> view);
}
