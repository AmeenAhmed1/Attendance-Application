package com.eraqi.attendanceapp.Tabs.LecturesPackage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.eraqi.attendanceapp.R;

/**
 * Created by Eraqi on 4/11/2018.
 */

public class Lectures extends Fragment {
    FloatingActionButton fab;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.lectures,container,false);
        fab=(FloatingActionButton)v.findViewById(R.id.fab);
        fab.bringToFront();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "test", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(),NewLecture.class));
            }
        });
        return v;
    }
}
