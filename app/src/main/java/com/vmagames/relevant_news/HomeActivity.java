package com.vmagames.relevant_news;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final String[] words = {"?!?!#","Hi!!!", "Good news everyone...","Have a nice day!"};

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        viewPager.setCurrentItem(0);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        final Button button = (Button)findViewById(R.id.choosebutton);
        button.setTypeface(Typeface.createFromAsset(getAssets(),"PT_Serif-Web-Bold.ttf" ));
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ChooseBoxList.class);
                startActivity(intent);
            }
        });




        final TextView textView = (TextView)findViewById(R.id.textview);
        textView.setTypeface(Typeface.createFromAsset(getAssets(),"PT_Serif-Web-Bold.ttf"));
        textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Random rand = new Random();
                textView.setText(words[rand.nextInt(4)]);
                textView.setTextColor(getResources().getColor(R.color.fontColorLight));

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        textView.setText("Relevant News");
                        textView.setTextColor(getResources().getColor(R.color.fontColorLight2));
                    }

                }, 500 );


            }

        });



    }


    public void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter1 = new ViewPagerAdapter(getSupportFragmentManager());
        adapter1.addFragment(NewsFragment.newInstance("https://newsapi.org/v1/articles?source=techcrunch&apiKey=6143fad2a3054d04ad08c2ef579f7593"), "Newsapi");
        adapter1.addFragment(NewsFragment.newInstance("https://newsapi.org/v1/articles?source=bbc-news&sortBy=top&apiKey=6143fad2a3054d04ad08c2ef579f7593"), "BBC");
        adapter1.addFragment(NewsFragment.newInstance("https://newsapi.org/v1/articles?source=google-news&sortBy=top&apiKey=6143fad2a3054d04ad08c2ef579f7593"), "Google");
        adapter1.addFragment(NewsFragment.newInstance("https://newsapi.org/v1/articles?source=buzzfeed&sortBy=top&apiKey=6143fad2a3054d04ad08c2ef579f7593"), "Buzzfeed");


        viewPager.setAdapter(adapter1);
    }

}
