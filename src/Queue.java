public interface Queue<E> {
    /**
     * Adds a new item to the tail of the queue.
     */
    void enQueue(E e)
    throws QueueException;

    /**
     * Removes and returns the item at the head of the queue.
     */
    E deQueue()
    throws QueueException;

    /**
     * Returns the item at the head of the queue without removal.
     */
    E head()
    throws QueueException;

    /**
     * Tests to see if the queue is empty.
     */
    boolean empty();

    /**
     * Removes all items from the queue.
     */
    void clear();
}
