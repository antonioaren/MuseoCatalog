package es.ulpgc.eite.da.framework.core.screen;


public interface I_ScreenObservable {

    public void updateObservableState(
    Class<? extends I_ScreenView> view, int code, I_ScreenState state);

}
