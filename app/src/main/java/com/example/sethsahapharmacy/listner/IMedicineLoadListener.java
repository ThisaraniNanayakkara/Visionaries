package com.example.sethsahapharmacy.listner;

import com.example.sethsahapharmacy.model.Medicinemodel;

import java.util.List;

// missing import

public interface IMedicineLoadListener {

    void onMedicineLoadSuccess(List<Medicinemodel> medicinemodelList);
    void onMedicineLoadFailed(String message);

}
