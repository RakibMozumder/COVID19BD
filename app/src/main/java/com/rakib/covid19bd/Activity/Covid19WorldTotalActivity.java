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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.rakib.covid19bd.R;
import com.rakib.covid19bd.SearchCountriesSummaryByDateRangeActivity;
import com.rakib.covid19bd.SplashActivity;
import com.rakib.covid19bd.adapter.HttpHandler;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static androidx.constraintlayout.widget.StateSet.TAG;
import static java.util.Calendar.DAY_OF_MONTH;


public class Covid19WorldTotalActivity extends AppCompatActivity {
    Button searchPreviousDataWorldTotalButton;

    int year_x,month_x,day_x;
    static final int DIALOG_ID=0;
    private int year_curr;
    private int month_curr;
    private int day_curr;
    // String globalsummary, date;
    //  int newConfirmed, totalConfirmed, newDeaths, totalDeaths, newRecovered, totalRecovered;
    private TextView newConfirmedtv, newDeathstv, newRecoveredtv, totalConfirmedtv, totalDeathstv, totalRecoveredtv, summaryglobaltodaytv;

    private TextView dateofsearchedworltotalTextView;
    private String dateofsearchedworldtotal;
    private String searched_date;
    private String formated_date;
    private String new_formated_date;
    private TextView namesearchedworltotalTextView;
    private String namesearchedworldtotal;
    // private ListView lv;
    // URL to get hashMapItems JSON
    //private static String url = "https://api.covid19api.com/summary/";
    //private SummaryLoader list;
    private ProgressDialog pDialog;
    private Button worldtotalTobdtButton;
    private Button worldtotalTobdtotalButton;
    private Button worldtotalToworldtButton;
    private Button worldtotalTodivisiontButton;
    private Button worldtotalTodistricttButton;
    // private ListView lv;
    //private String TAG = MainActivity.class.getSimpleName();
    // ArrayList<HashMap<String,String>> hashMapArraylist;
    //String[] lists;
    private ArrayList<String> countrynamearraylist;
    private List<String> countrynamelistlist;
    private ArrayList<String> countrynamelist;
    private TextView countrynameTextView;
    private Button fromDateButton,toDateButton,searchButton;
    private String url_Country_name = null;
    private String url_Start_Date = null;
    private String url_End_Date = null;
    //atcplete Text
    String[] countrynamestringlist;
    AutoCompleteTextView autoCompleteTextView;
    String url_for_dayrange_search ;

    final Calendar c=Calendar.getInstance();

