package es.ulpgc.eite.da.framework.core.screen;


import es.ulpgc.eite.da.framework.core.config.I_ConfigPresenter;

public interface I_ScreenPresenter extends I_ConfigPresenter {

    public void debug(String method);
    public void debug(String method, String var, Object val);

    public abstract void createScreen();
    public abstract void backScreen();
    public abstract void resumeScreen();
    public abstract void pauseScreen();
    public abstract void rotateScreen();

    public I_ScreenView getScreenView();
    public I_ScreenModel getScreenModel();

    //public int getTransitionCode();

    public void notifyScreenObservers(
    I_ScreenObservable subject, int code, I_ScreenState state);


    public void startNextScreenWithFinish(int code, boolean finish);
    public void startNextScreenWithObserver(I_ScreenObserver presenter, int code);
    public void finishScreen();

}
