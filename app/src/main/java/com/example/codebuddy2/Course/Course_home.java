package com.example.codebuddy2.Course;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.codebuddy2.Quesion_Bank.Home_Quesion;
import com.example.codebuddy2.R;

import java.util.ArrayList;
import java.util.HashMap;

public class Course_home extends AppCompatActivity {

    ArrayList<CourseModel> arrmodel=new ArrayList<>();
    HashMap<String,String> data=new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_home);

        RecyclerView recyclerView=findViewById(R.id.recyclercontact);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        arrmodel.add(new CourseModel(R.drawable.java,"Java","Java: Where code meets boundless potential"));
        arrmodel.add(new CourseModel(R.drawable.adv_java,"AdvancedJ","Advanced Java: Elevating development with next-level capabilities"));
        arrmodel.add(new CourseModel(R.drawable.python,"Python","Python: Where innovation meets seamless coding experience"));
        arrmodel.add(new CourseModel(R.drawable.c,"C","C: Unleashing the power of programming."));
        arrmodel.add(new CourseModel(R.drawable.cpp,"Cpp","Unleash your creativity with C++'s versatile power"));
        arrmodel.add(new CourseModel(R.drawable.data_structure,"DS","Harness the power of data structures for smarter solutions."));
        arrmodel.add(new CourseModel(R.drawable.dbms,"DBMS","DBMS: Where data organization meets optimal performance"));
        arrmodel.add(new CourseModel(R.drawable.android_development,"android","Unlock the potential of Android for groundbreaking app experiences."));
        arrmodel.add(new CourseModel(R.drawable.cloud_computing,"Cloud","Unleash the power of Cloud Computing for seamless and dynamic operations"));
        arrmodel.add(new CourseModel(R.drawable.sql,"SQL","Empower your projects with SQL's precise data handling capabilities."));
        arrmodel.add(new CourseModel(R.drawable.dart,"Dart","Dart: Igniting innovation and driving cross-platform excellence"));





     data.put("Java", getString(R.string.Java));
     data.put("AdvancedJ", getString(R.string.AdvancedJ));
     data.put("Python", getString(R.string.Python));
        data.put("C", getString(R.string.C));
        data.put("Cpp", getString(R.string.Cpp));
        data.put("DS", getString(R.string.DS));
        data.put("DBMS", getString(R.string.DBMS));
        data.put("android", getString(R.string.android));
        data.put("Cloud", getString(R.string.Cloud));
        data.put("SQL", getString(R.string.SQL));
        data.put("Dart", getString(R.string.Dart));







        CourseAdapter adapter=new CourseAdapter(this, arrmodel,data, new CourseAdapter.ItemClickListener() {
            @Override
            public void onItemClick(CourseModel details) {

            }

        });
        recyclerView.setAdapter(adapter);


    }
  
}