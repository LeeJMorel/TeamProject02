/*CS211 SPRING 2020, Created: 5/20/20, Lee Janzen, Harold Pham
This is the abstract list class.
Created for ch16, programming project 3.*/
import java.util.*;
import java.io.*;

public abstract class AbstractList<E> implements List<E> {

    

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
    
    private abstract class AbstractListIterator<E> implements Iterator<E> {
    }
}
