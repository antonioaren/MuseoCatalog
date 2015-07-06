package es.ulpgc.eite.da.framework.android;


import android.app.Application;
import android.content.Context;
import android.util.Log;
import es.ulpgc.eite.da.framework.core.mediator.I_MediatorSingleton;
import es.ulpgc.eite.da.framework.core.mediator.MediatorConfig;
import es.ulpgc.eite.da.framework.core.mediator.MediatorScreen;
import es.ulpgc.eite.da.framework.core.screen.*;

import java.util.ArrayList;
import java.util.List;

public abstract class AndroidMediatorSingleton
extends Application implements I_MediatorSingleton, I_AndroidMediator {



    private MediatorConfig _config;
    private List<I_ScreenObserver> _observers;

    public void _createMediator() {
        _observers = new ArrayList<I_ScreenObserver>();
        createMediator();
    }

    @Override
    public void debug(String method) {
        _debug(method);
    }

    @Override
    public void debug(String method, String var, Object val) {
        _debug(method , var, val);
    }


    @Override
    public void setCustomConfig(MediatorConfig config) {
        _config = config;
    }

    private MediatorConfig getConfig() {
        return _config;
    }

    private List<I_ScreenObserver> getObservers() {
        return _observers;
    }


    @Override
    public void registerScreenObserver(I_ScreenObserver observer) {

        if(!getObservers().contains(observer)) {
            getObservers().add(observer);
        }
    }

    @Override
    public void unregisterScreenObserver(I_ScreenObserver observer) {
        getObservers().remove(observer);
    }

    @Override
    public void notifyScreenObservers(
    I_ScreenObservable observable, int code, I_ScreenState state) {


        for(I_ScreenObserver observer: getObservers()) {

            I_ScreenPresenter presenter = (I_ScreenPresenter) observable;
            Class<? extends I_ScreenView> view = presenter.getViewClass();

            I_ScreenState _state =
                    observer.updateObserverState(view, code, state);
            I_ScreenPresenter _presenter = (I_ScreenPresenter) observer;
            Class<? extends I_ScreenView> _view = _presenter.getViewClass();

            MediatorScreen _screen = getConfig().getScreen(_view);
            _screen.setModifiedState(true); //todo
            debug("notifyScreenObservers", "modified", _screen.isModifiedState());
            getConfig().setScreen(_view, _screen);

            if(_state != null)  {
                observable.updateObservableState(_view, code, _state);

                MediatorScreen screen = getConfig().getScreen(view);
                screen.setModifiedState(true); //todo
                debug("notifyScreenObservers", "modified", screen.isModifiedState());
                getConfig().setScreen(view, screen);
            }
        }
    }




    @Override
    public void createScreen(I_ScreenView view) {
        //debug("createScreen");

        MediatorScreen screen = getConfig().getScreen(view);
        screen.setCreatedScreen(true);

        debug("createScreen", "modified", screen.isModifiedState());
        if(screen.isModifiedState()) {
            screen.setModifiedState(false);
        }

        getConfig().setScreen(view, screen);

    }

    @Override
    public void resumeScreen(I_ScreenView view) {
        //debug("resumeScreen");

        getConfig().checkScreenInstance(view);

        MediatorScreen screen = getConfig().getScreen(view);
        I_ScreenPresenter presenter = screen.getPresenterInstance();

        if(screen.isCreatedScreen()) {
            presenter.createScreen();

        }

        debug("resumeScreen", "modified", screen.isModifiedState());

        presenter.setScreenState(screen.getTransitionView(),
                screen.getTransitionCode(),  getScreenState(view));
        screen.setPresenterInstance(presenter);
        screen.setCreatedScreen(false);
        getConfig().setScreen(view, screen);

        presenter.resumeScreen();
    }

    @Override
    public void backScreen(I_ScreenView view) {
        //debug("backScreen");

        I_ScreenPresenter presenter = getScreenPresenter(view);
        presenter.backScreen();
    }

    @Override
    public void pauseScreen(I_ScreenView view) {
        //debug("pauseScreen");

        I_ScreenPresenter presenter = getScreenPresenter(view);
        presenter.pauseScreen();
    }


    @Override
    public void rotateScreen(I_ScreenView view) {
        //debug("rotateScreen");

        I_ScreenPresenter presenter = getScreenPresenter(view);
        presenter.rotateScreen();
    }

    @Override
    public I_ScreenPresenter getScreenPresenter(I_ScreenView view) {
        return getScreenPresenter(view.getClass());
    }

    @Override
    public I_ScreenPresenter getScreenPresenter(
    Class<? extends I_ScreenView> view) {

        MediatorScreen screen = getConfig().getScreen(view);
        return screen.getPresenterInstance();
    }


    @Override
    public I_ScreenView getScreenView(Class<? extends I_ScreenView> view) {

        MediatorScreen screen = getConfig().getScreen(view);
        return screen.getViewInstance();

    }

    @Override
    public I_ScreenModel getScreenModel(Class<? extends I_ScreenView> view) {

        MediatorScreen screen = getConfig().getScreen(view);
        return screen.getModelInstance();
    }


    @Override
    public I_ScreenDatabase getScreenDatabase(
    Class<? extends I_ScreenView> view) {

        MediatorScreen screen = getConfig().getScreen(view);
        return screen.getDatabaseInstance();
    }

    @Override
    public I_ScreenStorage getScreenStorage(
    Class<? extends I_ScreenView> view) {

        MediatorScreen screen = getConfig().getScreen(view);
        return screen.getStorageInstance();
    }



    @Override
    public void setNextState(I_ScreenView view, int code) {
        //debug("setNextState");

        I_ScreenState state = getNextState(view, code);
        Class<? extends I_ScreenView> _view = getNextScreen(view, code);
        MediatorScreen screen = getConfig().getScreen(_view);
        screen.setStateInstance(state);
        screen.setTransitionCode(code);
        screen.setTransitionView(view.getClass());
        getConfig().setScreen(getNextScreen(view, code), screen);
    }

    @Override
    public I_ScreenState getNextState(I_ScreenView view, int code) {
        //debug("getNextState");

        Class<? extends I_ScreenView> _view = getNextScreen(view, code);

        MediatorScreen screen = getConfig().getScreen(view);
        I_ScreenPresenter presenter =  screen.getPresenterInstance();
        return presenter.getNextState(_view, code);
    }

    @Override
    public void setScreenState(I_ScreenView view, I_ScreenState state) {
        //debug("setScreenState");

        MediatorScreen screen = getConfig().getScreen(view);
        screen.setStateInstance(state);
        screen.setModifiedState(true);  //todo
        debug("setScreenState", "modified", screen.isModifiedState());
        getConfig().setScreen(view, screen);
    }

    @Override
    public I_ScreenState getScreenState(I_ScreenView view) {
        //debug("getScreenState");

        MediatorScreen screen = getConfig().getScreen(view);

        if(screen.isModifiedState()) {
            screen.setModifiedState(false);
            debug("getScreenState", "modified", screen.isModifiedState());
            I_ScreenPresenter presenter =  screen.getPresenterInstance();
            I_ScreenState state = presenter.getScreenState();
            screen.setStateInstance(state);
            getConfig().setScreen(view, screen);
        }

        return screen.getStateInstance();
    }




    @Override
    public Class<? extends I_ScreenView> getNextScreen(
    I_ScreenView view, int code) {

        //debug("getNextScreen");

        return getNextScreen(view.getClass(), code);
    }


    private Class<? extends I_ScreenView> getNextScreen(
    Class<? extends I_ScreenView> view, int code) {

        Class<? extends I_ScreenView> _view =
                getConfig().getNextScreen(view, code);

        MediatorScreen screen = getConfig().getScreen(_view);
        screen.setTransitionCode(code); //todo
        getConfig().setScreen(_view, screen);

        return _view;
    }


    ///////////////////////////////////////////////////////////////


    @Override
    public void _debug(String method) { //todo

        Log.i("Framework." + super.getClass().getSimpleName(), method);
    }

    @Override
    public void _debug(String method, String var, Object val) {  //todo
        Log.i("Framework." + super.getClass().getSimpleName(),
                method + "." + var + "=" + val);
    }


    @Override
    public void onCreate() {
        super.onCreate();

        _createMediator();
    }

    @Override
    public String getResource(int resId) {
        return getResources().getString(resId);
    }

    @Override
    public String getNormalizedResource(int resId) {
        return getNormalizedString(getResource(resId));
    }

    @Override
    public Context getContext() {
        return this;
    }

    private String getNormalizedString(String str){

        str = str.replace("&", "");

        str = str.replace("  ", " ");

        str = str.replace(" ", "_");
        str = str.replace("-", "_");

        str = str.replace("ñ", "n");
        str = str.replace("á", "a");
        str = str.replace("é", "e");
        str = str.replace("í", "i");
        str = str.replace("ó", "o");
        str = str.replace("ú", "u");
        str = str.replace("ü", "u");
        str = str.replace("Á", "A");
        str = str.replace("É", "E");
        str = str.replace("Í", "I");
        str = str.replace("Ó", "O");
        str = str.replace("Ú", "U");
        str = str.replace("Ü", "U");
        str = str.replace("Ñ", "N");

        str = str.replace("º", "");
        str = str.replace("ª", "");
        str = str.replace(".", "");
        str = str.replace(":", "");

        return str;
    }

}
