package com.vmagames.relevant_news;

/**
 * Created by Марк on 25.08.2017.
 */

public class NewsItem {
    String title;
    String desc;
    String author;
    String link;
    String urlToImg;

    public NewsItem(String title, String desc, String author, String link, String urlToImg) {
        this.title = title;
        this.desc = desc;
        this.author = author;
        this.link = link;
        this.urlToImg = urlToImg;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getAuthor() {
        return author;
    }

    public String getLink() {
        return link;
    }

    public String getUrlToImg() {
        return urlToImg;
    }
}