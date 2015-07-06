package es.ulpgc.eite.da.catalog.android.generic.product.database;


import es.ulpgc.eite.da.catalog.android.generic.category.data.CategoryData;
import es.ulpgc.eite.da.catalog.android.generic.database.DatabaseClauseArg;
import es.ulpgc.eite.da.catalog.android.generic.product.data.ProductData;

import java.util.List;

public interface I_ProductDatabase {

    public ProductData getProduct(Long dataId);
    public ProductData getProductBy(DatabaseClauseArg[] args);
    public List<ProductData> getProductListBy(DatabaseClauseArg[] args);
    public List<ProductData> getProductList();
    public boolean deleteProduct(Long dataId);
    public boolean deleteProductList();
    public Long saveProduct(ProductData data);
    public boolean updateProduct(ProductData data);

    public CategoryData getCategory(Long dataId);

}
