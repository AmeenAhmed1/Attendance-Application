package com.eraqi.attendanceapp.Tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.eraqi.attendanceapp.R;

/**
 * Created by Eraqi on 4/11/2018.
 */

public class Halls extends Fragment  {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.halls,container,false);
        return v;
    }
}
