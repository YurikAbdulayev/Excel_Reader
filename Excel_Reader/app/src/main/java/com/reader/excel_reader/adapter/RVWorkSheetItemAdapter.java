package com.reader.excel_reader.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.reader.excel_reader.R;
import com.reader.excel_reader.models.WorkSheetModels;

import java.util.List;

/**
 * Created by yurik on 03.03.16.
 */
public class RVWorkSheetItemAdapter extends RecyclerView.Adapter<RVWorkSheetItemAdapter.ViewHolder>{

    public RVWorkSheetItemAdapter(List<WorkSheetModels> lSheetModels) {
        this.lSheetModels = lSheetModels;
    }

    private List<WorkSheetModels> lSheetModels;



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_work_sheet, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(lSheetModels.get(position).getString());
    }

    @Override
    public int getItemCount() {
        return lSheetModels != null? lSheetModels.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;


        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_item_work_sheet);
        }
    }
}
