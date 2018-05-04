import java.lang.reflect.Array;

public class HashTableLProbe3 <E> implements LUT<E> {

    /**
     * Implementation of an entry in the hash table array.
     *
     * The member class Entry encapsulates an entry of the LUT and
     * contains a {key, value} pair.
     */
    protected class Entry {

        public Entry(String k, E v) {
            key = k;
            value = v;
        }

        public Entry() {
            key = "";
            value = null;
        }

        protected String key;
        protected E value;
    }

    /**
     * The hash table is implemented by an array of entries.
     */
    protected Entry[] entries;

    /**
     * Compute a hash over a string and map it into a given range.
     */
    private int h1(String key, int M) {
        int n = 0;

        for (int i=0; i < key.length(); i++) {
            n += (int)key.charAt(i);
        }

        return n % M;
    }

    /**
     * Default constructor.
     */
    @SuppressWarnings("unchecked")
    public HashTableLProbe3() {
        // Necessary hack to create a generic array
        entries = (Entry[]) Array.newInstance(new Entry().getClass(), 50);
    }

    /**
     * Constructor for a given hash table size.
     */
    @SuppressWarnings("unchecked")
    public HashTableLProbe3(int size) {
        // Necessary hack to create a generic array
        entries = (Entry[]) Array.newInstance(new Entry().getClass(), size);
    }

    // Dedicated entry for a deleted entry.
    private Entry tombstone = new Entry("Tombstone", null);

    /**
     * Map a key to a value (insert into the hash table).
     */
    public void insert(String key, E value)
    throws LUTKeyException {
        // Compute the hash value
        int index = h1(key, entries.length);

        // Probe linearly to find empty slot.
        int count = 0;

        while (entries[index] != null
               && entries[index] != tombstone
               && count != entries.length) {
            index = (index+1) % entries.length;
            count += 1;
        }

        if (count == entries.length) {
            throw new LUTKeyException();
        } else {
            entries[index] = new Entry(key, value);
        }
    }

    /**
     * Find the value which is mapped to a key.
     */
    public E retrieve(String key)
    throws LUTKeyException {
        // Compute the hash value
        int index = h1(key, entries.length);

        // Probe linearly looking for match.
        int count = 0;

        while (entries[index] != null
               && !entries[index].key.equals(key)
               && count != entries.length) {
            index = (index+1) % entries.length;
            count += 1;
        }

        if (entries[index] == null || count == entries.length) {
            throw new LUTKeyException();
        } else {
            return entries[index].value;
        }
    }

    /**
     * Delete a mapping for a key.
     */
    public void remove(String key)
    throws LUTKeyException {
        // Compute the hash value
        int index = h1(key, entries.length);

        // Probe linearly looking for match.
        int count = 0;

        while (entries[index] != null
               && !entries[index].key.equals(key)
               && count != entries.length) {
            index = (index+1) % entries.length;
            count += 1;
        }

        if (entries[index] == null || count == entries.length) {
            throw new LUTKeyException();
        } else {
            // Better: check for end of chain
            if (entries[(index + 1) % entries.length] != null) {
                entries[index] = tombstone;
            } else {
                entries[index] = null;

                // Cleanup obsolete tombstones
                index = (index - 1) % entries.length;
                while (entries[index] == tombstone) {
                    entries[index] = null;
                    index = (index - 1) % entries.length;
                }
            }
        }
    }

    /**
     * Updates the key-value pair with the specified key with the new
     * specified value.
     */
    public void update(String key, E value)
    throws LUTKeyException {
        // Compute the hash value
        int index = h1(key, entries.length);

        // Probe linearly looking for match.
        int count = 0;

        while (entries[index] != null
               && !entries[index].key.equals(key)
               && count != entries.length) {
            index = (index+1) % entries.length;
            count += 1;
        }

        if (entries[index] == null || count == entries.length) {
            throw new LUTKeyException();
        } else {
            entries[index].value = value;
        }
    }

    /**
     * Return a textual representation of the hash table.
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < entries.length; ++i) {
            Entry e = entries[i];
            str += i + ": ";
            if (e != null) {
                str += e.key + " " + e.value + "\n";
            } else {
                str += null + "\n";
            }
        }
        return str;
    }
}
