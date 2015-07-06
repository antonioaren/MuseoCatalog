package es.ulpgc.eite.da.framework.core.mediator;


import es.ulpgc.eite.da.framework.core.screen.*;

public class MediatorScreen {

    private I_ScreenModel _mInstance;
    private I_ScreenPresenter _pInstance;
    private I_ScreenView _vInstance;
    private I_ScreenDatabase _dInstance;
    private I_ScreenStorage _sInstance;

    private Class<? extends I_ScreenView> _vClass;
    private Class<? extends I_ScreenModel> _mClass;
    private Class<? extends I_ScreenPresenter> _pClass;
    private Class<? extends I_ScreenDatabase> _dClass;
    private Class<? extends I_ScreenStorage> _sClass;

    private I_ScreenState _state;
    private Class<? extends I_ScreenView> _view;

    private boolean _created;
    private boolean _modified;
    private int _code;


    private MediatorScreen() {

        setModelInstance(null);
        setPresenterInstance(null);
        setViewInstance(null);
        setDatabaseInstance(null);
        setStorageInstance(null);

        setModelClass(null);
        setPresenterClass(null);
        setViewClass(null);
        setDatabaseClass(null);
        setStorageClass(null);

        setStateInstance(null);

        setTransitionView(null);
        setTransitionCode(MediatorCode.NULL); //todo

        setCreatedScreen(false);
        setModifiedState(false);

    }

    public MediatorScreen(Class<? extends I_ScreenView> view,
    Class<? extends I_ScreenPresenter> presenter,
    Class<? extends I_ScreenModel> model,
    Class<? extends I_ScreenDatabase> database,
    Class<? extends I_ScreenStorage> storage) {

        this();

        setModelClass(model);
        setPresenterClass(presenter);
        setViewClass(view);
        setDatabaseClass(database);
        setStorageClass(storage);

        setTransitionView(view);
    }


    public MediatorScreen(Class<? extends I_ScreenView> view,
    Class<? extends I_ScreenPresenter> presenter,
    Class<? extends I_ScreenModel> model) {

        this(view, presenter, model, null, null);
    }


    public MediatorScreen(Class<? extends I_ScreenView> view,
    Class<? extends I_ScreenPresenter> presenter,
    Class<? extends I_ScreenModel> model,
    Class<? extends I_ScreenDatabase> database) {

        this(view, presenter, model, database, null);
    }




    public I_ScreenStorage getStorageInstance() {
        return _sInstance;
    }

    public void setStorageInstance(I_ScreenStorage storage) {
        _sInstance = storage;
    }

    public I_ScreenDatabase getDatabaseInstance() {
        return _dInstance;
    }

    public void setDatabaseInstance(I_ScreenDatabase database) {
        _dInstance = database;
    }


    public I_ScreenView getViewInstance() {
        return _vInstance;
    }

    public void setViewInstance(I_ScreenView view) {
        _vInstance = view;
    }


    public I_ScreenModel getModelInstance() {
        return _mInstance;
    }

    public void setModelInstance(I_ScreenModel model) {
        _mInstance = model;
    }

    public I_ScreenPresenter getPresenterInstance() {
        return _pInstance;
    }

    public void setPresenterInstance(I_ScreenPresenter presenter) {
        _pInstance = presenter;
    }




    public Class<? extends I_ScreenStorage> getStorageClass() {
        return _sClass;
    }

    public void setStorageClass(Class<? extends I_ScreenStorage> storage) {
        _sClass = storage;
    }


    public Class<? extends I_ScreenDatabase> getDatabaseClass() {
        return _dClass;
    }

    public void setDatabaseClass(Class<? extends I_ScreenDatabase> database) {
        _dClass = database;
    }

    public Class<? extends I_ScreenView> getViewClass() {
        return _vClass;
    }

    public void setViewClass(Class<? extends I_ScreenView> view) {
        _vClass = view;
    }


    public Class<? extends I_ScreenModel> getModelClass() {
        return _mClass;
    }

    public void setModelClass(Class<? extends I_ScreenModel> model) {
        _mClass = model;
    }

    public Class<? extends I_ScreenPresenter> getPresenterClass() {
        return _pClass;
    }

    public void setPresenterClass(
    Class<? extends I_ScreenPresenter> presenter) {

        _pClass = presenter;
    }



    public I_ScreenState getStateInstance() {
        return _state;
    }

    public void setStateInstance(I_ScreenState state) {
        _state = state;
    }


    public void setTransitionView(Class<? extends I_ScreenView> view) {
        _view = view;
    }

    public Class<? extends I_ScreenView> getTransitionView() {
        return _view;
    }

    public int getTransitionCode() {
        return _code;
    }

    public void setTransitionCode(int code) {
        _code = code;
    }

    public boolean isCreatedScreen() {
        return _created;
    }

    public void setCreatedScreen(boolean status) {
        _created = status;
    }

    public boolean isModifiedState() {
        return _modified;
    }

    public void setModifiedState(boolean status) {
        _modified = status;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof MediatorScreen) {
            MediatorScreen screen = (MediatorScreen) obj;
            if (screen.getViewClass().equals(getViewClass())) {
                return true;
            }
        }

        return false;
    }

}
