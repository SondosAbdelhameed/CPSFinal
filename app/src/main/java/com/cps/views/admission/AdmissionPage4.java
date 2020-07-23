package com.cps.views.admission;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.cps.R;
import com.cps.databinding.FragmentAdmissionP4Binding;
import com.cps.helpers.GlobalFunction;
import com.cps.models.requests.SendAdmission;
import com.cps.models.requests.SendAdmissionMedia;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class AdmissionPage4 extends Fragment {

    FragmentAdmissionP4Binding binding;
    SendAdmission admission;
    SendAdmissionMedia admissionMedia;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_admission_p4, container, false);
        admission = (SendAdmission) getArguments().getSerializable("admission");
        admissionMedia = (SendAdmissionMedia) getArguments().getSerializable("admissionMedia");
        binding.setAdmission(admission);

        binding.imgStuPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (new GlobalFunction().isPermissionGranted(getActivity()))
                openGallery(601);
            }
        });
        binding.imgStuBirthCertificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (new GlobalFunction().isPermissionGranted(getActivity()))
                openGallery(602);
            }
        });
        binding.imgFatherId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (new GlobalFunction().isPermissionGranted(getActivity()))
                openGallery(603);
            }
        });
        binding.imgMotherId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (new GlobalFunction().isPermissionGranted(getActivity()))
                openGallery(604);
            }
        });
        binding.imgFatherQualify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (new GlobalFunction().isPermissionGranted(getActivity()))
                openGallery(605);
            }
        });
        binding.imgMotherQualify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (new GlobalFunction().isPermissionGranted(getActivity()))
                openGallery(606);
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.clear();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(getActivity(), "Canceled", Toast.LENGTH_SHORT).show();
        } else if (resultCode == Activity.RESULT_OK)  {
            if (data != null) {
                getImage(requestCode,data);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 3:
                Log.d("Permission", "External storage2");
                if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    Log.v("Permission","Permission: "+permissions[0]+ "was "+grantResults[0]);
                    //resume tasks needing this permission
                   // downloadPdfFile();
                }else if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
                    Log.v("Permission","Permission: "+permissions[0]+ "was "+grantResults[0]);
                    //resume tasks needing this permission
                    // SharePdfFile();
                }else{
                    // progress.dismiss();
                }
                break;
        }
    }

    public static AdmissionPage4 newInstance(SendAdmission admission , SendAdmissionMedia admissionMedia) {

        AdmissionPage4 f = new AdmissionPage4();
        Bundle b = new Bundle();
        b.putSerializable("admission", admission);
        b.putSerializable("admissionMedia", admissionMedia);
        f.setArguments(b);
        return f;
    }

    public boolean isValidate() {

        boolean check = true;

        if(admissionMedia.getStuPhoto() == null || admissionMedia.getStuPhoto().isEmpty()) {
            check = false;
            binding.tvStuPhoto.setError(getString(R.string.error_image_selected));
        }
        if(admissionMedia.getStuBirthPhoto() == null || admissionMedia.getStuBirthPhoto().isEmpty()) {
            check = false;
            binding.tvStuBirthCertificate.setError(getString(R.string.error_image_selected));
        }
        if(admissionMedia.getStuFaIdPhoto() == null || admissionMedia.getStuFaIdPhoto().isEmpty()) {
            check = false;
            binding.tvFatherId.setError(getString(R.string.error_image_selected));
        }
        if(admissionMedia.getStuMoIdPhoto() == null || admissionMedia.getStuMoIdPhoto().isEmpty()) {
            check = false;
            binding.tvMotherId.setError(getString(R.string.error_image_selected));
        }
        if(admissionMedia.getStuFaQualPhoto() == null || admissionMedia.getStuFaQualPhoto().isEmpty()) {
            admission.setStuFaQualPhoto("false");
        }
        if(admissionMedia.getStuMoQualPhoto() == null || admissionMedia.getStuMoQualPhoto().isEmpty()) {
            admission.setStuMoQualPhoto("false");
        }

        /**
         * if return false show the error message for each fragment
         * */
        return check;
    }

    void openGallery(int code){

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), code);
    }

    void getImage(int code , Intent data){

        Bitmap bitmap;
        BitmapDrawable bitmapDrawable;
        try {
            bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), data.getData());
            bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
            String base = toBase64(bitmap);
            if (code == 601){
                admission.setStuPhoto("true");
                admissionMedia.setStuPhoto(base);
                binding.imgStuPhoto.setBackground(bitmapDrawable);
            }else if (code == 602){
                admission.setStuBirthPhoto("true");
                admissionMedia.setStuBirthPhoto(base);
                binding.imgStuBirthCertificate.setBackground(bitmapDrawable);
            }else if (code == 603){
                admission.setStuFaIdPhoto("true");
                admissionMedia.setStuFaIdPhoto(base);
                binding.imgFatherId.setBackground(bitmapDrawable);
            }else if (code == 604){
                admission.setStuMoIdPhoto("true");
                admissionMedia.setStuMoIdPhoto(base);
                binding.imgMotherId.setBackground(bitmapDrawable);
            }else if (code == 605){
                admission.setStuFaQualPhoto("true");
                admissionMedia.setStuFaQualPhoto(base);
                binding.imgFatherQualify.setBackground(bitmapDrawable);
            }else if (code == 606){
                admission.setStuMoQualPhoto("true");
                admissionMedia.setStuMoQualPhoto(base);
                binding.imgMotherQualify.setBackground(bitmapDrawable);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String toBase64(Bitmap bitmap){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos); //bm is the bitmap object
        byte[] b = baos.toByteArray();

        String encodedImage = Base64.encodeToString(b, Base64.DEFAULT);

        return encodedImage;
    }

}
