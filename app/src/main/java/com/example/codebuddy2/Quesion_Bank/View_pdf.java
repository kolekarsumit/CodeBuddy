package com.example.codebuddy2.Quesion_Bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.codebuddy2.R;
import com.github.barteksc.pdfviewer.PDFView;

public class View_pdf extends AppCompatActivity {


    PDFView pdfview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pdf);

        pdfview=findViewById(R.id.pdfView);

        int position=getIntent().getIntExtra("position",0);

        if(position==0){
            pdfview.fromAsset("java.pdf").load();

        }
        else if(position==1){
            pdfview.fromAsset("advjava.pdf").load();
        } else if(position==2){
            pdfview.fromAsset("Python.pdf").load();
        } else if(position==3){
            pdfview.fromAsset("C.pdf").load();
        }else if(position==4){
            pdfview.fromAsset("Cpp.pdf").load();
        }else if(position==5){
            pdfview.fromAsset("DSA.pdf").load();
        }else if(position==6){
            pdfview.fromAsset("DBMS.pdf").load();
        }else if(position==7){
            pdfview.fromAsset("Android.pdf").load();
        }else if(position==8){
            pdfview.fromAsset("Cloud.pdf").load();
        }else if(position==9){
            pdfview.fromAsset("SQL.pdf").load();
        }else {
            pdfview.fromAsset("Dart.pdf").load();
        }

    }
}