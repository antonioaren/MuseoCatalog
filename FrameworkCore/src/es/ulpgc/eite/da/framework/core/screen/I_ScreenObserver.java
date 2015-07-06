package es.ulpgc.eite.da.framework.core.screen;


public interface I_ScreenObserver {

    public I_ScreenState updateObserverState(
    Class<? extends I_ScreenView> view, int code, I_ScreenState state);

}
