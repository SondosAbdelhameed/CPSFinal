package com.cps.views.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cps.models.responses.GalleryItem;

import java.util.List;

public class GalleryViewModel extends ViewModel {

    GalleryRepository repository;

    final MutableLiveData<List<GalleryItem>> galleryLiveData = new MutableLiveData<>();

    /**
     * If you need to separate event error from news error create new live data
     */
    final MutableLiveData<Throwable> errorLiveData = new MutableLiveData<>();

    public GalleryViewModel() {
        repository = new GalleryRepository();
    }

    void request_gallery(/*data to api*/){
        GalleryRepository.requestdata(galleryLiveData , errorLiveData);
    }
}
