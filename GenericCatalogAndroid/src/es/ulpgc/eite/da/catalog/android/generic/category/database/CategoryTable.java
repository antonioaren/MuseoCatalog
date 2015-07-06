package es.ulpgc.eite.da.catalog.android.generic.category.database;

import es.ulpgc.eite.da.catalog.android.generic.category.data.CategoryData;
import org.droidpersistence.dao.TableDefinition;

public class CategoryTable extends TableDefinition<CategoryData> {

	public CategoryTable() {
		super(CategoryData.class);
	}


}
