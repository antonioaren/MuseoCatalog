package es.ulpgc.eite.da.catalog.android.generic.category.database;


import es.ulpgc.eite.da.catalog.android.generic.category.data.CategoryData;
import es.ulpgc.eite.da.catalog.android.generic.database.DatabaseClauseArg;
import es.ulpgc.eite.da.catalog.android.generic.product.data.ProductData;

import java.util.List;

public interface I_CategoryDatabase {

    public CategoryData getCategory(Long dataId);
    public CategoryData getCategoryBy(DatabaseClauseArg[] args);
    public List<CategoryData> getCategoryListBy(DatabaseClauseArg[] args);
    public List<CategoryData> getCategoryList();
    public boolean deleteCategory(Long dataId);
    public boolean deleteCategoryList();
    public Long saveCategory(CategoryData data);
    public boolean updateCategory(CategoryData data);

    public List<ProductData> getProductListBy(DatabaseClauseArg[] args);

}
