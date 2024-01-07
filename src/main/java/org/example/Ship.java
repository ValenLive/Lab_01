package org.example;

public class Ship {

    private double tonnage;
    private String name;
    private int numberOfPassengers;

    public Ship(double tonnage, String name, int numberOfPassengers) {
        this.tonnage = tonnage;
        this.name = name;
        this.numberOfPassengers = numberOfPassengers;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "tonnage=" + tonnage +
                ", name='" + name + '\'' +
                ", numberOfPassengers=" + numberOfPassengers +
                '}';
    }

    public double getTonnage() {
        return tonnage;
    }

    public void setTonnage(double tonnage) {
        this.tonnage = tonnage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
}
