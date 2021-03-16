/*
* Class name: LinkedListIterator
*
* Version info: jdk 1.8
*
* Copyright notice:
* 
* Author info: Arpit Garg
*
* Creation date: 16/Mar/2021
*
* Last updated By: Arpit Garg
*
* Last updated Date: 16/Mar/2021
*
* Description: Iterator class for Linked List
*/
package com.nagarro.implementlinkedlist.service;

import java.util.Iterator;

import com.nagarro.implementlinkedlist.exception.InvalidValuesException;
import com.nagarro.implementlinkedlist.model.Node;

public class LinkedListIterator implements Iterator {
    private static final String NO_SUCH_ELEMENT = "No such Element";
    Node currentNode = null;
    Node head = null;

    /**
     * @param head
     */
    public LinkedListIterator(Node head) {
        this.head = head;
    }

    /**
     * check for linked list has next element or not
     */
    @Override
    public boolean hasNext() {
        if (currentNode == null && head != null) {
            return true;
        } else if (currentNode != null) {
            return currentNode.getNext() != null;
        }
        return false;
    }

    @Override
    public Object next() {
        if (currentNode == null) {
            currentNode = head;
            return head.getValue();
        } else if (currentNode != null) {
            currentNode = currentNode.getNext();
            return currentNode.getValue();
        }
        throw new InvalidValuesException(NO_SUCH_ELEMENT);
    }

}
