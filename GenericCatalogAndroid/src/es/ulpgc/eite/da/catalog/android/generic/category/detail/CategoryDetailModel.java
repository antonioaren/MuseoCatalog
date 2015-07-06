package es.ulpgc.eite.da.catalog.android.generic.category.detail;


import es.ulpgc.eite.da.catalog.android.core.detail.DetailModel;
import es.ulpgc.eite.da.catalog.android.generic.category.data.CategoryData;
import es.ulpgc.eite.da.catalog.android.generic.category.database.I_CategoryDatabase;
import es.ulpgc.eite.da.catalog.android.generic.database.DatabaseClauseArg;
import es.ulpgc.eite.da.catalog.android.generic.product.data.ProductData;

import java.util.List;

public class CategoryDetailModel
extends DetailModel implements I_CategoryDetailModel {

    public CategoryDetailModel() {
        super(null);
    }

    public CategoryDetailModel(CategoryData data) {
        super(data);
    }

    @Override
    public I_CategoryDatabase getDatabase() {
        return (I_CategoryDatabase) getScreenDatabase();
    }


    @Override
    public List<ProductData> getRelationalCollection() {

        DatabaseClauseArg arg = new DatabaseClauseArg(
                "parent_id", "==", "" + getData().getId());

        List<ProductData> collection = getDatabase().getProductListBy(
                new DatabaseClauseArg[]{arg});

        return collection;

    }

}
