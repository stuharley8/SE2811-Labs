package main;

import java.util.Iterator;

/**
 * A simple array iterator that will cycle back to the beginning of the array that it is
 * iterating over once it runs out of elements.
 *
 * @param <T>
 */
public class CircularArrayIterator<T> implements Iterator<T> {

    private int currentIndex;
    private T[] elements;

    public CircularArrayIterator(T[] objects) {
        this.elements = objects;
        this.currentIndex = -1;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return true;
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     */
    @Override
    public T next() {
        currentIndex = (currentIndex + 1) % elements.length;
        return elements[currentIndex];
    }

}
