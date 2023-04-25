package com.glearning.dsa.client;

import com.glearning.dsa.balancedBrackets.balancedBrackets;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        while(flag){
            System.out.println("Enter the input or q to quit");
            String input = sc.next();
            if(input.equals("q")){
                flag = false;
                continue;
            }
            boolean result = balancedBrackets.isBalanced(input);
            if(result==true) {
                System.out.println("The entered string has Balanced Brackets");
            }else{
                System.out.println("The entered string do not contain Balanced Bracket");
            }
        }
        sc.close();
    }
}
