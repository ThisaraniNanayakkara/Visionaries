package com.mad2021.sethsaha;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductVH extends RecyclerView.ViewHolder {
    public TextView txt_id,txt_name,txt_option;
    public ProductVH(@NonNull View itemView) {
        super(itemView);
        txt_id = itemView.findViewById(R.id.txt_id);
        txt_name = itemView.findViewById(R.id.txt_name);
        txt_option = itemView.findViewById(R.id.txt_option);
    }
}
