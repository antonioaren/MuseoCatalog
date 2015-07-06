package es.ulpgc.eite.da.framework.android;


import android.util.Log;
import es.ulpgc.eite.da.framework.core.config.I_ConfigView;
import es.ulpgc.eite.da.framework.core.mediator.I_MediatorSingleton;
import es.ulpgc.eite.da.framework.core.platform.I_PlatformPresenter;
import es.ulpgc.eite.da.framework.core.screen.*;


public abstract class AndroidScreenPresenter
implements I_ScreenPresenter, I_PlatformPresenter {



    private Class<? extends I_ScreenView> _view;
    private I_MediatorSingleton _mediator;
    //private int _code;


    @Override
    public void debug(String method) {
        _debug(method);
    }

    @Override
    public void debug(String method, String var, Object val) {
        _debug(method , var, val);
    }



    @Override
    public I_ScreenView getScreenView() {
        return getMediator().getScreenView(getViewClass());
    }

    @Override
    public I_ScreenModel getScreenModel() {
        return getMediator().getScreenModel(getViewClass());
    }


//    @Override
//    public int getTransitionCode() {
//        return _code;
//    }



    @Override
    public void notifyScreenObservers(
    I_ScreenObservable subject, int code, I_ScreenState state) {

        //debug("notifyScreenObservers");

        getMediator().notifyScreenObservers(subject, code, state);
    }

    @Override
    public void finishScreen() {
        //debug("finishScreen");

        _getScreenView().finishScreen();  //todo
    }


    @Override
    public void startNextScreenWithObserver(
    I_ScreenObserver presenter, int code) {

        //debug("startNextScreenWithObserver");

        getMediator().registerScreenObserver(presenter);
        getMediator().setNextState(getScreenView(), code);
        _getScreenView().startNextScreen(code); //todo
    }

    @Override
    public void startNextScreenWithFinish(int code, boolean finish) {
        //debug("startNextScreenWithFinish");

        getMediator().setNextState(getScreenView(), code);
        _getScreenView().startNextScreen(code); //todo

        if(finish) {
            _getScreenView().finishScreen();  //todo
        }
    }


    ///////////////////////////////////////////////////////////////



//    @Override
//    public void setTransitionCode(int code) {
//        _code = code;
//    }


    @Override
    public void setViewClass(Class<? extends I_ScreenView> view) {
        _view = view;
    }

    @Override
    public Class<? extends I_ScreenView> getViewClass() {
        return _view;
    }


    @Override
    public void setMediator(I_MediatorSingleton mediator) {
        _mediator = mediator;
    }

    @Override
    public I_MediatorSingleton getMediator() {
        return _mediator;
    }

    private I_ConfigView _getScreenView() {
        return getMediator().getScreenView(getViewClass());
    }

    ///////////////////////////////////////////////////////////////


    @Override
    public void _debug(String method) {
        Log.i("Framework." + super.getClass().getSimpleName(), method);
    }

    @Override
    public void _debug(String method, String var, Object val) {
        Log.i("Framework." + super.getClass().getSimpleName(),
                method + "." + var + "=" + val);
    }


}
