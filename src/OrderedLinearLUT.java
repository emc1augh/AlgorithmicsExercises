/**
 * Implementation of LUT using ordered linear search.
 *
 * This class is an implementation of the look-up table abstract data
 * type that uses a sequence array as the underlying data
 * structure. The capacity of the LUT is thus limited. The elements of
 * the look-up table are stored in reverse alphabetical order and
 * linear search is used for retrieval.
 */
public class OrderedLinearLUT<E> extends LinearLUT<E> {

    /**
     * Default constructor creates a default size sequence to store the LUT.
     */
    public OrderedLinearLUT() {
        super();
    }

    /**
     * Constructs a look-up table of specified maximum capacity.
     */
    public OrderedLinearLUT(int size) {
        super(size);
    }

    @Override
    public void insert(String key, E value)
    throws LUTKeyException {
        // insert method overridden to put the entries in the sequence
        // ordered by the key value.
        Entry newEntry = new Entry(new Key(key), value);
        int index = 0;
        while (index < seq.size()
               && newEntry.key.greaterThan(keyAt(index))) {
            index += 1;
        }

        try {
            seq.insert(newEntry, index);
        } catch (SequenceException e) {
            throw new LUTKeyException("LUT overflow");
        }
    }

    @Override
    protected int linearSearch(Key k) {
        // Override the linear search method to exploit the ordering of
        // the entries in the sequence. We can detect failed searches
        // before reaching the end of the table.
        int i = 0;
        while (i < seq.size() && k.greaterThan(keyAt(i))) {
            i += 1;
        }

        // The index found is either greater than or equal to k
        if (i < seq.size() && k.equals(keyAt(i))) {
            return i;
        }

        // If it is not equal, the search has failed.
        return -1;
    }
}
