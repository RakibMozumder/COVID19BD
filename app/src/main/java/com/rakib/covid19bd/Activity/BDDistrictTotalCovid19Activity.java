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


public class BDDistrictTotalCovid19Activity extends AppCompatActivity {
    Button searchPreviousDataDistrictTotalButton;

    int year_x,month_x,day_x;
    static final int DIALOG_ID=0;
    // String globalsummary, date;
    //  int newConfirmed, totalConfirmed, newDeaths, totalDeaths, newRecovered, totalRecovered;
    private TextView newConfirmedtv, newDeathstv, newRecoveredtv, totalConfirmedtv, totalDeathstv, totalRecoveredtv, summaryglobaltodaytv;

    private TextView dateofsearchedbddistricttotalTextView;
    private String dateofsearchedbddistricttotal;
    private String searched_date;
    private String formated_date;
    private String new_formated_date;
    // private ListView lv;
    // URL to get hashMapItems JSON
    //private static String url = "https://api.covid19api.com/summary/";
    //private SummaryLoader list;
    private ProgressDialog pDialog;
    private Button bddistricttotalTobdtButton;
    private Button bddistricttotalTobdtotalButton;
    private Button bddistricttotalToworldtButton;
    private Button bddistricttotalTodivisiontotalButton;
    private Button bddistricttotalTobdistricttButton;
    // private ListView lv;
    //private String TAG = MainActivity.class.getSimpleName();
    // ArrayList<HashMap<String,String>> hashMapArraylist;
    //String[] lists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bddistrict_total_covid19);
        Bundle bundle=getIntent().getExtras();
        searched_date=bundle.getString("key");
        if(searched_date.equals("districttotal")){
            showDialog(DIALOG_ID);
        }
        bddistricttotalTobdtButton=findViewById(R.id.bdistricttotalTobdtId);
        bddistricttotalTobdtotalButton=findViewById(R.id.bdistricttotalTobdtotalId);
        bddistricttotalToworldtButton=findViewById(R.id.bdistricttotalToworldtId);
        bddistricttotalTodivisiontotalButton=findViewById(R.id.bdistricttotalTodivisiontotalId);
        bddistricttotalTobdistricttButton=findViewById(R.id.bdistricttotalTobdistricttId);


        final Calendar callender=Calendar.getInstance();
        year_x=callender.get(Calendar.YEAR);
        month_x=callender.get(Calendar.MONTH);
        day_x=callender.get(Calendar.DAY_OF_MONTH);
        searchPreviousDataDistrictTotalButton=findViewById(R.id.searchPreviousDatabdistricttotalId);
        searchPreviousDataDistrictTotalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID);
            }
        });
        //showDateDialogOnClick();

        // summaryglobaltodaytv=findViewById(R.id.summaryGlobaltodayId);
        newConfirmedtv=findViewById(R.id.newConfirmedBdistricttotalId);
        newDeathstv=findViewById(R.id.newDeathBdistricttotalId);
        newRecoveredtv=findViewById(R.id.newRecoveredBdistricttotalId);
        totalConfirmedtv=findViewById(R.id.totalConfirmedBdistricttotalId);
        totalDeathstv=findViewById(R.id.totalDeathBdistricttotalId);
        totalRecoveredtv=findViewById(R.id.totalRecoveredBdistricttotalId);
        //hashMapArraylist = new ArrayList<>();
        dateofsearchedbddistricttotalTextView=findViewById(R.id.datesearcheddistricttotal);


        bddistricttotalTobdtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Covid19BDActivity.class);
                startActivity(intent);
            }
        });
        /*bddistricttotalTobdtotalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Covid19BDTotalActivity.class);
                startActivity(intent);
            }
        });*/
        bddistricttotalToworldtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Covid19WorldToday.class);
                startActivity(intent);
            }
        });
        bddistricttotalTodivisiontotalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BDDivisionsCovid19Activity.class);
                startActivity(intent);
            }
        });
        bddistricttotalTobdistricttButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BDDistricsCovid19Activity.class);
                startActivity(intent);
            }
        });




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
            if(month_x<10){
                formated_date=year_x+"-"+"0"+month_x+"-"+day_x+"T00:00:00Z";
            }
            if(dayOfMonth<10){
                formated_date=year_x+"-"+month_x+"-"+"0"+day_x+"T00:00:00Z";
            }
            if((month_x<10)&&(dayOfMonth<10)){
                formated_date=year_x+"-"+"0"+month_x+"-"+"0"+day_x+"T00:00:00Z";
            }
            else{
                formated_date=year_x+"-"+month_x+"-"+day_x+"T00:00:00Z";
            }

            Toast.makeText(BDDistrictTotalCovid19Activity.this,formated_date,Toast.LENGTH_LONG).show();
            if(formated_date!=null){
                new GethashMapItems2().execute();
            }
        }
    };
    private class GethashMapItems2 extends AsyncTask<String, String, Void> {

        // ProgressDialog dialog = new ProgressDialog(getParent(), R.style.progressdialog);
        // The variable is moved here, we only need it here while displaying the


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(BDDistrictTotalCovid19Activity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();



            //dialog.show();

            // Set the variable txtView here, after setContentView on the dialog
            // has been called! use dialog.findViewById().
            // txtView = dialog.findViewById(R.id.progressMessage);



            Toast.makeText(BDDistrictTotalCovid19Activity.this, "Json Data is downloading", Toast.LENGTH_LONG).show();

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
            dateofsearchedbddistricttotal=year_x+"-"+month_x+"-"+day_x;
            dateofsearchedbddistricttotalTextView.setText("Summary ("+dateofsearchedbddistricttotal+")");
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


