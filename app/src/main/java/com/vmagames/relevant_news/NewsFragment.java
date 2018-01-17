package com.vmagames.relevant_news;

/**
 * Created by Марк on 25.08.2017.
 */


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class NewsFragment extends Fragment {

    private static final String TAG = "myLog";
    private CustomAdapter mCustomAdapter;
    private String url;

    public NewsFragment() {

    }

    public static NewsFragment newInstance(String url) {

        Bundle args = new Bundle();

        NewsFragment fragment = new NewsFragment();
        args.putString("url", url);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        url = getArguments().getString("url");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.listviewlayout, container, false);
        final ListView newsItem = root.findViewById(R.id.list_item);
        mCustomAdapter = new CustomAdapter(getContext(), new ArrayList<NewsItem>());
        mCustomAdapter.clear();
        newsItem.setAdapter(mCustomAdapter);
        onReq(url);

        final SwipeRefreshLayout swipeRefreshLayout = root.findViewById(R.id.swipeRefresh);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                newsItem.setAdapter(mCustomAdapter);
                onReq(url);
                new Handler().postDelayed(new Runnable() {
                    @Override public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 300);
            }
        });


        newsItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(),Main2Activity.class);
                intent.putExtra("url",mCustomAdapter.getItem(position).getLink());
                startActivity(intent);
            }
        });


        return root;
    }

    private void onReq(String url){
        final RequestQueue queue = Volley.newRequestQueue(getContext());
        final List<NewsItem> newsFeed = new ArrayList<>();

        Log.i("myLog", "onReq: " + url);
        JsonObjectRequest myReq = new JsonObjectRequest(Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {

                            JSONArray newsItems = response.getJSONArray("articles");

                            for (int i = 0; i < newsItems.length(); i++) {

                                JSONObject temp = newsItems.getJSONObject(i);

                                String title1 = temp.getString("title");
                                String desk = temp.getString("description");
                                if (temp.getString("description") == null) {
                                    desk = " ";
                                }
                                String urlToImg = temp.getString("urlToImage");
                                String link1 = temp.getString("url");

                                //newsFeed.add(new NewsItem(title1, desk, "", link1, urlToImg));
                                mCustomAdapter.addAll(new NewsItem(title1, desk, "", link1, urlToImg));
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        queue.add(myReq);
    }

}
