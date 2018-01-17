package com.vmagames.relevant_news;

import android.app.Activity;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;

import java.util.zip.Inflater;

/**
 * Created by Марк on 30.08.2017.
 */

public class ChooseAdapter extends ArrayAdapter<String> {

    final Activity context;
    final String[] names;
    final Integer[] imgid;
    final String[] urls;

    public ChooseAdapter(Activity context, String[] names, Integer[] imgid, String[] urls){
        super(context, R.layout.chooseitem, names );
        this.context = context;
        this.names = names;
        this.imgid = imgid;
        this.urls = urls;
    }
    public View getView(int position, View view, ViewGroup getparent){
        LayoutInflater inflater = context.getLayoutInflater();
        View rowview = inflater.inflate(R.layout.chooseitem, null, true);

        ImageView imageView = rowview.findViewById(R.id.imageView);
        CheckBox checkBox = rowview.findViewById(R.id.checkBox);
        imageView.setImageResource(imgid[position]);
        checkBox.setText(names[position]);


        return rowview;
    }

}
