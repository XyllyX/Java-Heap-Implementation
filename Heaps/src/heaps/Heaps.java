/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heaps;

import java.util.Scanner;

/**
 *
 * @author Jacky Wang
 * Help from Sesh Venugopal https://www.youtube.com/watch?v=W81Qzuz4qH0
 */
public class Heaps {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Initialize heap object
    Heap<Integer> hp = new Heap<Integer>();
        //Scanner for user input
        Scanner sc = new Scanner(System.in);
        //Instructions message for console
        System.out.print("Enter next int to sort, type 'done' and press return to stop: ");
        String line = sc.next();
        //checks if user is done entering integers, each integer entered is instantly sorted into the heap
        while (!line.equals("done")) {
            hp.insert(Integer.parseInt(line));
            System.out.println(hp);
            System.out.print("Enter next int to sort, type 'done' and press return to stop: ");
            line = sc.next();
        }
         //Deletes until heap is empty, displaying deleted integer
        while (!hp.isEmpty()) {
            int max = hp.delete();
            System.out.println(max + " " + hp);
        }    
        
    }
    
}
