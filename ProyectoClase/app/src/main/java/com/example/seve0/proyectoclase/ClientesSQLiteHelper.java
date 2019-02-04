package com.example.seve0.proyectoclase;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class ClientesSQLiteHelper extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "user_database";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_USER = "users";
    private static final String TABLE_USER_MUSICA = "users_musica";
    private static final String TABLE_USER_CITY = "users_city";
    private static final String KEY_ID = "id";
    private static final String KEY_FIRSTNAME = "name";
    private static final String KEY_MUSICA = "musica";
    private static final String KEY_CITY = "city";

    /*CREATE TABLE students ( id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, phone_number TEXT......);*/

    private static final String CREATE_TABLE_STUDENTS = "CREATE TABLE "  + TABLE_USER + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_FIRSTNAME + " TEXT );";

    private static final String CREATE_TABLE_USER_MUSICA = "CREATE TABLE " + TABLE_USER_MUSICA + "(" + KEY_ID
            + " INTEGER,"+ KEY_MUSICA + " TEXT );";

    private static final String CREATE_TABLE_USER_CITY = "CREATE TABLE "  + TABLE_USER_CITY + "(" + KEY_ID
            + " INTEGER,"+ KEY_CITY + " TEXT );";

    public ClientesSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        Log.d("table", CREATE_TABLE_STUDENTS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_STUDENTS);
        db.execSQL(CREATE_TABLE_USER_MUSICA);
        db.execSQL(CREATE_TABLE_USER_CITY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_USER + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_USER_MUSICA + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_USER_CITY + "'");
        onCreate(db);
    }

    public void addUser(String name, String musica, String city) {
        SQLiteDatabase db = this.getWritableDatabase();
       
        ContentValues valores = new ContentValues();
        valores.put(KEY_FIRSTNAME, name);
      
        long id = db.insertWithOnConflict(TABLE_USER, null, valores, SQLiteDatabase.CONFLICT_IGNORE);



        ContentValues valoresMusica = new ContentValues();
        valoresMusica.put(KEY_ID, id);
        valoresMusica.put(KEY_MUSICA, musica);
        db.insert(TABLE_USER_MUSICA, null, valoresMusica);

       
        ContentValues valoresCiudad = new ContentValues();
        valoresCiudad.put(KEY_ID, id);
        valoresCiudad.put(KEY_CITY, city);
        db.insert(TABLE_USER_CITY, null, valoresCiudad);
    }

    public ArrayList<ModeloUsuario> getAllUsers() {
        ArrayList<ModeloUsuario> userModelArrayList = new ArrayList<ModeloUsuario>();

        String selectQuery = "SELECT  * FROM " + TABLE_USER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
       
        if (c.moveToFirst()) {
            do {
                ModeloUsuario modeloUsuario = new ModeloUsuario();
                modeloUsuario.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                modeloUsuario.setName(c.getString(c.getColumnIndex(KEY_FIRSTNAME)));

              
                String selectMusicaQuery = "SELECT  * FROM " + TABLE_USER_MUSICA +" WHERE "+KEY_ID+" = "+ modeloUsuario.getId();
                Log.d("",selectMusicaQuery);
               
                Cursor cMusica = db.rawQuery(selectMusicaQuery, null);

                if (cMusica.moveToFirst()) {
                    do {
                        modeloUsuario.setMusica(cMusica.getString(cMusica.getColumnIndex(KEY_MUSICA)));
                    } while (cMusica.moveToNext());
                }
                
                String selectCityQuery = "SELECT  * FROM " + TABLE_USER_CITY+" WHERE "+KEY_ID+" = "+ modeloUsuario.getId();;
              
                Cursor cCity = db.rawQuery(selectCityQuery, null);

                if (cCity.moveToFirst()) {
                    do {
                        modeloUsuario.setCity(cCity.getString(cCity.getColumnIndex(KEY_CITY)));
                    } while (cCity.moveToNext());
                }

                
                userModelArrayList.add(modeloUsuario);
            } while (c.moveToNext());
        }
        return userModelArrayList;
    }

    public void updateUser(int id, String name, String musica, String city) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FIRSTNAME, name);
        db.update(TABLE_USER, values, KEY_ID + " = ?", new String[]{String.valueOf(id)});

        ContentValues valuesMusica = new ContentValues();
        valuesMusica.put(KEY_MUSICA, musica);
        db.update(TABLE_USER_MUSICA, valuesMusica, KEY_ID + " = ?", new String[]{String.valueOf(id)});

        ContentValues valuesCiudad = new ContentValues();
        valuesCiudad.put(KEY_CITY, city);
        db.update(TABLE_USER_CITY, valuesCiudad, KEY_ID + "= ?", new String[]{String.valueOf(id)});
    }

    public void deleteUSer(int id) {

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_USER, KEY_ID + "= ?", new String[]{String.valueOf(id)});

        db.delete(TABLE_USER_MUSICA, KEY_ID + "= ?", new String[]{String.valueOf(id)});

        db.delete(TABLE_USER_CITY, KEY_ID +"= ?", new String[]{String.valueOf(id)});

    }

}
