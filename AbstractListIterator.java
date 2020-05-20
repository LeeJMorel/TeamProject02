/*CS211 SPRING 2020, Created: 5/20/20, Lee Janzen, Harold Pham
This is the abstract list class.
Created for ch16, programming project 3.*/
import java.util.*;

public interface AbstractListIterator<E> extends Iterator<E> {
  private int position;           // current position within the list
  private boolean removeOK;       // whether it's okay to remove now
  
   // post: constructs an iterator for the given list
   public AbstractListIterator() {
      position = 0;
      removeOK = false;
   }
        
   boolean hasNext(){
   }
   
   E next(){
   }
   
   void remove(){
   }
}
