package es.ulpgc.eite.da.framework.android;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import es.ulpgc.eite.da.framework.core.mediator.I_MediatorSingleton;
import es.ulpgc.eite.da.framework.core.platform.I_PlatformView;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenPresenter;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenView;


public abstract class AndroidScreenView
extends Activity implements I_ScreenView, I_PlatformView {

    private I_MediatorSingleton _mediator;

    @Override
    public void debug(String method) {
        _debug(method);
    }

    @Override
    public void debug(String method, String var, Object val) {
        _debug(method, var, val);
    }


    @Override
    public void _createScreen() {
        setMediator();
        getMediator().createScreen(this);
    }

    @Override
    public void _rotateScreen() {
        getMediator().rotateScreen(this);
    }

    @Override
    public void _resumeScreen() {
        getMediator().resumeScreen(this);
    }

    @Override
    public void _pauseScreen() {
        getMediator().pauseScreen(this);
    }


    @Override
    public void _backScreen() {
        getMediator().backScreen(this);
    }



    @Override
    public I_ScreenPresenter getScreenPresenter() {
        return  getMediator().getScreenPresenter(this);
    }



    ///////////////////////////////////////////////////////////////


    @Override
    public I_MediatorSingleton getMediator() {
        return _mediator;
    }

    @Override
    public void finishScreen() {
        _finishScreen();
    }


    @Override
    public void startNextScreen(int code) {
        _startNextScreen(this, getMediator().getNextScreen(this, code));
    }

    private void setMediator() {
        _mediator = _getMediator();
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
    public I_MediatorSingleton _getMediator() {
        return (I_MediatorSingleton) getApplication();
    }

    @Override
    public void _startNextScreen(
    I_ScreenView current, Class<? extends I_ScreenView> next) {

        Intent intent = new Intent((Activity) current, next);  //todo
        startActivity(intent);
    }

    @Override
    public void _finishScreen() {
        finish();
    }

    @Override
    public void onCreate(Bundle inState) {
        super.onCreate(inState);
        _createScreen();
    }

    @Override
    protected void onResume() {
        super.onResume();
        _resumeScreen();
    }

    @Override
    protected void onPause() {
        super.onPause();
        _pauseScreen();

    }

    @Override
    public void onBackPressed() {
        _backScreen();
        super.onBackPressed();
    }


    @Override
    public void onConfigurationChanged(Configuration config) {
        super.onConfigurationChanged(config);

        _rotateScreen();

    }

}
