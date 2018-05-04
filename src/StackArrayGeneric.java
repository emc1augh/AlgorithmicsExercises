/**
 * Implementation of Stack ADT.
 *
 * This class is an implementation of the Stack using an Array as the
 * underlying data structure. The capacity is limited and therefore
 * must be specified in the constructor. Overflow can occur when the
 * array becomes full.
 */
public class StackArrayGeneric<E> implements StackGeneric<E> {
    // Array containing the stack.
    private E[] objectArray;

    // Variable keeping track of the number of items in the stack.
    private int stackSize;

    /**
     * Constructs a Stack with maximum capacity of 50 items.
     */
    @SuppressWarnings("unchecked")
    public StackArrayGeneric() {
        objectArray = (E[]) new Object[50];
        stackSize = 0;
    }

    /**
     * Constructs a Stack with specified maximum capacity.
     */
    @SuppressWarnings("unchecked")
    public StackArrayGeneric(int size) {
        objectArray = (E[]) new Object[size];
        stackSize = 0;
    }

    /**
     * Adds a new item to the top of the stack.
     */
    public void push(E e)
    throws StackException {
        if (stackSize < objectArray.length) {
            objectArray[stackSize] = e;
            stackSize += 1;
        } else {
            throw new StackException("Stack Overflow");
        }
    }

    /**
     * Removes and returns the item at the top of the stack.
     */
    public E pop()
    throws StackException {
        if (stackSize != 0) {
            stackSize -= 1;
            return objectArray[stackSize];
        } else {
            throw new StackException("Stack Underflow");
        }
    }

    /**
     * Returns the item at the top of the stack without removal.
     */
    public E top()
    throws StackException {
        if (stackSize != 0) {
            return objectArray[stackSize - 1];
        } else {
            throw new StackException("Stack Underflow");
        }
    }

    /**
     * Tests to see if the stack is empty.
     */
    public boolean empty() {
        return stackSize == 0;
    }

    /**
     * Removes all items from the stack.
     */
    public void clear() {
        stackSize = 0;
    }
}

