/*CS211 SPRING 2020, Created: 5/20/20, Lee Janzen, Harold Pham
This is the abstract list class.
Created for ch16, programming project 3.*/
import java.util.*;
import java.io.*;

public abstract class AbstractList<E> implements List<E> {
   protected int size;        // current number of elements in the list
   
   //test 1
    // post: returns true if list is empty, false otherwise
    public boolean isEmpty() {
        return size == 0;
    }
    
    //test 2
    // post: returns the current number of elements in the list
    public int size() {
        return size;
    }
    
    // post: returns the current number of elements in the list + 1 increment
    public int increaseSize() {
        size++;
        return size;
    }
    
    // post: returns the current number of elements in the list - 1 increment
    public int decreaseSize() {
        size--;
        return size;
    }
    
    //test 3
    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(E value) {
        Iterator<E> i = this.iterator();
        int index = 0;
        
        while (i.hasNext()){
             if (i.next() == value){
                 return index;
             } else {
                 index++;
             }
         }
         return -1;
    }

   //test 4
    // post: returns true if the given value is contained in the list,
    //       false otherwise
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }
    
    //test 5
    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (size == 0) {
            return "[]";
        } else {
            Iterator<E> i = this.iterator();
            String result = "[" + i.next();
            while(i.hasNext()) {
                result += ", " + i.next();
            }
            result += "]";
            return result;
        }
    }
    
    //test6
    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: removes value at the given index, shifting subsequent values left
       public void remove(int index) 
    {
        checkIndex(index);
        int holder = 0;
        Iterator<E> i = this.iterator();
        
        while(holder != index && i.hasNext()) 
        {
             i.next();
             holder++;
        }
        i.remove();
        size--;
    }
    
    //test 7
    // post: list is empty
    public void clear() {
      Iterator<E> i = this.iterator();
        while (i.hasNext()) {
            i.remove();
        }
        size = 0;
    }
    
    
   // post: appends all values in the given list to the end of this list
    public void addAll(List<E> other) {
        for (E value: other) {
            add(value);
        }
    }
    
    
    // post: throws an IndexOutOfBoundsException if the given index is
    //       not a legal index of the current list
    protected void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }

   
}
