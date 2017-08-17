package com.wanching.zoophotogallery;

/**
 * Created by WanChing on 17/8/2017.
 */

public class Album {

    private String title;
    private int photoCount;

    public Album (String title, int photoCount){
        this.title = title;
        this.photoCount = photoCount;
    }

    public String getTitle(){return title;}

    public int getPhotoCount(){return photoCount;}
}
