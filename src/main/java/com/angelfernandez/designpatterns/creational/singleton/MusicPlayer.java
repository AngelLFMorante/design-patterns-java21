package com.angelfernandez.designpatterns.creational.singleton;

public class MusicPlayer {

    private static MusicPlayer instance;

    private String currentSong;

    private MusicPlayer() {
    }

    public static synchronized  MusicPlayer getInstance(){

        if(MusicPlayer.instance == null){
            instance = new MusicPlayer();
        }

        return instance;
    }

    public void play(String song){
        currentSong = song;
    }

    public String getCurrentSong(){
        return currentSong;
    }

}
