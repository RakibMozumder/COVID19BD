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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.rakib.covid19bd.R;
import com.rakib.covid19bd.SplashActivity;
import com.rakib.covid19bd.adapter.DivisionAdapter;
import com.rakib.covid19bd.adapter.HttpHandler;
import com.rakib.covid19bd.adapter.SummaryCountriesAdapter;
import com.rakib.covid19bd.model.Divisionmodel;
import com.rakib.covid19bd.model.SummaryCountries;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;

import static androidx.constraintlayout.widget.StateSet.TAG;
import static java.util.Calendar.DAY_OF_MONTH;


public class BDDivisionsCovid19Activity extends AppCompatActivity {
    Button searchPreviousDatabddivisiontButton;



    private  String formated_date="8/9/2020";
    private  String new_formated_date="8/8/2020";


    final Calendar c=Calendar.getInstance();
    int year_x,month_x,day_x;
    static final int DIALOG_ID=0;
    // String globalsummary, date;
    //  int newConfirmed, totalConfirmed, newDeaths, totalDeaths, newRecovered, totalRecovered;
    private TextView newConfirmedtv, newDeathstv, newRecoveredtv, totalConfirmedtv, totalDeathstv, totalRecoveredtv, summaryglobaltodaytv;
    private TextView displaydatedivisiontTextView;
    String[] stringlist={};
    // private ListView lv;
    // URL to get hashMapItems JSON
    //private static String url = "https://api.covid19api.com/summary/";
    //private SummaryLoader list;
    private ProgressDialog pDialog;
    private Button bddivisiontTobdtButton;
    private Button bddivisiontTobdtotalButton;
    private Button bddivisiontToworldtButton;
    private Button bddivisiontToworldtotalButton;
    private Button bddivisiontTodistricttButton;
    private ArrayList<Divisionmodel> divisionlist;
    private ListView divisionlistview;
    private DivisionAdapter divisionAdapter;
    // private ListView lv;
    //private String TAG = MainActivity.class.getSimpleName();
    // ArrayList<HashMap<String,String>> hashMapArraylist;
    //String[] lists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division_bd);
       /* bddivisiontTobdtButton=findViewById(R.id.bddivisiontTobdtId);
        bddivisiontTobdtotalButton=findViewById(R.id.bddivisiontTobdtotalId);
        bddivisiontToworldtButton=findViewById(R.id.bddivisiontToworldtId);
        bddivisiontToworldtotalButton=findViewById(R.id.bddivisiontToworldtotalId);
        bddivisiontTodistricttButton=findViewById(R.id.bddivisiontTodistricttId);*/


      /*  final Calendar callender=Calendar.getInstance();
        year_x=callender.get(Calendar.YEAR);
        month_x=callender.get(Calendar.MONTH);
        day_x=callender.get(Calendar.DAY_OF_MONTH);*/
        //searchPreviousDatabddivisiontButton=findViewById(R.id.searchPreviousDatabddivisiontId);
/*
        searchPreviousDatabddivisiontButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // showDialog(DIALOG_ID);
                Intent intent = new Intent(BDDivisionsCovid19Activity.this, Covid19WorldTotalActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("key","worldtotal");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
*/
        //showDateDialogOnClick();

       /* // summaryglobaltodaytv=findViewById(R.id.summaryGlobaltodayId);
        newConfirmedtv=findViewById(R.id.newConfirmedbddivisiontId);
      //  newDeathstv=findViewById(R.id.newDeathbddivisiontId);
       // newRecoveredtv=findViewById(R.id.newRecoveredbddivisiontId);
        totalConfirmedtv=findViewById(R.id.totalConfirmedbddivisiontId);
       // totalDeathstv=findViewById(R.id.totalDeathbddivisiontId);
       // totalRecoveredtv=findViewById(R.id.totalRecoveredbddivisiontId);
        //hashMapArraylist = new ArrayList<>();
        displaydatedivisiontTextView=findViewById(R.id.displaydatedivisiontId);*/


      /*  bddivisiontTobdtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Covid19BDActivity.class);
                startActivity(intent);
            }
        });*/
       /* bddivisiontTobdtotalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Covid19BDTotalActivity.class);
                startActivity(intent);
            }
        });*/
       /* bddivisiontToworldtotalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Covid19WorldTotalActivity.class);
                startActivity(intent);
            }
        });*/
      /*  bddivisiontToworldtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Covid19WorldToday.class);
                startActivity(intent);
            }
        });*/
      /*  bddivisiontToworldtotalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Covid19WorldTotalActivity.class);
                startActivity(intent);
            }
        });*/
       /* bddivisiontTodistricttButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BDDistricsCovid19Activity.class);
                startActivity(intent);
            }
        });*/

