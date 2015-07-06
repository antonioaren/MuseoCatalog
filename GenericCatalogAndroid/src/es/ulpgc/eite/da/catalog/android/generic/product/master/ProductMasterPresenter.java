package es.ulpgc.eite.da.catalog.android.generic.product.master;


import es.ulpgc.eite.da.catalog.android.core.state.DetailState;
import es.ulpgc.eite.da.catalog.android.generic.category.data.CategoryData;
import es.ulpgc.eite.da.catalog.android.generic.pattern.master.GenericMasterPresenter;
import es.ulpgc.eite.da.catalog.android.generic.product.data.ProductData;
import es.ulpgc.eite.da.catalog.android.generic.product.detail.ProductDetailView;
import es.ulpgc.eite.da.catalog.android.generic.product.state.ProductMasterState;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenView;

public class ProductMasterPresenter
extends GenericMasterPresenter implements I_ProductMasterPresenter {


    public ProductMasterPresenter(){
        super();
    }


    @Override
    public I_ProductMasterModel getMasterModel() {
        return (I_ProductMasterModel) getScreenModel();
    }

    @Override
    public String getMasterRowSubtitle(long dataId) {
        return getMasterModel().getRelationalData().getLabel();
    }


    @Override
    public void setScreenState(
    Class<? extends I_ScreenView> view, int code, I_ScreenState state) {


        debug("setScreenState", "view", view.getSimpleName());
        debug("setScreenState", "code", code);
        debug("setScreenState", "state", state.getClass().getSimpleName());

        if(state instanceof ProductMasterState) {

            ProductMasterState _state = (ProductMasterState) state;
            setMasterCode(_state.getCode());
            getMasterModel().setPosition(_state.getPosition());
            getMasterModel().setParentId(_state.getParentId());

            debug("setScreenState", "parent", getMasterModel().getParentId());

        } else {

            DetailState _state = (DetailState) state;

            setMasterCode(_state.getMasterCode()); //todo
            getMasterModel().setPosition(_state.getPosition());  //todo

            CategoryData data = (CategoryData) _state.getData();
            getMasterModel().setParentId(data.getId());

            debug("setScreenState", "parent", getMasterModel().getParentId());
        }
    }




    @Override
    public I_ScreenState getScreenState() {

        debug("getScreenState", "parent", getMasterModel().getParentId());

        ProductMasterState state = new ProductMasterState();
        state.setCollection(getMasterModel().getCollection());
        state.setPosition(getMasterModel().getPosition());
        state.setCode(getMasterCode());
        state.setParentId(getMasterModel().getParentId());
        return state;
    }


    @Override
    public I_ScreenState getNextState(
    Class<? extends I_ScreenView> view, int code) {

        debug("getNextState", "view", view.getSimpleName());
        debug("getNextState", "code", code);

        ProductData data = (ProductData) getMasterModel().getData();
        debug("getNextState", "data", data);

        data.setParentId(getMasterModel().getParentId());
        DetailState state = new DetailState(data);
        state.setPosition(getMasterModel().getPosition());
        state.setSize(getMasterModel().getSize());
        state.setMasterCode(getMasterCode());

        debug("getNextState", "parent", data.getParentId());

        return state;

    }


    @Override
    public I_ScreenState updateMasterState(
    Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        debug("updateMasterState", "view", view.getSimpleName());
        debug("updateMasterState", "code", code);

        if (view.equals(ProductDetailView.class)) {

            DetailState _state = (DetailState) state;
            ProductData data = (ProductData) _state.getData();

            return updateMasterModel(data, code);

        }

        return null;

    }

}
