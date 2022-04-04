package com.rakib.covid19bd.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.rakib.covid19bd.R;
import com.rakib.covid19bd.SplashActivity;
import com.rakib.covid19bd.adapter.HttpHandler;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;

import static androidx.constraintlayout.widget.StateSet.TAG;


public class Covid19WorldToday extends AppCompatActivity {
    Button searchPreviousDataWorldTodayButton;

    int year_x,month_x,day_x;
    static final int DIALOG_ID=0;
    // String globalsummary, date;
    //  int newConfirmed, totalConfirmed, newDeaths, totalDeaths, newRecovered, totalRecovered;
    private TextView newConfirmedtv, newDeathstv, newRecoveredtv, totalConfirmedtv, totalDeathstv, totalRecoveredtv, summaryglobaltodaytv;

    // private ListView lv;
    // URL to get hashMapItems JSON
    //private static String url = "https://api.covid19api.com/summary/";
    //private SummaryLoader list;
    private ProgressDialog pDialog;
    private Button worldtTobdtButton;
    private Button worldtTobdtotalButton;
    private Button worldtToworldtotalButton;
    private Button worldtTodivisiontButton;
    private Button worldtTodistricttButton;
    // private ListView lv;
    //private String TAG = MainActivity.class.getSimpleName();
    // ArrayList<HashMap<String,String>> hashMapArraylist;
    //String[] lists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid19_world_today);
        worldtTobdtButton=findViewById(R.id.worldtTobdtId);
        worldtTobdtotalButton=findViewById(R.id.worldtTobdtotalId);
        worldtToworldtotalButton=findViewById(R.id.worldtToworldtotalId);
        worldtTodivisiontButton=findViewById(R.id.worldtTodivisiontId);
        worldtTodistricttButton=findViewById(R.id.worldtTodistricttId);


