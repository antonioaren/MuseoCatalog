package es.ulpgc.eite.da.catalog.android.generic.product.state;


import es.ulpgc.eite.da.catalog.android.core.state.MasterState;

public class ProductMasterState extends MasterState {

    private long _parentId;

    public ProductMasterState() {
        super();
        setParentId(0L);
    }

    public long getParentId() {
        return _parentId;
    }

    public void setParentId(long id) {
        _parentId = id;
    }

}
