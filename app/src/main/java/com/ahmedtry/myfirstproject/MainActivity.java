package com.ahmedtry.myfirstproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public ImageView placesImage;
    public Random mRandom;

    int[] mPlacePics = {
            R.drawable.bike,
            R.drawable.football,
            R.drawable.park,
            R.drawable.running,
            R.drawable.shop,
            R.drawable.restaurant,
            R.drawable.museum,
    };

    int mCorentIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        placesImage = findViewById(R.id.park);
        mRandom = new Random();


    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("index",mCorentIndex);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null){
            mCorentIndex = savedInstanceState.getInt("index");
            if(mCorentIndex != -1 ){
                Drawable placesDrawable = ContextCompat.getDrawable(this, mPlacePics[mCorentIndex++]);
                placesImage.setImageDrawable(placesDrawable);
            }
        }
    }

    public void next(View view) {
        Drawable placesDrawable = ContextCompat.getDrawable(this, mPlacePics[++mCorentIndex]);
        placesImage.setImageDrawable(placesDrawable);

        if (mCorentIndex == mPlacePics.length) {
            mCorentIndex = 0;
        } //ifstatment
    }  //NextBtn

    public void back(View view) {
        if (mCorentIndex <= 0) {
            Toast.makeText(this, "انقلع مافي اقتراحات خلاص", Toast.LENGTH_SHORT).show();
            mCorentIndex = 6;

        } else {
            Drawable placeDrawable = ContextCompat.getDrawable(this, mPlacePics[mCorentIndex--]);
            placesImage.setImageDrawable(placeDrawable);

        } //ifstatment
    } // BackBtn

    public void mix(View view) {
        mCorentIndex = mRandom.nextInt(mPlacePics.length);
        showImage();

    } // mixBtn

    public void showImage() {
        Drawable placesDrawable = ContextCompat.getDrawable(this, mPlacePics[mCorentIndex]);
        placesImage.setImageDrawable(placesDrawable);


    } //to show pics

} // mainActivity



