package com.company;

public interface ExchangingSweets {
    /**Реализует процесс передачи некоторого количества конфет между персонажами*/
    default void exchangeSweetsFromTo(Character giving, Character taking, AmountOfSweets amount) {
        giving.removeSweets(amount.numberOfSweets());
        giving.decreaseMoodLevel(1);
        giving.removeWeight(amount.weight());

        taking.addSweets(amount.numberOfSweets());
        taking.increaseMoodLevel(1);
        taking.addWeight(amount.weight());

        System.out.println(giving.getName() + " отдал " + taking.getName() + " " + amount);
    }
}