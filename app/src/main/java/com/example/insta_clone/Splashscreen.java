package com.example.insta_clone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Thread thread = new Thread(){

            public void run(){

                try {
                    sleep(2000);
                }

                catch (Exception e){
                    e.printStackTrace();
                }

                finally {
                    Intent intent = new Intent(Splashscreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };thread.start();
    }
}