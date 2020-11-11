package com.example.retrofit2_mvp_api.model;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit2_mvp_api.R;

import java.util.ArrayList;

/**
 * Created by QuocKM on 10,November,2020
 * EbizWorld company,
 * HCMCity, VietNam.
 */
public class StaticRvAdapter extends RecyclerView.Adapter<StaticRvAdapter.StaticRVViewHolder> {

    private ArrayList<StaticRvModel> items;
    int row_index = -1;

    public StaticRvAdapter(ArrayList<StaticRvModel> items) {
        this.items = items;
    }


    @NonNull
    @Override
    public StaticRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.static_rv_item, parent, false);
        StaticRVViewHolder staticRVViewHolder = new StaticRVViewHolder(view);
        return staticRVViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StaticRVViewHolder holder, int position) {
         StaticRvModel currentItem = items.get(position);
         holder.imageView.setImageResource(currentItem.getImage());
         holder.textView.setText(currentItem.getText());

         holder.linearLayout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 row_index = position;
                 notifyDataSetChanged();

             }
         });

         if(row_index == position){
             holder.linearLayout.setBackgroundResource(R.drawable.static_rv_selected);
         }
         else {
             holder.linearLayout.setBackgroundResource(R.drawable.static_rv_bg);
         }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class StaticRVViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView imageView;
        LinearLayout linearLayout;

        @SuppressLint("CutPasteId")
        public StaticRVViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgItem1);
            textView = itemView.findViewById(R.id.txtItem1);
            linearLayout = itemView.findViewById(R.id.linerlayout);
        }
    }
}
