package es.ulpgc.eite.da.framework.core.mediator;


import es.ulpgc.eite.da.framework.core.config.I_ConfigSingleton;
import es.ulpgc.eite.da.framework.core.screen.*;

public interface I_MediatorSingleton extends I_ConfigSingleton {

    public void debug(String method);
    public void debug(String method, String var, Object val);

    public void createScreen(I_ScreenView view);
    public void resumeScreen(I_ScreenView view);
    public void pauseScreen(I_ScreenView view);
    public void backScreen(I_ScreenView view);
    public void rotateScreen(I_ScreenView view);

    public void registerScreenObserver(I_ScreenObserver observer);
    public void unregisterScreenObserver(I_ScreenObserver observer);
    public void notifyScreenObservers(
    I_ScreenObservable subject, int code, I_ScreenState state);

    public I_ScreenPresenter getScreenPresenter(
    Class<? extends I_ScreenView> view);
    public I_ScreenPresenter getScreenPresenter(I_ScreenView view);
    public I_ScreenView getScreenView(Class<? extends I_ScreenView> view);
    public I_ScreenModel getScreenModel(Class<? extends I_ScreenView> view);

    public I_ScreenDatabase getScreenDatabase(
    Class<? extends I_ScreenView> view);
    public I_ScreenStorage getScreenStorage(
    Class<? extends I_ScreenView> view);


    public Class<? extends I_ScreenView> getNextScreen(
    I_ScreenView view, int code);
    public void setNextState(I_ScreenView view, int code);
    public I_ScreenState getNextState(I_ScreenView view, int code);

    public void setScreenState(I_ScreenView view, I_ScreenState state);
    public I_ScreenState getScreenState(I_ScreenView view);



}
