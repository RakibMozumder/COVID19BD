package com.rakib.covid19bd.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rakib.covid19bd.R;
import com.rakib.covid19bd.model.SummaryCountries;
import com.rakib.covid19bd.model.SummaryWorld;

import java.util.List;

public class SummaryCountriesAdapter extends ArrayAdapter<SummaryCountries> {
    private Context callerContext;
    public SummaryCountriesAdapter(Context context, List<SummaryCountries> listSummaries) {
        super(context, 0, listSummaries);
        this.callerContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.summarycountries_list_item, parent, false);
        }

        // Find the summary at the given position in the list of summaries
        final SummaryCountries currentSummaryCountry = getItem(position);


        // Find the TextView with view ID name
        TextView nameView = listItemView.findViewById(R.id.summaryCountriesNameId);
        // Display the name of the province in current summary in nameView
        nameView.setText(currentSummaryCountry.getName());

        // Find the TextView with view ID name
        TextView dateView = listItemView.findViewById(R.id.summaryCoutriesDateId);
        // Display the name of the province in current summary in nameView
        dateView.setText(currentSummaryCountry.getDate());
;

        TextView newConfirmedView = listItemView.findViewById(R.id.summaryCountriesnewConfirmId);
        newConfirmedView.setText(String.valueOf(currentSummaryCountry.getNewConfirmed()));

        TextView newDeathView = listItemView.findViewById(R.id.summaryCountriesnewDeathId);
        newDeathView.setText(String.valueOf(currentSummaryCountry.getNewDeaths()));

        TextView newRecoverView = listItemView.findViewById(R.id.summaryCountriesnewRecoverId);
        newRecoverView.setText(String.valueOf(currentSummaryCountry.getNewRecovered()));

        TextView totalConfirmView = listItemView.findViewById(R.id.summaryCountriestotalConfirmId);
        totalConfirmView.setText(String.valueOf(currentSummaryCountry.getTotalConfirmed()));

        TextView totalDeathView = listItemView.findViewById(R.id.summaryCountriestotalDeathId);
        totalDeathView.setText(String.valueOf(currentSummaryCountry.getTotalDeaths()));

        TextView totalRecoveredView = listItemView.findViewById(R.id.summaryCountriestotalRecoverId);
        totalRecoveredView.setText(String.valueOf(currentSummaryCountry.getTotalRecovered()));

        ImageView deleteIcon = listItemView.findViewById(R.id.delete_SummaryCountriesId);
        deleteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String countryName = currentSummaryCountry.getName();
                remove(currentSummaryCountry);
                //SummaryDbHelper dbHelper = new SummaryDbHelper(SummaryAdapter.this.callerContext);
                //SQLiteDatabase db = dbHelper.getWritableDatabase();
                //db.delete(SummaryContract.SummaryEntry.TABLE_NAME, SummaryContract.SummaryEntry.COLUMN_PROVINCE_NAME + "=?", new String[] {provinceName});
                Toast.makeText(SummaryCountriesAdapter.this.callerContext, String.format("Deleted Country %s", countryName), Toast.LENGTH_SHORT).show();
            }
        });

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }
}
