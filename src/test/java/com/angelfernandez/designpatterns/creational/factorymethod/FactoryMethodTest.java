package com.angelfernandez.designpatterns.creational.factorymethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class FactoryMethodTest {

    @Test
    void shouldCreateBook (){
        ContentFactory bookFactory = new BookFactory();

        LibraryContent content  = bookFactory.createContent();

        assertInstanceOf(Book.class, content);
    }

    @Test
    void shouldCreateMagazine (){
        ContentFactory magazineFactory = new MagazineFactory();

        LibraryContent content  = magazineFactory.createContent();

        assertInstanceOf(Magazine.class, content);
    }

    @Test
    void shouldCreateAudiobook (){
        ContentFactory  audiobookFactory = new AudiobookFactory ();

        LibraryContent content  = audiobookFactory.createContent();

        assertInstanceOf(Audiobook.class, content);
    }

}