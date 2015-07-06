package es.ulpgc.eite.da.catalog.android.generic.framework;


import es.ulpgc.eite.da.framework.android.AndroidMediatorSingleton;

public class GenericCatalogSingleton extends AndroidMediatorSingleton {


    @Override
    public void createMediator() {
        setCustomConfig(new GenericCatalogConfig(this));
    }

}
