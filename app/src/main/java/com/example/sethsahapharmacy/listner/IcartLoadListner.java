package com.example.sethsahapharmacy.listner;

import com.example.sethsahapharmacy.model.CartModel;
import com.example.sethsahapharmacy.model.Medicinemodel;

import java.util.List;

public interface IcartLoadListner {
    void onCartLoadSuccess(List<CartModel> cartModelList);
    void onCartLoadFailed(String message);

}
