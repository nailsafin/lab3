package com.company;

public class Carlson extends Character implements DependentOnPosition, ExchangingSweets {

    /**Целочисленное значение позиции персонажа*/
    private int position;

    /**Конструктор персонажа Карлсон*/
    public Carlson(String name, String gender, int power, int weight, int numberOfSweets, int position, int moodLevel) {
        super(name, gender, power, weight, numberOfSweets, moodLevel);
        this.position = position;
    }



    /**Определяет возможность пересчета конфет*/
    public boolean isHereWhatToCount(int numberOfSweets) {
        if(numberOfSweets > 1) return true;
        else return false;
    }

    public void count(int numberOfSweets) {
        if(isHereWhatToCount(numberOfSweets)) {

            System.out.println(getName() + " пересчитал конфеты - " + getNumberOfSweets() + " штук!");
        }
    }



    /**Определяет возмонжость взлететь*/
    public boolean canFlyAway(int weight) {
        if(weight > 150) return false;
        else return true;
    }

    public void flyAway(int weight) {
        if(canFlyAway(weight)) System.out.println(getName() + " вылетел в окно");
        else {
            System.out.println(getName() + " попытался взлететь, но не смог");
        }
    }



    /**Определяет возможность прделиться конфетами*/
    public boolean canShare(int numberOfSweets, int moodLevel) {
        if (getMoodLevel() > 2 && getNumberOfSweets() > 70) return true;
        else return false;
    }

    /**Реализует процесс раздачи конфет персонажем*/
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

    /**Определяет возможность обиды персонажа*/
    public boolean shouldTakeOffence(String conclusion) {
        if(conclusion.equals("Гунилла сделала вывод: " + getName() + " мудак")) return true;
        else return false;
    }

    /**Возвращает реакцию персонажа на заключение в виде строки*/
    public String takeOffence(String conclusion) {
        if(shouldTakeOffence(conclusion)) {
            return getName() + " обиделся";
        }
        else {
            return getName() + " польщен";
        }
    }



    @Override
    public int getPosition() {
        if(canFlyAway(getWeight())) {
            position -= 1;
        }
        return position;
    }
}