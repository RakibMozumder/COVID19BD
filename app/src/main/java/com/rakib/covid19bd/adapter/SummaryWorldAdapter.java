package com.rakib.covid19bd.adapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.rakib.covid19bd.R;
import com.rakib.covid19bd.model.SummaryWorld;

import java.util.List;

public class SummaryWorldAdapter extends ArrayAdapter<SummaryWorld> {
    private Context callerContext;
    public SummaryWorldAdapter(Context context, List<SummaryWorld> listSummaries) {
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
                    R.layout.summaryworld_list_item, parent, false);
        }

        // Find the summary at the given position in the list of summaries
        final SummaryWorld currentSummary = getItem(position);

        // Find the TextView with view ID name
        TextView dateView = listItemView.findViewById(R.id.summaryGlobaltodayId);
        // Display the name of the province in current summary in nameView
        dateView.setText(currentSummary.getDate());

        TextView newConfirmedView = listItemView.findViewById(R.id.newConfirmId);
        newConfirmedView.setText(String.valueOf(currentSummary.getNewConfirmed()));

        TextView newDeathView = listItemView.findViewById(R.id.newDeathId);
        newDeathView.setText(String.valueOf(currentSummary.getNewDeaths()));

        TextView newRecoverView = listItemView.findViewById(R.id.newRecoverId);
        newRecoverView.setText(String.valueOf(currentSummary.getNewRecovered()));

        TextView totalConfirmView = listItemView.findViewById(R.id.totalConfirmId);
        totalConfirmView.setText(String.valueOf(currentSummary.getTotalConfirmed()));

        TextView totalDeathView = listItemView.findViewById(R.id.totalDeathId);
        totalDeathView.setText(String.valueOf(currentSummary.getTotalDeaths()));

        ImageView deleteIcon = listItemView.findViewById(R.id.delete_province);
        deleteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dateName = currentSummary.getDate();
                remove(currentSummary);
                //SummaryDbHelper dbHelper = new SummaryDbHelper(SummaryAdapter.this.callerContext);
                //SQLiteDatabase db = dbHelper.getWritableDatabase();
                //db.delete(SummaryContract.SummaryEntry.TABLE_NAME, SummaryContract.SummaryEntry.COLUMN_PROVINCE_NAME + "=?", new String[] {provinceName});
                Toast.makeText(SummaryWorldAdapter.this.callerContext, String.format("Deleted Country %s", dateName), Toast.LENGTH_SHORT).show();
            }
        });

        // Return the list item view that is now showing the appropriate data
        return listItemView;
    }
}
