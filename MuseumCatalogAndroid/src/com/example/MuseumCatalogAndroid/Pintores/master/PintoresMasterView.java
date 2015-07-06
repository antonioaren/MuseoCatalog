package com.example.MuseumCatalogAndroid.Pintores.master;

import android.view.View;
import android.widget.TextView;
import com.example.MuseumCatalogAndroid.Pintores.data.PintoresData;
import com.example.MuseumCatalogAndroid.R;
import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.catalog.android.core.master.I_MasterPresenter;
import es.ulpgc.eite.da.catalog.android.core.master.MasterView;

import java.util.List;

/**
 * Created by PedroAntonio on 03/05/2015.
 */
public class PintoresMasterView extends MasterView implements I_PintoresMasterView {

    @Override
    public void initMaster() {
        super.initMaster();
    }

    @Override
    public void setMasterContent() {
        super.setMasterContent();
    }

    @Override
    public int getListPosition() {
        return super.getListPosition();
    }

    @Override
    public void onMasterButtonClick(int code) {
        super.onMasterButtonClick(code);
    }

    @Override
    public void updateMasterContent(List<? extends I_CatalogData> collection) {
        super.updateMasterContent(collection);
    }

    @Override
    public I_PintoresMasterPresenter getMasterPresenter() {//Devuelve la vista con layout de la vista al presentador.
        return (I_PintoresMasterPresenter)getScreenPresenter();
    }

    @Override
    public int getMasterLayout() {// Asocia la vista con el XML ( es decir el codigo con lo diseñado
        return R.layout.pintores_master_view;//R que significa el recurso y el nombre del layaout que debe cargar.
    }

    @Override
    public int getMasterList() {
        return R.id.list_master_pintores;
    }

    @Override
    public int getMasterRowLayout() {
        return R.layout.pintores_master_row;
    }

    @Override
    public void setMasterRowContent(View row, I_CatalogData data) {

        TextView text = (TextView) row.findViewById(R.id.lbl_title);//Buscamos el texto de la celda por id asociandolo al xml

        PintoresData _data = (PintoresData)data;

        text.setText(_data.toString());

    }



}
