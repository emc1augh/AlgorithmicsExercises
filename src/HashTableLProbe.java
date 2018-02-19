import java.lang.reflect.Array;

public class HashTableLProbe <E> implements LUT<E> {

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
    public HashTableLProbe() {
        // Necessary hack to create a generic array
        entries = (Entry[]) Array.newInstance(new Entry().getClass(), 50);
    }

    /**
     * Constructor for a given hash table size.
     */
    @SuppressWarnings("unchecked")
    public HashTableLProbe(int size) {
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
            entries[index] = tombstone;
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

    /**
     * Delete a mapping for a key without creating a tombstone.
     */
    @SuppressWarnings("unchecked")
    public void delete(String key)
    throws LUTKeyException {
        // Like remove, except that the entry is not replaced by a tombstone.
        // Instead, the entry will be deleted (set to null).
        // This requires a cleanup and rehashing all succeeding entries.

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
            entries[index] = null;

            for(int i = index+1; i < entries.length; i++){
                if(i + 1  == entries.length || entries[i] == null){
                    break;
                } else {
                    if(entries[i] != null) {
                        String tempKey = entries[i].key;
                        E tempValue = entries[i].value;

                        entries[i]=null;

                        insert(tempKey, tempValue);
                    }
                }
            }
        }
    }


    /**
     * Resize the current hash table to a different size.
     *
     * Resizing can be done to enlarge or to shrink the hash table. If
     * the resized hash table cannot hold all elements of the previous
     * one, an exception will be thrown.
     */
    @SuppressWarnings("unchecked")
    public void resize(int m)
    throws LUTKeyException {

        HashTableLProbe newList = new HashTableLProbe(m);

        for (Entry entry : entries) {
            if (entry != null) {
                newList.insert(entry.key, entry.value);
            }
        }
        entries = newList.entries;
    }

}
