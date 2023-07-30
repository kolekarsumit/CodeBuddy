package com.example.codebuddy2.Course;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.codebuddy2.R;
import com.github.barteksc.pdfviewer.PDFView;

public class CardDetails extends AppCompatActivity {



    TextView headign,desc;
    ImageView img;

    AppCompatButton btn;
    int position=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_details);

         position = getIntent().getIntExtra("position", 0);
        headign = findViewById(R.id.heading);
        desc = findViewById(R.id.desc);
        img = findViewById(R.id.img);
        btn=findViewById(R.id.btn);

        Bundle bundle = getIntent().getExtras();

        headign.setText(bundle.getString("heading"));
        desc.setText(bundle.getString("desc"));
        img.setImageResource(bundle.getInt("img"));


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CardDetails.this, show_pdf.class);
                intent.putExtra("position",position);
                startActivity(intent);
            }
        });



    }




}