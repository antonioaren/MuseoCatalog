package com.example.MuseumCatalogAndroid.Pintores.master;

import com.example.MuseumCatalogAndroid.Pintores.data.PintoresData;
import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.catalog.android.core.master.MasterModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PedroAntonio on 03/05/2015.
 */
public class PintoresMasterModel  extends MasterModel implements I_PintoresMasterModel{

    private ArrayList<I_CatalogData> listaPintores;

    @Override
    public List<? extends I_CatalogData> getCollection() {
        //return new ArrayList<I_CatalogData>();
        listaPintores = new ArrayList<I_CatalogData>();

        PintoresData pintor = new PintoresData();
        pintor.setLabel("Luis");
        listaPintores.add(pintor);
        return listaPintores;
    }


}
