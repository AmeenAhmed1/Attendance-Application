package com.eraqi.attendanceapp.Tabs.LecturesPackage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


import com.eraqi.attendanceapp.R;
import com.firebase.client.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eraqi on 4/12/2018.
 */

public class NewLecture extends AppCompatActivity {
Firebase f;
    DatabaseReference firebaseDatabase;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newlecture);
        firebaseDatabase = FirebaseDatabase.getInstance().getReference();
        Spinner Hall = (Spinner) findViewById(R.id.HallSpinner);
        final Spinner Lecturer = (Spinner) findViewById(R.id.lecturerSpinner);
        final Spinner Grade = (Spinner) findViewById(R.id.GradeSpinner);
        final Spinner Department = (Spinner) findViewById(R.id.DepartmentSpinner);
        final Spinner Day = (Spinner) findViewById(R.id.DaySpinner);
        final EditText time=(EditText)findViewById(R.id.TimeEditText);
         Button add=(Button)findViewById(R.id.addButt) ;

        getDataFromFirebase(firebaseDatabase.child("Halls"), Hall, "Hall");
        getDataFromFirebase(firebaseDatabase.child("lecturerers"), Lecturer, "Lectureer");
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              DatabaseReference f=firebaseDatabase.child("lectures").child(getSelectedItem(Grade)).child(getSelectedItem(Department)).push();
               f.child("lectureer").setValue(getSelectedItem(Lecturer));
               f.child("time").setValue(time.getText().toString());
                f.child("day").setValue(getSelectedItem(Day));
            }
        });
    }
    private void getDataFromFirebase(DatabaseReference db, final Spinner s, final String HallOrLecturer){
        db.addListenerForSingleValueEvent(new ValueEventListener() {

            List<String> list=new ArrayList<String>();
            ArrayAdapter<String> adapter;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> data = dataSnapshot.getChildren();
                if(HallOrLecturer.equals("Hall")) {
                    for (DataSnapshot childs : data) {

                        list.add(childs.getKey().toString());


                    }
                }else {
                    for (DataSnapshot childs : data) {

                        list.add(childs.getValue().toString());


                    }
                }
                adapter = new ArrayAdapter<String>(getApplicationContext(),
                        android.R.layout.simple_spinner_item, list);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                s.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public String getSelectedItem(Spinner s){
        String selectedItem=s.getSelectedItem().toString();
        return selectedItem;
    }
}
