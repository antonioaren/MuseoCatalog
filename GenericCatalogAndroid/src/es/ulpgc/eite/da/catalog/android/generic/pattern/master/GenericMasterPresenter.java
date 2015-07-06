package es.ulpgc.eite.da.catalog.android.generic.pattern.master;


import es.ulpgc.eite.da.catalog.android.core.data.I_CatalogData;
import es.ulpgc.eite.da.catalog.android.core.framework.CatalogCode;
import es.ulpgc.eite.da.catalog.android.core.master.MasterPresenter;
import es.ulpgc.eite.da.catalog.android.core.state.DetailState;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenObserver;

public abstract class GenericMasterPresenter extends MasterPresenter
implements I_GenericMasterPresenter,  I_ScreenObserver {

    public GenericMasterPresenter() {
        super();
    }

    @Override
    public void resumeScreen() {
        super.resumeScreen();

        boolean status = getMasterModel().getCollection().size() != 0;
        getMasterView().updateMasterButton(status);

    }

    public I_GenericMasterView getMasterView() {
        return (I_GenericMasterView) getScreenView();
    }

    public I_GenericMasterModel getMasterModel() {
        return (I_GenericMasterModel) getScreenModel();
    }

    @Override
    public void onMasterButtonClick(int code) {

        debug("onMasterButtonClick");

        setMasterCode(code);

        if(code == CatalogCode.NEW) {
            getMasterModel().addData();
            startNextScreenWithObserver(this, code);
        }

        if(code == CatalogCode.EDIT) {
            getMasterModel().setPosition(getMasterView().getListPosition());
            startNextScreenWithObserver(this, code);
        }

        if(code == CatalogCode.CLEAR) {
            getMasterModel().delCollection();
            getMasterView().updateMasterContent(
                    getMasterModel().getCollection());
        }
    }

    @Override
    public DetailState updateMasterModel(I_CatalogData data, int code) {


        debug("updateMasterModel", "data", data);
        debug("updateMasterModel",
                "collection", getMasterModel().getCollection());

        switch (code) {

            case CatalogCode.BACK:
            case CatalogCode.DEL:
                getMasterModel().delData();
                debug("updateMasterModel",
                        "collection", getMasterModel().getCollection());
                break;

            case CatalogCode.ADD:
                getMasterModel().addData();
                debug("updateMasterModel",
                        "collection", getMasterModel().getCollection());
                break;

            case CatalogCode.NEXT:
                getMasterModel().setPosition(
                        getMasterModel().getPosition(data) + 1);
                break;

            case CatalogCode.PREV:
                getMasterModel().setPosition(
                        getMasterModel().getPosition(data) - 1);
                break;
        }

        if(code != CatalogCode.BACK)  {

            DetailState state = new DetailState(getMasterModel().getData());
            state.setDetailCode(code);
            state.setPosition(getMasterModel().getPosition());
            state.setSize(getMasterModel().getSize());
            if(getMasterModel().getSize() == 0) {
                state.setMasterCode(CatalogCode.FINISH);
            }

            return state;

        }

        return null;
    }

}
