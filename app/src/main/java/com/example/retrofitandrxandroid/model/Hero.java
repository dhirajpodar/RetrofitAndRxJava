
package com.example.retrofitandrxandroid.model;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Hero {

    @SerializedName("bio")
    private String mBio;
    @SerializedName("createdby")
    private String mCreatedby;
    @SerializedName("firstappearance")
    private String mFirstappearance;
    @SerializedName("imageurl")
    private String mImageurl;
    @SerializedName("name")
    private String mName;
    @SerializedName("publisher")
    private String mPublisher;
    @SerializedName("realname")
    private String mRealname;
    @SerializedName("team")
    private String mTeam;

    public String getBio() {
        return mBio;
    }

    public void setBio(String bio) {
        mBio = bio;
    }

    public String getCreatedby() {
        return mCreatedby;
    }

    public void setCreatedby(String createdby) {
        mCreatedby = createdby;
    }

    public String getFirstappearance() {
        return mFirstappearance;
    }

    public void setFirstappearance(String firstappearance) {
        mFirstappearance = firstappearance;
    }

    public String getImageurl() {
        return mImageurl;
    }

    public void setImageurl(String imageurl) {
        mImageurl = imageurl;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPublisher() {
        return mPublisher;
    }

    public void setPublisher(String publisher) {
        mPublisher = publisher;
    }

    public String getRealname() {
        return mRealname;
    }

    public void setRealname(String realname) {
        mRealname = realname;
    }

    public String getTeam() {
        return mTeam;
    }

    public void setTeam(String team) {
        mTeam = team;
    }

}
