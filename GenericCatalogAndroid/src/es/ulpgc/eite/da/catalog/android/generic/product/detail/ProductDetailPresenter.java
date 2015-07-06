package es.ulpgc.eite.da.catalog.android.generic.product.detail;


import es.ulpgc.eite.da.catalog.android.core.state.DetailState;
import es.ulpgc.eite.da.catalog.android.generic.pattern.detail.GenericDetailPresenter;
import es.ulpgc.eite.da.catalog.android.generic.product.data.ProductData;
import es.ulpgc.eite.da.catalog.android.generic.product.master.ProductMasterView;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenView;

public class ProductDetailPresenter
extends GenericDetailPresenter implements I_ProductDetailPresenter  {


    public ProductDetailPresenter() {
        super();
    }

    @Override
    public I_ProductDetailModel getDetailModel() {
        return (I_ProductDetailModel) getScreenModel();
    }//Incializa el modelo.

    @Override
    public String getDetailSubtitle() {
        return getDetailModel().getRelationalData().getLabel();
    }//Inicializa subtitulo.

//--------------- Estados de la pantalla------------
    @Override
    //SetUp del estado de la pantalla
    public void setScreenState(
    Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        debug("setScreenState", "view", view.getSimpleName());
        debug("setScreenState", "code", code);

        DetailState _state = (DetailState) state; //Crea un objeto del estado.
        ProductData data = (ProductData) _state.getData();//Obtiene el estado del dato.
        getDetailModel().setData(data);//Obtienes los datos del detalle.
        setDetailCode(_state.getDetailCode());
        setMasterCode(_state.getMasterCode());
        setPosition(_state.getPosition());// Ponemos la posicion en la que se quedara la aplicacion en caso de que se cambie de app.
        setSize(_state.getSize());//Obtener el tamaño del buffer donde se escribe el estado.

    }


    @Override
    public I_ScreenState getScreenState() {

        debug("getScreenState", "data", getDetailModel().getData());

        DetailState state = new DetailState(getDetailModel().getData());
        state.setDetailCode(getDetailCode());//pide el code del detalle.
        state.setMasterCode(getMasterCode());//Pide el code del Master
        state.setPosition(getPosition());//Obtener la posicion en el vector que contiene el stio en el que el OnResume debe ir.
        state.setSize(getSize());

        return state;
    }


    @Override
    public I_ScreenState getNextState(
    Class<? extends I_ScreenView> view, int code) {

        debug("getNextState", "view", view.getSimpleName());
        debug("getNextState", "code", code);

        return null;
    }


    @Override
    public void updateDetailState(
    Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        debug("updateDetailState", "view", view.getSimpleName());
        debug("updateDetailState", "code", code);

        if(view.equals(ProductMasterView.class)) {
            setScreenState(view, code, state);
            resumeScreen();
        }

    }

}
