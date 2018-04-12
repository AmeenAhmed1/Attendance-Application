package com.eraqi.attendanceapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int index=0;
    TextView activityName;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            View v =getSupportActionBar().getCustomView();
            //activityName=(TextView)v.findViewById(R.id.ActivityName);

            TabLayout myTab=(TabLayout)findViewById(R.id.MainTab);
            final ViewPager pager=(ViewPager)findViewById(R.id.MainPager);
            View halls=setTabView(getString(R.string.Halls));
            View lectures=setTabView(getString(R.string.Lectures));
            View students=setTabView(getString(R.string.students));

            myTab.addTab(myTab.newTab().setCustomView(halls));
            myTab.addTab(myTab.newTab().setCustomView(lectures));
            myTab.addTab(myTab.newTab().setCustomView(students));


            // setting the viewpager
            MainPagerAdapter adapter=new MainPagerAdapter(getSupportFragmentManager(),this,myTab.getTabCount());
            pager.setAdapter(adapter);
            pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(myTab));

            myTab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {

                    pager.setCurrentItem(tab.getPosition());
                   /* if(tab.getPosition()==0){
                        activityName.setText(R.string.Home);
                    }else  if(tab.getPosition()==1){
                        activityName.setText(R.string.Reserve);
                    }
                    else  if(tab.getPosition()==2){
                        activityName.setText(R.string.BeforeAfter);
                    }
                    else  if(tab.getPosition()==3){
                        activityName.setText(R.string.History);
                    }*/

                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });
        }

        @Override
        protected void onStart() {
            super.onStart();
           // activityName.setText(R.string.Home);
        }

    private View setTabView(String tabName) {
        View v=getLayoutInflater().inflate(R.layout.tab_layout,null);
        TextView tabText=(TextView)v.findViewById(R.id.tabTextView);
        tabText.setText(tabName);

        return v;
    }
}

