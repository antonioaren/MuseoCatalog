package es.ulpgc.eite.da.catalog.android.generic.category.master;


import es.ulpgc.eite.da.catalog.android.core.state.DetailState;
import es.ulpgc.eite.da.catalog.android.core.state.MasterState;
import es.ulpgc.eite.da.catalog.android.generic.category.data.CategoryData;
import es.ulpgc.eite.da.catalog.android.generic.category.detail.CategoryDetailView;
import es.ulpgc.eite.da.catalog.android.generic.pattern.master.GenericMasterPresenter;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenView;

public class CategoryMasterPresenter
extends GenericMasterPresenter implements I_CategoryMasterPresenter {


    public CategoryMasterPresenter() {
        super();
    }


    @Override
    public I_CategoryMasterModel getMasterModel() {
        return (I_CategoryMasterModel) getScreenModel();
    }


    @Override
    public String getMasterRowSubtitle(long dataId) {
        return "" + getMasterModel().getRelationalCollection(dataId).size();
    }

    @Override
    public void setScreenState(Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        //debug("setScreenState");

        if(state != null) {

            MasterState _state = (MasterState) state;
            getMasterModel().setPosition(_state.getPosition());
            setMasterCode(_state.getCode());

            debug("setScreenState", "mCode", getMasterCode());
            debug("setScreenState", "pos", getMasterModel().getPosition());
        }

    }

    @Override
    public I_ScreenState getScreenState() {

        debug("getScreenState", "collection", getMasterModel().getCollection());

        MasterState state = new MasterState();
        state.setCollection(getMasterModel().getCollection());  //todo
        state.setPosition(getMasterModel().getPosition());
        state.setCode(getMasterCode());
        return state;
    }

    @Override
    public I_ScreenState getNextState(
    Class<? extends I_ScreenView> view, int code) {

        debug("getNextState", "view", view.getSimpleName());
        debug("getNextState", "code", code);

        CategoryData data = (CategoryData) getMasterModel().getData();

        debug("getNextState", "data", data);

        DetailState state = new DetailState(data);
        state.setPosition(getMasterModel().getPosition());
        state.setSize(getMasterModel().getSize());
        state.setMasterCode(getMasterCode());
        return state;

    }


    @Override
    public I_ScreenState updateMasterState(Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        debug("updateMasterState");

        if (view.equals(CategoryDetailView.class)) {

            DetailState _state = (DetailState) state;
            CategoryData data = (CategoryData) _state.getData();

            return updateMasterModel(data, code);
        }

        return null;

    }


}
