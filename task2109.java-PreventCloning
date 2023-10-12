package com.codegym.task.task21.task2109;

/* 
Prevent cloning
Allow cloning of the A class
Prevent cloning of the B class
Allow cloning of the C class
Don't forget about the equals and hashCode methods!


Requirements:
1. The A class should support the Cloneable interface.
2. The B class must be a descendant of the A class.
3. The B class's declaration should not explicitly state "implements Cloneable".
4. The B class's clone method must be overridden in such a way that an attempt to clone a B object will generate a CloneNotSupportedException.
5. The C class must be a descendant of the B class.
6. C objects must be cloned successfully.

*/

import java.util.Objects;

public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            A a = (A) o;
            return i == a.i && j == a.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            B b = (B) o;
            return Objects.equals(name, b.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), name);
        }

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Object clone() throws CloneNotSupportedException {

            throw new CloneNotSupportedException();


        }
    }

    public static class C extends B {

        public C(int i, int j, String name) {
            super(i, j, name);
        }

        public Object clone(){
            C c = new C (super.getI(), super.getJ(), super.getName());


            return c;
        }
    }

    public static void main(String[] args) {

    }
}
