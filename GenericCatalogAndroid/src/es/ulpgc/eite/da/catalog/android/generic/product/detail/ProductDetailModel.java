package es.ulpgc.eite.da.catalog.android.generic.product.detail;


import es.ulpgc.eite.da.catalog.android.generic.category.data.CategoryData;
import es.ulpgc.eite.da.catalog.android.core.detail.DetailModel;
import es.ulpgc.eite.da.catalog.android.generic.product.data.ProductData;
import es.ulpgc.eite.da.catalog.android.generic.product.database.I_ProductDatabase;

public class ProductDetailModel
extends DetailModel implements I_ProductDetailModel{

    public ProductDetailModel() {
        super(null);
    }

    public ProductDetailModel(ProductData data) {
        super(data);

    }

    @Override
    public I_ProductDatabase getDatabase() {
        return (I_ProductDatabase) getScreenDatabase();
    }

    @Override
    public CategoryData getRelationalData() {
        ProductData _data = (ProductData) getData();
        return getDatabase().getCategory(_data.getParentId());
    }

}
