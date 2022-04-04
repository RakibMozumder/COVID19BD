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
import com.rakib.covid19bd.model.SearchByDateRangeCountrySummary;
import com.rakib.covid19bd.model.SummaryCountries;

import java.util.List;

public class SearchByDateRangeCountriesSummaryAdapter extends ArrayAdapter<SearchByDateRangeCountrySummary> {
    private Context callerContext;
    public SearchByDateRangeCountriesSummaryAdapter(Context context, List<SearchByDateRangeCountrySummary> listSummaries) {
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
                    R.layout.searchcountrysumbydate_range_list_item, parent, false);
        }

        // Find the summary at the given position in the list of summaries
        final SearchByDateRangeCountrySummary currentRow = getItem(position);


        // Find the TextView with view ID name
        TextView confirmedView = listItemView.findViewById(R.id.confirmed_textView);
        TextView activeView = listItemView.findViewById(R.id.active_textView);
        TextView recoveredView = listItemView.findViewById(R.id.recovered_textView);
        TextView deathView = listItemView.findViewById(R.id.death_textView);
        // Display the name of the province in current summary in nameView
       confirmedView.setText(currentRow.getConfirmed());

        // Find the TextView with view ID name

        // Display the name of the province in current summary in nameView
        activeView.setText(currentRow.getActive());
        recoveredView.setText(currentRow.getRecovered());
        deathView.setText(currentRow.getDeaths());

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }
}
