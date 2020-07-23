package com.cps.views.admission;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.widget.AppCompatSpinner;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cps.models.requests.SendAdmission;
import com.cps.models.requests.SendAdmissionMedia;
import com.cps.models.responses.JsonResponse;


public class AdmissionViewModel extends ViewModel {

    AdmissionRepository repository;

    final MutableLiveData<JsonResponse> liveData = new MutableLiveData<>();
    final MutableLiveData<Integer> liveDataMedia = new MutableLiveData<>();


    /**
     * If you need to separate event error from news error create new live data
     */
    final MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();

    public AdmissionViewModel() {
        repository = new AdmissionRepository();
    }

     void send_admission(SendAdmission admission ){
         repository.requestadmissiondata(admission ,liveData , errorLiveData);
    }

     void send_admission_media(SendAdmissionMedia admission ){
         repository.requestadmissionmedia(admission , liveDataMedia ,errorLiveData);
    }



/*
    @InverseBindingAdapter(attribute = "bind:pmtOpt",
            event = "bind:pmtOptAttrChanged")
    public static String getPmtOpt(final AppCompatSpinner spinner) {
        return (String)spinner.getSelectedItem();
    }*/

    /*@InverseBindingAdapter(attribute = "android:selectedItemPosition")
    public Integer SelectedItem(Spinner spinner) {
        return spinner.getSelectedItemPosition();
    }*/

    @BindingAdapter(value = {"selectedValue", "selectedValueAttrChanged"}, requireAll = false)
    public static void bindSpinnerData(AppCompatSpinner pAppCompatSpinner, String newSelectedValue, final InverseBindingListener newTextAttrChanged) {
        pAppCompatSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                newTextAttrChanged.onChange();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                newTextAttrChanged.onChange();
            }
        });
        if (newSelectedValue != null) {
            int pos = ((ArrayAdapter<String>) pAppCompatSpinner.getAdapter()).getPosition(newSelectedValue);
            pAppCompatSpinner.setSelection(pos, true);

        }else {
            int pos = ((ArrayAdapter<String>) pAppCompatSpinner.getAdapter()).getPosition(newSelectedValue);

            // pAppCompatSpinner.getAdapter().getItem(0);
            pAppCompatSpinner.setSelection(pos, true);
        }
    }

    @InverseBindingAdapter(attribute = "selectedValue", event = "selectedValueAttrChanged")
    public static String captureSelectedValue(Spinner pAppCompatSpinner) {
        //pAppCompatSpinner.getSelectedItemPosition();
        return (String) pAppCompatSpinner.getSelectedItem();
    }


    /*@InverseBindingMethods({
            @InverseBindingMethod(type = AdapterView.class, attribute = "android:selectedItemPosition"),
            @InverseBindingMethod(type = AdapterView.class, attribute = "android:selection",
                    method = "getSelectedItemPosition",
                    event = "android:selectedItemPositionAttrChanged"),
    })*/
    /*
    @BindingAdapter("android:selectedItemPosition")
    public static void setSelectedItemPosition(AdapterView view, int position) {
        if (view.getSelectedItemPosition() != position) {
            view.setSelection(position);
        }
    }

    @BindingAdapter(value = {"android:onItemSelected", "android:onNothingSelected",
            "android:selectedItemPositionAttrChanged" }, requireAll = false)
    public static void setOnItemSelectedListener(AdapterView view, final AdapterViewBindingAdapter.OnItemSelected selected,
                                                 final AdapterViewBindingAdapter.OnNothingSelected nothingSelected, final InverseBindingListener attrChanged) {
        if (selected == null && nothingSelected == null && attrChanged == null) {
            view.setOnItemSelectedListener(null);
        } else {
            view.setOnItemSelectedListener(
                    new AdapterViewBindingAdapter.OnItemSelectedComponentListener(selected, nothingSelected, attrChanged));
        }
    }

    */

}
