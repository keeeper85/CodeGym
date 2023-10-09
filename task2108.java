package com.codegym.task.task21.task2108;

/* 
Cloning plants
The Plant class should not implement the Cloneable interface
Implement deep cloning for Tree.


Requirements:
1. The Plant class should not implement the Cloneable interface.
2. The Tree class should support the Cloneable interface.
3. The Tree class must be a descendant of the Plant class.
4. The Tree class must correctly implement the clone method.

*/

public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = (Tree) tree.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant implements Cloneable {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        public Object clone(){
            String[] newBranches = new String[branches.length];
            for (int i = 0; i < newBranches.length; i++){
                newBranches[i] = branches[i];
            }
            Tree clone = new Tree(super.getName(), newBranches);

            return clone;
        }
    }
}
