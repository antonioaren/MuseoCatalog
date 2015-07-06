package com.example.MuseumCatalogAndroid.database;

import android.database.sqlite.SQLiteDatabase;
import android.os.SystemClock;
import com.example.MuseumCatalogAndroid.Cuadros.database.CuadrosDao;
import com.example.MuseumCatalogAndroid.Cuadros.database.I_CuadrosDatabase;
import com.example.MuseumCatalogAndroid.Pintores.database.I_PintoresDatabase;
import com.example.MuseumCatalogAndroid.Pintores.database.PintoresDao;
import com.example.MuseumCatalogAndroid.Pintores.database.PintoresTable;
import com.example.MuseumCatalogAndroid.R;
import es.ulpgc.eite.da.framework.android.AndroidScreenDatabase;
import es.ulpgc.eite.da.framework.android.I_AndroidMediator;

/**
 * Created by PedroAntonio on 13/05/2015.
 */
public class DatabaseMuseumCatalog extends AndroidScreenDatabase
        implements I_PintoresDatabase, I_CuadrosDatabase {

    @Override
    public void configDatabase() {

    }
}
