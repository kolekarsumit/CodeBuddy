package com.example.codebuddy2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class SendOTP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_otp);

        final TextInputEditText inputmobile = findViewById(R.id.inputmobile);
        final Button btngetotp = findViewById(R.id.getotpbtn);



        final ProgressBar progressBar = findViewById(R.id.progressBar);
//        FirebaseAuth mAuth=FirebaseAuth.getInstance();
//        mAuth.getFirebaseAuthSettings().setAppVerificationDisabledForTesting(true);

        btngetotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputmobile.getText().toString().trim().isEmpty()) {
                    Toast.makeText(SendOTP.this, "Enter mobile ", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                btngetotp.setVisibility(View.INVISIBLE);



                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+91" + inputmobile.getText().toString(),
                        60,
                        TimeUnit.SECONDS,
                        SendOTP.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                            @Override
                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                                progressBar.setVisibility(View.GONE);
                                btngetotp.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onVerificationFailed(@NonNull FirebaseException e) {

                                progressBar.setVisibility(View.GONE);
                                btngetotp.setVisibility(View.VISIBLE);
                                Toast.makeText(SendOTP.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(String verificationId, PhoneAuthProvider.ForceResendingToken forceResendingToken) {

                                progressBar.setVisibility(View.GONE);
                                btngetotp.setVisibility(View.VISIBLE);


                                Intent intent = new Intent(getApplicationContext(), ReciveOTP.class);


                                     intent.putExtra("name", getIntent().getStringExtra("name"));
                                     intent.putExtra("mail", getIntent().getStringExtra("mail"));
                                    intent.putExtra("mobile", inputmobile.getText().toString());
                                    intent.putExtra("verificationId", verificationId);
                                    startActivity(intent);

                            }

                        }
                );


            }
        });
    }
}