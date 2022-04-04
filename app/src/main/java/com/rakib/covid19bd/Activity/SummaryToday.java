package com.rakib.covid19bd.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.rakib.covid19bd.R;
import com.rakib.covid19bd.adapter.HttpHandler;

import org.json.JSONException;
import org.json.JSONObject;

public class SummaryToday extends AppCompatActivity {
    //private TextView newConfirmedtv,newDeathstv,newRecoveredtv,totalConfirmedtv,totalDeathstv,totalRecoveredtv,summaryglobaltodaytv;

    //private String globalsummary,date="";
    //private int newConfirmed, totalConfirmed, newDeaths, totalDeaths, newRecovered,totalRecovered=0;
    //private static String url = "https://api.covid19api.com/summary";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_today);

        Toast.makeText(getApplicationContext(), "before ok", Toast.LENGTH_LONG).show();

        Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_LONG).show();
    }
}
/*
package com.rakib.covid19bd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.text.PrecomputedTextCompat;

import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.textclassifier.ConversationActions;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.rakib.covid19bd.adapter.HttpHandler;
import com.rakib.covid19bd.updates.SummaryAdapter;
import com.rakib.covid19bd.adapter.SummaryLoader;
import com.rakib.covid19bd.updates.data.Summary;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

import static androidx.constraintlayout.widget.StateSet.TAG;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private TextView newConfirmedtv,newDeathstv,newRecoveredtv,totalConfirmedtv,totalDeathstv,totalRecoveredtv,summaryglobaltodaytv;
    String globalsummary, date = null;
    int newConfirmed, totalConfirmed,newDeaths, totalDeaths, newRecovered , totalRecovered ;



    // private ProgressDialog pDialog;
   // private ListView lv;

    // URL to get contacts JSON
    private  static  String url = "https://api.covid19api.com/summary/";
    private SummaryLoader list;


    // private ArrayList<Summary> listSummaries = new ArrayList<>();

    //ArrayList<HashMap<String, String>> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
        list = new SummaryLoader(MainActivity.this, url);
        list.loadInBackground();
        new SummaryAdapter(MainActivity.this, (List<Summary>) list);
        newConfirmedtv.setText(newConfirmed);
        newDeathstv.setText(newDeaths);
        newConfirmedtv.setText(newRecovered);
        totalConfirmedtv.setText(totalConfirmed);
        totalDeathstv.setText(totalDeaths);
        totalRecoveredtv.setText(totalRecovered);
        //summaryglobaltodaytv.setText(date);
        //contactList = new ArrayList<>();

        /*newConfirmedtv.setText("");
        newDeathstv.setText("");
        newConfirmedtv.setText("");
        totalConfirmedtv.setText("");
        totalDeathstv.setText("");
        totalRecoveredtv.setText("");
        summaryglobaltodaytv.setText("");*/
//        String jsonStr=null;
//        HttpHandler sh = new HttpHandler();
//        jsonStr = sh.makeServiceCall(url);
//Toast.makeText(MainActivity.this,jsonStr,Toast.LENGTH_LONG).show();

        /*if (jsonStr!=null){

            try {
                OkHttpClient client = new OkHttpClient().newBuilder().build();
                Request request = new ConversationActions.Request.Builder()
                        .url(url)
                        .method("GET",null)
                        .build();
                Response response = client.newCall(request).execute();

                String jsonString = response.body().string();

                String globalsummary, date1;
                String newConfirmed, totalConfirmed,newDeaths, totalDeaths, newRecovered , totalRecovered ;

               JSONObject jsonObj = new JSONObject(jsonStr);
               JSONObject jsonObjSummariesGlobal= jsonObj.getJSONObject("Global");
                //date=jsonObj.getString("Date");
                newConfirmed = jsonObjSummariesGlobal.getString("NewConfirmed");
                newDeaths = jsonObjSummariesGlobal.getString("NewDeaths");
                newRecovered = jsonObjSummariesGlobal.getString("NewRecovered");
                totalRecovered = jsonObjSummariesGlobal.getString("TotalRecovered");
                totalDeaths = jsonObjSummariesGlobal.getString("TotalDeaths");
                totalConfirmed = jsonObjSummariesGlobal.getString("TotalConfirmed");
                //getdisplaySummaryToday(newConfirmed, totalConfirmed, newDeaths, totalDeaths, newRecovered,totalRecovered,date);


               // summaryglobaltodaytv.setText(date1);

            } catch (JSONException | IOException e) {
                e.printStackTrace();
            }
        }else{
            Toast.makeText(MainActivity.this,"null value received",Toast.LENGTH_LONG).show();
        }*/


//Intent intent = new Intent(MainActivity.this, SummaryToday.class);
//startActivity(intent);
//JSONArray jsonArrayCountries=jsonObj.getJSONArray("Countries");
//date =jsonObj.getString("Date");
//JSONArray jsonObjSummariesGlobal = new JSONArray(jsonObjGlobal);


//lv = (ListView) findViewById(R.id.list);
//HttpHandler sh = new HttpHandler();

