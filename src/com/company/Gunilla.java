package com.company;

public class Gunilla extends Character implements ExchangingSweets {
     public Gunilla(String name, String gender, int power, int weight, int numberOfSweets, int moodLevel) {
         super(name, gender, power, weight, numberOfSweets, moodLevel);
     }

     public void thinkAbout(Carlson carlson) {
         if(carlson.canShare(carlson.getNumberOfSweets(), carlson.getMoodLevel())) {
             increaseMoodLevel(2);
         }
         System.out.println(getName() + " думала, что " + carlson.getName() + " поделиться конфетами");
     }


     public boolean shouldCry(int moodLevel) {
         if(moodLevel < 3) return true;
         else return false;
     }

     public void cry(int moodLevel) {
         if(shouldCry(moodLevel)) {
             System.out.println(getName() + " заплакала");
         }
         else System.out.println(getName() + " всплакнула");
     }
}
