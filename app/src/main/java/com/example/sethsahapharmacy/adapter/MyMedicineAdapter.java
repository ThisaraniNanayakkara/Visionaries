package com.example.sethsahapharmacy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sethsahapharmacy.R;
import com.example.sethsahapharmacy.listner.IRecycleViewListener;
import com.example.sethsahapharmacy.model.Medicinemodel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MyMedicineAdapter extends RecyclerView.Adapter<MyMedicineAdapter.MyMedicineViewHolder> {

    private Context context;
    private List<Medicinemodel> medicinemodelList;

    public MyMedicineAdapter(Context context, List<Medicinemodel> medicinemodelList) {
        this.context = context;
        this.medicinemodelList = medicinemodelList;
    }

    @NonNull
    @Override
    public MyMedicineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyMedicineViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_medicine_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyMedicineViewHolder holder, int position) {
        Glide.with(context).load(medicinemodelList.get(position).getImage())
             .into(holder.imageView);
        holder.txtPrice.setText(new StringBuilder("$").append(medicinemodelList.get(position).getPrice()));
        holder.txtName.setText(new StringBuilder().append(medicinemodelList.get(position).getName()));
    }

    @Override
    public int getItemCount() {
        return medicinemodelList.size();
    }

    public class MyMedicineViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.txtName)
        TextView txtName;
        @BindView(R.id.price)
        TextView txtPrice;

        IRecyclerViewClickListener listner;

        public void setListner(IRecyclerViewClickListener listner) {
            this.listner = listner;
        }

        private Unbinder unbinder;
        public MyMedicineViewHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this,itemView);
        }
    }
}
