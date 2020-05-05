package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class customArrayAdapter extends ArrayAdapter {
    public customArrayAdapter(@NonNull Context context, ArrayList<customEarthQuake> earthQuakes) {
        super(context, 0, earthQuakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.custom_array_adapter_layout, parent, false);
        }
        customEarthQuake getTheDataOfEarthQuake = (customEarthQuake) getItem(position);
        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);

        TextView address1 = (TextView) listItemView.findViewById(R.id.address1);
        address1.setText(getTheDataOfEarthQuake.getLocation1());
        TextView address2 = (TextView) listItemView.findViewById(R.id.address2);
        address2.setText(getTheDataOfEarthQuake.getLocation2());
        TextView date = (TextView) listItemView.findViewById(R.id.number1);
        date.setText(getTheDataOfEarthQuake.getnumber1());
        TextView time = (TextView) listItemView.findViewById(R.id.number2);
        time.setText(getTheDataOfEarthQuake.getnumber2());

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
     int magnitudeColor = getMagnitudeColor(getTheDataOfEarthQuake.getMagnitude());

        // Set the color on the magnitude circle
       magnitudeCircle.setColor(magnitudeColor);

        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(getTheDataOfEarthQuake.getMagnitude());
        magnitude.setText(output);

        return listItemView;
    }
    public int getMagnitudeColor(double magnitude){
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

     }
    