// Making a request to url and getting response
//String jsonStr = sh.makeServiceCall(url);

//Log.e(TAG, "Response from url: " + jsonStr);

//String globalsummary,date;
// int newConfirmed, totalConfirmed, newDeaths, totalDeaths, newRecovered,totalRecovered;
//Toast.makeText(MainActivity.this,jsonStr,Toast.LENGTH_LONG).show();

        /*if (jsonStr!=null) {
            try {

                JSONObject jsonObj = new JSONObject(jsonStr);
                JSONObject jsonObjSummariesGlobal= jsonObj.getJSONObject("Global");
                //JSONArray jsonArrayCountries=jsonObj.getJSONArray("Countries");
                //date =jsonObj.getString("Date");
                //JSONArray jsonObjSummariesGlobal = new JSONArray(jsonObjGlobal);
                Toast.makeText(MainActivity.this,"ok1",Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this,"ok2",Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this,"ok3",Toast.LENGTH_LONG).show();

                // name = jsonObjSummariesGlobal.getString("Country");
                //countryname=name;
                //getCountryName();
                //globalsummary="Global";
                //abbreviation = jsonObjSummariesGlobal.getString("Date");
                //abbreviation = "(" + abbreviation + ")";
                for (int i = 0; i < jsonObjSummariesGlobal.length(); i++) {
                    newConfirmed = jsonObjSummariesGlobal.getInt("NewConfirmed");
                    newDeaths = jsonObjSummariesGlobal.getInt("NewDeaths");
                    newRecovered = jsonObjSummariesGlobal.getInt("NewRecovered");
                    totalRecovered = jsonObjSummariesGlobal.getInt("TotalRecovered");
                    totalDeaths = jsonObjSummariesGlobal.getInt("TotalDeaths");
                    totalConfirmed = jsonObjSummariesGlobal.getInt("TotalConfirmed");

                    //Summary summary = new Summary(newConfirmed,newDeaths,newRecovered,totalConfirmed,totalDeaths,totalRecovered,date);
                    //listSummaries.add(summary);
                    Toast.makeText(MainActivity.this, "ok4", Toast.LENGTH_LONG).show();
                    Toast.makeText(MainActivity.this, "ok5", Toast.LENGTH_LONG).show();
                    Toast.makeText(MainActivity.this, "ok6", Toast.LENGTH_LONG).show();
                    //getdisplaySummaryToday(newConfirmed,newDeaths,newRecovered,totalConfirmed,totalDeaths,totalRecovered,date);
                    newConfirmedtv.setText(newConfirmed);
                    newDeathstv.setText(newDeaths);
                    newConfirmedtv.setText(newRecovered);
                    totalConfirmedtv.setText(totalConfirmed);
                    totalDeathstv.setText(totalDeaths);
                    totalRecoveredtv.setText(totalRecovered);
                    //summaryglobaltodaytv.setText(date);
                    Toast.makeText(MainActivity.this, "ok3", Toast.LENGTH_LONG).show();
                }

                // Getting JSON Array node
                //JSONArray contacts = jsonObj.getJSONArray("contacts");


                   *//* // looping through All Contacts
                    for (int i = 0; i <jsonObjSummariesGlobal.length(); i++) {
                        JSONObject jsonObjSummariesGlobal = jsonObjSummariesGlobal.getJSONObject(i);
                        Log.e(TAG, "Response from jsonarray: " + jsonObjSummariesGlobal);
                        name = jsonObjSummariesGlobal.getString("Country");
                        //countryname=name;
                        //getCountryName();
                        abbreviation = jsonObjSummariesGlobal.getString("Date");
                        abbreviation = "(" + abbreviation + ")";
                        tests = jsonObjSummariesGlobal.getInt("NewConfirmed");
                        recovered = jsonObjSummariesGlobal.getInt("NewDeaths");
                        activeCases = jsonObjSummariesGlobal.getInt("TotalRecovered");
                        deaths = jsonObjSummariesGlobal.getInt("TotalDeaths");
                        total = jsonObjSummariesGlobal.getInt("TotalConfirmed");


                        Summary summary = new Summary(name, abbreviation, tests, recovered, activeCases, deaths, total);
                        listSummaries.add(summary);
                        // tmp hash map for single contact
                       *//**//* HashMap<String, String> contact = new HashMap<>();

                        // adding each child node to HashMap key => value
                        contact.put("id", id);
                        contact.put("name", name);
                        contact.put("email", email);
                        contact.put("mobile", mobile);

                        // adding contact to contact list
                        contactList.add(contact);*//**//*
                    }*//*
            } catch (final JSONException e) {
                Log.e(TAG, "Json parsing error: " + e.getMessage());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this,
                                "Json parsing error: " + e.getMessage(),
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }
        }*/

//new GetSummary().execute();



   // }






