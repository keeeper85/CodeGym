package com.codegym.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/*
Build a tree (part 1)

*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;

    public CustomTree() {
        this.root = new Entry<>("0");
    }

    static class Entry<T> implements Serializable{
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddRightChildren = true;
            availableToAddLeftChildren = true;

        }

        public boolean isAvailableToAddChildren () {
            boolean result = availableToAddLeftChildren || availableToAddRightChildren;
            return result;
        }


    }
    public String get(int index) {
        throw new UnsupportedOperationException();
        //return null;
    }

    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException();
        //return super.addAll(index, c);
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
        //return super.subList(fromIndex, toIndex);
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
        //super.removeRange(fromIndex, toIndex);
    }

    @Override
    public int size() {

        int count = -1;
        Queue<Entry> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Entry node = queue.poll();
            count += 1;
            if (node.leftChild != null)
                queue.add(node.leftChild);
            if (node.rightChild != null)
                queue.add(node.rightChild);
        }
        return count;
    }

    public boolean add(String s) {
        //add root node to queue
        Entry<String> newNode = new Entry<>(s);
        Queue<Entry<String>> queue = new LinkedList<>();
        queue.add(root);
        Queue<Entry<String>> temp = new LinkedList<>();
        boolean isnull = false;
        while(!queue.isEmpty()) {
            //call the current node
            Entry<String> node = queue.poll();
            //identify node child if null and available
            if (node.leftChild == null && node.availableToAddLeftChildren == true) {
                node.leftChild = newNode;
                node.leftChild.parent = node;
                node.availableToAddLeftChildren = false;
                return true;
            } else if (node.rightChild == null && node.availableToAddRightChildren == true) {
                node.rightChild = newNode;
                node.rightChild.parent = node;
                node.availableToAddRightChildren = false;
                return true;
            }

            if (node.availableToAddLeftChildren == false && node.leftChild != null) {
                queue.add(node.leftChild);
            }

            if (node.availableToAddRightChildren == false && node.rightChild != null) {
                queue.add(node.rightChild);
            }

            if (node.leftChild == null && node.rightChild == null) {
                temp.add(node);
                isnull = true;
            }


        }

        if (isnull) {
            Entry node = temp.poll();
            node.leftChild = newNode;
            node.availableToAddLeftChildren = false;
            newNode.parent = node;
            return true;
        }

        return false;

    }

    public String getParent(String s) {
        Queue<Entry> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            if (root.elementName.equalsIgnoreCase(s))
                return null;
            else {
                Entry<String> node = queue.poll();
                if (node.elementName.equalsIgnoreCase(s)) {
                    return node.parent.elementName;
                } else {
                    if (node.leftChild != null) queue.add(node.leftChild);
                    if (node.rightChild != null) queue.add(node.rightChild);
                }
            }
        }
        return null;

    }

    public boolean remove (Object o) {
        if (!(o instanceof String)) throw new UnsupportedOperationException();

        Queue<Entry> queue = new LinkedList<>();
        queue.add(root);
        String targetName = o.toString();

        while (!queue.isEmpty()) {
            Entry<String> node = queue.poll();
            if (node.elementName.equalsIgnoreCase(targetName)) {
                //check parent lfet child or right child equal target name
                Entry<String> parent = node.parent;
                //should check child if exist
                if (parent.leftChild != null && parent.leftChild.elementName.equalsIgnoreCase(targetName)) {
                    parent.leftChild = null;
                } else if (parent.rightChild != null && parent.rightChild.elementName.equalsIgnoreCase(targetName))
                    parent.rightChild = null;

                return true;
            } else {
                if (node.leftChild != null) queue.add(node.leftChild);
                if (node.rightChild != null) queue.add(node.rightChild);

            }
        }
        return false;
    }

    //check all node
    public void allNode() {
        Queue<Entry> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Entry node = queue.poll();
            System.out.println(node.elementName);
            if (node.leftChild != null)
                queue.add(node.leftChild);
            if (node.rightChild != null)
                queue.add(node.rightChild);
        }
    }



}
