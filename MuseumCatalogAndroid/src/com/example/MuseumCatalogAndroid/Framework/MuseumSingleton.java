package com.example.MuseumCatalogAndroid.Framework;

import es.ulpgc.eite.da.framework.android.AndroidMediatorSingleton;

/**
 * Created by PedroAntonio on 13/05/2015.
 */
public class MuseumSingleton extends AndroidMediatorSingleton {

    @Override
    public void createMediator() {
        setCustomConfig(new MuseoConfig(this));
    }
}
