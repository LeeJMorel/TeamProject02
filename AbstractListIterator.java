/*CS211 SPRING 2020, Created: 5/20/20, Lee Janzen, Harold Pham
This is the abstract list class.
Created for ch16, programming project 3.*/

import java.util.*;
import java.io.*;

	public abstract class AbstractList<E> implements List<E> 
	{  
//Common Methods
	   public void add(int val)
	   {
		   add(size(),val);
	   }
	   
	   public boolean contains(int val)
	   {
		   return indexOf(val) >=0;
	   }
	   
	   public boolean isEmpty()
	   {
		   return size() == 0;
	   }
	   
//Abstract List Iterator class
	   private class AbstractListIterator implements Iterator<E>
	   {
			int position;           // current position within the list
			 boolean removeOK;       // whether it's okay to remove now
			  	        
			  public boolean hasNext()
			   {
				   return position < size();
			   }
			   
			  public void next()
			   {
				   position++;
				   return get(position-1);
			   }
			   
			   
			   public void remove()
			   {
				   
			   }
		}
	}

