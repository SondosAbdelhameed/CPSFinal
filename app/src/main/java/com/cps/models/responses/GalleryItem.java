package com.cps.models.responses;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.RelativeLayout;

import androidx.databinding.BindingAdapter;

import com.cps.R;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import static com.cps.helpers.Constant.SERVER_MEDIA_GALLERY;

public class GalleryItem{

	@SerializedName("id")
	private int id;

	@SerializedName("media")
	private String media;

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setMedia(String media){
		this.media = media;
	}

	public String getMedia(){
		return media;
	}

	@BindingAdapter("galleryImage")
	public static void loadImage(RelativeLayout img , String image){
		//String default_image;
		Context context = img.getContext();
		if (image != null) {
			//default_image = mediaItem.getMedia();

			Picasso.get().load(SERVER_MEDIA_GALLERY + image).placeholder(R.drawable.anim_img_placeholder).into(new Target(){

				@Override
				public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
					img.setBackground(new BitmapDrawable(context.getResources(), bitmap));
				}

				@Override
				public void onBitmapFailed(Exception e, Drawable errorDrawable) {
					Log.d("TAG", "FAILED");
				}

				@Override
				public void onPrepareLoad(Drawable placeHolderDrawable) {
					Log.d("TAG", "Prepare Load");
				}
			});

		}else {
			image = "null";
		}
	}

	@Override
	public String toString() {
		return "GalleryItem{" +
				"id=" + id +
				", media='" + media + '\'' +
				'}';
	}
}