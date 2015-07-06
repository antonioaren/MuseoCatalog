package es.ulpgc.eite.da.catalog.android.generic.database;

import android.database.sqlite.SQLiteDatabase;
import android.os.SystemClock;
import es.ulpgc.eite.da.catalog.android.generic.R;
import es.ulpgc.eite.da.catalog.android.generic.category.data.CategoryData;
import es.ulpgc.eite.da.catalog.android.generic.category.database.CategoryDao;
import es.ulpgc.eite.da.catalog.android.generic.category.database.CategoryTable;
import es.ulpgc.eite.da.catalog.android.generic.category.database.I_CategoryDatabase;
import es.ulpgc.eite.da.catalog.android.generic.product.data.ProductData;
import es.ulpgc.eite.da.catalog.android.generic.product.database.I_ProductDatabase;
import es.ulpgc.eite.da.catalog.android.generic.product.database.ProductDao;
import es.ulpgc.eite.da.catalog.android.generic.product.database.ProductTable;
import es.ulpgc.eite.da.framework.android.AndroidScreenDatabase;
import es.ulpgc.eite.da.framework.android.I_AndroidMediator;

import java.util.List;

public class DatabaseGenericCatalog extends AndroidScreenDatabase
implements I_CategoryDatabase, I_ProductDatabase {


    private final static int DB_VERSION = 10;
    public static final int CATALOG_NAME = R.string.app_generic_catalog;

    private DatabaseGenericCatalogUtils dbUtils;
	private SQLiteDatabase database;
	private CategoryDao categoryDao;
	private ProductDao productDao;



    @Override
    public void configDatabase() {

        String dbname=getPlatformMediator().getNormalizedResource(CATALOG_NAME);

        dbUtils = new DatabaseGenericCatalogUtils(
                getPlatformMediator().getContext(), dbname, null, DB_VERSION);
        setDatabase(dbUtils.getWritableDatabase());

        categoryDao = new CategoryDao(new CategoryTable(), database);
        productDao = new ProductDao(new ProductTable(), database);
    }


    private I_AndroidMediator getPlatformMediator() {
        return (I_AndroidMediator) getMediator();
    }

	private void openDatabase(){
		if(! getDatabase().isOpen()){

            setDatabase(dbUtils.getWritableDatabase());
		}
	}
	
	private void closeDatabase() {
		if (getDatabase().isOpen()) {
			getDatabase().close();
	    }
	}

	private void resetDatabase() {
		closeDatabase();
	    SystemClock.sleep(500);
	    openDatabase();
	}



    private SQLiteDatabase getDatabase() {
   		return database;
   	}

   	private void setDatabase(SQLiteDatabase db) {
   		database = db;
   	}

   	private CategoryDao getCategoryDao() {
   		return categoryDao;
   	}

       private void setCategoryDao(CategoryDao dao) {
   		categoryDao = dao;
   	}

   	private ProductDao getProductDao() {
   		return productDao;
   	}

   	private void setProductDao(ProductDao dao) {
   		productDao = dao;
   	}


    @Override
	public CategoryData getCategory(Long dataId) {
		return getCategoryDao().get(dataId);
	}

    @Override
	public ProductData getProduct(Long dataId){
		return getProductDao().get(dataId);
	}

    @Override
    public CategoryData getCategoryBy(DatabaseClauseArg[] args){

        String clause = " ";
        for (int index=0; index < args.length-1; index++) {
            DatabaseClauseArg arg = args[index];
            clause += arg.key + " "  + arg.cond + " '" + arg.val + "'";
            clause += " AND ";
        }

        DatabaseClauseArg arg = args[args.length-1];
        clause += arg.key + " "  + arg.cond + " '" + arg.val + "'";

        return getCategoryDao().getByClause(clause, null);
   	}

    @Override
    public ProductData getProductBy(DatabaseClauseArg[] args){

        String clause = " ";
        for (int index=0; index < args.length-1; index++) {
            DatabaseClauseArg arg = args[index];
            clause += arg.key + " "  + arg.cond + " '" + arg.val + "'";
            clause += " AND ";
        }

        DatabaseClauseArg arg = args[args.length-1];
        clause += arg.key + " "  + arg.cond + " '" + arg.val +"'";

        return getProductDao().getByClause(clause, null);
   	}


    @Override
    public List<CategoryData> getCategoryListBy(DatabaseClauseArg[] args){

        String clause = " ";
        for (int index=0; index < args.length-1; index++) {
            DatabaseClauseArg arg = args[index];
            clause += arg.key + " "  + arg.cond + " '" + arg.val + "'";
            clause += " AND ";
        }

        DatabaseClauseArg arg = args[args.length-1];
        clause += arg.key + " "  + arg.cond + " '" + arg.val + "'";

        return getCategoryDao().getAllbyClause(clause, null, null, null, "id");
   	}


    @Override
    public List<ProductData> getProductListBy(DatabaseClauseArg[] args){

        String clause = " ";
        for (int index=0; index < args.length-1; index++) {
            DatabaseClauseArg arg = args[index];
            clause += arg.key + " "  + arg.cond + " '" + arg.val + "'";
            clause += " AND ";
        }

        DatabaseClauseArg arg = args[args.length-1];
        clause += arg.key + " "  + arg.cond + " '" + arg.val + "'";

        return getProductDao().getAllbyClause(clause,
                null, null, null, "id");
   	}

    @Override
	public List<CategoryData> getCategoryList(){
        return getCategoryDao().getAllbyClause(null, null, null, null, "id");
	}

    @Override
	public List<ProductData> getProductList(){

        return getProductDao().getAllbyClause(null, null, null, null, "id");
	}	


    @Override
	public boolean deleteCategory(Long dataId){
        debug("deleteCategory");

		getDatabase().beginTransaction();
        boolean result = getCategoryDao().delete(dataId);
		getDatabase().setTransactionSuccessful();
		getDatabase().endTransaction();
		return result;
	}

    @Override
    public boolean deleteCategoryList(){

        int size = getCategoryList().size();
   		getDatabase().beginTransaction();
        int result = getDatabase().delete(
                getCategoryDao().getTableName(), "1", null);
   		getDatabase().setTransactionSuccessful();
   		getDatabase().endTransaction();

        if(result == size) {
            return true;
        } else {
            return false;
        }
   	}
    
    
    @Override
    public boolean deleteProductList(){
        int size = getProductList().size();
   		getDatabase().beginTransaction();
        int result = getDatabase().delete(
                getProductDao().getTableName(), "1", null);
   		getDatabase().setTransactionSuccessful();
   		getDatabase().endTransaction();

        if(result == size) {
            return true;
        } else {
            return false;
        }
   	}

    @Override
	public boolean deleteProduct(Long dataId){
		getDatabase().beginTransaction();
        boolean result = getProductDao().delete(dataId);
		getDatabase().setTransactionSuccessful();
		getDatabase().endTransaction();
		return result;
	}

    @Override
	public Long saveCategory(CategoryData data){

        debug("saveCategory");

        long result = 0;
		try {

			getDatabase().beginTransaction();
			result = getCategoryDao().save(data);
			getDatabase().setTransactionSuccessful();

		} catch (Exception ex) {
            debug("saveCategory", "error", ex.toString());
		}
		getDatabase().endTransaction();
		return result;
	}

    @Override
	public Long saveProduct(ProductData data){

        debug("saveProduct");

        debug("saveProduct", "id", data.getId());
        debug("saveProduct", "dataId", data.getParentId());

		long result = 0;
		try {

			getDatabase().beginTransaction();
			result = getProductDao().save(data);
			getDatabase().setTransactionSuccessful();

		} catch (Exception ex) {
            debug("saveProduct", "error", ex.toString());
		}
		getDatabase().endTransaction();


		return result;
	}

    @Override
    public boolean updateCategory(CategoryData data) {
        boolean result = false;
        try {

            getDatabase().beginTransaction();
            getCategoryDao().update(data, data.getId());
            getDatabase().setTransactionSuccessful();
            result = true;

        } catch (Exception e) {

        }
        getDatabase().endTransaction();
        return result;
    }

    @Override
    public boolean updateProduct(ProductData data) {
        boolean result = false;
        try {

            getDatabase().beginTransaction();
            getProductDao().update(data, data.getId());
            getDatabase().setTransactionSuccessful();
            result = true;

        } catch (Exception e) {

        }
        getDatabase().endTransaction();
        return result;
    }



}
