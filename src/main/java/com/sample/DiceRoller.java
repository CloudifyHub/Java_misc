package com.sample;
import java.util.Random;

//Local and Global Variable
public class DiceRoller {
    //Global
    Random random = new Random();
    int number;
    DiceRoller(){
        /*Random*/ random = new Random();
        /*int number = 0;*/
        //roll(random, number);
        roll();
    }


    //local
    /*
    void roll(Random random, int number) {
        number = random.nextInt(6)+2;
        System.out.println(number);
    }

     */

    //globAL
    void roll(){
        number = random.nextInt(6)+2;
        System.out.println(number);
    }

}
