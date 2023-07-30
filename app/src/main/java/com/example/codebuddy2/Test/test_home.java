package com.example.codebuddy2.Test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import com.example.codebuddy2.Quesion_Bank.Home_Quesion;
import com.example.codebuddy2.Quesion_Bank.Quesion_model;
import com.example.codebuddy2.R;

import java.util.ArrayList;
import java.util.HashMap;

public class test_home extends AppCompatActivity {

        ArrayList<TestModel> arr=new ArrayList<>();
        HashMap<String,String> map=new HashMap<>();


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_test_home);

            RecyclerView recyclerView=findViewById(R.id.testrecyclerview);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            arr.add(new TestModel(R.drawable.java,"Java"));
            arr.add(new TestModel(R.drawable.adv_java,"AdvancedJ"));
            arr.add(new TestModel(R.drawable.python,"Python"));
            arr.add(new TestModel(R.drawable.c,"C"));
            arr.add(new TestModel(R.drawable.cpp,"Cpp"));
            arr.add(new TestModel(R.drawable.data_structure,"DS"));
            arr.add(new TestModel(R.drawable.dbms,"DBMS"));
            arr.add(new TestModel(R.drawable.android_development,"android"));
            arr.add(new TestModel(R.drawable.cloud_computing,"Cloud"));
            arr.add(new TestModel(R.drawable.sql,"SQL"));
            arr.add(new TestModel(R.drawable.dart,"Dart"));


            map.put("Java","https://forms.gle/vypgmmAynao8Got98");
            map.put("AdvancedJ","https://forms.gle/R2Q5tuXHjxg8BdPa7");
            map.put("Python","https://forms.gle/v9rGWBYtSBBHxG6c9");
            map.put("C","https://forms.gle/bTJaf5rmbZVm77DC8");
            map.put("Cpp","https://forms.gle/7BkQmNt2LGPaUSak7");
            map.put("DS","https://forms.gle/d6ShYPkBSCpHZHz77");
            map.put("DBMS","https://forms.gle/NWmDz2kG4UCCqch46");
            map.put("android","https://forms.gle/6QXEA4LdDtN1qZ8C9");
            map.put("Cloud","https://forms.gle/NWmDz2kG4UCCqch46");
            map.put("SQL","https://forms.gle/sZmfeGjHrLx3zkWH9");
            map.put("Dart","https://forms.gle/kf6pGS2gNfddSCMW6");




            TestAdapter adapter=new TestAdapter(this,arr,new TestAdapter.ItemClickListener(){
                @Override
                public void OnItemclick(TestModel model) {
    //                Toast.makeText(test_home.this, model.name, Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(map.get(model.name)));
                    startActivity(intent);
                }


            });
            recyclerView.setAdapter(adapter);
        }
}