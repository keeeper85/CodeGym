package com.codegym.task.task37.task3713;

import com.codegym.task.task37.task3713.space.crew.AbstractCrewMember;
import com.codegym.task.task37.task3713.space.SpaceShip;

/* 
Chain of Responsibility

Amigo, we have a problem! During a visit to Planet #IND893, we dared to outsource
the automatic assignment of incoming tasks for crew members.
It's hard to believe, but now it seems that the first mate has to do everything!

We need to fix the program quickly, because cabin boys can scrub the deck,
but only the captain can shout "Battle stations!"

P.S. Try to implement the handleRequest method so that we don't have to change it if we add new positions.
Don't touch the other methods.


*/

public class Solution {
    public static void main(String[] args) {
        SpaceShip spaceShip = new SpaceShip();
        AbstractCrewMember crewMember = spaceShip.getCrewChain();

        crewMember.handleRequest(AbstractCrewMember.CompetencyLevel.EXPERT, "ATTACK");
        System.out.println("-----------------------------------------");
        crewMember.handleRequest(AbstractCrewMember.CompetencyLevel.NOVICE, "WASH THE FLOOR");
        System.out.println("-----------------------------------------");
        crewMember.handleRequest(AbstractCrewMember.CompetencyLevel.INTERMEDIATE, "CHECK ENGINE");
        System.out.println("-----------------------------------------");
        crewMember.handleRequest(AbstractCrewMember.CompetencyLevel.ADVANCED, "SET COURSE");
    }
}
