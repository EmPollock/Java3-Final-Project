package com.pollock.songs;

public class Song {
    private int songID;
    private String name;
    private String artist;
    private String youtube;

    public static int nextID = 0;

    public Song(String name, String artist, String youtube) {
        this.songID = nextID++;
        this.name = name;
        this.artist = artist;
        this.youtube = youtube;
    }

    public Song() {
        this.songID = nextID++;
        this.name = "";
        this.artist = "";
        this.youtube = "";
    }

    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }
}
