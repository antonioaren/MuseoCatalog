package es.ulpgc.eite.da.framework.core.mediator;


import es.ulpgc.eite.da.framework.core.config.*;
import es.ulpgc.eite.da.framework.core.screen.*;

import java.util.ArrayList;
import java.util.List;

public abstract class MediatorConfig implements I_ConfigMediator {

    private I_MediatorSingleton _mediator;
    private List<MediatorTransition> _transitions;
    private List<MediatorScreen> _screens;

    public MediatorConfig(I_MediatorSingleton mediator) {

        _mediator = mediator;

        _transitions = new ArrayList<MediatorTransition>();
        _screens = new ArrayList<MediatorScreen>();

        setCustomConfig();
    }


    private I_MediatorSingleton getMediator() {
        return _mediator;
    }

    public List<MediatorScreen> getScreens() {
        return _screens;
    }


    public List<MediatorTransition> getTransitions() {
        return _transitions;
    }


    public void debug(String method) {
        getMediator().debug(method);
    }

    public void debug(String method, String var, Object val) {
        getMediator().debug(method, var, val);
    }


    public MediatorScreen getScreen(I_ScreenView view) {
        return getScreen(view.getClass());
    }


    public MediatorScreen getScreen(Class<? extends I_ScreenView> view) {
        return getScreens().get(getScreenIndex(view));
    }

    public void setScreen(I_ScreenView view, MediatorScreen screen) {
        setScreen(view.getClass(), screen);
    }

    public void setScreen(
    Class<? extends I_ScreenView> view, MediatorScreen screen) {

        getScreens().set(getScreenIndex(view), screen);
    }


    public void checkScreenInstance(I_ScreenView view) {

        MediatorScreen screen =
                getScreens().get(getScreenIndex(view.getClass()));

        screen.setViewInstance(view);
        setScreen(view.getClass(), screen);

        if(!hasScreenInstance(view.getClass())) {
            setScreenInstance(view);
        }
    }

    private void setScreenInstance(I_ScreenView view) { //todo

        //debug("setScreenInstance");

        MediatorScreen screen =
                getScreens().get(getScreenIndex(view.getClass()));

        Class<? extends I_ScreenView> _view = screen.getViewClass();


        I_ScreenPresenter presenter = null;
        I_ScreenModel model = null;
        I_ScreenDatabase database = null;
        I_ScreenStorage storage = null;

        try {

            model = screen.getModelClass().newInstance();
            model.setMediator(getMediator());
            model.setViewClass(_view);

            presenter =  screen.getPresenterClass().newInstance();
            presenter.setViewClass(_view);
            presenter.setMediator(getMediator());

            if (screen.getDatabaseClass() != null) {
                database = screen.getDatabaseClass().newInstance();
                database.setMediator(getMediator());
            }

            if (screen.getStorageClass() != null) {
                storage = screen.getStorageClass().newInstance();
                storage.setMediator(getMediator());
            }

        } catch (Exception e) {

        }

        screen.setPresenterInstance(presenter);
        screen.setModelInstance(model);
        screen.setDatabaseInstance(database);
        screen.setStorageInstance(storage);

        setScreen(_view, screen);

    }


    private boolean hasScreenInstance(Class<? extends I_ScreenView> view) {

        MediatorScreen screen = getScreens().get(getScreenIndex(view));

        if(screen.getPresenterInstance() != null) {
            return true;
        }

        return false;
    }

    private int getScreenIndex(Class<? extends I_ScreenView> view) {

        for(MediatorScreen screen: getScreens()) {

            if(view.equals(screen.getViewClass())) {
                return  getScreens().indexOf(screen);
            }

        }

        return -1;
    }


    public Class<? extends I_ScreenView> getNextScreen(
    Class<? extends I_ScreenView> view, int code) {

        for(MediatorTransition transition: getTransitions()) {
            if(code == transition.getCode()
            && view.equals(transition.getCurrent())) {

                return transition.getNext();
            }
        }

        return null;
    }


}
