package com.example.MuseumCatalogAndroid.Cuadros.data;

import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import org.droidpersistence.annotation.Column;
import org.droidpersistence.annotation.PrimaryKey;
import org.droidpersistence.annotation.Table;

/**
 * Created by PedroAntonio on 16/05/2015.
 */
@Table(name="coleccion_pintores")
public class CuadrosData implements I_CuadrosData{
    @PrimaryKey(autoIncrement = true)// Primary key de la tabla.
    @Column(name = "id")//Columna de id
    private Long id; //Iniciacion de la variable id.

    @Column(name = "label")//Columna de la etiqueta
    private String label;//Inicializacion de la variable

    public CuadrosData() {
        //setLabel("");//Metodos inicializados para la etiqueta en la base de datos.
        setId(0L);
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String _label) {
        label = _label;
    }

    @Override
    public void setId(Long Valueid) {
        id = Valueid;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return getLabel();
    }
}
