package com.example.MuseumCatalogAndroid.Pintores.database;

import com.example.MuseumCatalogAndroid.Pintores.data.PintoresData;
import org.droidpersistence.dao.TableDefinition;

/**
 * Created by PedroAntonio on 13/05/2015.
 */
public class PintoresTable extends TableDefinition <PintoresData>{

    public PintoresTable() {
        super(PintoresData.class);
    }
}
