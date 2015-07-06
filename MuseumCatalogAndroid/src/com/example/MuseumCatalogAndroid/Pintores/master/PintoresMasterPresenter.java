package com.example.MuseumCatalogAndroid.Pintores.master;

import com.example.MuseumCatalogAndroid.Cuadros.details.CuadrosDetailsView;
import com.example.MuseumCatalogAndroid.Pintores.data.PintoresData;
import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.catalog.android.core.master.I_MasterModel;
import es.ulpgc.eite.da.catalog.android.core.master.I_MasterView;
import es.ulpgc.eite.da.catalog.android.core.master.MasterPresenter;
import es.ulpgc.eite.da.catalog.android.core.state.DetailState;
import es.ulpgc.eite.da.catalog.android.core.state.MasterState;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenView;

/**
 * Created by PedroAntonio on 01/05/2015.
 */
public class PintoresMasterPresenter
        extends MasterPresenter implements I_PintoresMasterPresenter {

    public PintoresMasterPresenter() {
        super();
    }

    @Override
    public I_PintoresMasterView getMasterView() {
        return (I_PintoresMasterView)getScreenView();
    }//Inicializacion de la vista.

    @Override
    public I_PintoresMasterModel getMasterModel() {
        return (I_PintoresMasterModel)getScreenModel();
    }//Inicialización de modelo

    @Override
    public void createScreen() {// llama al metodo init master
        super.createScreen();
    }


    @Override

    public void setMasterCode(int code) {
        super.setMasterCode(code);
    }

    @Override
    public int getMasterCode() {
        return super.getMasterCode();
    }

    @Override
    public void rotateScreen() {
        super.rotateScreen();
    }

    @Override
    public void backScreen() {
        super.backScreen();
    }

    @Override
    //Resumen actualizado
    public void resumeScreen() {
        super.resumeScreen();

    }

    @Override
    public void pauseScreen() {
        super.pauseScreen();
    }


    @Override
    //La accion de pulsar un boton.
    public void onMasterButtonClick(int code) {
        startNextScreenWithFinish(code, false);
    }

//------------------------ Estados de las pantallas------------------------ ------------------------
    @Override
    //Estado de la pantalla y actualizacion de ellas.
    public I_ScreenState updateMasterState(Class<? extends I_ScreenView> view, int code, I_ScreenState state) {
       /* if (view.equals(CuadrosDetailsView.class)) {

            DetailState _state = (DetailState) state;
            PintoresData data = (PintoresData) _state.getData(); Preguntar que hace este metodo.

            return updateMasterModel(data, code);
        }*/

        return null;
    }

    @Override
    public I_ScreenState updateObserverState(Class<? extends I_ScreenView> view, int code, I_ScreenState state) {
        return super.updateObserverState(view, code, state);
    }


    @Override
    //Establecer el estado de la pantalla
    public void setScreenState(Class<? extends I_ScreenView> view, int code, I_ScreenState state) {
        if(state != null) {
            MasterState _state = (MasterState) state; //declaramos un estado, MasterState
            getMasterModel().setPosition(_state.getPosition());//lo obtiene y lo pone.
            setMasterCode(_state.getCode());

            //debug("setScreenState", "mCode", getMasterCode());
            //debug("setScreenState", "pos", getMasterModel().getPosition());
        }
    }

    @Override
    //Saber el estado de la pantalla
    public I_ScreenState getScreenState() {
        MasterState state = new MasterState();
        state.setCollection(getMasterModel().getCollection());  //todo
        state.setPosition(getMasterModel().getPosition());
        state.setCode(getMasterCode());
        return state;
    }

    @Override
    //Obtener el estado de la siguiente pantalla
    public I_ScreenState getNextState(Class<? extends I_ScreenView> view, int code) {

        int position = getMasterView().getListPosition();

        PintoresData data = (PintoresData) getMasterModel().getData();

        DetailState state = new DetailState(data);
        state.setPosition(position);
        state.setSize(getMasterModel().getSize());
        state.setMasterCode(getMasterCode());
        return state;
    }

}
