package com.rakib.covid19bd.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.rakib.covid19bd.model.SummaryCountries;

import java.text.MessageFormat;
import java.util.ArrayList;

import static com.rakib.covid19bd.database.CountriesDbEntries.CountryDbEntry.Country;
import static com.rakib.covid19bd.database.CountriesDbEntries.CountryDbEntry.TABLE_NAME;
import static com.rakib.covid19bd.database.CountriesDbEntries.CountryDbEntry._ID;

public class CountriesDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = CountriesDbHelper.class.getSimpleName();

    /** Name of the database file */
    private static final String DATABASE_NAME = "Countries.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    public CountriesDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_DEVICE_TABLE =  "CREATE TABLE " + CountriesDbEntries.CountryDbEntry.TABLE_NAME + " ("
                + CountriesDbEntries.CountryDbEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + CountriesDbEntries.CountryDbEntry.Country + " TEXT NOT NULL, "
                + CountriesDbEntries.CountryDbEntry.Date + " TEXT NOT NULL, "
                + CountriesDbEntries.CountryDbEntry.NewConfirmed + " INTEGER NOT NULL, "
                + CountriesDbEntries.CountryDbEntry.NewDeaths + " INTEGER NOT NULL,"
                + CountriesDbEntries.CountryDbEntry.NewRecovered + " INTEGER NOT NULL,"
                + CountriesDbEntries.CountryDbEntry.TotalConfirmed + " INTEGER NOT NULL,"
                + CountriesDbEntries.CountryDbEntry.TotalDeaths + " INTEGER NOT NULL,"
                + CountriesDbEntries.CountryDbEntry.TotalRecovered + " INTEGER NOT NULL); ";



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

    public ArrayList<SummaryCountries> findCountry(String Country_name) {
        SQLiteDatabase db = this.getWritableDatabase();
    //String query = MessageFormat.format("SELECT * FROM {0} WHERE {1} = \"{2}\"", DeviceContract.DeviceEntry.TABLE_NAME, DeviceContract.DeviceEntry.DEVICE_ADDRESS, bluetoothID);
    String query = MessageFormat.format("SELECT * FROM {0} WHERE {1} = {2}", CountriesDbEntries.CountryDbEntry.TABLE_NAME, CountriesDbEntries.CountryDbEntry.Country,Country_name);
        Cursor cursor = db.rawQuery(query,null);
        ArrayList<SummaryCountries> summaryCountrieslist = new ArrayList<>();
        if (cursor.getCount()==0){
            return null;
        }
        else {
            while (cursor.moveToNext()) {
                try {
                    summaryCountrieslist.add(new SummaryCountries(
                            cursor.getString(cursor.getColumnIndex(CountriesDbEntries.CountryDbEntry.Country)),
                            cursor.getString(cursor.getColumnIndex(CountriesDbEntries.CountryDbEntry.Date)),
                            cursor.getInt(cursor.getColumnIndex(CountriesDbEntries.CountryDbEntry.NewConfirmed)),
                            cursor.getInt(cursor.getColumnIndex(CountriesDbEntries.CountryDbEntry.NewDeaths)),
                            cursor.getInt(cursor.getColumnIndex(CountriesDbEntries.CountryDbEntry.NewRecovered)),
                            cursor.getInt(cursor.getColumnIndex(CountriesDbEntries.CountryDbEntry.TotalConfirmed)),
                            cursor.getInt(cursor.getColumnIndex(CountriesDbEntries.CountryDbEntry.TotalDeaths)),
                            cursor.getInt(cursor.getColumnIndex(CountriesDbEntries.CountryDbEntry.TotalRecovered))));
               /* tracingList.add(new TracingItem(cursor.getString(cursor.getColumnIndex(DeviceContract.DeviceEntry.DEVICE_ADDRESS)),
                        cursor.getFloat(cursor.getColumnIndex(DeviceContract.DeviceEntry.AVERAGE_RSSI)),
                        cursor.getInt(cursor.getColumnIndex(DeviceContract.DeviceEntry.START_TIME)),
                        cursor.getInt(cursor.getColumnIndex(DeviceContract.DeviceEntry.END_TIME))));*/

                } catch (Exception e) {
                    // nothing
                }
            }
            return summaryCountrieslist;
        }


    }

}
