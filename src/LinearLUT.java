/**
 * Implementation of LUT using unordered linear search.
 *
 * This class is an implementation of the look-up table abstract data
 * type that uses a sequence array as the underlying data
 * structure. The capacity of the LUT is thus limited. The elements of
 * the look-up table are stored unordered and linear search is used
 * for retrieval.
 */
public class LinearLUT<E> implements LUT<E> {

    /**
     * The member class Key is used for the indexing keys of the LUT. It
     * is a String with basic comparative methods added.
     */
    protected class Key {

        private String kString;

        Key(String s) {
            kString = s;
        }

        boolean equals(Key k) {
            return kString.equals(k.toString());
        }

        boolean lessThan(Key k) {
            return kString.compareTo(k.toString()) < 0;
        }

        boolean greaterThan(Key k) {
            return kString.compareTo(k.toString()) > 0;
        }

        @Override
        public String toString() {
            return kString;
        }
    }

    /**
     * The member class Entry encapsulates an entry of the LUT and contains
     * a {key, value} pair.
     */
    protected class Entry {

        protected Key key;
        protected E value;

        Entry(Key k, E v) {
            key = k;
            value = v;
        }
    }

    // Single private data member - the LUT is stored in a sequence.
    protected Sequence<Entry> seq;

    /**
     * Default constructor creates a default size sequence to store the LUT.
     */
    public LinearLUT() {
        seq = new SequenceArray<Entry>();
    }

    /**
     * Constructs a look-up table of specified maximum capacity.
     */
    public LinearLUT(int size) {
        seq = new SequenceArray<Entry>(size);
    }

    @Override
    public void insert(String key, E value)
    throws LUTKeyException {
        // Just insert new entries at the easiest place - for the array
        // based sequence class, this is at the end of the sequence.
        Entry newEntry = new Entry(new Key(key), value);
        try {
            seq.insertLast(newEntry);
        } catch (SequenceException e) {
            throw new LUTKeyException("LUT overflow");
        }
    }

    @Override
    public void remove(String key)
    throws LUTKeyException {
        Key searchKey = new Key(key);
        int index = findPosition(searchKey);
        if (index >= 0) {
            try {
                seq.delete(index);
            } catch (SequenceException e) {
                throw new AssertionError("This should not happen." + e);
            }
        } else {
            throw new LUTKeyException();
        }
    }

    @Override
    public E retrieve(String key)
    throws LUTKeyException {
        Key searchKey = new Key(key);
        int index = findPosition(searchKey);
        if (index >= 0) {
            try {
                Entry searchEntry = seq.element(index);
                return searchEntry.value;
            } catch (SequenceException e) {
                throw new AssertionError("This should not happen." + e);
            }
        } else {
            throw new LUTKeyException("Key not found");
        }
    }

    @Override
    public void update(String key, E value)
    throws LUTKeyException {
        Key searchKey = new Key(key);
        int index = findPosition(searchKey);
        if (index >= 0) {
            try {
                Entry searchEntry = seq.element(index);
                searchEntry.value = value;
            } catch (SequenceException e) {
                throw new AssertionError("This should not happen." + e);
            }
        } else {
            throw new LUTKeyException("Key not found");
        }
    }

    @Override
    public String toString() {
        String output = "";
        for (int i = 0; i < seq.size(); i++) {
            try {
                Entry tableEntry = seq.element(i);
                output += tableEntry.key.toString() + ":" +
                          tableEntry.value.toString() + ", ";
            } catch (SequenceException e) {
                throw new AssertionError("This should not happen." + e);
            }
        }
        return output;
    }

    /**
     * Returns the index of the sequence holding the entry with the
     * specified key. If no match is found an index of -1 is returned.
     */
    protected int findPosition(Key k) {
        return linearSearch(k);
    }

    /**
     * Performs linear search on the sequence holding the LUT and returns
     * the index of the entry containing the specifed key. If no match is
     * found an index of -1 is returned.
     */
    protected int linearSearch(Key k) {
        for (int i = 0; i < seq.size(); i++) {
            if (k.equals(keyAt(i))) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the key at the specified position in the sequence.
     */
    protected Key keyAt(int index) {
        try {
            Entry entryAt = seq.element(index);
            return entryAt.key;
        } catch (SequenceException e) {
            throw new AssertionError("This should not happen." + e);
        }
    }
}
