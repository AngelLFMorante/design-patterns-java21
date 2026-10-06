package com.angelfernandez.designpatterns.creational.builder;

public class BuilderExample {
    public static void main(String[] args) {
        Computer computer1 = new Computer.Builder()
                .processor("Ryzen 7")
                .ram(32)
                .graphicsCard("5070Rtx")
                .wifi(true)
                .bluetooth(false)
                .build();
        System.out.println("#### ORDENADOR 1 ####");
        System.out.println(computer1);

        Computer computer2 = new Computer.Builder()
                .processor("Intel 10")
                .ram(16)
                .graphicsCard("970gtx")
                .wifi(false)
                .build();
        System.out.println("#### ORDENADOR 2 ####");
        System.out.println(computer2);
    }
}
