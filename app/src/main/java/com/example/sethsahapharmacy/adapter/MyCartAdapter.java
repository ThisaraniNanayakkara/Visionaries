package com.example.sethsahapharmacy.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sethsahapharmacy.R;
import com.example.sethsahapharmacy.eventbus.MyUpdateCartEvent;
import com.example.sethsahapharmacy.model.CartModel;
import com.google.firebase.database.FirebaseDatabase;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MyCartAdapter extends RecyclerView.Adapter<MyCartAdapter.MyCartViewHolder> {

    private Context context;
    private List<CartModel> cartModelList;

    public MyCartAdapter(Context context, List<CartModel> cartModelList) {
        this.context = context;
        this.cartModelList = cartModelList;
    }

    @NonNull
    @Override
    public MyCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyCartViewHolder(LayoutInflater.from(context)
        .inflate(R.layout.layout_cart_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyCartViewHolder holder, int position) {
        Glide.with(context)
                .load(cartModelList.get(position).getImage())
                .into(holder.imageView);
        holder.txt_Price.setText(new StringBuilder("$").append(cartModelList.get(position).getPrice()));
        holder.txt_Name.setText(new StringBuilder().append(cartModelList.get(position).getName()));
        holder.txt_qty.setText(new StringBuilder().append(cartModelList.get(position).getQuantity()));

        //Event
        holder.p1_minus.setOnClickListener(v ->{
            minusCartItem(holder,cartModelList.get(position));
        });
        holder.p1_plus.setOnClickListener(v ->{
            plusCartItem(holder,cartModelList.get(position));
        });

        holder.p1_bin.setOnClickListener( v -> {
            AlertDialog dialog = new AlertDialog.Builder(context)
                    .setTitle("Delete").setMessage("Are you sure?")
                    .setNegativeButton("Cancel", (dialog1, which) -> dialog1.dismiss())
                    .setPositiveButton("Ok", (dialog12, which) -> {

                        //Temporary Remove
                        notifyItemRemoved(position);

                        deleteFromFirebase(cartModelList.get(position));
                        dialog12.dismiss();

                    }).create();
            dialog.show();
        });
    }

    private void deleteFromFirebase(CartModel cartModel) {
        FirebaseDatabase.getInstance()
                .getReference("cart").child("UNIQUE_USER_ID").child(cartModel.getKey())
                .removeValue()
                .addOnSuccessListener(aVoid -> EventBus.getDefault().postSticky(new MyUpdateCartEvent()));
    }

    private void plusCartItem(MyCartViewHolder holder, CartModel cartModel) {
        cartModel.setQuantity(cartModel.getQuantity()+1);
        cartModel.setTotalPrice(cartModel.getQuantity()*Float.parseFloat(cartModel.getPrice()));

        //Update Quantity
        holder.txt_qty.setText(new StringBuilder().append(cartModel.getQuantity()));
        updateFirebase(cartModel);
    }

    private void minusCartItem(MyCartViewHolder holder, CartModel cartModel) {
        if(cartModel.getQuantity() > 1)
        {
            cartModel.setQuantity(cartModel.getQuantity()-1);
            cartModel.setTotalPrice(cartModel.getQuantity()*Float.parseFloat(cartModel.getPrice()));

            //Update Quantity
            holder.txt_qty.setText(new StringBuilder().append(cartModel.getQuantity()));
            updateFirebase(cartModel);
        }
    }

    private void updateFirebase(CartModel cartModel) {
        FirebaseDatabase.getInstance()
                .getReference("cart").child("UNIQUE_USER_ID").child(cartModel.getKey())
                .setValue(cartModel)
                .addOnSuccessListener(aVoid -> EventBus.getDefault().postSticky(new MyUpdateCartEvent()));

    }

    @Override
    public int getItemCount() {
        return cartModelList.size();
    }

    public class MyCartViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.p1_minus)
        ImageView p1_minus;
        @BindView(R.id.p1_plus)
        ImageView p1_plus;
        @BindView(R.id.p1_bin)
        ImageView p1_bin;
        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.txt_Name)
        TextView txt_Name;
        @BindView(R.id.txt_Price)
        TextView txt_Price;
        @BindView(R.id.txt_qty)
        TextView txt_qty;

        Unbinder unbinder;
        public MyCartViewHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this,itemView);
        }
    }
}
