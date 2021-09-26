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
import com.example.sethsahapharmacy.eventbus.MyUpdateCartEvent;
import com.example.sethsahapharmacy.listner.IRecyclerViewClickListener;
import com.example.sethsahapharmacy.listner.IcartLoadListner;
import com.example.sethsahapharmacy.model.CartModel;
import com.example.sethsahapharmacy.model.Medicinemodel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class MyMedicineAdapter extends RecyclerView.Adapter<MyMedicineAdapter.MyMedicineViewHolder> {

    private Context context;
    private List<Medicinemodel> medicinemodelList;
    private IcartLoadListner icartLoadListner;

    public MyMedicineAdapter(Context context, List<Medicinemodel> medicinemodelList, IcartLoadListner icartLoadListner) {
        this.context = context;
        this.medicinemodelList = medicinemodelList;
        this.icartLoadListner = icartLoadListner;
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

//        holder.setlistener((view, adapterPosition) -> {
//            addToCart(medicinemodelList.get(position));
//        });


    }

    private void addToCart(Medicinemodel medicineModel) {
        DatabaseReference userCart = FirebaseDatabase
                .getInstance()
                .getReference("Cart")
                .child("UNIQUE_USER_ID");

        userCart.child(medicineModel.getKey())
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()) //If user already has item in cart
                        {
                            //Just Update quantity  and total Price
                            CartModel cartModel = snapshot.getValue(CartModel.class);
                            cartModel.setQuantity(cartModel.getQuantity()+1);
                            Map<String,Object> updateData = new HashMap<>();
                            updateData.put("quantity", cartModel.getQuantity());
                            updateData.put("totalPrice", cartModel.getQuantity()*Float.parseFloat(cartModel.getPrice()));

                            userCart.child(medicineModel.getKey())
                                    .updateChildren(updateData)
                                    .addOnSuccessListener(aVoid -> {
                                        icartLoadListner.onCartLoadFailed("Added to Cart");
                                    })
                                    .addOnFailureListener(e -> icartLoadListner.onCartLoadFailed(e.getMessage()));
                        }
                        else //If Item not in cart; add new
                        {
                            CartModel cartModel = new CartModel();
                            cartModel.setName(medicineModel.getName());
                            cartModel.setImage(medicineModel.getImage());
                            cartModel.setKey(medicineModel.getKey());
                            cartModel.setPrice(medicineModel.getPrice());
                            cartModel.setQuantity(1);
                            cartModel.setTotalPrice(Float.parseFloat(medicineModel.getPrice()));

                            userCart.child(medicineModel.getKey())
                                    .setValue(cartModel)
                                    .addOnSuccessListener(aVoid -> {
                                        icartLoadListner.onCartLoadFailed("Added to Cart");
                                    })
                                    .addOnFailureListener(e -> icartLoadListner.onCartLoadFailed(e.getMessage()));

                        }
                        EventBus.getDefault().postSticky(new MyUpdateCartEvent());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        icartLoadListner.onCartLoadFailed(error.getMessage());
                    }
                });
    }


    @Override
    public int getItemCount() {
        return medicinemodelList.size();
    }

    public class MyMedicineViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.txtName)
        TextView txtName;
        @BindView(R.id.price)
        TextView txtPrice;

        IRecyclerViewClickListener listener;

        private Unbinder unbinder;
        public MyMedicineViewHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onRecyclerClick(view,getAdapterPosition());
        }



    }
}
