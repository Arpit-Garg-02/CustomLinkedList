/*
* Class name: Main
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
* Description: Main class of Linked List
*/
package com.nagarro.implementlinkedlist.main;

import java.util.Scanner;

import com.nagarro.implementlinkedlist.exception.InvalidValuesException;
import com.nagarro.implementlinkedlist.service.LinkedList;

public class Main {
    private static final String WELCOME = "Welcome!....";
    private static final String WRONG_CHOICE = "Wrong Choice!";
    private static final String ENTER_POSITION = "Enter position";
    private static final String ENTER_ELEMENT_TO_BE_ADDED = "Enter Element to be added";
    private static final String PRESS_Y_FOR_CONTINUE = "Press 'y' for continue...";
    private static final String ENTER_YOUR_CHOICE = "Enter Your Choice...";
    private static final String _11_TRAVERSE = "11- Traverse";
    private static final String _10_ITERATOR = "10- Iterator";
    private static final String _9_SIZE = "9- Size";
    private static final String _8_REVERSE = "8- Reverse";
    private static final String _7_CENTER = "7- Center";
    private static final String _6_REMOVE_AT_SOME_POSITION = "6- Remove at Some position";
    private static final String _5_REMOVE_AT_LAST_POSITION = "5- Remove at Last position";
    private static final String _4_REMOVE_AT_FIRST_POSITION = "4- Remove at First position";
    private static final String _3_INSERT_AT_SOME_POSITION = "3- Insert at Some position";
    private static final String _2_INSERT_AT_LAST_POSITION = "2- Insert at Last position";
    private static final String _1_INSERT_AT_FIRST_POSITION = "1- Insert at First position";
    private static final String SELECT_OPERATION_TO_BE_PERFORM = "Select Operation to be perform...";
    static Scanner scan = new Scanner(System.in);

    /**
     * @param args
     */
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        char ch;
        System.out.println(WELCOME);

        do {
            System.out.println(SELECT_OPERATION_TO_BE_PERFORM);
            System.out.println(_1_INSERT_AT_FIRST_POSITION);
            System.out.println(_2_INSERT_AT_LAST_POSITION);
            System.out.println(_3_INSERT_AT_SOME_POSITION);
            System.out.println(_4_REMOVE_AT_FIRST_POSITION);
            System.out.println(_5_REMOVE_AT_LAST_POSITION);
            System.out.println(_6_REMOVE_AT_SOME_POSITION);
            System.out.println(_7_CENTER);
            System.out.println(_8_REVERSE);
            System.out.println(_9_SIZE);
            System.out.println(_10_ITERATOR);
            System.out.println(_11_TRAVERSE);
            System.out.println(ENTER_YOUR_CHOICE);
            int choice = scan.nextInt();
            choiceAction(choice, linkedList);
            System.out.println(PRESS_Y_FOR_CONTINUE);
            ch = scan.next().charAt(0);
        } while (ch == 'y');
        scan.close();
    }

    /**
     * provide different operations for user
     * 
     * @param choice
     * @param linkedList
     */
    private static void choiceAction(int choice, LinkedList linkedList) {
        switch (choice) {
        case 1:
            System.out.println(ENTER_ELEMENT_TO_BE_ADDED);
            int firstValue = scan.nextInt();
            linkedList.addFirst(firstValue);
            break;

        case 2:
            System.out.println(ENTER_ELEMENT_TO_BE_ADDED);
            int lastValue = scan.nextInt();
            linkedList.addLast(lastValue);
            break;

        case 3:
            System.out.println(ENTER_POSITION);
            int position = scan.nextInt();
            System.out.println(ENTER_ELEMENT_TO_BE_ADDED);
            int positionValue = scan.nextInt();
            linkedList.addPosition(position, positionValue);
            break;

        case 4:
            linkedList.removeFirst();
            break;

        case 5:
            linkedList.removeLast();
            break;

        case 6:
            System.out.println(ENTER_POSITION);
            int removePosition = scan.nextInt();
            linkedList.removeAtPostion(removePosition);
            break;

        case 7:
            System.out.println(linkedList.center());
            break;

        case 8:
            linkedList.reverse();
            break;

        case 9:
            System.out.println(linkedList.size());
            break;

        case 10:
            System.out.println(linkedList.toString());
            break;

        case 11:
            linkedList.traverse();
            break;

        default:
            new InvalidValuesException(WRONG_CHOICE);
        }
    }
}
