package com.example.musicchalaye;

public class Songs {
    String song;
    String url;
    String artists;
    String coverimage;
    public Songs(){

    }
    public Songs(String song,String url,String artists,String coverimage){
        this.artists=artists;
        this.coverimage=coverimage;
        this.song=song;
        this.url=url;


    }

    public String getArtists() {
        return artists;
    }

    public String getCoverimage() {
        return coverimage;
    }

    public String getSong() {
        return song;
    }

    public String getUrl() {
        return url;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    public void setCoverimage(String coverimage) {
        this.coverimage = coverimage;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
