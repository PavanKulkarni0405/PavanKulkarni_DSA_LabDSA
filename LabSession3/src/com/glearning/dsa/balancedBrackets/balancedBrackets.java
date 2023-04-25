package com.glearning.dsa.balancedBrackets;

import java.util.Stack;

public class balancedBrackets {

    public static  boolean isBalanced(String input){
        //create a stack data structure of character
        Stack<Character> stack = new Stack<>();
       // char [] ch= input.toCharArray();

        //iterate through the  elements of input
        for(int index = 0; index < input.length(); index++){
            char ch  = input.charAt(index);
            if(ch == '(' || ch =='{'||ch=='['){
            stack.push(ch);
            } else if(ch == ')' || ch == '}' || ch == ']') {
                if (stack.empty()) {
                    return false;
                }
                char top = stack.pop();
                if(ch == ')' && top !='(' ||
                        ch == '}' && top !='{' ||
                        ch == ']' && top !='['){
                    return false;
            }
                //stack.pop();

            }

        }
        return stack.empty();

    }
}
