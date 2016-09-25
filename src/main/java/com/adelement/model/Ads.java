package com.adelement.model;

/**
 * Created by Meetansh on 25-09-2016.
 */
public class Ads {
    private String headline;
    private String subheadline;
    private String imageurl;
    private String button;

    public  Ads(){}

    public  Ads(String headline, String subheadline, String imageurl, String button) {
        this.headline = headline;
        this.subheadline = subheadline;
        this.imageurl = imageurl;
        this.button = button;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getSubheadline() {
        return subheadline;
    }

    public void setSubheadline(String subheadline) {
        this.subheadline = subheadline;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "headline="+ headline +
                ", subheadline="+ subheadline +
                ", button="+ button +
                ", imageurl="+ imageurl ;
    }
}
