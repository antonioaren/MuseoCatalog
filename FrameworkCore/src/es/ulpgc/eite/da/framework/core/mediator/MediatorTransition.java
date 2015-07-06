package es.ulpgc.eite.da.framework.core.mediator;


import es.ulpgc.eite.da.framework.core.screen.I_ScreenView;

public class MediatorTransition {

    private Class<? extends I_ScreenView> _current;
    private Class<? extends I_ScreenView> _next;
    private int _code;


    public MediatorTransition(Class<? extends I_ScreenView> current,
    Class<? extends I_ScreenView> next, int code) {

        _current = current;
        _next = next;
        _code = code;
    }


    public Class<? extends I_ScreenView> getCurrent() {
        return _current;
    }

    public void setCurrent(Class<? extends I_ScreenView> view) {
        _current = view;
    }

    public Class<? extends I_ScreenView> getNext() {
        return _next;
    }

    public void setNext(Class<? extends I_ScreenView> view) {
        _next = view;
    }

    public int getCode() {
        return _code;
    }

    public void setCode(int code) {
        _code = code;
    }


    @Override
    public boolean equals(Object obj) {

        if(obj instanceof MediatorTransition) {
            MediatorTransition transition = (MediatorTransition) obj;
            if(transition.getCurrent().equals(getCurrent())
            && transition.getNext().equals(getNext())
            && transition.getCode() == getCode()) {

                return true;
            }
        }

        return false;
    }

}
