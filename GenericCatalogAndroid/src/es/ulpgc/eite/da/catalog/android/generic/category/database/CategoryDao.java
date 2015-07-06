package es.ulpgc.eite.da.catalog.android.generic.category.database;

import android.database.sqlite.SQLiteDatabase;
import es.ulpgc.eite.da.catalog.android.generic.category.data.CategoryData;
import org.droidpersistence.dao.DroidDao;
import org.droidpersistence.dao.TableDefinition;

public class CategoryDao extends DroidDao<CategoryData, Long> {

	public CategoryDao(TableDefinition<CategoryData> td, SQLiteDatabase db) {

		super(CategoryData.class, td, db);
	}

}
