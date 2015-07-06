package es.ulpgc.eite.da.catalog.android.generic.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import es.ulpgc.eite.da.catalog.android.generic.category.database.CategoryTable;
import es.ulpgc.eite.da.catalog.android.generic.product.database.ProductTable;

public class DatabaseGenericCatalogUtils extends SQLiteOpenHelper {


    public DatabaseGenericCatalogUtils(Context ctx,
    String name, CursorFactory factory, int ver) {

        super(ctx, name, factory, ver);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {

            CategoryTable categoryTable = new CategoryTable();
            categoryTable.onCreate(db);
            ProductTable productTable = new ProductTable();
            productTable.onCreate(db);

        } catch (Exception e) {
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        try {

            CategoryTable categoryTable = new CategoryTable();
            categoryTable.onUpgrade(db, oldVer, newVer);
            ProductTable productTable = new ProductTable();
            productTable.onUpgrade(db, oldVer, newVer);

        } catch (Exception e) {
        }

    }

}
