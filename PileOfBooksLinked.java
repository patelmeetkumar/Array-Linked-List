
public class PileOfBooksLinked<T> implements BookInterface<T> 
{
	private Node firstNode;
	private int numberOfEntries;
	
	/*
	 * Creates an empty bag.
	 */
	public PileOfBooksLinked()
	{
		firstNode = null;
		numberOfEntries = 0;
	} // end default constructor
	
	public class Node
	{
		private T data;
		private Node next;
		
		private Node(T dataPortion)
		{
			this(dataPortion, null);
		} // end constructor
		
		private Node(T dataPortion, Node nextNode)
		{
			data = dataPortion;
			next = nextNode;
		} // end constructor
		
		private T getData()
		{
			return data;
		} // end getData
		
		private void setData(T newData)
		{
			data = newData;
		} // end setData
		
		private Node getNextNode()
		{
			return next;
		} // end getNextNode
		
		private void setNextNode(Node nextNode)
		{
			next = nextNode;
		} // end setNextNode

	} // end Node class
	
	/**
	 * Adds a new entry(book) to this bag.
	 * 
	 * @param newEntry The object(book) to be added as a new entry.
	 * @return True if the addition of book is successful, or false if not.
	 */
	public boolean add(T newEntry)
	{
		Node newNode = new Node(newEntry);
		
		newNode.setNextNode(firstNode);		
		firstNode = newNode;
		numberOfEntries++;
		
		return true;
	} // end add
	
	/**
	 * Removes one unspecified entry(book) from this bag, if possible.
	 * 
	 * @return Either the removed entry(book), if the removal was successful, or null.
	 */
	public T remove()
	{
		T result = null;
		if (firstNode != null)
		{
			result = firstNode.getData();
			firstNode = firstNode.getNextNode();
			numberOfEntries--;
		} // end if
		
		return result;
	} // end remove
	
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
	
	/** 
	 * Removes all entries(books) from this bag. 
	 */
	public void clear()
	{
		while(!isEmpty())
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
		int frequency = 0;
		int counter = 0;
		
		Node currentNode = firstNode;
		while((counter < numberOfEntries) && (currentNode != null))
		{
			if (anEntry.equals(currentNode.getData()))
			{
				frequency++;
			} // end if
			
			counter++;
			currentNode = currentNode.getNextNode();
		} // end while
		
		return frequency;
	} // end getFrequencyOf
	
	/**
	 * Tests whether this bag contains a given entry(book).
	 * 
	 * @param anEntry The entry(book) to find.
	 * @return True if the bag contains anEntry(book), or false if not.
	 */
	public boolean contains(T anEntry)
	{
		boolean found = false;
		Node currentNode = firstNode;
		
		while(!found && (currentNode != null))
		{
			if (anEntry.equals(currentNode.getData()))
			{
				found = true;
			}
			else
			{
				currentNode = currentNode.getNextNode();
			} // end if
		} // end while
	
		return found;
		/*
		 * Alternative, but slightly less efficient way:
		 * return getFrequencyOf(anEntry) > 0;
		 */
	} // end contains
	
	/**
	 * Retrieves all entries(books) that are in this bag.
	 * 
	 * @return A newly allocated array of all the entries(books) in the bag. Note: If the
	 *         bag is empty, the returned array is empty.
	 */
	public T[] toArray()
	{
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];
		
		int index = 0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null))
		{
			result[index] = currentNode.getData();
			index++;
			currentNode = currentNode.getNextNode();
		} // end while
		
		return result;
	} // end toArray


	
	/**
	 * Removes one occurrence of a given entry(book) from this bag, if possible.
	 * 
	 * @param anEntry The entry(book) to be removed.
	 * @return True if the removal of a particular book was successful, or false if not.
	 */
	/*
	public boolean remove(T anEntry)
	{
		Node previous = firstNode;
		Node current = firstNode;
		boolean found = false;

		if(!isEmpty()){
			while(!found && current != null) {
				if(current.getData().equals(anEntry)) {
					found = true;
					Node next = current.getNextNode(); // could be null
					previous.setNextNode(next);
					numberOfEntries--;
				} else {
					previous = current;
					current = current.getNextNode();
				} // end inner-if
			} // end while
		} // end outer-if

		return found;
	} // end remove
	*/
	
	
	
}
