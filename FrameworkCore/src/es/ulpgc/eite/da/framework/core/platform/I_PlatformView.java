package es.ulpgc.eite.da.framework.core.platform;


import es.ulpgc.eite.da.framework.core.mediator.I_MediatorSingleton;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenView;

public interface I_PlatformView {

    public void _debug(String method);
    public void _debug(String method, String var, Object val);

    public I_MediatorSingleton _getMediator();

    public void _finishScreen();
    public void _startNextScreen(
    I_ScreenView current, Class<? extends I_ScreenView> next);

    public abstract void _backScreen();
    public abstract void _pauseScreen();
    public abstract void _resumeScreen();
    public abstract void _createScreen();
    public abstract void _rotateScreen();
}