//            /**
//             * Async task class to get json by making HTTP call
//             */
////   private  class GetSummary extends AsyncTask<PrecomputedTextCompat.Params, Void, Result> {
////
////
////
////        @Override
////        protected void onPreExecute() {
////            super.onPreExecute();
////            // Showing progress dialog
////            pDialog = new ProgressDialog(MainActivity.this);
////            pDialog.setMessage("Please wait...");
////            pDialog.setCancelable(false);
////            pDialog.show();
////
////
////        }
////
////        @Override
////        protected Result doInBackground(PrecomputedTextCompat.Params... params) {
////            HttpHandler sh = new HttpHandler();
////            Toast.makeText(getApplicationContext(), "before url", Toast.LENGTH_LONG).show();
////
////            // Making a request to url and getting response
////            String jsonStr = sh.makeServiceCall(url);
////
////            //Log.e(TAG, "Response from url: " + jsonStr);
////            Toast.makeText(getApplicationContext(), "before obj", Toast.LENGTH_LONG).show();
////
////
////            if (jsonStr != null) {
////                try {
////
////                    JSONObject jsonObj = new JSONObject(jsonStr);
////                    JSONObject jsonObjSummariesGlobal= jsonObj.getJSONObject("Global");
////                    //JSONArray jsonArrayCountries=jsonObj.getJSONArray("Countries");
////                    date =jsonObj.getString("Date");
////                    //JSONArray jsonObjSummariesGlobal = new JSONArray(jsonObjGlobal);
////
////                   // name = jsonObjSummariesGlobal.getString("Country");
////                    //countryname=name;
////                    //getCountryName();
////                    //globalsummary="Global";
////                    //abbreviation = jsonObjSummariesGlobal.getString("Date");
////                    //abbreviation = "(" + abbreviation + ")";
////                    newConfirmed = jsonObjSummariesGlobal.getInt("NewConfirmed");
////                    newDeaths = jsonObjSummariesGlobal.getInt("NewDeaths");
////                    newRecovered = jsonObjSummariesGlobal.getInt("NewRecovered");
////                    totalRecovered = jsonObjSummariesGlobal.getInt("TotalRecovered");
////                    totalDeaths = jsonObjSummariesGlobal.getInt("TotalDeaths");
////                    totalConfirmed = jsonObjSummariesGlobal.getInt("TotalConfirmed");
////
////                    //Summary summary = new Summary(newConfirmed,newDeaths,newRecovered,totalConfirmed,totalDeaths,totalRecovered,date);
////                    //listSummaries.add(summary);
////
////                    //getdisplaySummaryToday(newConfirmed,newDeaths,newRecovered,totalConfirmed,totalDeaths,totalRecovered,date);
////
////
////                    // Getting JSON Array node
////                    //JSONArray contacts = jsonObj.getJSONArray("contacts");
////
////                } catch (final JSONException e) {
////                    Log.e(TAG, "Json parsing error: " + e.getMessage());
////                    runOnUiThread(new Runnable() {
////                        @Override
////                        public void run() {
////                            Toast.makeText(getApplicationContext(),
////                                    "Json parsing error: " + e.getMessage(),
////                                    Toast.LENGTH_LONG)
////                                    .show();
////                        }
////                    });
////
////                }
////            } else {
////                Log.e(TAG, "Couldn't get json from server.");
////                runOnUiThread(new Runnable() {
////                    @Override
////                    public void run() {
////                        Toast.makeText(getApplicationContext(),
////                                "Couldn't get json from server. Check LogCat for possible errors!",
////                                Toast.LENGTH_LONG)
////                                .show();
////                    }
////                });
////
////            }
////
////            return null;
////        }
////
////        @Override
////        protected void onPostExecute(Result result) {
////            super.onPostExecute(result);
////            // Dismiss the progress dialog
////            if (pDialog.isShowing())
////                pDialog.dismiss();
////
////
////              ///Updating parsed JSON data into ListView
////            //SummaryAdapter summaryAdapter =new SummaryAdapter(MainActivity.this,listSummaries);
////            //lv.setAdapter(summaryAdapter);
////           /* ListAdapter adapter = new SimpleAdapter(
////                    MainActivity.this, contactList,
////                    R.layout.list_item, new String[]{"name", "email",
////                    "mobile"}, new int[]{R.id.name,
////                    R.id.email, R.id.mobile});*/
////            Toast.makeText(getApplicationContext(), "lll", Toast.LENGTH_LONG).show();
////
////
////        }
////
////    }
//
////    private void getdisplaySummaryToday(int newConfirmed, int newDeaths, int newRecovered, int totalConfirmed, int totalDeaths, int totalRecovered, String date) {
////        newConfirmedtv.setText(newConfirmed);
////        newDeathstv.setText(newDeaths);
////        newConfirmedtv.setText(newRecovered);
////        totalConfirmedtv.setText(totalConfirmed);
////        totalDeathstv.setText(totalDeaths);
////        totalRecoveredtv.setText(totalRecovered);
////        summaryglobaltodaytv.setText(date);
////    Toast.makeText(getApplicationContext(), "here", Toast.LENGTH_LONG).show();
////
////    }
//            }
// */