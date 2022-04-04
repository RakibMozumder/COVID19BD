package com.rakib.covid19bd.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import com.rakib.covid19bd.model.SummaryCountries;

import java.text.MessageFormat;
import java.util.ArrayList;

import static com.rakib.covid19bd.database.CountriesDbEntries.CountryDbEntry.Country;
import static com.rakib.covid19bd.database.CountriesDbEntries.CountryDbEntry.TABLE_NAME;

public class CountrynameDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = CountrynameDbHelper.class.getSimpleName();

    /** Name of the database file */
    private static final String DATABASE_NAME = "Countryname.db";
    private final static String TABLE_NAME = "countryname";
    private final static String ID = "ID";
    private final static String Country= "Country";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    public CountrynameDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_DEVICE_TABLE =  "CREATE TABLE " + TABLE_NAME + " ("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + Country + " TEXT NOT NULL); ";



        // Execute the SQL statement
        db.execSQL(SQL_CREATE_DEVICE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }

    public boolean insertData(String name){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Country,name);
        long result=sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if (result==-1){
            return false;
        }
        else {
            return true;
        }

    }

    public ArrayList<String> findCountry(String Country_name) {
        SQLiteDatabase db = this.getWritableDatabase();
    //String query = MessageFormat.format("SELECT * FROM {0} WHERE {1} = \"{2}\"", DeviceContract.DeviceEntry.TABLE_NAME, DeviceContract.DeviceEntry.DEVICE_ADDRESS, bluetoothID);
    String query = MessageFormat.format("SELECT * FROM {0} WHERE {1} = {2}", TABLE_NAME, Country,Country_name);
        Cursor cursor = db.rawQuery(query,null);
        ArrayList<String> countrynamelist = new ArrayList<>();
        if (cursor.getCount()==0){
            return null;
        }
        else {
            while (cursor.moveToNext()) {
                try {
                    countrynamelist.add(cursor.getString(cursor.getColumnIndex(Country)));
               /* tracingList.add(new TracingItem(cursor.getString(cursor.getColumnIndex(DeviceContract.DeviceEntry.DEVICE_ADDRESS)),
                        cursor.getFloat(cursor.getColumnIndex(DeviceContract.DeviceEntry.AVERAGE_RSSI)),
                        cursor.getInt(cursor.getColumnIndex(DeviceContract.DeviceEntry.START_TIME)),
                        cursor.getInt(cursor.getColumnIndex(DeviceContract.DeviceEntry.END_TIME))));*/

                } catch (Exception e) {
                    // nothing
                }
            }
            return countrynamelist;
        }


    }

}
