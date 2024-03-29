package com.example.introslider;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AdaptorViewPager extends PagerAdapter
{
    private int[] layouts;
    private LayoutInflater layoutInflater;
    private Context context;

    public AdaptorViewPager(int[] layouts, Context context) {
        this.layouts = layouts;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount()
    {
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o)
    {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position)
    {
        View view = layoutInflater.inflate(layouts[position], container, false);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object)
    {
        View view = (View) object;

        container.removeView(view);
    }
}