    private String currentdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid19_world_total);
        Bundle bundle = getIntent().getExtras();
        searched_date = bundle.getString("key");

        final Calendar calendar2=Calendar.getInstance();
        year_x = calendar2.get(Calendar.YEAR);
        month_x = calendar2.get(Calendar.MONTH);
        day_x = calendar2.get(Calendar.DAY_OF_MONTH);
        if (searched_date.equals("worldtotal")) {
            showDialog(DIALOG_ID);
        }
        worldtotalTobdtButton = findViewById(R.id.worldtotalTobdtId);
        worldtotalTobdtotalButton = findViewById(R.id.worldtotalTobdtotalId);
        worldtotalToworldtButton = findViewById(R.id.worldtotalToworldtId);
        worldtotalTodivisiontButton = findViewById(R.id.worldtotalTodivisiontId);
        worldtotalTodistricttButton = findViewById(R.id.worldtotalTodistricttId);







        searchPreviousDataWorldTotalButton = findViewById(R.id.searchPreviousDataworldtotalId);
        searchPreviousDataWorldTotalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_ID);
            }
        });

        //showDateDialogOnClick();
        // summaryglobaltodaytv=findViewById(R.id.summaryGlobaltodayId);
        newConfirmedtv = findViewById(R.id.newConfirmedWTotalId);
        newDeathstv = findViewById(R.id.newDeathWTotalId);
        newRecoveredtv = findViewById(R.id.newRecoveredWTotalId);
        totalConfirmedtv = findViewById(R.id.totalConfirmedWTotalId);
        totalDeathstv = findViewById(R.id.totalDeathWTotalId);
        totalRecoveredtv = findViewById(R.id.totalRecoveredWTotalId);
        //hashMapArraylist = new ArrayList<>();
        dateofsearchedworltotalTextView = findViewById(R.id.datesearchedworldtotalId);


        worldtotalTobdtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Covid19BDActivity.class);
                startActivity(intent);
            }
        });
      /*  worldtotalTobdtotalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Covid19BDTotalActivity.class);
                startActivity(intent);
            }
        });*/
        worldtotalToworldtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Covid19WorldToday.class);
                startActivity(intent);
            }
        });
        worldtotalTodivisiontButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BDDivisionsCovid19Activity.class);
                startActivity(intent);
            }
        });
        worldtotalTodistricttButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BDDistricsCovid19Activity.class);
                startActivity(intent);
            }
        });


        countrynamestringlist = new String[]{"Afghanistan", "Albania", "Algeria", "Andorra", "Angola", " Antigua", "Barbuda", " Argentina", " Armenia", " Australia", " Austria", " Azerbaijan", " Bahamas", "Bahrain", "Bangladesh", " Barbados", " Belarus", " Belgium", " Belize", " Benin", " Bhutan", " Bolivia", " Bosnia", "Herzegovina", " Botswana", " Brazil", " Brunei Darussalam", " Bulgaria", " Burkina Faso", " Burundi", " Cambodia", " Cameroon", " Canada", " Cape Verde", " Central African Republic", " Chad", " Chile", " China", " Colombia", " Comoros", " Congo (Brazzaville)", " Congo (Kinshasa)", " Costa Rica", " Croatia", " Cuba", " Cyprus", " Czech Republic", " Côte d Ivoire", " Denmark", " Djibouti", " Dominica", " Dominican Republic", " Ecuador", " Egypt", " El Salvador", " Equatorial Guinea", " Eritrea", " Estonia", " Ethiopia", " Fiji", " Finland", " France", " Gabon", " Gambia", " Georgia", " Germany", " Ghana", " Greece", " Grenada", " Guatemala", " Guinea", " Guinea-Bissau", " Guyana", " Haiti", " Holy See (Vatican City State)", " Honduras", " Hungary", " Iceland", " India", " Indonesia", " Iran", " Islamic Republic of", " Iraq", " Ireland", " Israel", " Italy", " Jamaica", " Japan", " Jordan", " Kazakhstan", " Kenya", " Korea (South)", " Kuwait", " Kyrgyzstan", " Lao PDR", " Latvia", " Lebanon", " Lesotho", " Liberia", " Libya", " Liechtenstein", " Lithuania", " Luxembourg", " Macao", " SAR China", " Macedonia", " Republic of", " Madagascar", " Malawi", " Malaysia", " Maldives", " Mali", " Malta", " Mauritania", " Mauritius", " Mexico", " Moldova", " Monaco", " Mongolia", " Montenegro", " Morocco", " Mozambique", " Myanmar", " Namibia", " Nepal", " Netherlands", " New Zealand", " Nicaragua", " Niger", " Nigeria", " Norway", " Oman", " Pakistan", " Palestinian Territory", " Panama", " Papua New Guinea", " Paraguay", " Peru", " Philippines", " Poland", " Portugal", " Qatar", " Republic of Kosovo", " Romania", " Russian Federation", " Rwanda", " Réunion", " Saint Kitts", "Nevis", " Saint Lucia", " Saint Vincent", "Grenadines", " San Marino", " Sao Tome", "Principe", " Saudi Arabia", " Senegal", " Serbia", " Seychelles", " Sierra Leone", " Singapore", " Slovakia", " Slovenia", " Somalia", " South Africa", " South Sudan", " Spain", " Sri Lanka", " Sudan", " Suriname", " Swaziland", " Sweden", " Switzerland", " Syrian Arab Republic (Syria)", " Taiwan", " Republic of China", " Tajikistan", " Tanzania", " United Republic of", " Thailand", " Timor-Leste", " Togo", " Trinidad", "Tobago", " Tunisia", " Turkey", " Uganda", " Ukraine", " United Arab Emirates", " United Kingdom", " United States of America", " Uruguay", " Uzbekistan", " Venezuela (Bolivarian Republic)", " Viet Nam", " Western Sahara", " Yemen", " Zambia", " Zimbabwe"};
        countrynamearraylist = new ArrayList<String>(Arrays.asList(new String[]{"Afghanistan", " Albania", " Algeria", " Andorra", " Angola", " Antigua", "Barbuda", " Argentina", " Armenia", " Australia", " Austria", " Azerbaijan", " Bahamas", " Bahrain", " Bangladesh", " Barbados", " Belarus", " Belgium", " Belize", " Benin", " Bhutan", " Bolivia", " Bosnia", "Herzegovina", " Botswana", " Brazil", " Brunei Darussalam", " Bulgaria", " Burkina Faso", " Burundi", " Cambodia", " Cameroon", " Canada", " Cape Verde", " Central African Republic", " Chad", " Chile", " China", " Colombia", " Comoros", " Congo (Brazzaville)", " Congo (Kinshasa)", " Costa Rica", " Croatia", " Cuba", " Cyprus", " Czech Republic", " Côte d Ivoire", " Denmark", " Djibouti", " Dominica", " Dominican Republic", " Ecuador", " Egypt", " El Salvador", " Equatorial Guinea", " Eritrea", " Estonia", " Ethiopia", " Fiji", " Finland", " France", " Gabon", " Gambia", " Georgia", " Germany", " Ghana", " Greece", " Grenada", " Guatemala", " Guinea", " Guinea-Bissau", " Guyana", " Haiti", " Holy See (Vatican City State)", " Honduras", " Hungary", " Iceland", " India", " Indonesia", " Iran", " Islamic Republic of", " Iraq", " Ireland", " Israel", " Italy", " Jamaica", " Japan", " Jordan", " Kazakhstan", " Kenya", " Korea (South)", " Kuwait", " Kyrgyzstan", " Lao PDR", " Latvia", " Lebanon", " Lesotho", " Liberia", " Libya", " Liechtenstein", " Lithuania", " Luxembourg", " Macao", " SAR China", " Macedonia", " Republic of", " Madagascar", " Malawi", " Malaysia", " Maldives", " Mali", " Malta", " Mauritania", " Mauritius", " Mexico", " Moldova", " Monaco", " Mongolia", " Montenegro", " Morocco", " Mozambique", " Myanmar", " Namibia", " Nepal", " Netherlands", " New Zealand", " Nicaragua", " Niger", " Nigeria", " Norway", " Oman", " Pakistan", " Palestinian Territory", " Panama", " Papua New Guinea", " Paraguay", " Peru", " Philippines", " Poland", " Portugal", " Qatar", " Republic of Kosovo", " Romania", " Russian Federation", " Rwanda", " Réunion", " Saint Kitts", "Nevis", " Saint Lucia", " Saint Vincent", "Grenadines", " San Marino", " Sao Tome", "Principe", " Saudi Arabia", " Senegal", " Serbia", " Seychelles", " Sierra Leone", " Singapore", " Slovakia", " Slovenia", " Somalia", " South Africa", " South Sudan", " Spain", " Sri Lanka", " Sudan", " Suriname", " Swaziland", " Sweden", " Switzerland", " Syrian Arab Republic (Syria)", " Taiwan", " Republic of China", " Tajikistan", " Tanzania", " United Republic of", " Thailand", " Timor-Leste", " Togo", " Trinidad", "Tobago", " Tunisia", " Turkey", " Uganda", " Ukraine", " United Arab Emirates", " United Kingdom", " United States of America", " Uruguay", " Uzbekistan", " Venezuela (Bolivarian Republic)", " Viet Nam", " Western Sahara", " Yemen", " Zambia", " Zimbabwe"}));

        autoCompleteTextView = findViewById(R.id.autoCompleteworldtotalTextViewId);
        ArrayAdapter arrayadapter = new ArrayAdapter(Covid19WorldTotalActivity.this, R.layout.support_simple_spinner_dropdown_item, countrynamestringlist);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(arrayadapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                url_Country_name = String.valueOf(parent.getItemAtPosition(position));
                namesearchedworldtotal=String.valueOf(parent.getItemAtPosition(position));
                namesearchedworltotalTextView.setText(namesearchedworldtotal+" : ");
                Toast.makeText(Covid19WorldTotalActivity.this, url_Country_name, Toast.LENGTH_LONG).show();

            }
        });

        //new GethashMapItems2().execute();
        if (url_Country_name != null) {
            //https://api.covid19api.com/country//"?from="//"T00:00:00Z&to="//"T00:00:00Z"
            //search country with date range
            url_for_dayrange_search = "https://api.covid19api.com/country/" +
                    url_Country_name;
          /*  Intent intent = new Intent(Covid19WorldTotalActivity.this, SearchCustomActivity.class);
            Bundle bundle1=new Bundle();
            bundle1.putString("countryname",url_Country_name);
            intent.putExtras(bundle);
            startActivity(intent);*/

           // Toast.makeText(Covid19WorldTotalActivity.this, url_Country_name + " From: " + url_Start_Date + " To: " + url_End_Date, Toast.LENGTH_LONG).show();
        }

        final Calendar c2=Calendar.getInstance();
        year_curr=c2.get(Calendar.YEAR);
        month_curr=c2.get(Calendar.MONTH);
        day_curr=c2.get(Calendar.DAY_OF_MONTH);
        month_curr=month_curr+1;
        if((month_curr<10)&&(day_curr<10)){
            currentdate=year_curr+"-"+"0"+month_curr+"-"+"0"+day_curr+"T00:00:00Z";
        }
        else if(month_curr<10){
            currentdate=year_curr+"-"+"0"+month_curr+"-"+day_curr+"T00:00:00Z";
        }
        else if(day_curr<10){
            currentdate=year_curr+"-"+month_curr+"-"+"0"+day_curr+"T00:00:00Z";
        }
        else{
            currentdate=year_curr+"-"+month_curr+"-"+day_curr+"T00:00:00Z";
        }
        Toast.makeText(Covid19WorldTotalActivity.this,"currentdate: "+currentdate,Toast.LENGTH_LONG).show();

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
            if((month_x<10)&&(dayOfMonth<10)){
                formated_date=year_x+"-"+"0"+month_x+"-"+"0"+day_x+"T00:00:00Z";
            }
            else if(month_x<10){
                formated_date=year_x+"-"+"0"+month_x+"-"+day_x+"T00:00:00Z";
            }
            else if(dayOfMonth<10){
                formated_date=year_x+"-"+month_x+"-"+"0"+day_x+"T00:00:00Z";
            }
            else{
                formated_date=year_x+"-"+month_x+"-"+day_x+"T00:00:00Z";
            }
            Toast.makeText(Covid19WorldTotalActivity.this,"searched"+formated_date,Toast.LENGTH_LONG).show();
                new GethashMapItems2().execute();

        }
    };
    private class GethashMapItems2 extends AsyncTask<String, String, Void> {

        // ProgressDialog dialog = new ProgressDialog(getParent(), R.style.progressdialog);
        // The variable is moved here, we only need it here while displaying the


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(Covid19WorldTotalActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();



            //dialog.show();

            // Set the variable txtView here, after setContentView on the dialog
            // has been called! use dialog.findViewById().
            // txtView = dialog.findViewById(R.id.progressMessage);



            Toast.makeText(Covid19WorldTotalActivity.this, "Json Data is downloading", Toast.LENGTH_LONG).show();

        }


        @Override
        protected Void doInBackground(String... urls) {
            //publishProgress("Testing");
            //String url = "https://api.covid19api.com/summary";

            // Toast.makeText(GlobalSummaryActivity.this, "1", Toast.LENGTH_SHORT).show();

            //String url = https://uddokhta.000webhostapp.com/summaryworldtoday.json
            //String url = "https://api.covid19api.com/country/bangladesh";
            String countryname = null;
            int newConfirmed = 0;
            int newDeaths = 0;
            int newRecovered = 0;
            int totalConfirmed = 0;
            int totalDeaths = 0;
            int totalRecovered = 0;
            int pre_totalConfirmed = 0;
            int pre_totalDeaths = 0;
            int pre_totalRecovered = 0;
            int active = 0;
            try {


                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd",Locale.US);
                Date date1 = sdf.parse(formated_date);
                Date date2 = sdf.parse(currentdate);
                if((date1.before(date2)) && (url_Country_name==null)){
                      c.set(year_x,month_x,day_x);
                    c.add(Calendar.DAY_OF_MONTH, 1);
                    int newDate = c.get(Calendar.DAY_OF_MONTH);
                    int newMonth = c.get(Calendar.MONTH);
                    int newYear = c.get(Calendar.YEAR);
                    if((newMonth<10)&&(newDate<10)){
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
                    }

                    String url = "https://api.covid19api.com/world?from=" +
                            formated_date +
                            "T00:00:00Z&to=" +
                            new_formated_date+
                            "T00:00:00Z";
                    //Toast.makeText(GlobalSummaryActivity.this, "2", Toast.LENGTH_SHORT).show();
                    HttpHandler sh = new HttpHandler();
                    //Toast.makeText(GlobalSummaryActivity.this, "3", Toast.LENGTH_LONG).show();

                    // Making a request to url and getting response
                    String jsonStr = sh.makeServiceCall(url);
                    Log.e(TAG, "Response from url: " + jsonStr);
                    if (jsonStr != null) {
                        try {

                            JSONArray jsonArray = new JSONArray(jsonStr);
                            for (int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                newConfirmed = jsonObject.getInt("NewConfirmed");
                                newDeaths = jsonObject.getInt("NewDeaths");
                                newRecovered = jsonObject.getInt("NewRecovered");
                                totalConfirmed = jsonObject.getInt("TotalConfirmed");
                                totalDeaths = jsonObject.getInt("TotalDeaths");
                                totalRecovered = jsonObject.getInt("TotalRecovered");


                            }

                            publishProgress(String.valueOf(newConfirmed), String.valueOf(newDeaths), String.valueOf(newRecovered), String.valueOf(totalConfirmed), String.valueOf(totalDeaths), String.valueOf(totalRecovered));
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


                }
                else if((date1.before(date2)) && (url_Country_name!=null)){
                    c.set(year_x,month_x,day_x);
                    c.add(Calendar.DAY_OF_MONTH, -1);
                    int newDate = c.get(Calendar.DAY_OF_MONTH);
                    int newMonth = c.get(Calendar.MONTH);
                    int newYear = c.get(Calendar.YEAR);
                    if((newMonth<10)&&(newDate<10)){
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
                    }

                  /*  String url ="https://api.covid19api.com/country/" +
                            url_Country_name +
                            "?from=" +
                            formated_date +
                            "T00:00:00Z&to=" +
                            new_formated_date +
                            "T00:00:00Z";*/
                    String url ="https://api.covid19api.com/country/" +
                            url_Country_name;

                    HttpHandler sh = new HttpHandler();
                    //Toast.makeText(GlobalSummaryActivity.this, "3", Toast.LENGTH_LONG).show();

                    // Making a request to url and getting response
                    String jsonStr = sh.makeServiceCall(url);
                    Log.e(TAG, "Response from url: " + jsonStr);
                    if (jsonStr != null) {
                        try {


                            JSONArray jsonArray = new JSONArray(jsonStr);
                            //JSONObject jsonObjectCountry = jsonObj.getJSONObject("Global");
                            //JSONArray jsonArrayCountries=jsonObj.getJSONArray("Countries");
                            //date = jsonObj.getString("Date");

                            for (int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String date=jsonObject.getString("Date");
                                if (date.equals(formated_date)){
                                    //newConfirmed = jsonObject.getInt("Confirmed");
                                    //newDeaths = jsonObject.getInt("Deaths");
                                    // newRecovered = jsonObject.getInt("Recovered");
                                    totalConfirmed = jsonObject.getInt("Confirmed");
                                    totalDeaths = jsonObject.getInt("Deaths");
                                    totalRecovered = jsonObject.getInt("Recovered");
                                    active = jsonObject.getInt("Active");
                                }
                                else if (date.equals(new_formated_date)){
                                    pre_totalConfirmed = jsonObject.getInt("Confirmed");
                                    pre_totalDeaths = jsonObject.getInt("Deaths");
                                    pre_totalRecovered = jsonObject.getInt("Recovered");
                                }
                            }
                            newConfirmed = (totalConfirmed-pre_totalConfirmed);
                            newDeaths = (totalDeaths-pre_totalDeaths);
                            newRecovered = (totalRecovered-pre_totalRecovered);

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
                        /*    runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    Toast.makeText(getApplicationContext(),new_formated_date+"and"+formated_date ,
                                            Toast.LENGTH_LONG).show();
                                }
                            });*/

                            publishProgress( String.valueOf(newConfirmed), String.valueOf(newDeaths), String.valueOf(newRecovered), String.valueOf(totalConfirmed), String.valueOf(totalDeaths), String.valueOf(totalRecovered));

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



                }
                else if(date1.after(date2)){
                    Toast.makeText(getApplicationContext(),"upcomingdate"+":"+formated_date,Toast.LENGTH_LONG).show();

                }
                else if((date1.compareTo(date2)==0) && url_Country_name==null){
                    String url = "https://api.covid19api.com/summary";
                    HttpHandler sh = new HttpHandler();
                    // Making a request to url and getting response
                    String jsonStr = sh.makeServiceCall(url);
                    Log.e(TAG, "Response from url: " + jsonStr);
                    if (jsonStr != null) {
                        try {
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

                            publishProgress(String.valueOf(newConfirmed), String.valueOf(newDeaths), String.valueOf(newRecovered), String.valueOf(totalConfirmed), String.valueOf(totalDeaths), String.valueOf(totalRecovered));
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
                }
                else if((date1.compareTo(date2)==0) && url_Country_name!=null){


                    String url = "https://api.covid19api.com/summary";

                    //Toast.makeText(GlobalSummaryActivity.this, "2", Toast.LENGTH_SHORT).show();

                    HttpHandler sh = new HttpHandler();
                    //Toast.makeText(GlobalSummaryActivity.this, "3", Toast.LENGTH_LONG).show();

                    // Making a request to url and getting response
                    String jsonStr = sh.makeServiceCall(url);
                    Log.e(TAG, "Response from url: " + jsonStr);
                    if (jsonStr != null) {
                        try {

                            JSONObject jsonObj = new JSONObject(jsonStr);
                            //JSONObject jsonObjectCountry = jsonObj.getJSONObject("Global");
                            JSONArray jsonArrayCountries=jsonObj.getJSONArray("Countries");
                            //date = jsonObj.getString("Date");
                            for (int i=0;i<jsonArrayCountries.length();i++){
                                JSONObject jsonObjectCountry = jsonArrayCountries.getJSONObject(i);
                                countryname=jsonObjectCountry.getString("Country");
                                if((countryname.equals(url_Country_name)) || (countryname.equals(url_Country_name))){
                                    newConfirmed = jsonObjectCountry.getInt("NewConfirmed");
                                    newDeaths = jsonObjectCountry.getInt("NewDeaths");
                                    newRecovered = jsonObjectCountry.getInt("NewRecovered");
                                    totalConfirmed = jsonObjectCountry.getInt("TotalConfirmed");
                                    totalDeaths = jsonObjectCountry.getInt("TotalDeaths");
                                    totalRecovered = jsonObjectCountry.getInt("TotalRecovered");
                                }
                            }
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











                }




            } catch (Exception e) {
                e.printStackTrace();
            }





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

            dateofsearchedworldtotal=year_x+"-"+month_x+"-"+day_x;
            dateofsearchedworltotalTextView.setText("Summary ("+dateofsearchedworldtotal+")");

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


