package com.example.MuseumCatalogAndroid.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.MuseumCatalogAndroid.Cuadros.database.CuadrosTable;
import com.example.MuseumCatalogAndroid.Pintores.database.PintoresTable;

/**
 * Created by PedroAntonio on 13/05/2015.
 */
public class DatabaseMuseumCatalogUtils extends SQLiteOpenHelper{

    public DatabaseMuseumCatalogUtils(Context ctx,
                                     String name, SQLiteDatabase.CursorFactory factory, int ver) {

        super(ctx, name, factory, ver);
    }
    @Override
    //Crear la base de datos
    public void onCreate(SQLiteDatabase db) {
        try {

            PintoresTable pintoresTable = new PintoresTable();
            pintoresTable.onCreate(db);

            CuadrosTable cuadrosTable = new CuadrosTable();
            cuadrosTable.onCreate(db);

        } catch (Exception e) {
        }
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try{
            PintoresTable pintoresTable = new PintoresTable();
            pintoresTable.onUpgrade(db,oldVersion,newVersion);

            CuadrosTable cuadrosTable = new CuadrosTable();
            cuadrosTable.onUpgrade(db,oldVersion,newVersion);


        }catch (Exception e){
        }

    }
}
