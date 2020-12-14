package com.company;

public enum AmountOfSweets {
    BAG(10,10, "кулёк конфет"),
    BOX(50, 50, "коробка для входных конфет"),
    ONEPIECE(1, 1, "одна конфета");

    private int numberOfSweets;
    private int weight;
    private String name;

    AmountOfSweets(int numberOfSweets, int weight,String name) {
         this.numberOfSweets = numberOfSweets;
         this.weight = weight;
         this.name = name;
    }

    public int numberOfSweets() {
        return this.numberOfSweets;
    }
    public int weight() {
        return this.weight;
    }
    public String toString() {
        return this.name;
    }
}
