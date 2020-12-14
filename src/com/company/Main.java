package com.company;

public class Main {

    public static void main(String[] args) {
        Carlson Carlson = new Carlson("Карлсон", "мальчик", 70, 100, 2, 3, 4);
        Kirre Kirre = new Kirre("Кирре", "мальчик", 40, 50, AmountOfSweets.BAG.numberOfSweets(), 0, 4);
        Gunilla Gunilla = new Gunilla("Гунилла", "девочка", 40,40,AmountOfSweets.BOX.numberOfSweets(), 1);

        Kirre.exchangeSweetsFromTo(Kirre, Carlson, AmountOfSweets.BAG);
        Gunilla.exchangeSweetsFromTo(Gunilla, Carlson, AmountOfSweets.BOX);
        Gunilla.thinkAbout(Carlson);
        Carlson.share(Kirre, Gunilla, Carlson, AmountOfSweets.ONEPIECE);
        Carlson.flyAway(Carlson.getWeight());
        Gunilla.cry(Gunilla.getMoodLevel());
        System.out.println(Carlson);
        System.out.println(Kirre);
        System.out.println(Gunilla);
    }
}
