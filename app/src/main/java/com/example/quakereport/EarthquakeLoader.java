package com.example.quakereport;


import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private String Url;

    public EarthquakeLoader(@NonNull Context context , String Url) {

        super(context);
        this.Url = Url;
    }

    @Override
    protected void onStartLoading() {
        Log.d("gaur" , "startload called");
        forceLoad();
    }

    @Nullable
    @Override
    public List<Earthquake> loadInBackground() {

        Log.d("gaur" , "loadinback called");

        if (Url == null) {
            return null;
        }
        List<Earthquake> result = QueryUtils.fetchEarthquakeData(Url);
        return result;
    }

}

