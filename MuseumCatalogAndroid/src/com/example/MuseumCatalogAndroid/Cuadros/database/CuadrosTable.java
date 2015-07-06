package com.example.MuseumCatalogAndroid.Cuadros.database;

import com.example.MuseumCatalogAndroid.Cuadros.data.CuadrosData;
import org.droidpersistence.dao.TableDefinition;

/**
 * Created by PedroAntonio on 16/05/2015.
 */
public class CuadrosTable extends TableDefinition <CuadrosData> {
    public CuadrosTable() {
        super(CuadrosData.class);
    }
}
