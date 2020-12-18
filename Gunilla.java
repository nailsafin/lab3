package com.company;

public class Gunilla extends Character implements ExchangingSweets {

    /**Конструктор персонажа*/
    public Gunilla(String name, String gender, int power, int weight, int numberOfSweets, int moodLevel) {
        super(name, gender, power, weight, numberOfSweets, moodLevel);
    }

    /**Описывает процесс размышлений с изменением показателя настроения*/
    public void thinkAbout(Carlson carlson) {
        if(carlson.canShare(carlson.getNumberOfSweets(), carlson.getMoodLevel())) {
            increaseMoodLevel(2);
        }
        System.out.println(getName() + " думала, что " + carlson.getName() + " поделится конфетами");
    }



    /**Определяет возможность плача*/
    public boolean shouldCry(double welfare) {
        if(welfare < 0.1) return true;
        else return false;
    }

    public void cry(double welfare) {
        if(shouldCry(welfare)) {
            System.out.println(getName() + " заплакала");
        }
        else System.out.println(getName() + " всплакнула");
    }

    /**Возвращает умозаключение в виде строки*/
    public String makeConclusion(Carlson carlson) {
        if(!carlson.canShare(carlson.getNumberOfSweets(), carlson.getMoodLevel())){
            decreaseMoodLevel(1);
            return "Гунилла сделала вывод: " + carlson.getName() + " мудак";
        }
        else {
            increaseMoodLevel(1);
            return "Гунилла сделала вывод: " + carlson.getName() + " красавчик";
        }
    }
}