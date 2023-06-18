package com.example.quakereport;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

class EaryhquakeAdapter extends ArrayAdapter<Earthquake> {


    private static final String LOCATION_SEPERATOR = " of ";

    public EaryhquakeAdapter(Context context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    public String formatdata(Date dateobject) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateobject);

    }


    public String formattime(Date dateobject) {

        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateobject);

    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude) {

        int magnitudeColorid;
        int magnitudeFloor = (int) Math.floor(magnitude);

        switch (magnitudeFloor) {

            case 0:
            case 1:
                magnitudeColorid = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorid = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorid = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorid = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorid = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorid = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorid = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorid = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorid = R.color.magnitude9;
                break;
            default:
                magnitudeColorid = R.color.magnitude10plus;
                break;

        }
        return ContextCompat.getColor(getContext(), magnitudeColorid);

    }


    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listitemview = convertView;
        if (listitemview == null) {
            listitemview = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Earthquake current = getItem(position);

        TextView mag = listitemview.findViewById(R.id.mag);
        String formattedMag = formatMagnitude(current.getMag());
        mag.setText(formattedMag);

        GradientDrawable magnitudeCircle = (GradientDrawable) mag.getBackground();

        int magnitudeColor = getMagnitudeColor(current.getMag());

        magnitudeCircle.setColor(magnitudeColor);

        String originalocation = current.getPlace();
        String locationoffset;
        String primarylocation;


        if (originalocation.contains(LOCATION_SEPERATOR)) {

            String[] parts = originalocation.split(LOCATION_SEPERATOR);
            locationoffset = parts[0] + LOCATION_SEPERATOR;
            primarylocation = parts[1];

        } else {
            locationoffset = getContext().getString(R.string.near_the);
            primarylocation = originalocation;
        }

        TextView primaryLocation = listitemview.findViewById(R.id.primary_loc);
        primaryLocation.setText(primarylocation);

        TextView offsetlocation = listitemview.findViewById(R.id.location_offset);
        offsetlocation.setText(locationoffset);

        Date dateObject = new Date(current.getTimeinmilliseconds());


        TextView date = listitemview.findViewById(R.id.date);
        String formattedate = formatdata(dateObject);
        date.setText(formattedate);

        TextView time = listitemview.findViewById(R.id.time_view);
        String formattedtime = formattime(dateObject);
        time.setText(formattedtime);

        return listitemview;
    }
}
