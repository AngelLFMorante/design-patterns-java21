package com.angelfernandez.designpatterns;

import com.angelfernandez.designpatterns.creational.singleton.MusicPlayer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class MusicPlayerTest {

    @Test
    void shouldReturnSameInstance() {

        var player1 = MusicPlayer.getInstance();
        var player2 = MusicPlayer.getInstance();

        assertSame(player1, player2);
    }

    @Test
    void shouldShareCurrentSongBetweenReferences(){
        var player1 = MusicPlayer.getInstance();
        var player2 = MusicPlayer.getInstance();

        player1.play("Bohemian Rhapsody");

        assertEquals("Bohemian Rhapsody", player2.getCurrentSong());
    }
}