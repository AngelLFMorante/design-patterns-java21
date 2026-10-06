package com.angelfernandez.designpatterns.creational.factorymethod;

public class FactoryMethodExample {

    public static void main(String[] args) {
       /* ContentFactory bookFactory = new BookFactory();
        LibraryContent book = bookFactory.createContent();
        book.open();

        ContentFactory magazineFactory = new MagazineFactory();
        LibraryContent magazine = magazineFactory.createContent();
        magazine.open();

        ContentFactory audiobookFactory = new AudiobookFactory();
        LibraryContent audioBook = audiobookFactory.createContent();
        audioBook.open();*/

        ContentFactory bookFactory = new BookFactory();
        bookFactory.openContent();

        ContentFactory magazineFactory = new MagazineFactory();
        magazineFactory.openContent();

        ContentFactory audiobookFactory = new AudiobookFactory();
        audiobookFactory.openContent();
    }
}
