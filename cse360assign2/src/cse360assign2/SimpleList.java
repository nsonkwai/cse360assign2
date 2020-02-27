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

import java.util.Arrays;

/**
 * 
 * Public class SimpleList holds methods that perform operations on a list.
 * These operations consist of creating a new list, adding an element to the
 * beginning of the list, removing an element, counting the amount of elements,
 * search through the list, printing the list, appending an element to the end
 * of the list, returning the first element, and returning the size of the list.
 *
 */
public class SimpleList {
	private static int[] list;
	private static int count;

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
	 * full, the size of the list is increased by 50 percent of the original list
	 * length and the new element is added to the list.
	 * 
	 * @param newElement This is the new element being added to the list
	 */
	public void add(int newElement) {
		int[] tempArray = new int[list.length];
		int size = (int) (list.length + (list.length * .5));
		if (count == list.length) {
			list = Arrays.copyOf(list, size);
			tempArray = new int[list.length];
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
	 * the list is shifted down one to fill the empty space. If the list has more
	 * than 25 percent empty places, the size is reduced.
	 * 
	 * @param element This is the element that is to be removed from the list.
	 */
	public void remove(int element) {
		int target = 0;
		for (int index = 0; index < list.length; index++) {
			if (element == list[index]) {
				count--;
				target = index;
				for (int targetIndex = target; targetIndex < list.length; targetIndex++) {
					if (targetIndex == list.length - 1) {
						list[list.length - 1] = 0;
					} else {
						list[targetIndex] = list[targetIndex + 1];
					}
				}
			}
		}
		int percent = (int) (list.length * .25);
		int emptySpaces = list.length - count;
		if (emptySpaces > percent) {
			if(list.length - percent > 0) {
				list = Arrays.copyOf(list, list.length - percent);
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