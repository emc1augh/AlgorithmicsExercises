public interface StackGeneric<E> {
    /**
     * Adds a new item to the top of the stack.
     */
    void push(E e)
    throws StackException;

    /**
     * Removes and returns the item at the top of the stack.
     */
    E pop()
    throws StackException;

    /**
     * Returns the item at the top of the stack without removal.
     */
    E top()
    throws StackException;

    /**
     * Tests to see if the stack is empty.
     */
    boolean empty();

    /**
     * Removes all items from the stack.
     */
    void clear();
}

