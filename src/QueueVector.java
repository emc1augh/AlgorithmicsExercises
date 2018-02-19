import java.util.Vector;

/**
 * Implementation of Queue ADT.
 *
 * This class is an implementation of the Queue using a Vector as the
 * underlying data structure. The capacity is unlimited and therefore needn't be
 * specified in the constructor.
 */

public class QueueVector<E> implements Queue<E> {
    // Array containing the queue.
    private Vector myVector;

    // Index of tail of queue.
    private int queueTail;

    // Index of head of queue.
    private int queueHead;

    // Number of items in the queue.
    private int queueSize;

    /**
     * Constructs a Queue with specified maximum capacity.
     */
    public QueueVector() {
        myVector = new Vector();
        queueHead = 0;
        queueTail = 0;
        queueSize = 0;
    }

    /**
     * Adds a new item to the tail of the queue.
     */
    public void enQueue(E e) throws QueueException {
        myVector.add(e);
        queueSize += 1;
    }

    /**
     * Removes and returns the item at the head of the queue.
     */
    public E deQueue()
            throws QueueException {
        if (queueSize != 0) {
            queueSize -= 1;
            E oldQueueHead = (E) myVector.elementAt(0);
            queueHead = (queueHead + 1) % myVector.size();
            return oldQueueHead;
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
            return (E) myVector.elementAt(0);
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
