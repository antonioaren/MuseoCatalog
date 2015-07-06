package es.ulpgc.eite.da.catalog.android.generic.product.database;

import es.ulpgc.eite.da.catalog.android.generic.product.data.ProductData;
import org.droidpersistence.dao.TableDefinition;

public class ProductTable extends TableDefinition<ProductData> {

	public ProductTable() {
		super(ProductData.class);
	}

}
