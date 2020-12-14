package com.company;

public class Carlson extends Character implements DependentOnPosition, ExchangingSweets {
    private int position;

    public Carlson(String name, String gender, int power, int weight, int numberOfSweets, int position, int moodLevel) {
        super(name, gender, power, weight, numberOfSweets, moodLevel);
        this.position = position;
    }



    public boolean isHereWhatToCount(int numberOfSweets) {
        if(numberOfSweets > 1) return true;
        else return false;
    }

    public void count(int numberOfSweets) {
        if(isHereWhatToCount(numberOfSweets)) {

            System.out.println(getName() + " пересчитал конфеты - " + getNumberOfSweets() + " штук!");
        }
    }



    public boolean canFlyAway(int weight) {
        if(weight > 150) return false;
        else return true;
    }

    public void flyAway(int weight) {
        if(canFlyAway(weight)) System.out.println(getName() + " вылетел в окно");
        else System.out.println(getName() + " попытался взлететь, но не смог");
    }



    public boolean canShare(int numberOfSweets, int moodLevel) {
        if (getMoodLevel() > 2 && getNumberOfSweets() > 10) return true;
        else return false;
    }

    public void share(Kirre kirre, Gunilla gunilla, Carlson carlson, AmountOfSweets amount) {
        if(canShare(getNumberOfSweets(), getMoodLevel())) {
            System.out.println(getName() + " поделился с остальными и дал каждому по конфете");
            exchangeSweetsFromTo(carlson, kirre, amount);
            exchangeSweetsFromTo(carlson, gunilla, amount);
            count(getNumberOfSweets());
        }
        else {
            System.out.println(getName() + " не поделился и стал считать конфеты");
            count(getNumberOfSweets());
        }
    }



    @Override
    public int getPosition() {
        return position;
    }
}
