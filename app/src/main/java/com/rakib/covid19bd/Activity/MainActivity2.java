package com.rakib.covid19bd.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.rakib.covid19bd.R;
import com.rakib.covid19bd.adapter.HttpHandler;
import com.rakib.covid19bd.adapter.SummaryCountriesAdapter;
import com.rakib.covid19bd.model.SummaryCountries;
import com.rakib.covid19bd.model.SummaryWorld;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity2 extends AppCompatActivity {
    //BottomNavigationView navView = findViewById(R.id.nav_view);
    //private TextView summaryWorldTodayTextView,summaryBDTodayTextView;//open
    //private TextView newConfirmedtv, newDeathstv, newRecoveredtv, totalConfirmedtv, totalDeathstv, totalRecoveredtv, summaryglobaltodaytv;
    // private ProgressDialog pDialog;
    // private ListView lv;

    // URL to get contacts JSON
    //private static String url = "https://api.covid19api.com/summary/";
    //private SummaryLoader list;

    // private ProgressDialog pDialog;
    // private ListView lv;

    //private String TAG = MainActivity.class.getSimpleName();
    ArrayList<HashMap<String,String>> contactList;
    ArrayList<SummaryCountries> summarycountrieslist;
    SummaryCountriesAdapter summarycountriesadapter;
    ListView countrylistView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);




        /*summaryWorldTodayTextView=findViewById(R.id.summaryWorldTodayId);
        summaryBDTodayTextView=findViewById(R.id.summaryBdTodayId);*///open

        //list = new SummaryLoader(MainActivity.this, url);
        //list.loadInBackground();
        //new SummaryAdapter(MainActivity.this, (List<Summary>) list);
   /*   newConfirmedtv.setText(newConfirmed);
        newDeathstv.setText(newDeaths);
        newConfirmedtv.setText(newRecovered);
        totalConfirmedtv.setText(totalConfirmed);
        totalDeathstv.setText(totalDeaths);
        totalRecoveredtv.setText(totalRecovered);*/
        contactList = new ArrayList<>();
        countrylistView = (ListView) findViewById(R.id.countrylistViewId);
        summarycountrieslist =new ArrayList<>();//open


        /*summaryWorldTodayTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,GlobalSummaryActivity.class);
                startActivity(intent);
            }
        });*///open


         new GetContacts().execute();

    }

    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            Toast.makeText(MainActivity2.this,"Json Data is downloading",Toast.LENGTH_LONG).show();

        }


        @Override
        protected Void doInBackground(Void... arg0) {
            String url = "https://api.covid19api.com/summary";
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);
            //Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                     String globalsummary, date,countryname;
                     int newConfirmed, totalConfirmed, newDeaths, totalDeaths, newRecovered, totalRecovered;

                    JSONObject jsonObj = new JSONObject(jsonStr);
                    JSONArray jsonObjSummariesCountries= jsonObj.getJSONArray("Countries");
                    for (int i = 0; i < jsonObjSummariesCountries.length(); i++) {
                        JSONObject jsonObjSummariesCountry =jsonObjSummariesCountries.getJSONObject(i);
                        // name = jsonObjSummariesGlobal.getString("Country");
                        countryname = jsonObjSummariesCountry.getString("Country");
                        date = jsonObjSummariesCountry.getString("Date");
                        newConfirmed = jsonObjSummariesCountry.getInt("NewConfirmed");
                        newDeaths = jsonObjSummariesCountry.getInt("NewDeaths");
                        newRecovered = jsonObjSummariesCountry.getInt("NewRecovered");
                        totalRecovered = jsonObjSummariesCountry.getInt("TotalRecovered");
                        totalDeaths = jsonObjSummariesCountry.getInt("TotalDeaths");
                        totalConfirmed = jsonObjSummariesCountry.getInt("TotalConfirmed");


                        //SummaryCountries summary = new SummaryWorld(countryname,date, String.valueOf(newConfirmed), String.valueOf(newDeaths), String.valueOf(newRecovered), String.valueOf(totalConfirmed), String.valueOf(totalDeaths), String.valueOf(totalRecovered));
                        SummaryCountries summary = new SummaryCountries(countryname,date, newConfirmed,newDeaths, newRecovered, totalConfirmed, totalDeaths, totalRecovered);
                        summarycountrieslist.add(summary);
                    }


                        // tmp hash map for single contact

                      //  HashMap<String, String> contact = new HashMap<>();
                        // adding each child node to HashMap key => value
                       // contact.put("newConfirmed", String.valueOf(newConfirmed));
                       // contact.put("newDeaths", String.valueOf(newDeaths));
                       /* contact.put("newRecovered", newRecovered);
                        contact.put("totalRecovered", totalRecovered);
                        contact.put("totalDeaths", totalDeaths );
                        contact.put("totalConfirmed", totalConfirmed);*/
                        // adding contact to contact list
                        //contactList.add(contact);

                            //onProgressUpdate();



                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "222",
                                    Toast.LENGTH_LONG).show();
                        }
                    });





                } catch ( final JSONException e) {
                    //Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });

                }

            }else {
                //Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            summarycountriesadapter=new SummaryCountriesAdapter(getApplicationContext(),summarycountrieslist);
            countrylistView.setAdapter(summarycountriesadapter);

            Toast.makeText(getApplicationContext(),"g",Toast.LENGTH_LONG).show();


            //adapter.notify();
            //adapter.notifyDataSetChanged();
            //populateUI(getApplicationContext());
        }


    }


}