package com.escan.viewpaggerdemo;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ViewPager mSlideViewPager;
    LinearLayout mDotLayout;
    SliderAdapter sliderAdapter;
    TextView mDots[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSlideViewPager=findViewById(R.id.slideViewPager);
        mDotLayout=findViewById(R.id.dotsLayout);
        sliderAdapter=new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);

        dotIndicator(0);
        mSlideViewPager.setOnPageChangeListener(changeListener);
    }

    void dotIndicator(int position)
    {
        mDots=new TextView[3];
        mDotLayout.removeAllViews();
        for (int i = 0; i < 3; i++) {
            mDots[i]=new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            mDotLayout.addView(mDots[i]);
        }
        if (mDots.length>0)
        {
            mDots[position].setTextColor(getResources().getColor(R.color.white));
        }
    }
    ViewPager.OnPageChangeListener changeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            dotIndicator(i);
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
