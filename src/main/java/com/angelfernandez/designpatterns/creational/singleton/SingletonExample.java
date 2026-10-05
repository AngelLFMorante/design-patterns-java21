package com.angelfernandez.designpatterns.creational.singleton;

public class SingletonExample {

    public static void main(String[] args) {
        MusicPlayer player1 = MusicPlayer.getInstance();
        MusicPlayer player2 = MusicPlayer.getInstance();

        player1.play("Purple Rain - Prince");

        System.out.println("¿Es la misma instancia? " + (player1 == player2));
        System.out.println("Canción actual: " + player2.getCurrentSong());
    }
}
