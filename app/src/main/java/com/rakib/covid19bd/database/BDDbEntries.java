package com.rakib.covid19bd.database;

import android.provider.BaseColumns;

public final class BDDbEntries {
    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private BDDbEntries() {}

    public static final class CountryDbEntry implements BaseColumns {
        // Name of database table that will store bluetooth device contacts.
        public final static String TABLE_NAME = "bangladesh_today";

        public final static String _ID = BaseColumns._ID;

        public final static String Country= "Country";

        public final static String Date= "Date";

        public final static String NewConfirmed ="NewConfirmed";

        public final static String NewDeaths ="NewDeaths";

        public final static String NewRecovered ="NewRecovered";

        public final static String TotalConfirmed ="TotalConfirmed";

        public final static String TotalDeaths ="TotalDeaths";

        public final static String TotalRecovered ="TotalRecovered";
    }
}