        divisionlist=new ArrayList<>();
        divisionlistview=findViewById(R.id.divisionlistviewId);
        new GethashMapItems2().execute();

    }
   /* @Override
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
            Toast.makeText(BDDivisionsCovid19Activity.this,formated_date,Toast.LENGTH_LONG).show();

        }
    };*/
    private class GethashMapItems2 extends AsyncTask<String, String, Void> {

        // ProgressDialog dialog = new ProgressDialog(getParent(), R.style.progressdialog);
        // The variable is moved here, we only need it here while displaying the




        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(BDDivisionsCovid19Activity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();



            //dialog.show();

            // Set the variable txtView here, after setContentView on the dialog
            // has been called! use dialog.findViewById().
            // txtView = dialog.findViewById(R.id.progressMessage);



            Toast.makeText(BDDivisionsCovid19Activity.this, "Json Data is downloading", Toast.LENGTH_LONG).show();

        }


        @Override
        protected Void doInBackground(String... urls) {
            //publishProgress("Testing");

            // Toast.makeText(GlobalSummaryActivity.this, "1", Toast.LENGTH_SHORT).show();

            //String url = https://uddokhta.000webhostapp.com/summaryworldtoday.json
            String url = "https://uddokhta.000webhostapp.com/covidbd.json";
            //Toast.makeText(GlobalSummaryActivity.this, "2", Toast.LENGTH_SHORT).show();

            HttpHandler sh = new HttpHandler();
            //Toast.makeText(GlobalSummaryActivity.this, "3", Toast.LENGTH_LONG).show();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);
            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {

                   /* c.set(year_x,month_x,day_x);
                    c.add(DAY_OF_MONTH, -1);
                    int newDate = c.get(Calendar.DAY_OF_MONTH);
                    int newMonth = c.get(Calendar.MONTH);
                    int newYear = c.get(Calendar.YEAR);*/
                    /*if((newMonth<10)&&(newDate<10)){
                        new_formated_date=newYear+"-"+"0"+newMonth+"-"+"0"+newDate+"T00:00:00Z";
                    }
                    else if(newMonth<10){
                        new_formated_date=newYear+"-"+"0"+newMonth+"-"+newDate+"T00:00:00Z";
                    }
                    else if(newDate<10){
                        new_formated_date=newYear+"-"+newMonth+"-"+"0"+newDate+"T00:00:00Z";
                    }
                    else{
                        new_formated_date=newYear+"-"+newMonth+"-"+newDate+"T00:00:00Z";
                    }*/

                    JSONArray jsonArray = new JSONArray(jsonStr);
                    for (int i=0;i<jsonArray.length();i++) {
                        String countryname=null;
                        String iedcr_confirmed=null;
                        String pre_iedcr_confirmed=null;
                        String pre_Division=null;
                        String period_date=null;
                        int newConfirmed = 0;
                        int newDeaths=0;
                        int newRecovered=0;
                        int totalConfirmed=0;
                        int pre_totalConfirmed=0;
                        int totalDeaths=0;
                        int totalRecovered=0;
                        String district_name=null;
                        String  division=null;

                              JSONObject jsonObj = jsonArray.getJSONObject(i);
                               period_date = jsonObj.getString("period_date");
                                 division = jsonObj.getString("Division");
                               iedcr_confirmed = jsonObj.getString("iedcr_confirmed");
                               district_name = jsonObj.getString("district_name");

                            //newConfirmed = jsonObject.getInt("Confirmed");
                            //newDeaths = jsonObject.getInt("Deaths");
                            // newRecovered = jsonObject.getInt("Recovered");
                            /*totalConfirmed = jsonObject.getInt("Confirmed");
                            totalDeaths = jsonObject.getInt("Deaths");
                            totalRecovered = jsonObject.getInt("Recovered");
                           } active = jsonObject.getInt("Active");*/

                        Divisionmodel divisionmodel = new Divisionmodel(period_date,district_name,division,iedcr_confirmed);
                        divisionlist.add(divisionmodel);
                        }




//                    newDeaths = (totalDeaths-pre_totalDeaths);
//                    newRecovered = (totalRecovered-pre_totalRecovered);
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
            //displaydatedivisiontTextView.setText(formated_date);
            divisionAdapter=new DivisionAdapter(getApplicationContext(),divisionlist);
            divisionlistview.setAdapter(divisionAdapter);

        }



    }


}


