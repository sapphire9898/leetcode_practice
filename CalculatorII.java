package com.example.java;


import java.util.Stack;

/**
 * Created by yueyangzou on 16/10/10.
 */
// This is the text editor interface.
// Anything you type or change here will be seen by the other person in real time.
public class Calculator {
    public int compute(String str) {
        if (str == null || str.length() == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();

        boolean mulprev = false;
        boolean divprev = false;
        int sign = 1;

        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                int curr = str.charAt(i) - '0';// if there are spaces use while.
                if (mulprev) {
                    int first = stack.pop();
                    stack.push(first * curr);
                    mulprev = false;
                }
                else if (divprev) {
                    int first = stack.pop();
                    stack.push(first / curr);
                    divprev = false;
                }
                else {
                    stack.push(sign * curr);
                }
            }
            else if (str.charAt(i) == '+') {
                sign = 1;
            }
            else if (str.charAt(i) == '-') {
                sign = -1;
            }
            else if (str.charAt(i) == '*') {
                sign = 1;
                mulprev = true;
            }
            else if (str.charAt(i) == '/') {
                sign = 1;
                divprev = true;
            }
        }

        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }



    public static void main(String[] args) {
        Calculator calculator =  new Calculator();
        System.out.println(calculator.compute("1+2*4"));
    }

}


