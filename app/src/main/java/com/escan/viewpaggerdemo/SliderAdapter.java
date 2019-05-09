package com.escan.viewpaggerdemo;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    //Array
    public int[] slider_iamges = {
            R.drawable.group_10,
            R.drawable.group_11,
            R.drawable.group_12
    };
    public String[] slide_header = {
            "EAT",
            "SLEEP",
            "CODE"
    };
    public String[] sloder_desc = {
            "There is lot of this to do we can do the  and we are using "
            , "There is lot of this to do we can do the  and we are using "
            , "There is lot of this to do we can do the  and we are using "
    };

    @Override
    public int getCount() {
        return slide_header.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {

        return view == (RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.slider_layout, container, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
            }
        });

        ImageView slideImageView = view.findViewById(R.id.imageView);
        TextView textViewTitle = view.findViewById(R.id.title);
        TextView textViewDesc = view.findViewById(R.id.desc);

        slideImageView.setImageResource(slider_iamges[position]);
        textViewTitle.setText(slide_header[position]);
        textViewDesc.setText(sloder_desc[position]);
        container.addView(view);
        Log.e("Corent Slider is ","  "+position);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout) object);
    }
}
