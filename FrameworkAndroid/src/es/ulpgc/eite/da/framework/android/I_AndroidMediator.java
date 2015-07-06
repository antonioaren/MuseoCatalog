package es.ulpgc.eite.da.framework.android;


import android.content.Context;
import es.ulpgc.eite.da.framework.core.platform.I_PlatformMediator;

public interface I_AndroidMediator extends I_PlatformMediator {


    public String getResource(int resId);
    public String getNormalizedResource(int resId);
    public Context getContext();

}
