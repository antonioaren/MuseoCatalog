package es.ulpgc.eite.da.framework.android;


import android.util.Log;
import es.ulpgc.eite.da.framework.core.mediator.I_MediatorSingleton;
import es.ulpgc.eite.da.framework.core.platform.I_PlatformDatabase;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenDatabase;


public abstract class AndroidScreenDatabase
implements I_ScreenDatabase, I_PlatformDatabase {


    private I_MediatorSingleton _mediator;

    @Override
    public void debug(String method) {
        _debug(method);
    }

    @Override
    public void debug(String method, String var, Object val) {
        _debug(method , var, val);
    }

    ///////////////////////////////////////////////////////////////


    @Override
    public void setMediator(I_MediatorSingleton mediator) {
        _mediator = mediator;
        configDatabase();
    }

    @Override
    public I_MediatorSingleton getMediator() {
        return _mediator;
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
