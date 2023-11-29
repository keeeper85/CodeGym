package com.codegym.task.task37.task3702;

import com.codegym.task.task37.task3702.female.FemaleFactory;
import com.codegym.task.task37.task3702.male.MaleFactory;

public class Solution {

    public static void main(String[] args) {

        Human human = FactoryProducer.getFactory(FactoryProducer.HumanFactoryType.MALE).getPerson(11);
        System.out.println(human);

    }
}
