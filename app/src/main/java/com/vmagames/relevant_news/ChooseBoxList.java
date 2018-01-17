package com.vmagames.relevant_news;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Марк on 30.08.2017.
 */

public class ChooseBoxList extends AppCompatActivity {


    @Override
        protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chooselist);
        String[] urls = {"https://newsapi.org/v1/articles?source=abc-news-au&sortBy=top&apiKey=6143fad2a3054d04ad08c2ef579f7593", "https://newsapi.org/v1/articles?source=ars-technica&sortBy=top&apiKey=6143fad2a3054d04ad08c2ef579f7593"};
        String[] names = {"ABC News", "BBC", "Relevant News", "Loading"};
        Integer[] imgid ={R.drawable.googlenews, R.drawable.bbc_news_logo, R.drawable.relevantnewslogo, R.drawable.loading};
        ChooseAdapter adapter;
        adapter = new ChooseAdapter(ChooseBoxList.this, names, imgid, urls);
        ListView listView = (ListView)findViewById(R.id.lvList);
        listView.setAdapter(adapter);


    }

}
