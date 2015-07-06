package es.ulpgc.eite.da.catalog.android.generic.category.detail;


import es.ulpgc.eite.da.catalog.android.core.state.DetailState;
import es.ulpgc.eite.da.catalog.android.generic.category.data.CategoryData;
import es.ulpgc.eite.da.catalog.android.generic.category.master.CategoryMasterView;
import es.ulpgc.eite.da.catalog.android.generic.pattern.detail.GenericDetailPresenter;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenState;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenView;

public class CategoryDetailPresenter
extends GenericDetailPresenter implements I_CategoryDetailPresenter {


    public CategoryDetailPresenter() {
        super();
    }


    @Override
    public I_CategoryDetailModel getDetailModel() {
        return (I_CategoryDetailModel) getScreenModel();
    }

    @Override
    public String getDetailSubtitle() {
        return "" + getDetailModel().getRelationalCollection().size();
    }

    @Override
    public void setScreenState(
    Class<? extends I_ScreenView> view, int code, I_ScreenState state) {


        debug("setScreenState", "view", view.getSimpleName());
        debug("setScreenState", "code", code);

        DetailState _state = (DetailState) state;
        CategoryData data = (CategoryData) _state.getData();

        debug("setScreenState", "data", data);

        getDetailModel().setData(data);
        setMasterCode(_state.getMasterCode());
        setDetailCode(_state.getDetailCode());  //todo
        setPosition(_state.getPosition());
        setSize(_state.getSize());

    }


    @Override
    public I_ScreenState getScreenState() {

        debug("getScreenState", "data", getDetailModel().getData());

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


        debug("getNextState", "view", view.getSimpleName());
        debug("getNextState", "code", code);
        debug("getNextState", "data", getDetailModel().getData());

        return new DetailState(getDetailModel().getData());
    }


    @Override
    public void updateDetailState(
    Class<? extends I_ScreenView> view, int code, I_ScreenState state) {

        debug("updateDetailState", "view", view.getSimpleName());
        debug("updateDetailState", "code", code);

        if(view.equals(CategoryMasterView.class)) {

            setScreenState(view, code, state);
            resumeScreen();
        }
    }

}
