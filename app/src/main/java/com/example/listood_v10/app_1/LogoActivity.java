package com.example.listood_v10.app_1;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.listood_v10.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogoActivity extends AppCompatActivity {
    private EditText edLogin, edPassword;
    private FirebaseAuth mAuth;
    private Button btStart, btExit, btSignUp, btSignIn;
    private TextView tvUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        init();

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser cUser = mAuth.getCurrentUser();
        if(cUser != null)
        {
            showSigned();
            Toast.makeText(this, "User not null", Toast.LENGTH_SHORT).show();



        }
        else
        {
            shownotSigned();
            Toast.makeText(this, "User null", Toast.LENGTH_SHORT).show();
        }
    }

    private void init()
    {
        tvUserName=findViewById(R.id.tvUserEmail);
        btStart=findViewById(R.id.btStart);
        btExit=findViewById(R.id.btExit);
        btSignIn=findViewById(R.id.bt_sign_in);
        btSignUp=findViewById(R.id.bt_sign_up);
        edLogin = findViewById(R.id.edLogin);
        edPassword = findViewById(R.id.edPassword);
        mAuth = FirebaseAuth.getInstance();
    }
    public void onClickSignUp(View view)
    {
        if(!TextUtils.isEmpty(edLogin.getText().toString()) && !TextUtils.isEmpty(edPassword.getText().toString()))
        {
            mAuth.createUserWithEmailAndPassword(edLogin.getText().toString(),edPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        shownotSigned();
                        sendEmailVer();
                        Toast.makeText(getApplicationContext(), "User SignUp Successful", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        shownotSigned();
                        Toast.makeText(getApplicationContext(), "User SignUp failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
        else
        {
            Toast.makeText(getApplicationContext(), "Please entre Email and Password", Toast.LENGTH_SHORT).show();
        }
    }
    public void onClickSignIn(View view)
    {
        if(!TextUtils.isEmpty(edLogin.getText().toString()) && !TextUtils.isEmpty(edPassword.getText().toString())){
            mAuth.signInWithEmailAndPassword(edLogin.getText().toString(),edPassword.getText().toString()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        showSigned();
                        Toast.makeText(getApplicationContext(), "User SignIn Successful", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        shownotSigned();
                        Toast.makeText(getApplicationContext(), "User SignIn failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    public  void onClickExit (View view){

        FirebaseAuth.getInstance().signOut();
        shownotSigned();
    }

    private void showSigned(){

        FirebaseUser user = mAuth.getCurrentUser();
        assert user != null;
        if(user.isEmailVerified()) {
            String userName="Вы вошли как : " + user.getEmail();
            tvUserName.setText(userName);
            btStart.setVisibility(View.VISIBLE);
            tvUserName.setVisibility(View.VISIBLE);
            btExit.setVisibility(View.VISIBLE);
            edLogin.setVisibility(View.GONE);
            edPassword.setVisibility(View.GONE);
            btSignIn.setVisibility(View.GONE);
            btSignUp.setVisibility(View.GONE);
        } else {

            Toast.makeText(getApplicationContext(), "Проверьте вашу почту для подтверждения Email адреса", Toast.LENGTH_SHORT).show();
        }
    }

    private void shownotSigned(){

        btStart.setVisibility(View.GONE);
        tvUserName.setVisibility(View.GONE);
        btExit.setVisibility(View.GONE);
        edLogin.setVisibility(View.VISIBLE);
        edPassword.setVisibility(View.VISIBLE);
        btSignIn.setVisibility(View.VISIBLE);
        btSignUp.setVisibility(View.VISIBLE);
    }

    public void onClickStart(View view) {

        Intent intent = new Intent(LogoActivity.this, MainActivity_1.class);
        startActivity(intent);
    }

    private void sendEmailVer(){

        FirebaseUser user = mAuth.getCurrentUser();
        assert user !=null;
        user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){

                    Toast.makeText(getApplicationContext(), "Проверьте вашу почту для подтверждения Email адреса", Toast.LENGTH_SHORT).show();
                } else{


                    Toast.makeText(getApplicationContext(), "Send Email failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}