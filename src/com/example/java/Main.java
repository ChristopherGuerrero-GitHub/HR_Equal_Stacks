package com.example.java;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        /*
            This program is a solution for HackerRank problem Equal Stacks.

            The first line contains three space-separated integers, n1, n2, and n3,
            describing the respective number of cylinders in stacks ,1 ,2 and 3.
            The subsequent lines describe the respective heights of each
            cylinder in a stack from top to bottom:

            The second line contains n1 space-separated integers describing the
                cylinder heights in stack 1.
            The third line contains n2 space-separated integers describing the
                cylinder heights in stack 2.
            The fourth line contains n3 space-separated integers describing the
                cylinder heights in stack 3.

            Print a single integer denoting the maximum height at which all stacks
            will be of equal height.

         */
/*
        Input:
        5 3 4
        3 2 1 1 1
        4 3 2
        1 1 4 1
                output : 5
*/

        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();

        //assign each element of the following three arrays h1,h2,h3 the input integer
        //to represent the the three cylinders
        int h1[] = new int[n1];
        for(int h1_i=0; h1_i < n1; h1_i++){
            h1[h1_i] = in.nextInt();
        }

        int h2[] = new int[n2];
        for(int h2_i=0; h2_i < n2; h2_i++){
            h2[h2_i] = in.nextInt();
        }

        int h3[] = new int[n3];
        for(int h3_i=0; h3_i < n3; h3_i++){
            h3[h3_i] = in.nextInt();
        }

        //Create three Stack objects stack1,stack2,stack3
        //define sum1,sum2,sum3
        Stack<Integer> stack1 = new Stack<>();
        int sum1 = 0;
        Stack<Integer> stack2 = new Stack<>();
        int sum2 = 0;
        Stack<Integer> stack3 = new Stack<>();
        int sum3 = 0;
        int temp;

        //Transfer the data elements in each of the three arrays into
        //the corresponding stack. ie. stack1 push h1 element, stack2 push h2 element...
        for(int i = n1 - 1; i >= 0; i--) {
            sum1 += h1[i];
            stack1.push(h1[i]);
        }

        for(int i = n2 - 1; i >= 0; i--) {
            sum2 += h2[i];
            stack2.push(h2[i]);
        }

        for(int i = n3 - 1; i >= 0; i--) {
            sum3 += h3[i];
            stack3.push(h3[i]);
        }

        //Go through the loop until you find the maximum height at which all stacks
        //are of equal height. Print the result of that maximum height integer value.
        while(sum1 != sum2 || sum2 != sum3) {
            temp = Math.max(sum1, Math.max(sum2, sum3));
            if(temp == sum1 && !stack1.isEmpty()) {
                sum1 -= stack1.pop();
            }
            if(temp == sum2 && !stack2.isEmpty()) {
                sum2 -= stack2.pop();
            }
            if(temp == sum3 && !stack3.isEmpty()) {
                sum3 -= stack3.pop();
            }
        }
        System.out.println(sum1);

    }
}
