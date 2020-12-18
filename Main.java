package com.company;

public class Main {

    /**Наполнение сцены*/
    public static void main(String[] args) {

        WelfareCalculating calculate;
        calculate = (moodLevel, weight, numberOfSweets) -> (Math.pow(moodLevel, 2) + Math.pow(numberOfSweets, 2)/weight)*Math.pow(weight, -0.5);

        Carlson carlson = new Carlson("Карлсон", "мальчик", 30, 100, 2, 3, 2);
        Kirre kirre = new Kirre("Кирре", "мальчик", 80, 90, AmountOfSweets.BAG.numberOfSweets(), 0, 2);
        Gunilla gunilla = new Gunilla("Гунилла", "девочка", 40,40,AmountOfSweets.BOX.numberOfSweets(), 1);

        kirre.exchangeSweetsFromTo(kirre, carlson, AmountOfSweets.BAG);
        gunilla.exchangeSweetsFromTo(gunilla, carlson, AmountOfSweets.BOX);
        gunilla.thinkAbout(carlson);
        carlson.share(kirre, gunilla, carlson, AmountOfSweets.ONEPIECE);

        String conclusion = gunilla.makeConclusion(carlson);
        System.out.println(conclusion);

        String carlsonsResponse = carlson.takeOffence(conclusion);
        System.out.println(carlsonsResponse);
        kirre.showAgress(carlsonsResponse, carlson);

        carlson.flyAway(carlson.getWeight());

        double gunillasWelfare = calculate.calculateWelfare(gunilla.getMoodLevel(), gunilla.getWeight(), gunilla.getNumberOfSweets());
        gunilla.cry(gunillasWelfare);

        System.out.println(carlson);
        System.out.println(kirre);
        System.out.println(gunilla);
    }
}
