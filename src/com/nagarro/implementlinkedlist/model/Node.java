/*
* Class name: Node
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
* Description: Model class of Linked List i.e. Node, Information is saved in form of Node
*/
package com.nagarro.implementlinkedlist.model;

public class Node {
    private int value;
    private Node next;

    /**
     * @param nextNode
     */
    public void setNode(Node nextNode) {
        this.next = nextNode;
    }

    /**
     * @return
     */
    public Node getNext() {
        return next;
    }

    /**
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * @return
     */
    public int getValue() {
        return this.value;
    }
}
