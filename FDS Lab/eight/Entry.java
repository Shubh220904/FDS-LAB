/**
 * A class to represent an entry in the priority queue.
 *
 * @param <K> the type of the key.
 * @param <V> the type of the value.
 */
class Entry<K, V> {

    private K key; // the key of the entry
    private V value; // the value of the entry

    /**
     * Constructs a new entry with the given key and value.
     *
     * @param key   the key of the entry.
     * @param value the value of the entry.
     */
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Gets the key of the entry.
     *
     * @return the key of the entry.
     */
    public K getKey() {
        return key;
    }

    /**
     * Gets the value of the entry.
     *
     * @return the value of the entry.
     */
    public V getValue() {
        return value;
    }

    /**
     * Sets the key of the entry.
     *
     * @param key the new key of the entry.
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * Sets the value of the entry.
     *
     * @param value the new value of the entry.
     */
    public void setValue(V value) {
        this.value = value;
    }
}
