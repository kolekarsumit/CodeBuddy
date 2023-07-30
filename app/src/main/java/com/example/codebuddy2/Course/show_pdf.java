package com.example.codebuddy2.Course;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.codebuddy2.R;
import com.github.barteksc.pdfviewer.PDFView;

public class show_pdf extends AppCompatActivity {

    PDFView pdfshow;
    int position=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_pdf);

        pdfshow=findViewById(R.id.pdfshow);
//        int position=getIntent().getIntExtra("position",0);
         position=getIntent().getIntExtra("position",0);

        if(position==0){
            pdfshow.fromAsset("javacontent.pdf").load();
        }
        else if(position==1){
            pdfshow.fromAsset("javacontent.pdf").load();
        } else if(position==2){
            pdfshow.fromAsset("Pythoncontent.pdf").load();
        } else if(position==3){
            pdfshow.fromAsset("Ccontent.pdf").load();
        } else if(position==4){
            pdfshow.fromAsset("cppcontent.pdf").load();
        } else if(position==5){
            pdfshow.fromAsset("dscontent.pdf").load();
        } else if(position==6){
            pdfshow.fromAsset("DBMScontent.pdf").load();
        } else if(position==7){
            pdfshow.fromAsset("androidcontent.pdf").load();
        } else if(position==8){
            pdfshow.fromAsset("cloudcontent.pdf").load();
        } else if(position==9) {
            pdfshow.fromAsset("SQLcontent.pdf").load();
        }
        else{
            pdfshow.fromAsset("Dartcontent.pdf").load();
        }
    }
}