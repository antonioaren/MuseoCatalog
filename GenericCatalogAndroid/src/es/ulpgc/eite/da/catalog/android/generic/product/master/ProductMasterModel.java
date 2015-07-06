package es.ulpgc.eite.da.catalog.android.generic.product.master;


import es.ulpgc.eite.da.catalog.android.core.master.MasterModel;
import es.ulpgc.eite.da.catalog.android.generic.category.data.CategoryData;
import es.ulpgc.eite.da.catalog.android.generic.database.DatabaseClauseArg;
import es.ulpgc.eite.da.catalog.android.generic.product.data.ProductData;
import es.ulpgc.eite.da.catalog.android.generic.product.database.I_ProductDatabase;

import java.util.List;

public class ProductMasterModel
extends MasterModel implements I_ProductMasterModel {

    private long _parentId;


    public ProductMasterModel() {
        super();
        setParentId(0L);
    }

    private I_ProductDatabase getDatabase() {
        return (I_ProductDatabase) getScreenDatabase();
    }

    @Override
    public void addData() {

        ProductData _data = new ProductData("Product " + (getSize() + 1));
        _data.setParentId(getParentId());
        getDatabase().saveProduct(_data);

        super.addData();
    }


    @Override
    public void delData() {

        debug("delData");
        getDatabase().deleteProduct(
                getCollection().get(getPosition()).getId());

        super.delData();
    }

    @Override
    public List<ProductData> getCollection() {

        debug("getCollection", "parentId", getParentId());

        DatabaseClauseArg arg = new DatabaseClauseArg(
                "parent_id", "==", "" + getParentId());

        List<ProductData> collection = getDatabase().getProductListBy(
                new DatabaseClauseArg[]{arg});
        debug("getCollection", "collection", collection);
        debug("getCollection", "database", getDatabase().getProductList());
        return collection;

    }

    @Override
    public void delCollection() { //todo

        for(ProductData data: getCollection()) {
            getDatabase().deleteProduct(data.getId());
        }

    }



    @Override
    public long getParentId() {
        return _parentId;
    }

    @Override
    public void setParentId(long id) {
        _parentId = id;
    }

    @Override
    public CategoryData getRelationalData() {
        debug("getRelationalData", "parent", getParentId());
        return getDatabase().getCategory(getParentId());
    }

}
