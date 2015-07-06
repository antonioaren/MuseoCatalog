package es.ulpgc.eite.da.catalog.android.generic.product.database;

import android.database.sqlite.SQLiteDatabase;
import es.ulpgc.eite.da.catalog.android.generic.product.data.ProductData;
import org.droidpersistence.dao.DroidDao;
import org.droidpersistence.dao.TableDefinition;

public class ProductDao extends DroidDao<ProductData, Long> {

	public ProductDao(TableDefinition<ProductData> td, SQLiteDatabase db) {

		super(ProductData.class, td, db);
	}

}
