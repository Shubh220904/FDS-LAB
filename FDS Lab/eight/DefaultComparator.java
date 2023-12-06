import java.util.*;
/**
 * A generic comparator that uses the natural ordering of the keys.
 *
 * @param <K> the type of keys to be compared.
 */
class DefaultComparator<K> implements Comparator<K> {

    /**
     * Compares two keys using their natural ordering.
     *
     * @param a the first key.
     * @param b the second key.
     * @return a negative integer, zero, or a positive integer as the first key is less than, equal to,
     *         or greater than the second key.
     * @throws ClassCastException if the keys are not mutually comparable.
     */
    public int compare(K a, K b) throws ClassCastException {
        return ((Comparable<K>) a).compareTo(b); // cast a to Comparable
    }
}