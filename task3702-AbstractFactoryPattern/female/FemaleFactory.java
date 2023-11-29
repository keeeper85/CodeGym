package com.codegym.task.task37.task3702.female;

import com.codegym.task.task37.task3702.AbstractFactory;
import com.codegym.task.task37.task3702.Human;
import com.codegym.task.task37.task3702.male.KidBoy;
import com.codegym.task.task37.task3702.male.Man;
import com.codegym.task.task37.task3702.male.TeenBoy;

public class FemaleFactory implements AbstractFactory {

    public Human getPerson(int age){
        if (age <= KidGirl.MAX_AGE) return new KidGirl();
        else if (age <= TeenGirl.MAX_AGE) return new TeenGirl();
        return new Woman();
    }

}
