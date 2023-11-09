package com.codegym.task.task28.task2809;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

/* 
Plants vs Zombies

1. Read about java.util.concurrent.Phaser.
2. Put the methods in the right places:
- arriveAndDeregister(): starts calling the tasks' run methods,
- arriveAndAwaitAdvance(): waits for all threads to be created.
See output.txt for example output.
Logic: First, all the characters join the game.
After all the characters have joined the game and are ready to play, the phrase "The game has begun!" is displayed.
After that, the characters enter the game and then die.

*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        List<Character> characters = new ArrayList<>();
        characters.add(new Plant());
        characters.add(new Plant());
        characters.add(new Zombie());
        characters.add(new Zombie());
        characters.add(new Zombie());
        start(characters);
    }

    private static boolean isEveryoneReady = false;

    private static void start(List<Character> characters) throws InterruptedException {
        final Phaser phaser = new Phaser(1 + characters.size());
//        phaser.arriveAndDeregister();
//        phaser.arriveAndAwaitAdvance();


        for (final Character character : characters) {
            final String member = character.toString();
            System.out.println(member + " joined the game");
            new Thread() {
                @Override
                public void run() {

                    System.out.println(member + " is preparing to play");
                    phaser.arriveAndAwaitAdvance();

                    if (!isEveryoneReady) {
                        isEveryoneReady = true;
                        System.out.println("The game has begun!");
                    }


                    character.run();

                }
            }.start();

        }
        phaser.arriveAndDeregister();


    }
}
