/**
 * Implementation of Queue ADT.
 *
 * This class is an implementation of the Queue using an Array as the
 * underlying data structure. The capacity is limited and therefore must be
 * specified in the constructor. Overflow can occur when the array becomes
 * full.
 */

public class QueueArray<E> implements Queue<E> {
    // Array containing the queue.
    private E[] objectArray;

    // Index of tail of queue.
    private int queueTail;

    // Index of head of queue.
    private int queueHead;

    // Number of items in the queue.
    private int queueSize;

    /**
     * Constructs a Queue with maximum capacity of 50 items.
     */
    public QueueArray() {
        @SuppressWarnings("unchecked")
        E[] o = (E[]) new Object[50];
        objectArray = o;
        queueHead = 0;
        queueTail = 0;
        queueSize = 0;
    }

    /**
     * Constructs a Queue with specified maximum capacity.
     */
    public QueueArray(int size) {
        @SuppressWarnings("unchecked")
        E[] o = (E[]) new Object[50];
        objectArray = o;
        queueHead = 0;
        queueTail = 0;
        queueSize = 0;
    }

    /**
     * Adds a new item to the tail of the queue.
     */
    public void enQueue(E e)
    throws QueueException {
        if (queueSize < objectArray.length) {
            objectArray[queueTail] = e;
            queueTail = (queueTail + 1) % objectArray.length;
            queueSize += 1;
        } else {
            throw new QueueException("Queue Overflow");
        }
    }

    /**
     * Removes and returns the item at the head of the queue.
     */
    public E deQueue()
    throws QueueException {
        if (queueSize != 0) {
            queueSize -= 1;
            int oldQueueHead = queueHead;
            queueHead = (queueHead + 1) % objectArray.length;
            return objectArray[oldQueueHead];
        } else {
            throw new QueueException("Queue Underflow");
        }
    }

    /**
     * Returns the item at the head of the queue without removal.
     */
    public E head()
    throws QueueException {
        if (queueSize != 0) {
            return objectArray[queueHead];
        } else {
            throw new QueueException("Queue Underflow");
        }
    }

    /**
     * Tests to see if the queue is empty.
     */
    public boolean empty() {
        return queueSize == 0;
    }

    /**
     * Removes all items from the queue.
     */
    public void clear() {
        queueTail = 0;
        queueHead = 0;
        queueSize = 0;
    }
}
