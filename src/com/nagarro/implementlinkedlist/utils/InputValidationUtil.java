package com.nagarro.implementlinkedlist.utils;

import java.util.Scanner;

public class InputValidationUtil {

    private static final String WRONG_VALUE_RE_ENTER_VALUE = "Wrong value! Re-enter value ";
    private static final String INVALID_INPUT = "Invalid input !";
    private Scanner scan = new Scanner(System.in);

    public int inputValidation(String inputValue) {
        boolean flag = true;
        int value = 0;
        while (flag) {
            try {
                try {
                    value = Integer.parseInt(inputValue);
                } catch (Exception e) {
                    throw new IllegalStateException(INVALID_INPUT);
                }
                flag = false;
            } catch (IllegalStateException e) {
                System.out.println(WRONG_VALUE_RE_ENTER_VALUE);
                inputValue = scan.next();
                flag = true;
            }
        }
        return value;
    }

}
