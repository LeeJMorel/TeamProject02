/*CS211 SPRING 2020, Created: 5/20/20, Lee Janzen, Harold Pham, Andy Zhong
This is the common interface that the list classes implement.
Created for ch16, programming project 3.*/

public interface List<E> extends Iterable<E> {
    public int size(); //A list must show their size variable.
    public E get(int index); //A list must have an obtainability method.
    public int indexOf(E value); //A list must be able to identify its contents.
    public boolean isEmpty(); //A list must show whether it is empty or not.
    public boolean contains(E value); //A list must have an identifier method.
    public void add(E value); //A list must be able to append content.
    public void add(int index, E value); //A list must be able to append content to a given spot.
    public void addAll(List<E> other); //A list must be able to append another lists content to itself.
    public void remove(int index); //A list must be able to dispose content.
    public void set(int index, E value); //A list must be able to replace content.
    public void clear(); //A list must be able to clear all contents.
}
