package com.company;

public abstract class Character {
    private String name;
    private String gender;
    private int power;
    private int weight;
    private int numberOfSweets;
    private int moodLevel;

    public Character(String name, String gender, int power, int weight, int numberOfSweets, int moodLevel) {
        this.name = name;
        this.gender = gender;
        this.power = power;
        this.numberOfSweets = numberOfSweets;
        this.weight = weight + numberOfSweets;
        this.moodLevel = moodLevel;
    }



    public String getName() {
        return name;
    }
    public String getGender() {return gender;}
    public int getPower() {return power;}


    public int getNumberOfSweets() {
        return numberOfSweets;
    }

    public void addSweets(int numberOfSweets) {
        this.numberOfSweets += numberOfSweets;
    }

    public void removeSweets(int numberOfSweets) {
        this.numberOfSweets -= numberOfSweets;
    }



    public void addWeight(int mass) {
        weight += mass;
    }

    public int getWeight() {
        return weight;
    }

    public void removeWeight(int mass) {
        weight -= mass;
    }



    public int getMoodLevel() {
        return moodLevel;
    }

    public void increaseMoodLevel(int i) {
        moodLevel += i;
    }

    public void decreaseMoodLevel(int i) {
        moodLevel -= i;
    }


    @Override
    public String toString() {
        String mood = null;
        if(moodLevel > 2) {
            mood = " в хорошем настроении";
        }
        return name + " c " + numberOfSweets + " конфетами" + mood;
    }

    @Override
    public boolean equals(Object o) {
        Character character = (Character) o;
        if(character.moodLevel == moodLevel &&
                character.power == power &&
                character.weight == weight) return true;
        else return false;
    }

    public int hashCode() {
        return 100*power*moodLevel/weight;
    }

}
