package es.ulpgc.eite.da.framework.core.config;

import es.ulpgc.eite.da.framework.core.mediator.I_MediatorSingleton;

public interface I_ConfigView {

    public I_MediatorSingleton getMediator();

    public void finishScreen();
    public void startNextScreen(int code);

}
