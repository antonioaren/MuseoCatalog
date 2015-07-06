package es.ulpgc.eite.da.framework.android;


import android.util.Log;
import es.ulpgc.eite.da.framework.core.mediator.I_MediatorSingleton;
import es.ulpgc.eite.da.framework.core.platform.I_PlatformModel;
import es.ulpgc.eite.da.framework.core.screen.*;

public abstract class AndroidScreenModel
implements I_ScreenModel, I_PlatformModel {


    private I_MediatorSingleton _mediator;
    private Class<? extends I_ScreenView> _view;

    @Override
    public void debug(String method) {
        _debug(method);
    }

    @Override
    public void debug(String method, String var, Object val) {
        _debug(method , var, val);
    }


    @Override
    public I_ScreenPresenter getScreenPresenter() {
        return getMediator().getScreenPresenter(getViewClass());
    }

    @Override
    public I_ScreenDatabase getScreenDatabase() {
        return getMediator().getScreenDatabase(getViewClass());
    }

    @Override
    public I_ScreenStorage getScreenStorage() {
        return getMediator().getScreenStorage(getViewClass());
    }



    ///////////////////////////////////////////////////////////////


    @Override
    public void setMediator(I_MediatorSingleton mediator) {
        _mediator = mediator;
    }


    @Override
    public I_MediatorSingleton getMediator() {
        return _mediator;
    }

    @Override
    public void setViewClass(Class<? extends I_ScreenView> view) {
        _view = view;
    }

    private Class<? extends I_ScreenView> getViewClass() {
        return _view;
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
