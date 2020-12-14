package com.company;

public class Kirre extends Character implements DependentOnPosition, ExchangingSweets{
    protected int position;
    private int moodLevel;

    public Kirre(String name, String gender, int power, int weight, int numberOfSweets, int position, int moodLevel) {
        super(name, gender, power, weight, numberOfSweets, moodLevel);
        this.position = position;
        this.moodLevel = moodLevel;
    }

    public boolean managed(int position1, int position2) {
        if(Math.abs(position1 - position2) > 2) return true;
        else return false;
    }

    public void putInMouth(int position1, AmountOfSweets amount, Character taking) {
        if(managed(position1, getPosition())) {
            addWeight(amount.weight());
            taking.removeSweets(amount.numberOfSweets());
            moodLevel += 1;
            System.out.println(getName() + " успел съесть " + amount);
        }
    }

    public boolean giveSweetsWithoutFight(int moodLevel) {
        if(moodLevel >= 3) return true;
        else return false;
    }

    @Override
    public void exchangeSweetsFromTo(Character giving, Character taking, AmountOfSweets amount) {
        if(giveSweetsWithoutFight(moodLevel)) {
            moodLevel -= 1;
            giving.removeSweets(amount.numberOfSweets());
            giving.decreaseMoodLevel(1);
            giving.removeWeight(amount.weight());

            taking.addSweets(amount.numberOfSweets());
            taking.increaseMoodLevel(1);
            taking.addWeight(amount.weight());

            System.out.println(giving.getName() + " отдал " + taking.getName() + " " + amount);

            putInMouth(((Carlson)taking).getPosition(), AmountOfSweets.ONEPIECE, taking);
        }
        else {
            FightForSweets fight = new FightForSweets(giving, taking);
            fight.start(giving, taking, amount);
        }
    }



    @Override
    public int getPosition() {
        return position;
    }
}
