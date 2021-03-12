/*
* Class name: LinkedList
*
* Version info: jdk 1.8
*
* Copyright notice:
* 
* Author info: Arpit Garg
*
* Creation date: 11/Mar/2021
*
* Last updated By: Arpit Garg
*
* Last updated Date: 11/Mar/2021
*
* Description: LinkedList class for creating and do operations
*/
package com.nagarro.implementlinkedlist.service;

import com.nagarro.implementlinkedlist.exception.InvalidValuesException;
import com.nagarro.implementlinkedlist.model.Node;

public class LinkedList {
    private static final String LIST_IS_EMPTY = "List is empty";
    private static final String NO_VALUE = "No Value";
    private static final String WRONG_INDEX_ENTERED = "Wrong Index Entered";
    private Node head;
    private Node tail;
    private int size = 0;

    /**
     * Add value at the first of linked list
     * 
     * @param value
     */
    public void addFirst(int value) {
        Node node = new Node();
        node.setValue(value);
        node.setNode(null);
        if (size == 0)
            head = tail = node;
        else {
            node.setNode(head);
            head = node;
        }
        size++;
    }

    /**
     * Add value at the Last of linked list
     * 
     * @param value
     */
    public void addLast(int value) {
        Node node = new Node();
        node.setValue(value);
        node.setNode(null);
        if (size == 0) {
            head = tail = node;
        } else {
            tail.setNode(node);
            tail = node;
        }
        size++;
    }

    /**
     * Add value at the given position of linked list
     * 
     * @param index
     * @param value
     */
    public void addPosition(int index, int value) {
        if (index < 0 || index > size)
            new InvalidValuesException(WRONG_INDEX_ENTERED);
        else if (index == 0) {
            addFirst(value);
        } else if (index == size) {
            addLast(value);
        } else {
            Node node = new Node();
            node.setValue(value);
            node.setNode(null);
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            }
            node.setNode(temp.getNext());
            temp.setNode(node);
            size++;
        }
    }

    /**
     * Remove First value from LinkedList
     */
    public void removeFirst() {
        if (size == 0)
            new InvalidValuesException(NO_VALUE);
        else if (size == 1) {
            head = tail = null;
            size--;
        } else {
            Node temp = head;
            head = temp.getNext();
            size--;
        }
    }

    /**
     * Remove Last value from LinkedList
     */
    public void removeLast() {
        if (size == 0)
            new InvalidValuesException(LIST_IS_EMPTY);
        else if (size == 1) {
            head = tail = null;
            size = 0;
        } else {
            Node temp = head;
            for (int i = 0; i < size - 2; i++) {
                temp = temp.getNext();
            }
            tail = temp;
            temp.setNode(null);
            size--;
        }
    }

    /**
     * Remove value on the given position from LinkedList
     * 
     * @param index
     */
    public void removeAtPostion(int index) {
        if (index < 0 || index > size)
            System.out.println(WRONG_INDEX_ENTERED);
        else if (index == 0)
            removeFirst();
        else if (index == size - 1)
            removeLast();
        else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            }
            temp.setNode(temp.getNext().getNext());
            size--;
        }
    }

    /**
     * Find the value on given Index
     * 
     * @param index
     * @return value on index
     */
    private int getAt(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp.getValue();
    }

    /**
     * Calculate the center of LinkedList
     * 
     * @return center of LinkedList
     */
    public int center() {
        if (size % 2 != 0) {
            return getAt(size % 2 + 1);
        } else {
            return getAt(size / 2);
        }
    }

    /**
     * @param index
     * @return Node on the given index
     */
    private Node getNode(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

    /**
     * Reverse the LinkedList
     */
    public void reverse() {
        int left = 0;
        int right = size - 1;
        while (left < right) {
            Node leftNode = getNode(left);
            Node rightNode = getNode(right);
            int temp = leftNode.getValue();
            leftNode.setValue(rightNode.getValue());
            rightNode.setValue(temp);
            left++;
            right--;
        }
    }

    /**
     * @return size of LinkedList
     */
    public int size() {
        return size;
    }

    /**
     * @return LinkedList in the String form
     */
    public String toString() {
        String output = "";
        Node temp = head;
        while (temp != null) {
            output += " " + temp.getValue();
            temp = temp.getNext();
        }
        return "[" + output + " ]";
    }

    /**
     * Traverse the LinkedList
     */
    public void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getValue() + " ");
            temp = temp.getNext();
        }
    }
}
