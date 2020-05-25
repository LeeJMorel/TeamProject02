/*CS211 SPRING 2020, Created: 5/20/20, Lee Janzen, Harold Pham, Andy Zhong
This is the modified ArrayList for the purpose of this project. implements List<E> and extends AbstractList<E>.
Created for ch16, programming project 3.*/

import java.util.*;

public class ArrayList<E> extends AbstractList<E> implements List<E> 
{
    private E[] elementData; // list of values

    public static final int DEFAULT_CAPACITY = 100; //For the general purpose of our constructor.

    // pre : capacity >= 0 (throws IllegalArgumentException if not)
    // post: constructs an empty list with the given capacity
    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) 
    {
        if (capacity < 0) 
        {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        elementData = (E[]) new Object[capacity];
        this.size = 0;
    }

    // post: constructs an empty list of default capacity
    public ArrayList() 
    {
        this(DEFAULT_CAPACITY);
    }


    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: returns the value at the given index in the list
    public E get(int index) 
    {
        super.checkIndex(index);
        return elementData[index];
    }


    // post: appends the given value to the end of the list
    public void add(E value) 
    {
        ensureCapacity(this.size + 1);
        elementData[this.size] = value;
        increaseSize();
    }

    // pre : 0 <= index <= size() (throws IndexOutOfBoundsException if not)
    // post: inserts the given value at the given index, shifting subsequent values right
    public void add(int index, E value) 
    {
        if (index < 0 || index > this.size) 
        {
            throw new IndexOutOfBoundsException("index: " + index);
        }
        ensureCapacity(this.size + 1);
        for (int i = this.size; i >= index + 1; i--) 
        {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = value;
        increaseSize();
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: removes value at the given index, shifting subsequent values left
    public void remove(int index) 
    {
        super.checkIndex(index);
        for (int i = index; i < this.size - 1; i++) 
        {
            elementData[i] = elementData[i + 1];
        }
        elementData[size - 1] = null;
        decreaseSize();
    }

    // pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
    // post: replaces the value at the given index with the given value
    public void set(int index, E value) 
    {
        super.checkIndex(index);
        elementData[index] = value;
    }

    // post: list is empty
    public void clear() 
    {
        for (int i = 0; i < this.size; i++) 
        {
            elementData[i] = null;
        }
        this.size = 0;
    }

    // post: appends all values in the given list to the end of this list while retaining previous lists integrity.
    public void addAll(List<E> other) 
    {
        for (E value: other) 
        {
            add(value);
        }
    }

    // post: returns an iterator for this list
    public Iterator<E> iterator() 
    {
        return new ArrayListIterator();
    }

    // post: ensures that the underlying array has the given capacity; if not,
    // the size is doubled (or more if given capacity is even larger)
    public void ensureCapacity(int capacity) 
    {
        if (capacity > elementData.length) 
        {
            int newCapacity = elementData.length * 2 + 1;
            if (capacity > newCapacity) 
            {
                newCapacity = capacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }
    
    //Our Inner class which runs the ArrayLists iterator. Holds three methods.
    private class ArrayListIterator implements Iterator<E> 
    {
        private int position;           // current position within the list
        private boolean removeOK;       // whether it's okay to remove now

        // post: constructs an iterator for the given list
        public ArrayListIterator() 
        {
            position = 0;
            removeOK = false;
        }

        // post: returns true if there are more elements left, false otherwise
        public boolean hasNext() 
        {
            return position < size();
        }

        // pre : hasNext() (throws NoSuchElementException if not)
        // post: returns the next element in the iteration
        public E next() 
        {
            if (!hasNext()) 
            {
                throw new NoSuchElementException();
            }
            E result = elementData[position];
            position++;
            removeOK = true;
            return result;
        }

        // pre : next() has been called without a call on remove (throws
        //       IllegalStateException if not)
        // post: removes the last element returned by the iterator
        public void remove() 
        {
            if (!removeOK) 
            {
                throw new IllegalStateException();
            }
            ArrayList.this.remove(position - 1);
            position--;
            removeOK = false;
        }
    }
}
