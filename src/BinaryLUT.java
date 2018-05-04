/**
 * Implementation of LUT using binary search.
 *
 * This class is an implementation of the look-up table abstract data type
 * that uses a sequence array as the underlying data structure. The capacity
 * of the LUT is thus limited. The elements of the look-up table are stored
 * in reverse alphabetical order and binary search is used for retrieval.
 */
public class BinaryLUT<E> extends OrderedLinearLUT<E> {

    /**
     * Default constructor creates a default size sequence to store the LUT.
     */
    public BinaryLUT() {
        super();
    }

    /**
     * Constructs a look-up table of specified maximum capacity.
     */
    public BinaryLUT(int size) {
        super(size);
    }

    /**
     * Returns the index of the sequence holding the entry with the
     * specified key. If no match is found an index of -1 is returned.
     */
    protected int findPosition(Key k) {
        // Override findPosition method to call a binary search method
        // rather than linear search.
        return binarySearch(k, 0, seq.size());
    }

    /**
     * Performs recursive binary search on the sequence holding the LUT and
     * returns the index of the entry containing the specifed key. If no
     * match is found an index of -1 is returned.
     */
    private int binarySearch(Key k, int bottom, int top) {
        // If the range is reduced to zero, the search has failed.
        if (bottom == top) {
            return -1;
        }

        // If the middle key corresponds to the search key, the
        // search has succeeded. Otherwise, search bottom half if the
        // search key is less, top half if not.
        int middle = (bottom + top) / 2;
        Key lutKey = keyAt(middle);
        if (k.equals(lutKey)) {
            return middle;
        } else if (k.greaterThan(lutKey)) {
            return binarySearch(k, middle + 1, top);
        } else {
            return binarySearch(k, bottom, middle);
        }
    }
}
