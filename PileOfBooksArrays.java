import java.util.Arrays;

/*
 * A class of bags whose entries are stored in a resizable array.
 */
public class PileOfBooksArrays<T> implements BookInterface<T> 
{
	private T[] bag;
	private static final int DEFAULT_CAPACITY = 25;
	private int numberOfEntries;
	private boolean integrityOK = false;
	private static final int MAX_CAPACITY = 100;

	/*
	 * Creates an empty bag whose initial capacity is 25.
	 */
	public PileOfBooksArrays() 
	{
		this(DEFAULT_CAPACITY);
	} // end default constructor
	
	/*
	 * Creates an empty bag given capacity.
	 * 
	 * @param desiredCapacity The integer capacity wanted for bag
	*/
	public PileOfBooksArrays(int desiredCapacity) 
	{	
		if (desiredCapacity <= MAX_CAPACITY) 
		{
			numberOfEntries = 0;
			@SuppressWarnings("unchecked")
			T[] tempBag = (T[]) new Object[desiredCapacity];
			bag = tempBag;
			integrityOK = true;
		} 
		else 
		{
			throw new IllegalStateException("Attempt to create a bag whose" + 
											"capacity exceeds allowed maximum");
		} // end if

	} // end constructor

	/*
	 * Throws an exception if the object is not initialized.
	 */
	private void checkIntegrity() 
	{
		if (!integrityOK) 
		{
			throw new SecurityException("ArrayBag object is corrupt.");
		} // end if
	} // end checkIntegrity

	/*
	 * Determines if the array is full
	 * 
	 * @return true if array is full, false otherwise.
	 */
	private boolean isArrayFull() 
	{
		return numberOfEntries >= bag.length;
	} // end isArrayFull

	/*
	 * Checks if the bag has reached the maximum capacity
	 * 
	 * @param the capacity of the bag which is compared to max capacity
	 */
	private void checkCapacity(int capacity) 
	{
		if (capacity > MAX_CAPACITY) 
		{
			throw new IllegalStateException("Attempt to create a bag whose " + 
											"capacity exceeds allowed " + "maximum of " + 
											MAX_CAPACITY);
		} // end if
	} // end checkCapacity

	/*
	 * Doubles the capacity of bag if needed until max capacity reached
	 */
	private void doubleCapacity() 
	{
		int newLength = 2 * bag.length;
		checkCapacity(newLength);
		bag = Arrays.copyOf(bag, newLength);
	} // end doubleCapacity

	/*
	 * Adds a particular entry at the beginning of the array. 
	 * The top of pile is the last element of a bag.
	 * 
	 * @param newEntry The entry wanted to be added
	 * @return true after performing operation, if can't -> throws an exception
	*/
	public boolean add(T newEntry)
	{
		checkIntegrity();

		if (isArrayFull()) 
		{
			doubleCapacity();
		} // end if

		bag[numberOfEntries] = newEntry;
		numberOfEntries++;

		return true;
	} // end add

	/*
	 * Removes the first element, where last element in bag is the top.
	 * 
	 * @return Either the removed entry(book), if the removal was successful, or null.
	 */
	public T remove()
	{
		checkIntegrity();
		T result = null;
		
		if (numberOfEntries > 0) 
		{
			result = bag[numberOfEntries - 1];
			bag[numberOfEntries - 1] = null;
			numberOfEntries--;
		} // end if
		
		return result;
		
	} // end remove
	
	/**
	 * Retrieves all entries(books) that are in this bag.
	 * 
	 * @return newly allocated array of all the entries(books) in the bag.
	 */
	public T[] toArray() 
	{
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries];
		for (int index = 0; index < numberOfEntries; index++) 
		{
			result[index] = bag[index];
		} // end for

		return result;
	} // end toArray

	/**
	 * Sees whether this bag is empty - if there's any book inside or not.
	 * 
	 * @return True if the bag is empty of books, or false if not.
	 */
	public boolean isEmpty() 
	{
		return numberOfEntries == 0;
	} // end isEmpty

	/**
	 * Gets the current number of entries(books) in this bag.
	 * 
	 * @return The integer number of entries(books) currently in the bag.
	 */
	public int getCurrentSize() 
	{
		return numberOfEntries;
	} // end getCurrentSize

	/*
	 * Removes all entries(books) from this bag. 
	 */
	public void clear() 
	{
		while (!isEmpty()) 
		{
			remove();
		} // end while
		
	} // end clear

	/**
	 * Counts the number of times a given entry(book) appears in this bag.
	 * 
	 * @param anEntry The entry(book) to be counted.
	 * @return The number of times anEntry(book) appears in the bag.
	 */
	public int getFrequencyOf(T anEntry) 
	{
		checkIntegrity();
		int counter = 0;

		for (int index = 0; index < numberOfEntries; index++) 
		{
			if (anEntry.equals(bag[index])) 
			{
				counter++;
			} // end if
		} // end for

		return counter;
	} // end getFrequencyOf

	/**
	 * Tests whether this bag contains a given entry(book).
	 * 
	 * @param anEntry The entry(book) to find.
	 * @return True if the bag contains anEntry(book), or false if not.
	 */
	public boolean contains(T anEntry) 
	{
		checkIntegrity();
		for (int i = 0; i < numberOfEntries; i++) 
		{
			if (bag[i].equals(anEntry)) 
			{
				return true;
			} // end if
		} // end for
		
		return false;
		/*
		 * Two alternatives, but slightly less efficient ways:
		 * return getIndexOf(anEntry) > -1;
		 * return getFrequencyOf(anEntry) > 0;
		 */
	} // end contains

	
	
	/*
	 * Adds a new entry(book) to this bag.
	 * 
	 * @param newEntry The object(book) to be added as a new entry.
	 * @return True if the addition of book is successful, or false if not.
	 */
	/*
	public boolean remove(T anEntry) 
	{
		checkIntegrity();
		int index = getIndexOf(anEntry);
		T result = removeEntry(index);
		return anEntry.equals(result);
	} // end remove
	*/
	
	/*
	 * Returns the index of the element in the array
	 * 
	 * @param the element provided to retrieve entry index
	 * @return the integer index of anEntry
	 */
	/*
	private int getIndexOf(T anEntry) 
	{
		int where = -1;
		boolean found = false;
		int index = 0;

		while (!found && (index < numberOfEntries)) 
		{
			if (anEntry.equals(bag[index])) 
			{
				found = true;
				where = index;
			} // end if
			index++;
		} // end while

		return where;
	} // end getIndexOf
	*/
	
	/*
	 * Removes the particular entry given it's index.
	 * 
	 * @param return the entry given it's index
	 * @return the entry at given index, or null if can't find.
	 */
	/*
	public T removeEntry(int givenIndex)
	{
		T result = null;
		
		if (!isEmpty() && (givenIndex > 0))
		{
			result = bag[givenIndex];
			bag[givenIndex] = bag[numberOfEntries -1];
			bag[numberOfEntries - 1] = null;
			numberOfEntries--;
		} // end if
		
		return result;
	} // end removeEntry
	*/
	
	
	
}
