package com.example.MuseumCatalogAndroid.Cuadros.details;

import com.example.MuseumCatalogAndroid.Pintores.data.PintoresData;
import com.example.MuseumCatalogAndroid.Pintores.master.PintoresMasterView;
import es.ulpgc.eite.da.catalog.android.core.detail.DetailPresenter;
import es.ulpgc.eite.da.catalog.android.core.detail.I_DetailModel;
import es.ulpgc.eite.da.catalog.android.core.detail.I_DetailView;
import es.ulpgc.eite.da.catalog.android.core.state.DetailState;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenView;

/**
 * Created by PedroAntonio on 06/05/2015.
 */
public class CuadrosDetailsPresenter
        extends DetailPresenter implements I_CuadrosDetailsPresenter {

    public CuadrosDetailsPresenter(){
        super();
    }

    @Override //Inicializar y pedir el modelo del detalle
    public I_CuadrosDetailsModel getDetailModel() {
        return (I_CuadrosDetailsModel)getScreenModel();
    }

    @Override //Inicializar y pedir la vista del detalle.
    public I_CuadrosDetailsView getDetailView() {
        return (I_CuadrosDetailsView)getScreenView();
    }

    @Override
    public void setMasterCode(int code) {
    }

    @Override
    public int getMasterCode() {
        return 0;
    }

    @Override
    public int getDetailCode() {
        return 0;
    }

    @Override
    public void setDetailCode(int code) {

    }

    @Override
    public int getPosition() {
        return 0;
    }

    @Override
    public void setPosition(int position) {

    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void setSize(int size) {
    }

   /* @Override
    //No estoy seguro, aunque hice una escritura en el I_genericDetailPresenter para poder usar este metodo, dado que cuando lo llamo
    //desde la vista no puede ser visto porque no encuentra getDetailSubtitle, aunque se lo he puesto en la interfaz de data.

    public String getDetailSubtitle() {
        return getDetailModel().getRelationalData().getLabel();
    }*/

    //Sigo viendo en el State que solo en el ejemplo de category y product esta solo los estados de las pantallas sin mas.
//-------------------------------- Estados de la pantalla ------------------------------------------------
    @Override
    public void setScreenState(
            Class<? extends I_ScreenView> view, int code, I_ScreenState state) {
        //debug("setScreenState", "view", view.getSimpleName());
        //debug("setScreenState", "code", code);

        DetailState _state = (DetailState) state;
        PintoresData data = (PintoresData) _state.getData();

        //debug("setScreenState", "data", data);

        getDetailModel().setData(data);
        setMasterCode(_state.getMasterCode());
        setDetailCode(_state.getDetailCode());
        setPosition(_state.getPosition());
        setSize(_state.getSize());
    }//El setup de los estados de pantallas.

    @Override
    public I_ScreenState getScreenState() {

        //debug("getScreenState", "data", getDetailModel().getData());

        DetailState state = new DetailState(getDetailModel().getData());

        state.setDetailCode(getDetailCode());
        state.setMasterCode(getMasterCode());
        state.setPosition(getPosition());
        state.setSize(getSize());

        return state;
    }

    @Override
    public I_ScreenState getNextState(
            Class<? extends I_ScreenView> view, int code) {
        //debug("getNextState", "view", view.getSimpleName());
        //debug("getNextState", "code", code);
        //debug("getNextState", "data", getDetailModel().getData());

       /* DetailState state = new DetailState(getDetailModel().getData());
        state.setDetailCode(getDetailCode());//pide el code del detalle.
        state.setMasterCode(getMasterCode());//Pide el code del Master
        state.setPosition(getPosition());//Obtener la posicion en el vector que contiene el stio en el que el OnResume debe ir.
        state.setSize(getSize());
        return state;*/
        return null;
    }//Solo hay un detalle y un maestro por tanto no se necesita tener el estado del siguiente ya con el back ya al pasado.

    @Override
    public void updateDetailState(
            Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        if(view.equals(PintoresMasterView.class)) {
            setScreenState(view, code, state);
            resumeScreen();
        }

    }



    @Override
    public void onDetailButtonClick(int code) {
    }

    @Override
    public String getDetailSubtitle() {
        return null;
    }
}
