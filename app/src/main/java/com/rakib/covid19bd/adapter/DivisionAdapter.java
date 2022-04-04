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
import com.rakib.covid19bd.model.Divisionmodel;
import com.rakib.covid19bd.model.SummaryCountries;

import java.util.List;

public class DivisionAdapter extends ArrayAdapter<Divisionmodel>{
    
    private Context callerContext;
    
    public DivisionAdapter(Context context, List<Divisionmodel> listDivision) {
        super(context, 0, listDivision);
        this.callerContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_list_division, parent, false);
        }

        // Find the summary at the given position in the list of summaries
        final Divisionmodel currentRow = getItem(position);


        // Find the TextView with view ID name
        TextView dateTextView = listItemView.findViewById(R.id.itemdivisiondateId);
        // Display the name of the province in current summary in nameView
        dateTextView.setText(currentRow.getDate());

        // Find the TextView with view ID name
        TextView districtTextView = listItemView.findViewById(R.id.item_divisiondistrictnameId);
        // Display the name of the province in current summary in nameView
        districtTextView.setText(currentRow.getDistrict());
        ;

        TextView divisionTextView = listItemView.findViewById(R.id.item_divisiondivisionnameId);
        divisionTextView.setText((currentRow.getDivision()));

        TextView confirmedTextView = listItemView.findViewById(R.id.item_divisionconfirmcaseId);
        confirmedTextView.setText(currentRow.getIedcr_confirmed());

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }
}

