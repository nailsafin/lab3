package com.company;

public abstract class Character {

    /**Характеристики персонажа*/
    private String name;
    private String gender;
    private int power;
    private int weight;
    private int numberOfSweets;
    private int moodLevel;

    /**Конструктор абстрактного класса персонажа*/
    public Character(String name, String gender, int power, int weight, int numberOfSweets, int moodLevel) {
        this.name = name;
        this.gender = gender;
        this.power = power;
        this.numberOfSweets = numberOfSweets;
        this.weight = weight + numberOfSweets;
        this.moodLevel = moodLevel;
    }



    /**Возвращает имя персонажа*/
    public String getName() {return name;}

    /**Возвращает пол персонажа*/
    public String getGender() {return gender;}

    /**Возвращает силу персонажа*/
    public int getPower() {return power;}

    /**Возвращает количество конфет у персонажа*/
    public int getNumberOfSweets() {
        return numberOfSweets;
    }

    /**Увеличивает количество конфет на заданное число*/
    public void addSweets(int numberOfSweets) {
        this.numberOfSweets += numberOfSweets;
        addWeight(numberOfSweets);
    }

    /**Уменьшает количество конфет на заданное число*/
    public void removeSweets(int numberOfSweets) {
        this.numberOfSweets -= numberOfSweets;
        removeWeight(numberOfSweets);
    }



    /**Увеличивает масссу персонажа на заданное число*/
    public void addWeight(int mass) {
        weight += mass;
    }

    /**Возвращает массу персонажа*/
    public int getWeight() {
        return weight;
    }

    /**Уменьшает масссу персонажа на заданное число*/
    public void removeWeight(int mass) {
        weight -= mass;
    }



    /**Возвращает уровень настроения персонажа*/
    public int getMoodLevel() {
        return moodLevel;
    }

    /**Увеличивает уровень настроения персонажа*/
    public void increaseMoodLevel(int i) {
        moodLevel += i;
    }

    /**Уменьшает уровень настроения персонажа*/
    public void decreaseMoodLevel(int i) {
        moodLevel -= i;
    }


    @Override
    /**Возвращает сводку по персонажу*/
    public String toString() {
        WelfareCalculating calculate;
        calculate = (moodLevel, weight, numberOfSweets) -> (Math.pow(moodLevel, 2) + Math.pow(numberOfSweets, 2)/weight)*Math.pow(weight, -0.5);
        String mood = null;
        if(moodLevel > 2 || calculate.calculateWelfare(getMoodLevel(), getWeight(), getNumberOfSweets()) > 0.1) {
            mood = " в хорошем настроении";
        }
        else {
            mood = " в плохом настроении";
        }
        return name + " c " + numberOfSweets + " конфетами" + mood;
    }

    @Override
    /**Проверяет равенство двух персонажей по заданным критериям*/
    public boolean equals(Object o) {
        Character character = (Character) o;
        if(character.moodLevel == moodLevel &&
                character.power == power &&
                character.weight == weight) return true;
        else return false;
    }

    /**Вычисляет индивидуальный кэффициент удельной силы*/
    public int hashCode() {
        return 100*power*moodLevel/weight;
    }

}