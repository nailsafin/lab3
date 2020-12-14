package com.company;

public class FightForSweets implements ExchangingSweets {
    Character giving;
    Character taking;

    public FightForSweets(Character giving, Character taking) {
        this.taking = taking;
        this.giving = giving;
    }

    private boolean isDraw(Character giving, Character taking) {
        if(taking.equals(giving)) return true;
        else return false;
    }

    public void start(Character giving, Character taking, AmountOfSweets amount) {
        System.out.println("Началась драка между " + giving.getName() + " и " + taking.getName() + " за " + amount);
        if(isDraw(giving, taking)) {
            System.out.println("драка закончилась ничьей, все остаются при своих конфетах");
        }
        else {
            if(taking.hashCode() > giving.hashCode()) {
                System.out.println(giving.getName() + " проиграл");
                    exchangeSweetsFromTo(giving, taking, amount);
            }
            else {
                System.out.println(giving.getName() + " выиграл и остался при своих конфетах");
            }
        }
    }



    @Override
    public String toString() {
        return "между " + taking.getName() + " и " + giving.getName() + " началась драка";
    }
}
