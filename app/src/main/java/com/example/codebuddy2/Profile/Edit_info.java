package com.example.codebuddy2.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.codebuddy2.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Edit_info extends AppCompatActivity {

    TextInputEditText name_edit, phone_edit, mail_edit, git_edit, linkedi_edit;
    Button btn;

    DatabaseReference reference;

    String nameUser,phoneUser,git,link,mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);


        name_edit = findViewById(R.id.edit_name);
        phone_edit = findViewById(R.id.edit_phone);
        git_edit = findViewById(R.id.edit_git);
        linkedi_edit = findViewById(R.id.edit_linkedin);
        btn = findViewById(R.id.submit_btn);
        reference=FirebaseDatabase.getInstance().getReference("users");



        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String name = String.valueOf(name_edit.getText());
                String phone = String.valueOf(phone_edit.getText());
                String mail = String.valueOf(mail_edit.getText());
                String git = String.valueOf(git_edit.getText());
                String linkedin = String.valueOf(linkedi_edit.getText());



                if (TextUtils.isEmpty(name) ||
                        TextUtils.isEmpty(phone) ||
                        TextUtils.isEmpty(mail) ||
                        TextUtils.isEmpty(git) ||
                        TextUtils.isEmpty(linkedin)) {
                    Toast.makeText(Edit_info.this, "Please fill all the details", Toast.LENGTH_SHORT).show();

                }


            }
        });


    }


    public  boolean isnamechange(){
        if(!nameUser.equals(name_edit.getText().toString())){
            reference.child("users").child("");
        }
        return false;
    }
}