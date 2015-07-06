package com.example.MuseumCatalogAndroid.Pintores.database;

import android.database.sqlite.SQLiteDatabase;
import com.example.MuseumCatalogAndroid.Pintores.data.PintoresData;
import org.droidpersistence.dao.DroidDao;
import org.droidpersistence.dao.TableDefinition;

/**
 * Created by PedroAntonio on 13/05/2015.
 */
public class PintoresDao extends DroidDao <PintoresData, Long>{

    public PintoresDao(Class<PintoresData> model, TableDefinition<PintoresData> tableDefinition, SQLiteDatabase database) {
        super(model, tableDefinition, database);
    }
}
