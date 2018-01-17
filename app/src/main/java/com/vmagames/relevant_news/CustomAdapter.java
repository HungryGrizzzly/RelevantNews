package com.vmagames.relevant_news;

/**
 * Created by Марк on 25.08.2017.
 */

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class CustomAdapter extends ArrayAdapter<NewsItem> {
    Typeface tf1, tf2;
    private List<NewsItem> mNewsItemList = new ArrayList<>();
    private Context mContext;


    CustomAdapter(Context context, List<NewsItem> list) {
        super(context, 0, list);
        mNewsItemList = list;
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        }

        final NewsItem currentItem = mNewsItemList.get(position);
        final ImageView newsImg = convertView.findViewById(R.id.lefticon);
        final TextView heading = convertView.findViewById(R.id.heading);
        final TextView desc = convertView.findViewById(R.id.desc);


        tf1 = Typeface.createFromAsset(getContext().getAssets(),"PT_Serif-Web-Bold.ttf" );
        tf2 = Typeface.createFromAsset(getContext().getAssets(),"PT_Serif-Web-Regular.ttf" );

        heading.setText(currentItem.getTitle());
        heading.setTypeface(tf1);
        desc.setText(currentItem.getDesc());
        desc.setTypeface(tf2);

        if (currentItem.getUrlToImg().isEmpty()) {
            Glide.with(mContext)
                    .load(R.drawable.loading)
                    .into(newsImg);

        } else {
            Glide.with(mContext)
                    .load(currentItem.getUrlToImg())
                    .into(newsImg);
        }

        return convertView;
    }
}