/*CS211 SPRING 2020, Created: 5/20/20, Lee Janzen, Harold Pham
This is the abstract list class.
Created for ch16, programming project 3.*/
import java.util.*;
import java.io.*;

public abstract class AbstractList<E> implements List<E> {
   private int size;        // current number of elements in the list

    // post: returns true if the given value is contained in the list,
    //       false otherwise
    public boolean contains(E value) {
        return indexOf(value) >= 0;
    }

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
    
    // post: returns true if list is empty, false otherwise
    public boolean isEmpty() {
        return size == 0;
    }
    
    // post: returns the current number of elements in the list
    public int size() {
        return size;
    }
    
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
    
    // post: throws an IndexOutOfBoundsException if the given index is
    //       not a legal index of the current list
    private void checkIndex(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index: " + index);
        }
    }
    
    // post: list is empty
    public void clear() {
      Iterator<E> i = this.iterator();
        while (i.hasNext()) {
            i.remove()
        }
        size = 0;
    }
    
    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: removes value at the given index, shifting subsequent values left
    public void remove(int index) {
        checkIndex(index);
        find the thing at the index and remove it
        size--;
    }
    
        // post: appends all values in the given list to the end of this list
    public void addAll(List<E> other) {
        for (E value: other) {
            add(value);
        }
    }

    
    private abstract class AbstractListIterator<E> implements Iterator<E> {
    }
}
