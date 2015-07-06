package com.example.MuseumCatalogAndroid.Pintores.data;

import android.content.pm.LabeledIntent;
import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import org.droidpersistence.annotation.Column;
import org.droidpersistence.annotation.PrimaryKey;
import org.droidpersistence.annotation.Table;

/**
 * Created by PedroAntonio on 09/05/2015.
 */
@Table(name="coleccion_pintores")
public class PintoresData implements I_PintoresData {

    @PrimaryKey(autoIncrement = true)// Primary key de la tabla.
    @Column(name = "id")//Columna de id
    private Long id; //Iniciacion de la variable id.

    @Column(name = "label")//Columna de la etiqueta
    private String label;//Inicializacion de la variable

    public PintoresData() {
        setLabel("");//Metodos inicializados para la etiqueta en la base de datos.
        setId(0L);
    }



    @Override
    public String getLabel() {

        return label;
    }//Etiqueta en la base de datos, parar saber dondek se encuentra dentro de la tabla.

    @Override
    public void setLabel(String _label) {
        label = _label;
    }//Poner un valor a la etiqueta ya definida.

    @Override
    public void setId(Long ValueId) {
        id = ValueId;

    }//Poner un valor id (valor entero) para hacer la referencia a las tablas.

    @Override
    public Long getId() {
        return id;

    }//metodo que devuelve el valor de id.


    @Override
    public String toString() {
        return getLabel();
    }
}
