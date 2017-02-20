package com.challenger.apps.airlines.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Challenger on 2/20/17.
 */

public class StorageDB extends SQLiteOpenHelper implements StorageInterface {

    @Override
    public boolean save(AirlineModel airlineModel) {
        return addAirline(airlineModel) >= 0;
    }

    @Override
    public boolean delete(String code) {
        return deleteAirline(code) >= 0;
    }

    @Override
    public boolean isSaved(String code) {
        return getAirline(code) != null;
    }

    @Override
    public ArrayList<AirlineModel> getFavorites() {
        return getAllAirlines();
    }

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "airplanesDB";

    private static final String TABLE_FAVORITES = "favorites";

    private static final String KEY_CLAZZ = "KEY_CLAZZ";
    private static final String KEY_CODE = "KEY_CODE";
    private static final String KEY_DEFAULT_NAME = "KEY_DEFAULT_NAME";
    private static final String KEY_LOGO_URL = "KEY_LOGO_URL";
    private static final String KEY_NAME = "KEY_NAME";
    private static final String KEY_PHONE = "KEY_PHONE";
    private static final String KEY_SITE = "KEY_SITE";
    private static final String KEY_USERNAME = "KEY_USERNAME";

    public StorageDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_FAVORITES + "("
                + KEY_CLAZZ + " TEXT,"
                + KEY_CODE + " TEXT PRIMARY KEY,"
                + KEY_DEFAULT_NAME + " TEXT,"
                + KEY_LOGO_URL + " TEXT,"
                + KEY_NAME + " TEXT,"
                + KEY_PHONE + " TEXT,"
                + KEY_SITE + " TEXT,"
                + KEY_USERNAME + " TEXT"
                + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FAVORITES);

        // Create tables again
        onCreate(db);
    }

    private long addAirline(AirlineModel airlineModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_CLAZZ, airlineModel.getClazz());
        values.put(KEY_CODE, airlineModel.getCode());
        values.put(KEY_DEFAULT_NAME, airlineModel.getPhone());
        values.put(KEY_LOGO_URL, airlineModel.getLogoURL());
        values.put(KEY_NAME, airlineModel.getName());
        values.put(KEY_PHONE, airlineModel.getPhone());
        values.put(KEY_SITE, airlineModel.getSite());
        values.put(KEY_USERNAME, airlineModel.getUsName());

        // Inserting Row
        long ret = db.insert(TABLE_FAVORITES, null, values);
        db.close(); // Closing database connection

        return ret;
    }

    private AirlineModel getAirline(String code) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_FAVORITES, new String[]{
                        KEY_CLAZZ, KEY_CODE, KEY_DEFAULT_NAME, KEY_LOGO_URL, KEY_NAME, KEY_PHONE, KEY_SITE, KEY_USERNAME},
                KEY_CODE + "=?", new String[]{code}, null, null, null, null);
        if (cursor.getCount() > 0)
            cursor.moveToFirst();
        else
            return null;

        AirlineModel airlineModel = new AirlineModel();
        airlineModel.setClazz(cursor.getString(0));
        airlineModel.setCode(cursor.getString(1));
        airlineModel.setDefaultName(cursor.getString(2));
        airlineModel.setLogoURL(cursor.getString(3));
        airlineModel.setName(cursor.getString(4));
        airlineModel.setPhone(cursor.getString(5));
        airlineModel.setSite(cursor.getString(6));
        airlineModel.setUsName(cursor.getString(7));

        return airlineModel;
    }

    private ArrayList<AirlineModel> getAllAirlines() {
        ArrayList<AirlineModel> airlineList = new ArrayList<AirlineModel>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_FAVORITES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                AirlineModel airlineModel = new AirlineModel();
                airlineModel.setClazz(cursor.getString(0));
                airlineModel.setCode(cursor.getString(1));
                airlineModel.setDefaultName(cursor.getString(2));
                airlineModel.setLogoURL(cursor.getString(3));
                airlineModel.setName(cursor.getString(4));
                airlineModel.setPhone(cursor.getString(5));
                airlineModel.setSite(cursor.getString(6));
                airlineModel.setUsName(cursor.getString(7));

                airlineList.add(airlineModel);
            } while (cursor.moveToNext());
        }

        return airlineList;
    }

    private long deleteAirline(String code) {
        SQLiteDatabase db = this.getReadableDatabase();

        long ret = db.delete(TABLE_FAVORITES, KEY_CODE + " = ?", new String[]{code});
        db.close();
        return ret;
    }

}
