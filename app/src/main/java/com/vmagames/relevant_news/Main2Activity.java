package com.vmagames.relevant_news;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String url = getIntent().getExtras().getString("url");

        WebView webView = (WebView)findViewById(R.id.webView);
        webView.loadUrl(url);


        final TextView textView = (TextView)findViewById(R.id.textBack);
        textView.setTypeface(Typeface.createFromAsset(getAssets(), "PT_Serif-Web-Bold.ttf"));
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();

                textView.setTextColor(getResources().getColor(R.color.fontColorLight2));
                textView.setBackgroundColor(getResources().getColor(R.color.colortoolOnclick));
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        textView.setBackgroundColor(getResources().getColor(R.color.colortool));

                    }

                }, 500 );

            }
        });
    }

}
