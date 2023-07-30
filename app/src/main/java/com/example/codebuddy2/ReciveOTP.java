package com.example.codebuddy2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class ReciveOTP extends AppCompatActivity {

    private String name;
    private String mail;
    private TextInputEditText inputcode;
    private String verifiactionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recive_otp);

        TextView textmobile = findViewById(R.id.textmobile);
        textmobile.setText(String.format(
                "+91-%s", getIntent().getStringExtra("mobile")
        ));

        inputcode = findViewById(R.id.inputcode);


        final ProgressBar progressBar = findViewById(R.id.progressBar);
        final Button buttonverify = findViewById(R.id.btnverifiction);

        verifiactionId = getIntent().getStringExtra("verificationId");
        name = getIntent().getStringExtra("name");
        mail = getIntent().getStringExtra("mail");


        buttonverify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (inputcode.getText().toString().trim().isEmpty()) {
                    Toast.makeText(ReciveOTP.this, "Please enter the valid code", Toast.LENGTH_SHORT).show();
                }

                String code = inputcode.getText().toString();

                if (verifiactionId != null) {
                    progressBar.setVisibility(View.VISIBLE);
                    buttonverify.setVisibility(View.INVISIBLE);

                    PhoneAuthCredential phoneAuthCredential = PhoneAuthProvider.getCredential(
                            verifiactionId, code
                    );

                    FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    progressBar.setVisibility(View.GONE);
                                    buttonverify.setVisibility(View.VISIBLE);

                                    if (task.isSuccessful()) {
                                        Intent intent = new Intent(getApplicationContext(), Login.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        intent.putExtra("name", name);
                                        intent.putExtra("mail", mail);
                                        intent.putExtra("phone",textmobile.getText());
                                        startActivity(intent);
                                    }else{
                                        Toast.makeText(ReciveOTP.this, "Invalid OTP", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }

            }
        });

        findViewById(R.id.textresendotp).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+91" + getIntent().getStringExtra("mobile"),
                        60,
                        TimeUnit.SECONDS,
                        ReciveOTP.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {


                                Toast.makeText(ReciveOTP.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(String newverificationId, PhoneAuthProvider.ForceResendingToken forceResendingToken) {


                                verifiactionId=newverificationId;
                                Toast.makeText(ReciveOTP.this, "OTP send", Toast.LENGTH_SHORT).show();
                            }

                        }
                );
            }
        });


    }

}