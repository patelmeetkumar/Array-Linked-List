/** 
 * An interface that describes the operations of a bag of objects. 
 */

public interface BookInterface<T> 
{

	/**
	 * Gets the current number of entries(books) in this bag.
	 * 
	 * @return The integer number of entries(books) currently in the bag.
	 */
	public int getCurrentSize();

	/**
	 * Sees whether this bag is empty - if there's any book inside or not.
	 * 
	 * @return True if the bag is empty of books, or false if not.
	 */
	public boolean isEmpty();

	/**
	 * Adds a new entry(book) to this bag.
	 * 
	 * @param newEntry The object(book) to be added as a new entry.
	 * @return True if the addition of book is successful, or false if not.
	 */
	public boolean add(T newEntry);

	/**
	 * Removes one unspecified entry(book) from this bag, if possible.
	 * 
	 * @return Either the removed entry(book), if the removal was successful, or null.
	 */
	public T remove();

	/**
	 * Removes one occurrence of a given entry(book) from this bag, if possible.
	 * 
	 * @param anEntry The entry(book) to be removed.
	 * @return True if the removal of a particular book was successful, or false if not.
	 */
//	public boolean remove(T anEntry);

	/** 
	 * Removes all entries(books) from this bag. 
	 */
	public void clear();

	/**
	 * Counts the number of times a given entry(book) appears in this bag.
	 * 
	 * @param anEntry The entry(book) to be counted.
	 * @return The number of times anEntry(book) appears in the bag.
	 */
	public int getFrequencyOf(T anEntry);

	/**
	 * Tests whether this bag contains a given entry(book).
	 * 
	 * @param anEntry The entry(book) to find.
	 * @return True if the bag contains anEntry(book), or false if not.
	 */
	public boolean contains(T anEntry);

	/**
	 * Retrieves all entries(books) that are in this bag.
	 * 
	 * @return A newly allocated array of all the entries(books) in the bag. Note: If the
	 *         bag is empty, the returned array is empty.
	 */
	public T[] toArray();

	
	
}
