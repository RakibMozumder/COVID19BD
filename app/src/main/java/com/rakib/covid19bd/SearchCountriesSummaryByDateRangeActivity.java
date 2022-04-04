package com.rakib.covid19bd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchCountriesSummaryByDateRangeActivity extends AppCompatActivity {


     private String url_Country_name = null;
     private String url_Start_Date = null;
     private String url_End_Date = null;
     //atcplete Text
     String[] countrynamestringlist;
     AutoCompleteTextView autoCompleteTextView;
     String url_for_dayrange_search ;

     //dpocker





     //String globalsummary, date;
   // int newConfirmed, totalConfirmed, newDeaths, totalDeaths, newRecovered, totalRecovered;

    // private ListView lv;
    // URL to get hashMapItems JSON
    //private static String url = "https://api.covid19api.com/summary/";
    //private SummaryLoader list;

     private ArrayList<String> countrynamearraylist;
    private List<String> countrynamelistlist;
    private ArrayList<String> countrynamelist;
    private TextView countrynameTextView;
    private Button fromDateButton,toDateButton,searchButton;
    private Button readButton,writeButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_countries_summary_by_date_range);

        //readButton=findViewById(R.id.readId);
       // writeButton=findViewById(R.id.writeId);
       /* searchButton=findViewById(R.id.searchButtonId);
        countrynameTextView=findViewById(R.id.urlCountryNameId);

*/

        countrynamestringlist= new String[]{"Afghanistan", " Albania", " Algeria", " Andorra", " Angola", " Antigua", "Barbuda", " Argentina", " Armenia", " Australia", " Austria", " Azerbaijan", " Bahamas", " Bahrain", " Bangladesh", " Barbados", " Belarus", " Belgium", " Belize", " Benin", " Bhutan", " Bolivia", " Bosnia", "Herzegovina", " Botswana", " Brazil", " Brunei Darussalam", " Bulgaria", " Burkina Faso", " Burundi", " Cambodia", " Cameroon", " Canada", " Cape Verde", " Central African Republic", " Chad", " Chile", " China", " Colombia", " Comoros", " Congo (Brazzaville)", " Congo (Kinshasa)", " Costa Rica", " Croatia", " Cuba", " Cyprus", " Czech Republic", " Côte d Ivoire", " Denmark", " Djibouti", " Dominica", " Dominican Republic", " Ecuador", " Egypt", " El Salvador", " Equatorial Guinea", " Eritrea", " Estonia", " Ethiopia", " Fiji", " Finland", " France", " Gabon", " Gambia", " Georgia", " Germany", " Ghana", " Greece", " Grenada", " Guatemala", " Guinea", " Guinea-Bissau", " Guyana", " Haiti", " Holy See (Vatican City State)", " Honduras", " Hungary", " Iceland", " India", " Indonesia", " Iran", " Islamic Republic of", " Iraq", " Ireland", " Israel", " Italy", " Jamaica", " Japan", " Jordan", " Kazakhstan", " Kenya", " Korea (South)", " Kuwait", " Kyrgyzstan", " Lao PDR", " Latvia", " Lebanon", " Lesotho", " Liberia", " Libya", " Liechtenstein", " Lithuania", " Luxembourg", " Macao", " SAR China", " Macedonia", " Republic of", " Madagascar", " Malawi", " Malaysia", " Maldives", " Mali", " Malta", " Mauritania", " Mauritius", " Mexico", " Moldova", " Monaco", " Mongolia", " Montenegro", " Morocco", " Mozambique", " Myanmar", " Namibia", " Nepal", " Netherlands", " New Zealand", " Nicaragua", " Niger", " Nigeria", " Norway", " Oman", " Pakistan", " Palestinian Territory", " Panama", " Papua New Guinea", " Paraguay", " Peru", " Philippines", " Poland", " Portugal", " Qatar", " Republic of Kosovo", " Romania", " Russian Federation", " Rwanda", " Réunion", " Saint Kitts", "Nevis", " Saint Lucia", " Saint Vincent", "Grenadines", " San Marino", " Sao Tome", "Principe", " Saudi Arabia", " Senegal", " Serbia", " Seychelles", " Sierra Leone", " Singapore", " Slovakia", " Slovenia", " Somalia", " South Africa", " South Sudan", " Spain", " Sri Lanka", " Sudan", " Suriname", " Swaziland", " Sweden", " Switzerland", " Syrian Arab Republic (Syria)", " Taiwan", " Republic of China", " Tajikistan", " Tanzania", " United Republic of", " Thailand", " Timor-Leste", " Togo", " Trinidad", "Tobago", " Tunisia", " Turkey", " Uganda", " Ukraine", " United Arab Emirates", " United Kingdom", " United States of America", " Uruguay", " Uzbekistan", " Venezuela (Bolivarian Republic)", " Viet Nam", " Western Sahara", " Yemen", " Zambia", " Zimbabwe"};
        countrynamearraylist= new ArrayList<String>(Arrays.asList(new String[]{"Afghanistan", " Albania", " Algeria", " Andorra", " Angola", " Antigua", "Barbuda", " Argentina", " Armenia", " Australia", " Austria", " Azerbaijan", " Bahamas", " Bahrain", " Bangladesh", " Barbados", " Belarus", " Belgium", " Belize", " Benin", " Bhutan", " Bolivia", " Bosnia", "Herzegovina", " Botswana", " Brazil", " Brunei Darussalam", " Bulgaria", " Burkina Faso", " Burundi", " Cambodia", " Cameroon", " Canada", " Cape Verde", " Central African Republic", " Chad", " Chile", " China", " Colombia", " Comoros", " Congo (Brazzaville)", " Congo (Kinshasa)", " Costa Rica", " Croatia", " Cuba", " Cyprus", " Czech Republic", " Côte d Ivoire", " Denmark", " Djibouti", " Dominica", " Dominican Republic", " Ecuador", " Egypt", " El Salvador", " Equatorial Guinea", " Eritrea", " Estonia", " Ethiopia", " Fiji", " Finland", " France", " Gabon", " Gambia", " Georgia", " Germany", " Ghana", " Greece", " Grenada", " Guatemala", " Guinea", " Guinea-Bissau", " Guyana", " Haiti", " Holy See (Vatican City State)", " Honduras", " Hungary", " Iceland", " India", " Indonesia", " Iran", " Islamic Republic of", " Iraq", " Ireland", " Israel", " Italy", " Jamaica", " Japan", " Jordan", " Kazakhstan", " Kenya", " Korea (South)", " Kuwait", " Kyrgyzstan", " Lao PDR", " Latvia", " Lebanon", " Lesotho", " Liberia", " Libya", " Liechtenstein", " Lithuania", " Luxembourg", " Macao", " SAR China", " Macedonia", " Republic of", " Madagascar", " Malawi", " Malaysia", " Maldives", " Mali", " Malta", " Mauritania", " Mauritius", " Mexico", " Moldova", " Monaco", " Mongolia", " Montenegro", " Morocco", " Mozambique", " Myanmar", " Namibia", " Nepal", " Netherlands", " New Zealand", " Nicaragua", " Niger", " Nigeria", " Norway", " Oman", " Pakistan", " Palestinian Territory", " Panama", " Papua New Guinea", " Paraguay", " Peru", " Philippines", " Poland", " Portugal", " Qatar", " Republic of Kosovo", " Romania", " Russian Federation", " Rwanda", " Réunion", " Saint Kitts", "Nevis", " Saint Lucia", " Saint Vincent", "Grenadines", " San Marino", " Sao Tome", "Principe", " Saudi Arabia", " Senegal", " Serbia", " Seychelles", " Sierra Leone", " Singapore", " Slovakia", " Slovenia", " Somalia", " South Africa", " South Sudan", " Spain", " Sri Lanka", " Sudan", " Suriname", " Swaziland", " Sweden", " Switzerland", " Syrian Arab Republic (Syria)", " Taiwan", " Republic of China", " Tajikistan", " Tanzania", " United Republic of", " Thailand", " Timor-Leste", " Togo", " Trinidad", "Tobago", " Tunisia", " Turkey", " Uganda", " Ukraine", " United Arab Emirates", " United Kingdom", " United States of America", " Uruguay", " Uzbekistan", " Venezuela (Bolivarian Republic)", " Viet Nam", " Western Sahara", " Yemen", " Zambia", " Zimbabwe"}));

        autoCompleteTextView=findViewById(R.id.autoCompleteTextViewId);
        ArrayAdapter arrayadapter=new ArrayAdapter(SearchCountriesSummaryByDateRangeActivity.this,R.layout.support_simple_spinner_dropdown_item,countrynamestringlist);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(arrayadapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                url_Country_name= String.valueOf(parent.getItemAtPosition(position));
                countrynameTextView.setText(String.valueOf(parent.getItemAtPosition(position)));
                Toast.makeText(SearchCountriesSummaryByDateRangeActivity.this,url_Country_name,Toast.LENGTH_LONG).show();
            }
        });
        //
        //countrynameTextView.setText(url_Country_name);


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((url_Country_name!=null) && (url_Start_Date!=null) && (url_End_Date!=null)){
                    //https://api.covid19api.com/country//"?from="//"T00:00:00Z&to="//"T00:00:00Z"
                    //search country with date range
                    url_for_dayrange_search= "https://api.covid19api.com/country/" +
                            url_Country_name;
                    Toast.makeText(SearchCountriesSummaryByDateRangeActivity.this,url_Country_name+" From: "+url_Start_Date+" To: "+url_End_Date,Toast.LENGTH_LONG).show();

                   /* Intent intent = new Intent(SearchCountriesSummaryByDateRangeActivity.this, SearchCovid19Activity.class);
                    Bundle bundle=new Bundle();
                    bundle.putString("country",url_Country_name);
                    intent.putExtras(bundle);
                    startActivity(intent);*/
                    //finish();

                }/*else  if ((url_Country_name!=null) && ((url_Start_Date!=null) ||  (url_End_Date!=null))){
                    //https://api.covid19api.com/live/country/south-africa
                    //country with all time tillcurrrent date
                    url_for_dayrange_search= "https://api.covid19api.com/live/country/" +
                            url_Country_name;
                    Toast.makeText(SearchCountriesSummaryByDateRangeActivity.this,url_Country_name+" From: "+url_Start_Date+" To: "+url_End_Date,Toast.LENGTH_LONG).show();


                }else  if ((url_Country_name!=null) ){
                    //https://api.covid19api.com/total/dayone/country/Bangladesh
                  //  https://api.covid19api.com/dayone/country/south-africa
                    //country with all time
                    url_for_dayrange_search= "https://api.covid19api.com/total/dayone/country/" +
                            url_Country_name;
                    Toast.makeText(SearchCountriesSummaryByDateRangeActivity.this,url_Country_name+" From: "+url_Start_Date+" To: "+url_End_Date,Toast.LENGTH_LONG).show();


                }else  if ((url_Start_Date!=null) && (url_End_Date!=null) ){
                   // https://api.covid19api.com/world?from=2020-09-01T00:00:00Z&to=2020-09-01T00:00:00Z
                    //world alltime all country summary
                    url_for_dayrange_search= "https://api.covid19api.com/" +
                            "world" +
                            "?from=" +
                            url_Start_Date +
                            "T00:00:00Z&to=" +
                            url_End_Date +
                            "T00:00:00Z";
                    Toast.makeText(SearchCountriesSummaryByDateRangeActivity.this,url_Country_name+" From: "+url_Start_Date+" To: "+url_End_Date,Toast.LENGTH_LONG).show();


                }else  if ((url_Start_Date!=null)|| (url_End_Date!=null) ){

                    url_for_dayrange_search= "https://api.covid19api.com/country/" +
                            url_Country_name +
                            "?from=" +
                            url_Start_Date +
                            "T00:00:00Z&to=" +
                            url_End_Date +
                            "T00:00:00Z";
                    Toast.makeText(SearchCountriesSummaryByDateRangeActivity.this,url_Country_name+" From: "+url_Start_Date+" To: "+url_End_Date,Toast.LENGTH_LONG).show();


                }*//*else{
                   // https://api.covid19api.com/world/total
                    //total world now
                    url_for_dayrange_search= "https://api.covid19api.com/country/" +
                            url_Country_name +
                            "?from=" +
                            url_Start_Date +
                            "T00:00:00Z&to=" +
                            url_End_Date +
                            "T00:00:00Z";
                    Toast.makeText(SearchCountriesSummaryByDateRangeActivity.this,url_Country_name+" From: "+url_Start_Date+" To: "+url_End_Date,Toast.LENGTH_LONG).show();

                }*/

            }
        });
        //
    /*    writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    //https://api.covid19api.com/countries     //Slug
                    FileOutputStream fileOutputStream=openFileOutput("countryname7.txt",MODE_PRIVATE);
                    fileOutputStream.write(countrynamelist.toString().getBytes());
                    fileOutputStream.close();
                    Toast.makeText(SearchCountriesSummaryByDateRangeActivity.this,"complete",Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream fileInputStream=openFileInput("countryname7.txt");
                    InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
                    BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                    StringBuffer stringBuffer=new StringBuffer();
                    String lines;
                    while ((lines=bufferedReader.readLine())!=null){
                        stringBuffer.append(lines+",");
                        countrynamelist.add(lines);

                    }
                    searchByDatelistView.setAdapter(new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,countrynamelist));


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }



                Toast.makeText(SearchCountriesSummaryByDateRangeActivity.this,"completeread",Toast.LENGTH_LONG).show();

            }
        });*/

    }





}