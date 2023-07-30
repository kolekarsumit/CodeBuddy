package com.example.codebuddy2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    TextInputEditText email, pass, username,mobile;
    Button btn;
    TextView  tologin;
    ProgressBar progressBar;

    FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference mDatabase;
    Data_Model data;

    private  static final String USERS="users";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.registermail);
        mobile = findViewById(R.id.registermobile);
        pass = findViewById(R.id.registerpassword);
        username = findViewById(R.id.registeruser);
        btn = findViewById(R.id.btn_register);
        tologin = findViewById(R.id.registerlogin);
        database=FirebaseDatabase.getInstance();
        mDatabase=database.getReference(USERS);
        mAuth = FirebaseAuth.getInstance();



        tologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();

            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail, password, user,phone;
                mail = String.valueOf(email.getText());
                password = String.valueOf(pass.getText());
                user = String.valueOf(username.getText());
                phone = String.valueOf(mobile.getText());

                if (TextUtils.isEmpty(mail)) {
                    Toast.makeText(Register.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Register.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(user)) {
                    Toast.makeText(Register.this, "Enter Username", Toast.LENGTH_SHORT).show();
                    return;
                } if (TextUtils.isEmpty(phone)) {
                    Toast.makeText(Register.this, "Enter phone", Toast.LENGTH_SHORT).show();
                    return;
                }

                 data=new Data_Model(user,phone,mail,"","");



                mAuth.createUserWithEmailAndPassword(mail, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    Toast.makeText(Register.this, "Succefully Authenticate", Toast.LENGTH_SHORT).show();
                                    FirebaseUser user=mAuth.getCurrentUser();
                                    updateUI(user);

                                } else {
                                    Toast.makeText(Register.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });


            }
        });




    }


    void updateUI(FirebaseUser currentUser){
        String keyid=mDatabase.push().getKey();
        mDatabase.child(keyid).setValue(data);
        Intent intent=new Intent(Register.this, SendOTP.class);
//        intent.putExtra("email",)
        startActivity(intent);
    }

}