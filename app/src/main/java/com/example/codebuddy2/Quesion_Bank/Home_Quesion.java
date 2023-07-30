package com.example.codebuddy2.Quesion_Bank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.codebuddy2.Course.CourseModel;
import com.example.codebuddy2.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Home_Quesion extends AppCompatActivity {


    ArrayList<Quesion_model> arr=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_quesion);

        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arr.add(new Quesion_model(R.drawable.java,"Java"));
        arr.add(new Quesion_model(R.drawable.adv_java,"AdvancedJ"));
        arr.add(new Quesion_model(R.drawable.python,"Python"));
        arr.add(new Quesion_model(R.drawable.c,"C"));
        arr.add(new Quesion_model(R.drawable.cpp,"Cpp"));
        arr.add(new Quesion_model(R.drawable.data_structure,"DS"));
        arr.add(new Quesion_model(R.drawable.dbms,"DBMS"));
        arr.add(new Quesion_model(R.drawable.android_development,"android"));
        arr.add(new Quesion_model(R.drawable.cloud_computing,"Cloud"));
        arr.add(new Quesion_model(R.drawable.sql,"SQL"));
        arr.add(new Quesion_model(R.drawable.dart,"Dart"));

        QuesionAdapter adapter=new QuesionAdapter(Home_Quesion.this, arr, new QuesionAdapter.ItemClickListener() {
            @Override
            public void onItemClick(Quesion_model model) {
                Toast.makeText(Home_Quesion.this, model.name, Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);





    }
}