        final Calendar callender=Calendar.getInstance();
        year_x=callender.get(Calendar.YEAR);
        month_x=callender.get(Calendar.MONTH);
        day_x=callender.get(Calendar.DAY_OF_MONTH);
        searchPreviousDataWorldTodayButton=findViewById(R.id.searchPreviousDataworldtId);
        searchPreviousDataWorldTodayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // showDialog(DIALOG_ID);
                Intent intent = new Intent(Covid19WorldToday.this, Covid19WorldTotalActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("key","worldtotal");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        //showDateDialogOnClick();

        // summaryglobaltodaytv=findViewById(R.id.summaryGlobaltodayId);
        newConfirmedtv=findViewById(R.id.newConfirmedworldtId);
        newDeathstv=findViewById(R.id.newDeathworldtId);
        newRecoveredtv=findViewById(R.id.newRecoveredworldtId);
        totalConfirmedtv=findViewById(R.id.totalConfirmedworldtId);
        totalDeathstv=findViewById(R.id.totalDeathworldtId);
        totalRecoveredtv=findViewById(R.id.totalRecoveredworldtId);
        //hashMapArraylist = new ArrayList<>();


        worldtTobdtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Covid19BDActivity.class);
                startActivity(intent);
            }
        });
       /* worldtTobdtotalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Covid19BDTotalActivity.class);
                startActivity(intent);
            }
        });*/
       /* worldtToworldtotalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Covid19WorldTotalActivity.class);
                startActivity(intent);
            }
        });*/
        worldtTodivisiontButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BDDivisionsCovid19Activity.class);
                startActivity(intent);
            }
        });
        worldtTodistricttButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BDDistricsCovid19Activity.class);
                startActivity(intent);
            }
        });


        new GethashMapItems2().execute();

    }
    @Override
    protected Dialog onCreateDialog(int id) {
        if(id==DIALOG_ID)
            return new DatePickerDialog(this,dpickerlistener,year_x,month_x,day_x);
        return null;
    }
    private DatePickerDialog.OnDateSetListener dpickerlistener=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            year_x=year;
            month_x=month+1;
            day_x=dayOfMonth;
            String formated_date=year_x+"-"+month_x+"-"+day_x+"T00:00:00Z";
            Toast.makeText(Covid19WorldToday.this,formated_date,Toast.LENGTH_LONG).show();

        }
    };
    private class GethashMapItems2 extends AsyncTask<String, String, Void> {

        // ProgressDialog dialog = new ProgressDialog(getParent(), R.style.progressdialog);
        // The variable is moved here, we only need it here while displaying the




        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(Covid19WorldToday.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();



            //dialog.show();

            // Set the variable txtView here, after setContentView on the dialog
            // has been called! use dialog.findViewById().
            // txtView = dialog.findViewById(R.id.progressMessage);



            Toast.makeText(Covid19WorldToday.this, "Json Data is downloading", Toast.LENGTH_LONG).show();

        }


        @Override
        protected Void doInBackground(String... urls) {
            //publishProgress("Testing");

            // Toast.makeText(GlobalSummaryActivity.this, "1", Toast.LENGTH_SHORT).show();

            //String url = https://uddokhta.000webhostapp.com/summaryworldtoday.json
            String url = "https://api.covid19api.com/summary";
            //Toast.makeText(GlobalSummaryActivity.this, "2", Toast.LENGTH_SHORT).show();

            HttpHandler sh = new HttpHandler();
            //Toast.makeText(GlobalSummaryActivity.this, "3", Toast.LENGTH_LONG).show();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);
            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    String countryname=null;
                    int newConfirmed = 0;
                    int newDeaths=0;
                    int newRecovered=0;
                    int totalConfirmed=0;
                    int totalDeaths=0;
                    int totalRecovered=0;

                    JSONObject jsonObj = new JSONObject(jsonStr);
                    JSONObject jsonObjectGlobal = jsonObj.getJSONObject("Global");
                    //JSONArray jsonArrayCountries=jsonObj.getJSONArray("Countries");
                    //date = jsonObj.getString("Date");

                            newConfirmed = jsonObjectGlobal.getInt("NewConfirmed");
                            newDeaths = jsonObjectGlobal.getInt("NewDeaths");
                            newRecovered = jsonObjectGlobal.getInt("NewRecovered");
                            totalConfirmed = jsonObjectGlobal.getInt("TotalConfirmed");
                            totalDeaths = jsonObjectGlobal.getInt("TotalDeaths");
                            totalRecovered = jsonObjectGlobal.getInt("TotalRecovered");


                    // name = jsonObjectCountry.getString("Country");
                    //countryname=name;
                    //getCountryName();
                    //globalsummary="Global";
                    //abbreviation = jsonObjectCountry.getString("Date");
                    //abbreviation = "(" + abbreviation + ")";
                   



                    /*// tmp hash map for single hashMapItem
                       HashMap<String, String> hashMapItem = new HashMap<>();
                    // adding each child node to HashMap key => value
                       hashMapItem.put("newConfirmed", String.valueOf(newConfirmed));
                       hashMapItem.put("newDeaths", String.valueOf(newDeaths));
                        hashMapItem.put("newRecovered", String.valueOf(newRecovered));
                        hashMapItem.put("totalRecovered", String.valueOf(totalConfirmed));
                        hashMapItem.put("totalDeaths",String.valueOf(totalDeaths));
                        hashMapItem.put("totalConfirmed", String.valueOf(totalRecovered));
                     //adding hashMapItem to hashMapItem list
                         hashMapArraylist.add(hashMapItem);*/

                    publishProgress( String.valueOf(newConfirmed), String.valueOf(newDeaths), String.valueOf(newRecovered), String.valueOf(totalConfirmed), String.valueOf(totalDeaths), String.valueOf(totalRecovered));
                  /*  runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            Toast.makeText(getApplicationContext(),
                                    date + "11" + String.valueOf(newConfirmed),
                                    Toast.LENGTH_LONG).show();
                        }
                    });*/

                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });

                }

            } else {
                Log.e(TAG, "Couldn't get json from server.");
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
            if (pDialog.isShowing()) {
                pDialog.dismiss();
            }


        }
        @Override
        protected void onProgressUpdate(String... update) {
            //In UI thread, you can access UI here
            //super.onProgressUpdate(date,newConfirmed, newDeaths, newRecovered, totalConfirmed, totalDeaths, totalRecovered);
            /*if (update.length > 0)
                txtView.setText(update[0]);*/
            /*summaryglobaltodaytv.setText(date);
            newConfirmedtv.setText(String.valueOf(newConfirmed));
            newDeathstv.setText(String.valueOf(newDeaths));
            newConfirmedtv.setText(String.valueOf(newRecovered));
            totalConfirmedtv.setText(totalConfirmed);
            totalDeathstv.setText(String.valueOf(totalDeaths));
            totalRecoveredtv.setText(String.valueOf(totalRecovered));
*/
            if(update.length>0){
                //summaryglobaltodaytv.setText(update[0]);
                newConfirmedtv.setText(update[0]);
                newDeathstv.setText(update[1]);
                newRecoveredtv.setText(update[2]);
                totalConfirmedtv.setText(update[3]);
                totalDeathstv.setText(update[4]);
                totalRecoveredtv.setText(update[5]);
            }

        }

        //adapter.notify();
        //adapter.notifyDataSetChanged();
        //populateUI(getApplicationContext());


    }


}


