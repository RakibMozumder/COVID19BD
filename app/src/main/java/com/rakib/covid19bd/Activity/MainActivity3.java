package com.rakib.covid19bd.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.rakib.covid19bd.R;
import com.rakib.covid19bd.adapter.HttpHandler;
import com.rakib.covid19bd.adapter.SearchByDateRangeCountriesSummaryAdapter;
import com.rakib.covid19bd.adapter.SummaryCountriesAdapter;
import com.rakib.covid19bd.model.SearchByDateRangeCountrySummary;
import com.rakib.covid19bd.model.SummaryCountries;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

   ListView savedfilelistView;
   ArrayList<String> CountriesArraylist;
   List<String> clist;

    ArrayList<SearchByDateRangeCountrySummary> searchByDateRangeCountrySummarieslist;
    SearchByDateRangeCountriesSummaryAdapter searchByDateRangeCountriesSummaryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        CountriesArraylist=new ArrayList<>();


        savedfilelistView=findViewById(R.id.savedfilelistViewId);





        searchByDateRangeCountrySummarieslist =new ArrayList<SearchByDateRangeCountrySummary>();

        new GetContacts().execute();



    }

 /*   public void readfile(View view){

    }
    public void writefile(View view){
try {

    FileOutputStream fileOutputStream=openFileOutput("countryname.txt",MODE_WORLD_WRITEABLE);
    fileOutputStream.write(searchByDateRangeCountrySummarieslist.toString().getBytes());
    fileOutputStream.close();
    Toast.makeText(MainActivity3.this,"complete",Toast.LENGTH_LONG).show();
} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}

    }*/

    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            Toast.makeText(MainActivity3.this,"Json Data is downloading",Toast.LENGTH_LONG).show();

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
                      /*  date = jsonObjSummariesCountry.getString("Date");
                        newConfirmed = jsonObjSummariesCountry.getInt("NewConfirmed");
                        newDeaths = jsonObjSummariesCountry.getInt("NewDeaths");
                        newRecovered = jsonObjSummariesCountry.getInt("NewRecovered");
                        totalRecovered = jsonObjSummariesCountry.getInt("TotalRecovered");
                        totalDeaths = jsonObjSummariesCountry.getInt("TotalDeaths");
                        totalConfirmed = jsonObjSummariesCountry.getInt("TotalConfirmed");
*/

                       // SummaryCountries summary = new SummaryWorld(countryname,date, String.valueOf(newConfirmed), String.valueOf(newDeaths), String.valueOf(newRecovered), String.valueOf(totalConfirmed), String.valueOf(totalDeaths), String.valueOf(totalRecovered));
                       // SearchByDateRangeCountrySummary summary = new SearchByDateRangeCountrySummary(countryname);
                        //searchByDateRangeCountrySummarieslist.add(summary);
                        CountriesArraylist.add(countryname);
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

                                    Toast.makeText(getApplicationContext(),"ok",
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
            searchByDateRangeCountriesSummaryAdapter=new SearchByDateRangeCountriesSummaryAdapter(getApplicationContext(),searchByDateRangeCountrySummarieslist);
            savedfilelistView.setAdapter(searchByDateRangeCountriesSummaryAdapter);
            Toast.makeText(getApplicationContext(),"showed",Toast.LENGTH_LONG).show();

            //adapter.notify();
            //adapter.notifyDataSetChanged();
            //populateUI(getApplicationContext());
        }


    }

}
