package ExerciseCode2;

import ExerciseCode1.Queue;
import ExerciseCode1.QueueException;

/**
 * Implementation of Queue ADT using a linked list.
 *
 * This class is an implementation of the Queue using an linked list
 * as the underlying data structure. The capacity is therefore
 * unlimited and overflow does not need to be checked.
 */

public class QueueList<E> implements Queue<E> {
    // We use object references to the head and tail of the list (the head
    // and tail of the queue, respectively).
    private Node listHead;
    private Node listTail;

    /**
     * Constructs an empty queue object.
     */
    public QueueList() {
        listHead = null;
        listTail = null;
    }

    // Only require a single constructor, which sets both object
    // references to null.

    @Override
    public void enQueue(E e) {
        // There is a special case when the queue is empty.
        // Then the both the head and tail pointers needs to be
        // initialised to reference the new node.
        if (listHead == null) {
            listHead = new Node(e);
            listTail = listHead;
        }

        // In the general case, we simply add a new node to the end
        // of the list via the tail pointer.
        else {
            listTail.next = new Node(e, listTail.next);
            listTail = listTail.next;
        }
    }

    @Override
    public E deQueue()
    throws QueueException {
        // Check there is something in the queue to return.
        if (listHead == null) {
            throw new QueueException("Queue Underflow");
        }

        // There is a special case when there if just one item in the
        // queue. Both pointers then need to be reset to null after
        // the dequeue.
        if (listHead.next == null) {
            E head = listHead.datum;
            listHead = null;
            listTail = null;
            return head;
        }

        // In the general case, we just unlink the first node of the
        // list and return the object inside.
        else {
            E head = listHead.datum;
            listHead = listHead.next;
            return head;
        }
    }

    @Override
    public E head()
    throws QueueException {
        if (listHead != null) {
            return listHead.datum;
        } else {
            throw new QueueException("Queue Underflow");
        }
    }

    @Override
    public boolean empty() {
        return listHead == null;
    }

    @Override
    public void clear() {
        listHead = null;
        listTail = null;
    }

    /**
     * Member class Node encapsulates the nodes of the linked list in
     * which the queue is stored. Each node contains a data item and a
     * reference to another node - the next in the linked list.
     */
    protected class Node {

        E datum;
        Node next;

        // The Node data structure consists of two object references.
        // One for the datum contained in the node and the other for
        // the next node in the list.

        Node(E e) {
            this(e, null);
        }

        Node(E e, Node n) {
            datum = e;
            next = n;
        }
    }
}
