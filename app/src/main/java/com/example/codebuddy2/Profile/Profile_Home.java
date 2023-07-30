package com.example.codebuddy2.Profile;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.codebuddy2.Data_Model;
import com.example.codebuddy2.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class Profile_Home extends AppCompatActivity {

    TextView profilename,username,email,mobile,git,linkedn;

    Button btn;

    FirebaseDatabase database;
    DatabaseReference userRef;

    String mail;
    private  static final String USERS="users";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_home);


        Intent intent=getIntent();
        mail=intent.getStringExtra("email");

        profilename =findViewById(R.id.profile_name);
        username =findViewById(R.id.username);
        email=findViewById(R.id.mail);
        mobile=findViewById(R.id.phone);
        git=findViewById(R.id.git);
        linkedn=findViewById(R.id.linkedin);
        btn=findViewById(R.id.edit_info_btn);



        database=FirebaseDatabase.getInstance();
        userRef=database.getReference(USERS);


        System.out.println(mail);

        userRef.addValueEventListener(new ValueEventListener() {
            String fname,fmail,fphone,fgit,flink;
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot keyID:dataSnapshot.getChildren()){
                    if (keyID.child("mail").getValue().equals(mail)){
                            fname = keyID.child("name").getValue(String.class);

                        fmail=keyID.child("mail").getValue(String.class);
                        fphone=keyID.child("phone").getValue(String.class);
                        fgit=keyID.child("git").getValue(String.class);
                        flink=keyID.child("link").getValue(String.class);
                        break;
                    }
                }


                System.out.println(fname);
                System.out.println(fmail);
                System.out.println(fphone);
                System.out.println(fgit);
                System.out.println(flink);

                profilename.setText(fname);
                username.setText(fname);
                email.setText(fmail);
                mobile.setText(fphone);
                git.setText(fgit);
                linkedn.setText(flink);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(Profile_Home.this, "Cant show data", Toast.LENGTH_SHORT).show();
            }
        });






    }
}