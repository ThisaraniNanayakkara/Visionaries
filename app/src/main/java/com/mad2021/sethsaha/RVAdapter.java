package com.mad2021.sethsaha;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private Context context;
    ArrayList<Products> list = new ArrayList<>();
    public RVAdapter(Context ctx)
    {
        this.context = ctx;
    }
    public void setItems(ArrayList<Products> products)
    {
        list.addAll(products);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
        return new ProductVH(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        Products e = null;
        this.onBindViewHolder(holder,position,e);
    }

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position, Products e)
    {
        ProductVH vh = (ProductVH) holder;
        Products products = e==null? list.get(position):e;
        vh.txt_id.setText(products.getID());
        vh.txt_name.setText(products.getPname());
//        vh.txt_price.setText(products.getPname());
        vh.txt_option.setOnClickListener(v->
        {
            PopupMenu popupMenu =new PopupMenu(context,vh.txt_option);
            popupMenu.inflate(R.menu.option_menu);
            popupMenu.setOnMenuItemClickListener(item->
            {
                switch (item.getItemId())
                {
                    case R.id.menu_edit:
                        Intent intent=new Intent(context,MainActivity.class);
                        intent.putExtra("EDIT",products);
                        context.startActivity(intent);
                        break;
                    case R.id.menu_remove:
                        DAOProducts dao=new DAOProducts();
                        dao.remove(products.getKey()).addOnSuccessListener(suc->
                        {
                            Toast.makeText(context, "Record is removed", Toast.LENGTH_SHORT).show();
                            notifyItemRemoved(position);
                            list.remove(products);
                        }).addOnFailureListener(er->
                        {
                            Toast.makeText(context, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
                        });

                        break;
                }
                return false;
            });
            popupMenu.show();
        });
    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }
}
