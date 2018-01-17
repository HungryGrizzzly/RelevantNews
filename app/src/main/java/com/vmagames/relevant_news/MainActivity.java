package com.vmagames.relevant_news;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.preload);
        TextView textView = (TextView)findViewById(R.id.preloadText);
        textView.setTypeface(Typeface.createFromAsset(getAssets(), "PT_Serif-Web-Bold.ttf"));

        new Handler().postDelayed(new Runnable(){
            @Override
                    public void run(){

                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();

            }

        },2*1000);


    }

}