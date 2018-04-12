package com.eraqi.attendanceapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.Toast;


import com.eraqi.attendanceapp.Tabs.Halls;
import com.eraqi.attendanceapp.Tabs.LecturesPackage.Lectures;
import com.eraqi.attendanceapp.Tabs.Students;


/**
 * Created by Eraqi on 11/30/2017.
 */

public class MainPagerAdapter extends FragmentStatePagerAdapter {
    int itemCount;
    Context c;
    public MainPagerAdapter(FragmentManager fm, Context c,int count) {
        super(fm);
        this.c=c;
        itemCount=count;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                Halls Tab0=new Halls();
                return Tab0;
            case 1:
                Lectures Tab1=new Lectures();
                Toast.makeText(c, "Tab0", Toast.LENGTH_SHORT).show();

                return Tab1;
            case 2:

                Students Tab2=new Students();
                Toast.makeText(c, "Tab1", Toast.LENGTH_SHORT).show();
                return Tab2;

            default:

                return null;
        }


    }

    @Override
    public int getCount() {
        return itemCount;
    }
}
