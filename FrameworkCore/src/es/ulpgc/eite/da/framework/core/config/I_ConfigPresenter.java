package es.ulpgc.eite.da.framework.core.config;


import es.ulpgc.eite.da.framework.core.mediator.I_MediatorSingleton;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenView;

public interface I_ConfigPresenter {

    public void setMediator(I_MediatorSingleton mediator);
    public I_MediatorSingleton getMediator();

    public void setViewClass(Class<? extends I_ScreenView> view);
    public Class<? extends I_ScreenView> getViewClass();

    //public void setTransitionCode(int code);

    public abstract void setScreenState(
    Class<? extends I_ScreenView> view, int code, I_ScreenState state);
    public abstract I_ScreenState getScreenState();
    public abstract I_ScreenState getNextState(
    Class<? extends I_ScreenView> view, int code);
}
