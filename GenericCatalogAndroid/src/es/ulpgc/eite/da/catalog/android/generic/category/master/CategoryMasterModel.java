package es.ulpgc.eite.da.catalog.android.generic.category.master;


import es.ulpgc.eite.da.catalog.android.core.master.MasterModel;
import es.ulpgc.eite.da.catalog.android.generic.category.data.CategoryData;
import es.ulpgc.eite.da.catalog.android.generic.category.database.I_CategoryDatabase;
import es.ulpgc.eite.da.catalog.android.generic.database.DatabaseClauseArg;
import es.ulpgc.eite.da.catalog.android.generic.product.data.ProductData;

import java.util.List;

public class CategoryMasterModel
extends MasterModel implements I_CategoryMasterModel {

    public CategoryMasterModel() {
        super();

    }

    private I_CategoryDatabase getDatabase() {
        return (I_CategoryDatabase) getScreenDatabase();
    }


    @Override
    public void addData() {

        CategoryData data = new CategoryData("Category " + (getSize() + 1));
        getDatabase().saveCategory(data);

        debug("addData", "data", data);

        super.addData();

        debug("addData", "collection", getCollection());
    }


    @Override
    public void delData() {

        CategoryData data = getCollection().get(getPosition());
        getDatabase().deleteCategory(data.getId());

        super.delData();
    }

    @Override
    public List<CategoryData> getCollection() {
        return getDatabase().getCategoryList();

    }


    @Override
    public void delCollection() {
        getDatabase().deleteCategoryList();
    }


    @Override
    public List<ProductData> getRelationalCollection(long dataId) {

        DatabaseClauseArg arg = new DatabaseClauseArg(
                "parent_id", "==", "" + dataId);

        List<ProductData> collection = getDatabase().getProductListBy(
                new DatabaseClauseArg[]{arg});
        return collection;

    }


}
