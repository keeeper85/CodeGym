package com.codegym.task.task37.task3712;

import java.util.ArrayList;
import java.util.List;

/* 
Template method

The Football, Basketball, and Tennis classes describe three popular games.
Ask your favorite search engine about the Template Method pattern and make it
so that the code in the Solution class's main method makes sense.

*/

public class Solution {
    public static void main(String[] args) {
        List<Game> games = new ArrayList<>();

        games.add(new Football());
        games.add(new Basketball());
        games.add(new Tennis());

        for(Game game : games) {
            game.run();
            System.out.println("---------------------------------------------");
        }
    }
}
