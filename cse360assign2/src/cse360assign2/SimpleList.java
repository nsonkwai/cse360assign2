/**
 * 
 * This file contains the public class SimpleList. 
 * Public class SimpleList holds methods that perform operations on a list.
 * This is the second version of SimpleList.java.
 * 
 * @author Nfn Sonkwaiataroroks
 * @classID 400
 * @assignment 2
 * 
 */
package cse360assign2;

/**
 * 
 * Public class SimpleList holds methods that perform operations on a list.
 * These operations consist of creating a new list, adding an element to the
 * beginning of the list, removing an element, counting the amount of elements,
 * search through the list, and printing the list.
 *
 */
public class SimpleList {
	private int[] list;
	private int count;

	/**
	 * 
	 * This SimpleList() method creates a new list of size 10 and sets the count of
	 * that list to zero.
	 * 
	 */
	public SimpleList() {
		list = new int[10];
		count = 0;
	}

	/**
	 * This method adds the new element to the beginning of the list. If the list is
	 * full, the last element is dropped off and the new element is added to the
	 * beginning.
	 * 
	 * @param newElement This is the new element being added to the list
	 */
	public void add(int newElement) {
		int[] tempArray = new int[10];
		if (count == 10) {
			list[9] = 0;
			count--;
		}
		for (int index = 0; index < list.length - 1; index++) {
			tempArray[index + 1] = list[index];
		}
		tempArray[0] = newElement;
		list = tempArray;
		count++;
	}

	/**
	 * 
	 * This method removes an element from the list. Once the element is removed,
	 * the list is shifted down one to fill the empty space. 
	 * 
	 * @param element This is the element that is to be removed from the list.
	 */
	public void remove(int element) {
		int target = 0;
		for (int index = 0; index < list.length; index++) {
			if (list[index] == element) {
				count--;
				target = index;
				for (int targetIndex = target; targetIndex < list.length; targetIndex++) {
					if (targetIndex == 9) {
						list[9] = 0;
					} else {
						list[targetIndex] = list[targetIndex + 1];
					}
				}
			}
		}
	}

	/**
	 * 
	 * This method counts the elements in the list and returns the amount.
	 * 
	 * @return count This is the amount of elements in the list.
	 */
	public int count() {
		int counter = 0;
		for (int index = 0; index < list.length; index++) {
			if (list[index] != 0) {
				counter++;
			}
		}
		count = counter;
		return count;
	}

	/**
	 * 
	 * This method concatenates all the elements in the list into a
	 * string(listString) and returns the listString.
	 * 
	 * @return listString This is the list as a string.
	 */
	public String toString() {
		String listString = "";
		listString += list[0];
		for (int index = 1; index < count; index++) {
			listString += " " + list[index];
		}
		return listString;
	}

	/**
	 * This method receives a target to be searched for in the list. The list is
	 * traversed and if the target is found, the targets index is returned.
	 * Otherwise, -1 is returned.
	 * 
	 * @param target This is the integer being searched for in the list.
	 * @return found This is the index of the target in the list.
	 */
	public int search(int target) {
		int found = -1;
		for (int index = 0; index < count; index++) {
			if (target == list[index]) {
				found = index;
			}
		}
		return found;
	}
}