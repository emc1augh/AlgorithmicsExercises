/**
 * Implementation of Stack ADT.
 *
 * This class is an implementation of the Stack using an linked list
 * as the underlying data structure. The capacity is therefore
 * unlimited and overflow does not need to be checked.
 */

public class StackList<E> implements StackGeneric<E> {
    /**
     * Member class Node encapsulates the nodes of the linked list in
     * which the stack is stored. Each node contains a data item and a
     * reference to another node - the next in the linked list.
     */
    protected class Node {

        public Node(E e) {
            this(e, null);
        }

        public Node(E e, Node n) {
            datum = e;
            next = n;
        }

        // The Node data structure consists of two object references.
        // One for the datum contained in the node and the other for
        // the next node in the list.
        protected E datum;
        protected Node next;
    }

    // The only private data members required is a pointer to the head of
    // the linked list (the top of the stack).
    private Node listHead;

    // Only require a single constructor, which sets the listHead object
    // reference to null.
    /**
     * Constructs an empty stack object.
     */
    public StackList() {
        listHead = null;
    }

    /**
     * Adds a new item to the top of the stack.
     */
    public void push(E e) {
        listHead = new Node(e, listHead);
    }

    /**
     * Removes and returns the item at the top of the stack.
     */
    public E pop()
    throws StackException {
        if (listHead != null) {
            E top = listHead.datum;
            listHead = listHead.next;
            return top;
        } else {
            throw new StackException("Stack Underflow");
        }
    }

    /**
     * Returns the item at the top of the stack without removal.
     */
    public E top()
    throws StackException {
        if (listHead != null) {
            return listHead.datum;
        } else {
            throw new StackException("Stack Underflow");
        }
    }

    /**
     * Tests to see if the stack is empty.
     */
    public boolean empty() {
        return listHead == null;
    }

    /**
     * Removes all items from the stack.
     */
    public void clear() {
        listHead = null;
    }
}
