/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * 
 * @author Gaurav
 */
import java.util.*;
import java.lang.*;
import java.io.*;

class OneAbsoluteDifference {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int no = sc.nextInt();
		
		while(no > 0) {
		    
		    long num = sc.nextLong();
		    
		    Queue<Long> element = new LinkedList<>();
		    
		    for (long i = 1; i < 10; i++) {         // one digit number for formation of two digit numbers
		        element.add(i);
		    }
		    
		    boolean found = false;                 // if found remained false we will print -1;
		    
		    long curr_element = element.peek();    // peek over the element in the queue
		    
		    while(curr_element < num) {            // if curr_element is less than given number, we can find next higher digit number.
		        
		        long rem = curr_element % 10;      // finding remainder
		        
		        long temp;
		        
		        if (rem > 0) {                     // not taking numbers ending with zero
		            temp = curr_element*10 + (rem - 1);
		            if (temp <= num) {
    		            element.add(temp);
    		            found = true;
    		            System.out.print(temp + " ");
		            }
		        }
		        
		        if (rem != 9) {                    // for numbing ending with 9
		            temp = curr_element*10 + (rem + 1);
		            if (temp <= num) {
    		            element.add(temp);
    		            found = true;
    		            System.out.print(temp + " ");
		            }
		        }
		        element.poll();
		        if (element.peek() == null) break;
		        curr_element = element.peek();
		    }
		    System.out.println(found ? "" : "-1");
		    
		    no--;
		}
	}
}
