package com.angelfernandez.designpatterns.creational.builder;

public class Computer {

    private final String processor;
    private final String graphicsCard;
    private final int ram;
    private final int storage;
    private final boolean wifi;
    private final boolean bluetooth;

    private Computer(Builder builder) {
        this.processor = builder.processor;
        this.graphicsCard = builder.graphicsCard;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.wifi = builder.wifi;
        this.bluetooth = builder.bluetooth;
    }

    public static class Builder {
        private String processor;
        private String graphicsCard;
        private int ram;
        private int storage;
        private boolean wifi;
        private boolean bluetooth;

        public Builder processor(String processor){
            this.processor = processor;
            return this;
        }

        public Builder graphicsCard (String graphicsCard){
            this.graphicsCard = graphicsCard;
            return this;
        }
        public Builder ram(int ram){
            this.ram = ram;
            return this;
        }
        public Builder storage(int storage){
            this.storage = storage;
            return this;
        }
        public Builder wifi(boolean wifi){
            this.wifi = wifi;
            return this;
        }
        public Builder bluetooth(boolean bluetooth){
            this.bluetooth = bluetooth;
            return this;
        }

        public Computer build(){
            checkComputerData();
            return new Computer(this);
        }

        private void checkComputerData() {
            if(processor == null || processor.isBlank()){
                throw new IllegalStateException("Procesador no puede estar vacio");
            }
            if(ram <= 0){
                throw new IllegalStateException("La RAM debe ser mayor que 0");
            }
        }
    }

    @Override
    public String toString() {
        return "Computer{" +
                "processor='" + processor + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", wifi=" + wifi +
                ", bluetooth=" + bluetooth +
                '}';
    }
}
