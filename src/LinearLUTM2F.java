
public class LinearLUTM2F<E> implements LUT<E> {

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

    public LinearLUTM2F() {
        seq = new SequenceList<Entry>();
    }

    @Override
    public void insert(String key, E value)
    throws LUTKeyException {
        // Just insert new entries at the easiest place - for the array
        // based sequence class, this is at the end of the sequence.
        Entry newEntry = new Entry(new Key(key), value);
        try {
            seq.insertFirst(newEntry);
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
                remove(key);
                insert(key,searchEntry.value);
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
            remove(key);
            insert(key, value);
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

    protected int findPosition(Key k) {
        return linearSearch(k);
    }

    protected int linearSearch(Key k) {
        for (int i = 0; i < seq.size(); i++) {
            if (k.equals(keyAt(i))) {
                return i;
            }
        }
        return -1;
    }

    protected Key keyAt(int index) {
        try {
            Entry entryAt = seq.element(index);
            return entryAt.key;
        } catch (SequenceException e) {
            throw new AssertionError("This should not happen." + e);
        }
    }
}
