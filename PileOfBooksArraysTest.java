
public class PileOfBooksArraysTest {

	public static void main(String[] args) {

		/*
		 * Creates empty bag.
		 * Tests isEmpty, getCurrentSize, toArray
		 */
		System.out.println("Creating an empty bag.");
		BookInterface<String> aBag = new PileOfBooksArrays<>();
		displayBag(aBag);
		testIsEmpty(aBag, true);

		/*
		 * Creates a bag with elements. 
		 * Tests add, isEmpty, getFrequencyOf, contains, remove, getCurrentSize, toArray
		 */
		String[] contentsOfBag = { "A", "D", "B", "A", "C", "A", "D" };
		testAdd(aBag, contentsOfBag);
		System.out.println();
		testIsEmpty(aBag, false);
		testFrequency(aBag, contentsOfBag);
		testContains(aBag, contentsOfBag);
		testRemove(aBag, contentsOfBag);

		System.out.println();
		
		/*
		 * Creates a bag with elements. 
		 * Tests clear, add, isEmpty, getCurrentSize, toArray
		 */
		String[] testStrings = { "A", "B" };
		testAdd(aBag, testStrings);
		System.out.println("\nClearing the bag:");
		aBag.clear();
		System.out.println();
		testIsEmpty(aBag, true);
		displayBag(aBag);
	} // end main

	// Tests the method add.
	private static void testAdd(BookInterface<String> aBag, String[] content) 
	{
		System.out.print("Adding to the bag: ");
		for (int index = 0; index < content.length; index++) 
		{
			aBag.add(content[index]);
			System.out.print(content[index] + " ");
		} // end for
		System.out.println();

		System.out.println("The last element added is the first element in the pile of books.");
		displayBag(aBag);
	} // end testAdd

	// Tests the remove method.
	private static void testRemove(BookInterface<String> aBag, String[] tests) 
	{
		for (int index = 0; index < tests.length; index++) 
		{
			System.out.println("\nRemoving a string from the bag:");
			String removedString = aBag.remove();
			System.out.println("remove() returns " + removedString);
			
			displayBag(aBag);
		} // end for
	} // end testRemove

	// Tests the method isEmpty.
	// correctResult indicates what isEmpty should return.
	private static void testIsEmpty(BookInterface<String> aBag, boolean correctResult) 
	{
		System.out.print("Testing isEmpty with ");
		if (correctResult)
			System.out.println("an empty bag:");
		else
			System.out.println("a bag that is not empty:");

		System.out.print("isEmpty finds the bag ");
		if (correctResult && aBag.isEmpty())
			System.out.println("empty: OK.");
		else if (correctResult)
			System.out.println("not empty, but it is empty: ERROR.");
		else if (!correctResult && aBag.isEmpty())
			System.out.println("empty, but it is not empty: ERROR.");
		else
			System.out.println("not empty: OK.");
		System.out.println();
	} // end testIsEmpty

	// Tests the method getFrequencyOf.
	private static void testFrequency(BookInterface<String> aBag, String[] tests) 
	{
		System.out.println("\nTesting the method getFrequencyOf:");
		for (int index = 0; index < tests.length; index++)
			System.out.println("In this bag, the count of " + tests[index] + " is " + 
							aBag.getFrequencyOf(tests[index]));
	} // end testFrequency

	// Tests the method contains.
	private static void testContains(BookInterface<String> aBag, String[] tests) 
	{
		System.out.println("\nTesting the method contains:");
		for (int index = 0; index < tests.length; index++)
			System.out.println("Does this bag contain " + tests[index] + "? " + 
								aBag.contains(tests[index]));
	} // end testContains

	// Tests the method toArray, getCurrentSize while displaying the bag.
	private static void displayBag(BookInterface<String> aBag) 
	{
		System.out.println("The bag contains " + aBag.getCurrentSize() + " string(s), as follows:");
		Object[] bagArray = aBag.toArray();
		for (int index = 0; index < bagArray.length; index++) 
		{
			System.out.print(bagArray[index] + " ");
		} // end for

		System.out.println();
	} // end displayBag

	
	
} // end PileOfBooksArraysTest
