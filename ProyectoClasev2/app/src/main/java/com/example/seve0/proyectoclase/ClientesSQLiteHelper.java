package com.example.seve0.proyectoclase;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Handler para todas las consultas de SQLite, proporciona los métodos necesarios para
 * la creación de las tablas así como los métodos necesarios para las funciones CRUD
 */

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
    private static final String KEY_GUSTOS_ID = "gustosid";


    /*
    Declaración de las sentencias SQL para la creación de tablas necesarias
     */
    private static final String CREATE_TABLE_USERS = "CREATE TABLE "  + TABLE_USER + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_FIRSTNAME + " TEXT, " + KEY_GUSTOS_ID + "INTEGER NOT NULL REFERENCES "   + TABLE_USER_MUSICA + "( " + KEY_MUSICA + ")) ;" ;


    private static final String CREATE_TABLE_USER_MUSICA = "CREATE TABLE " + TABLE_USER_MUSICA + "(" + KEY_ID
            + " INTEGER,"+ KEY_MUSICA + " TEXT );";

    private static final String CREATE_TABLE_USER_CITY = "CREATE TABLE "  + TABLE_USER_CITY + "(" + KEY_ID
            + " INTEGER,"+ KEY_CITY + " TEXT );";


    public ClientesSQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("table", CREATE_TABLE_USERS);
    }


    /**
     * Método que se ejecuta en la apertura de la BBDD
     * @param db Base de datos
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
        db.execSQL(CREATE_TABLE_USER_MUSICA);
        db.execSQL(CREATE_TABLE_USER_CITY);
    }

    /**
     * Método que se ejecuta cuando la BBDD necesita ser actualizada (su versión es inferior a la
     * actual)
     * @param db Base de datos
     * @param oldVersion Versión antigua de la BBDD
     * @param newVersion Nueva versión de la BBDD
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_USER + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_USER_MUSICA + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + TABLE_USER_CITY + "'");
        onCreate(db);
    }

    /**
     * Método para añadir nuevas entradas a la BBDD
     * @param name nombre a introducir en la BBDD
     * @param musica género musical asociado a name
     * @param city ciudad asociada a name
     */
    public void addUser(String name, String musica, String city) {
        //Obtención de la base de datos para realizar cambios
        SQLiteDatabase db = this.getWritableDatabase();

        //Creación e inserción del objeto a introducir en la tabla de usuarios
        ContentValues valores = new ContentValues();
        valores.put(KEY_FIRSTNAME, name);

        // Devuelve la id de la entrada o -1 en caso de conflicto
        long id = db.insertWithOnConflict(TABLE_USER, null, valores, SQLiteDatabase.CONFLICT_IGNORE);

        //Creación e inserción de los objetos a introducir en las tablas de música y ciudades
        ContentValues valoresMusica = new ContentValues();
        valoresMusica.put(KEY_ID, id);
        valoresMusica.put(KEY_MUSICA, musica);
        db.insert(TABLE_USER_MUSICA, null, valoresMusica);

       
        ContentValues valoresCiudad = new ContentValues();
        valoresCiudad.put(KEY_ID, id);
        valoresCiudad.put(KEY_CITY, city);
        db.insert(TABLE_USER_CITY, null, valoresCiudad);
    }

    /**
     * Método para devolver todos los usuarios de la BBDD
     * @return Objeto tipo ArrayList con todos los usuarios de la BBDD
     */
    public ArrayList<ModeloUsuario> getAllUsers() {
        ArrayList<ModeloUsuario> userModelArrayList = new ArrayList<ModeloUsuario>();

        // SELECT * FROM USERS
        String selectQuery = "SELECT  * FROM " + TABLE_USER;
        SQLiteDatabase db = this.getReadableDatabase();
        // Objeto tipo cursor que marca al resultado de la query
        Cursor c = db.rawQuery(selectQuery, null);

        /* Si la tabla no está vacía, entra en el bloque de
           obtención de usuarios para llenar el ArrayList
         */
        if (c.moveToFirst()) {
            do {
                // Creación del objeto usuario tipo y su ID y nombre de la tabla USERS
                ModeloUsuario modeloUsuario = new ModeloUsuario();
                modeloUsuario.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                modeloUsuario.setName(c.getString(c.getColumnIndex(KEY_FIRSTNAME)));

                // SELECT * FROM USERS_MUSICA selecciona el género musical correspondiente al usuario
                String selectMusicaQuery = "SELECT  * FROM " + TABLE_USER_MUSICA +" WHERE "+KEY_ID+" = "+ modeloUsuario.getId();
                Log.d("",selectMusicaQuery);
                // Objeto tipo cursor que marca al resultado de la query
                Cursor cMusica = db.rawQuery(selectMusicaQuery, null);

                //Si hay una entrada de música, se introduce en el objeto modelousuario
                if (cMusica.moveToFirst()) {
                    modeloUsuario.setMusica(cMusica.getString(cMusica.getColumnIndex(KEY_MUSICA)));
                }

                // SELECT * FROM USERS_CITY selecciona la ciudad correspondiente al usuario
                String selectCityQuery = "SELECT  * FROM " + TABLE_USER_CITY+" WHERE "+KEY_ID+" = "+ modeloUsuario.getId();;
              
                Cursor cCity = db.rawQuery(selectCityQuery, null);

                //Si hay una entrada, se introduce en el objeto modelousuario
                if (cCity.moveToFirst()) {
                        modeloUsuario.setCity(cCity.getString(cCity.getColumnIndex(KEY_CITY)));
                }

                
                userModelArrayList.add(modeloUsuario);
            } while (c.moveToNext());
        }
        return userModelArrayList;
    }

    /**
     * Actualiza el usuario con los datos necesarios
     * @param id ID de la entrada a actualizar
     * @param name nuevo nombre de la entrada
     * @param musica nuevo género musical de la entrada
     * @param city nueva ciudad de la entrada
     */
    public void updateUser(int id, String name, String musica, String city) {

        SQLiteDatabase db = this.getWritableDatabase();

        //Actualización del nombre
        ContentValues values = new ContentValues();
        values.put(KEY_FIRSTNAME, name);
        db.update(TABLE_USER, values, KEY_ID + " = ?", new String[]{String.valueOf(id)});

        //Actualización del género musical
        ContentValues valuesMusica = new ContentValues();
        valuesMusica.put(KEY_MUSICA, musica);
        db.update(TABLE_USER_MUSICA, valuesMusica, KEY_ID + " = ?", new String[]{String.valueOf(id)});

        //Actualización de la ciudad
        ContentValues valuesCiudad = new ContentValues();
        valuesCiudad.put(KEY_CITY, city);
        db.update(TABLE_USER_CITY, valuesCiudad, KEY_ID + "= ?", new String[]{String.valueOf(id)});
    }

    /**
     * Método para el borrado de usuarios
     * @param id ID del usuario a borrar
     */
    public void deleteUSer(int id) {

        SQLiteDatabase db = this.getWritableDatabase();

        //Borrado de la tabla de usuarios
        db.delete(TABLE_USER, KEY_ID + "= ?", new String[]{String.valueOf(id)});

        //Borrado de la tabla de géneros musicales
        db.delete(TABLE_USER_MUSICA, KEY_ID + "= ?", new String[]{String.valueOf(id)});

        //Borrado de la tabla de ciudades
        db.delete(TABLE_USER_CITY, KEY_ID +"= ?", new String[]{String.valueOf(id)});

    }

}
