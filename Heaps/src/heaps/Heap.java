/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heaps;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 *
 * @author Jacky Wang
 * Help from Sesh Venugopal https://www.youtube.com/watch?v=W81Qzuz4qH0
 */

//Extends comparable means it can compare to it's own type of object
public class Heap<T extends Comparable<T>> {
    
    private ArrayList<T> items;
    
    public Heap() {
        //initializes arraylist for the heap
        items = new ArrayList<T>();
    }
    
    //This function allows values to be sifted up the tree based on priority values, 
    //used whenever new elements are added
    private void moveUp() {
        int k = items.size() - 1;
        //This checks that you can only use it on an array with objects inside
        while (k > 0) {
            int p = (k-1)/2;
            //Compares a node and the parent node
            T item = items.get(k);
            T parent = items.get(p);
            //sifts up if and only if comparison returns positive value (higher priority)
            if(item.compareTo(parent) > 0) {
                //switches around the data of the node with the parent node by setting the values in place of each other
                items.set(k, parent);
                items.set(p, item);
                //element k moves up
                k = p;
            }
            //does not sift and function ends if comparison evaluates to false
            else {
                break;
            }
        }
    }
    
    //Function for adding to the heap (arraylist)
    public void insert(T item) {
        items.add(item);
        //New element added to the bottom of the arraylist, 
        //Then runs the "sift up" function to determine the place inside the heap
        //This is how new elements are sorted in the heap
        moveUp();
    }
    
    //Function for sift down when nodes are deleted as lowest value will replace deleted nodes
    private void moveDown() {
        int k = 0;
        //Compares values to children using formula for finding children on a 1D array
        int left = 2*k+1;
        //Only runs when left element is still within array bounds
        while (left < items.size()) {
            //max is used to check if
            //right is set to element after left, which is the right child of element "k"
            int max = 1, right = left+1;
            if (right < items.size()) {
                if(items.get(right).compareTo(items.get(left)) > 0) {
                    max++;
                }                
            }
            if (items.get(k).compareTo(items.get(max)) < 0 ) {
                //Stores k in a temporary variable before switching with compared max value
                T temp = items.get(k);
                items.set(k, items.get(max));
                items.set(max, temp);
                k = max;
                left = 2*k+1;
            }
            else {
                break;
            }
        }
    }
    
    //Method for removing and sorting nodes after removal
    public T delete()
            throws NoSuchElementException {
        if (items.size() == 0) {
            throw new NoSuchElementException();
        }
        if (items.size() == 1) {
            return items.remove(0);
        }
        T hold = items.get(0);
        items.set(0, items.remove(items.size()-1));
        moveDown();
        return hold;
    }
    
    public int size() {
        return items.size();
    }
    
    public boolean isEmpty() {
        return items.isEmpty();
    }
    
    public String toString() {
        return items.toString();
    }
    
}
