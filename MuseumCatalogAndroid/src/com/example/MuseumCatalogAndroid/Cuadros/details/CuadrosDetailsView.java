package com.example.MuseumCatalogAndroid.Cuadros.details;

import android.widget.EditText;
import android.widget.TextView;
import com.example.MuseumCatalogAndroid.Cuadros.data.CuadrosData;
import com.example.MuseumCatalogAndroid.Cuadros.data.I_CuadrosData;
import com.example.MuseumCatalogAndroid.Pintores.data.I_PintoresData;
import com.example.MuseumCatalogAndroid.R;
import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.catalog.android.core.detail.DetailView;
/*import es.ulpgc.eite.da.catalog.android.generic.pattern.detail.GenericDetailView;
import es.ulpgc.eite.da.catalog.android.generic.pattern.detail.I_GenericDetailPresenter;
import es.ulpgc.eite.da.catalog.android.generic.product.data.ProductData;*/

/**
 * Created by PedroAntonio on 06/05/2015.
 */
public class CuadrosDetailsView extends DetailView implements I_CuadrosDetailsView {

    @Override
    public int getDetailLayout() {
        return R.layout.cuadros_detail_view;
    }

    //@Override
    public CuadrosDetailsPresenter getDetailPresenter() {
        return (CuadrosDetailsPresenter) getScreenPresenter();
    }



   /* //@Override
    public I_CatalogData getDetailContent(I_CatalogData data) {
        CuadrosData _data = (CuadrosData) data;

        EditText _label = (EditText) findViewById(R.id.txt_titulo);
        _data.setLabel(_label.getText().toString());

        return _data;
    }*/

    @Override
    public void setDetailContent(I_CatalogData data) {
        CuadrosData _data = (CuadrosData) data;

        //debug("setDetailContent", "data", _data);

        EditText title = (EditText) findViewById(R.id.txt_titulo);
        title.setText(_data.toString());

        TextView subtitle = (TextView) findViewById(R.id.lbl_subtitulo);
        subtitle.setText(getDetailPresenter().getDetailSubtitle());



        //getDetailSubtitle esta creado en el I_GenericCatalog y no dentro de la interfaz del presenter que es donde considero que
        //deberia ir.

        //Esto nos sirve para poner el subtitulo, pero al yo no tener subtitulo lo que hay que poner es la
        //información que quiero poner dentro al elegir el pintor.
    }

}
