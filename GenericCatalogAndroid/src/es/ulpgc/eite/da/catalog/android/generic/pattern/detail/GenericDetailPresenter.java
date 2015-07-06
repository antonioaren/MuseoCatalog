package es.ulpgc.eite.da.catalog.android.generic.pattern.detail;


import es.ulpgc.eite.da.catalog.android.core.detail.DetailPresenter;
import es.ulpgc.eite.da.catalog.android.core.framework.CatalogCode;
import es.ulpgc.eite.da.framework.core.screen.I_ScreenObservable;

public abstract class GenericDetailPresenter extends DetailPresenter
implements I_GenericDetailPresenter, I_ScreenObservable {


    public GenericDetailPresenter() {
        super();
    }

    public I_GenericDetailView getDetailView() {
        return (I_GenericDetailView) getScreenView();
    }


    @Override
    public void resumeScreen() {

        super.resumeScreen();

        debug("resumeScreen", "mcode", getMasterCode());
        debug("resumeScreen", "dcode", getDetailCode());

        boolean dStatus = true;
        if (getDetailCode() != CatalogCode.NULL) {
            dStatus=getDetailView().updateDetailButtons(getDetailCode());
        }

        boolean mStatus = true;
        if (getMasterCode() != CatalogCode.NULL) {
            mStatus=getDetailView().updateDetailButtons(getMasterCode());
        }

        if (dStatus && mStatus) {
            updateDetailButtons();
        }
    }

    @Override
    public void backScreen() {
        debug("backScreen", "dcode", getDetailCode());
        debug("backScreen", "mcode", getMasterCode());

        if(getDetailCode() == CatalogCode.ADD
        || getMasterCode() == CatalogCode.NEW) {

            updateMasterContent(getDetailModel().getData(), CatalogCode.BACK);
        }
    }


    @Override
    public void onDetailButtonClick(int code) {

        setDetailCode(code);
        setMasterCode(CatalogCode.NULL);

        debug("onDetailButtonClick", "dcode", getDetailCode());

        if(getDetailView().updateDetailButtons(code)){
            updateDetailButtons();
        }

        switch (code) {

            case CatalogCode.LIST:
                startNextScreenWithFinish(code, false);
                break;

            case CatalogCode.SAVE:
                getDetailModel().setData(getDetailView().getDetailContent(
                        getDetailModel().getData()));

            case CatalogCode.NEXT:
            case CatalogCode.PREV:
            case CatalogCode.ADD:
            case CatalogCode.DEL:
                updateDetailContent(code);
                break;
        }

        if(getDetailView().updateDetailButtons(code)){
            updateDetailButtons();
        }

    }


    private void updateDetailButtons() {
        debug("updateDetailButtons");

        updateDetailButtons(CatalogCode.PREV);
        updateDetailButtons(CatalogCode.NEXT);
    }

    private void updateDetailButtons(int code) {

        getDetailView().updateDetailButtons(
                code, checkMasterContent(code));
    }


    private boolean checkMasterContent(int code) {

        debug("checkMasterContent", "pos", getPosition());
        debug("checkMasterContent", "size", getSize());

        boolean status = true;

        switch (code) {

            case CatalogCode.NEXT:
                if(getPosition() == getSize() - 1) {
                    status = false;
                }
                break;

            case CatalogCode.PREV:
                if(getPosition() == 0) {
                    status = false;
                }
                break;
        }

        return status;
    }


}
