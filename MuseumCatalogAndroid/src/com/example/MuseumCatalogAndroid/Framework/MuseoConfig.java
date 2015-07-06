package com.example.MuseumCatalogAndroid.Framework;

import com.example.MuseumCatalogAndroid.Cuadros.details.CuadrosDetailsModel;
import com.example.MuseumCatalogAndroid.Cuadros.details.CuadrosDetailsPresenter;
import com.example.MuseumCatalogAndroid.Cuadros.details.CuadrosDetailsView;
import com.example.MuseumCatalogAndroid.Pintores.master.PintoresMasterModel;
import com.example.MuseumCatalogAndroid.Pintores.master.PintoresMasterPresenter;
import com.example.MuseumCatalogAndroid.Pintores.master.PintoresMasterView;
import com.example.MuseumCatalogAndroid.database.DatabaseMuseumCatalog;
import es.ulpgc.eite.da.catalog.android.core.framework.CatalogCode;
import es.ulpgc.eite.da.framework.core.mediator.I_MediatorSingleton;
import es.ulpgc.eite.da.framework.core.mediator.MediatorConfig;
import es.ulpgc.eite.da.framework.core.mediator.MediatorScreen;
import es.ulpgc.eite.da.framework.core.mediator.MediatorTransition;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenView;

/**
 * Created by PedroAntonio on 06/05/2015.
 */
public class MuseoConfig extends MediatorConfig {



    public MuseoConfig(I_MediatorSingleton mediator) {
        super(mediator);
    }

    @Override
    public void setCustomConfig() {
        setCatalogConfig();
    }

    public void setCatalogConfig() {

        setCatalogTransitionCollection();
        setCatalogScreenCollection();
    }

    private void setCatalogTransitionCollection() {

        getTransitions().add(new MediatorTransition(
                PintoresMasterView.class, CuadrosDetailsView.class,
                CatalogCode.EDIT));
    }



    private void setCatalogScreenCollection() {

        getScreens().add(new MediatorScreen(
                PintoresMasterView.class, PintoresMasterPresenter.class,
                PintoresMasterModel.class,DatabaseMuseumCatalog.class
                 ));

        getScreens().add(new MediatorScreen(
                CuadrosDetailsView.class, CuadrosDetailsPresenter.class,
                CuadrosDetailsModel.class
        ));
    }
}
