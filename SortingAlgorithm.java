package sortingAlgorithm;

import java.util.Random;

import homework2.*;

/**
 * A set of Integer Sorting Algorithm
 * @author liang dong
 *
 */
public class SortingAlgorithm<T extends Comparable<? super T>> {
	
	private T[] tempArray;// For merge sort

	
	/**
	 * a function that uses iterative selection sort to sort an array.
	 * @param array The array that to be sorted
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public void selectiveSortByIteration(T[] array) {
		selectiveSortByIteration(array, 0, array.length - 1);
	}

	/**
	 * a function that uses iterative selection sort to sort an array.
	 * @param array The array that to be sorted
	 * @param firstIndex The first index of an partial array to be sorted
	 * @param lastIndex The last index of an partial array to be sorted
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public void selectiveSortByIteration(T[] array, int firstIndex, int lastIndex) {
		if(firstIndex > lastIndex) {
			throw new FirstIndexIsGreaterThanLastIndexException();
		}
		int indexOfSmallest;
		for(int i = firstIndex; i <= lastIndex; i++) {
			indexOfSmallest = i;
			for(int j = i; j <= lastIndex; j++) {
				if(array[indexOfSmallest].compareTo(array[j]) > 0) {
					indexOfSmallest = j;
				}
			}//end nested for
			swap(array, i, indexOfSmallest);	
		}//end for
	}//end selectiveSortByIteration
	
	
	
	/**
	 * a function that uses recursive selection sort to sort an array.
	 * @param array The array that to be sorted
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public void selectiveSortByRecursion(T[] array) {
		selectiveSortByRecursion(array, 0, array.length - 1) ;
	}
	
	
	/**
	 * a function that uses recursive selection sort to sort an array.
	 * @param array The array that to be sorted
	 * @param firstUnsorted The index of the first entry in an unsorted part of the array
	 * @param lastIndex The last index of an partial array to be sorted
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public void selectiveSortByRecursion(T[] array, int firstUnsorted, int lastIndex) {
		if(firstUnsorted > lastIndex) {
			throw new FirstIndexIsGreaterThanLastIndexException();
		}
		int indexOfSmallest = 0;
		indexOfSmallest = findIndexOfSmallest(array, firstUnsorted, lastIndex);
		swap(array, firstUnsorted, indexOfSmallest);
		if(firstUnsorted + 1 <= lastIndex) {
			selectiveSortByRecursion(array,firstUnsorted + 1, lastIndex);
		}
		
	}//selectiveSortByRecursion
	
	/**
	 * a function that find the index of the smallest entry in an array
	 * @param array The target array
	 * @param indexOfCheckingElement The starting index
	 * @param lastIndex The last index of an partial array to be sorted
	 * @return Index of the smallest entry
	 */
	private int findIndexOfSmallest(T[] array, int indexOfCheckingElement, int lastIndex) {
		if(indexOfCheckingElement >= lastIndex) {
			return indexOfCheckingElement;
		}
		else {
			 int index = findIndexOfSmallest(array, indexOfCheckingElement + 1, lastIndex);
			 if (array[index].compareTo(array[indexOfCheckingElement]) < 0) {
				 return index;
			 }
			 else
				 return indexOfCheckingElement;
		}	
	}//end findIndexOfSmallest		

	
	/**
	 * swap two entries.
	 * @param array the target array
	 * @param first Index of an entry
	 * @param last Index Of another entry
	 */
	private void swap(T[] array, int first, int last) {
		T temp = array[first];
		array[first] = array[last];
		array[last] = temp;
	}
	
	
	
	/**
	 * a function that uses iterative insertion sort to sort an array.
	 * @param array The array that to be sorted
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public void insertionSortByIteration(T[] array) {
		insertionSortByIteration(array, 0, array.length - 1);
	}
	
	/**
	 * A function that uses iterative insertion sort to sort a partial array.
	 * @param array an array that to be sorted
	 * @param firstIndex The first index of an partial array to be sorted
	 * @param lastIndex The last index of an partial array to be sorted
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public void insertionSortByIteration(T[] array, int firstIndex, int lastIndex) {
		if(firstIndex > lastIndex) {
			throw new FirstIndexIsGreaterThanLastIndexException();
		}
		for (int i = firstIndex; i <= lastIndex; i++) {
			int j = i;
			while((j > firstIndex) && (array[j].compareTo(array[j-1]) < 0)) {
				T temp = array[j];
				array[j] = array[j-1];
				array[j-1] = temp;
				j--;
			}//end while
		}//end for
	}//end  insertionSortByIteration
	
	
	/**
	 * a function that uses recursive insertion sort to sort an array.
	 * @param array The array that to be sorted
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public void insertionSortByRecursion(T[] array) {
		insertionSortByRecursion(array, 0, array.length - 1);
	}//end insertionSortByRecursion
	
	/**
	 * a function that uses recursive insertion sort to sort a partial array.
	 * @param array The array that to be sorted
	 * @param firstIndex The first index of an partial array to be sorted
	 * @param lastIndex The last index of an partial array to be sorted
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public void insertionSortByRecursion(T[] array, int firstIndex, int lastIndex) {
		if(firstIndex > lastIndex) {
			throw new FirstIndexIsGreaterThanLastIndexException();
		}
		doInsertionSort(array, firstIndex, lastIndex, 1);
	}//end insertionSortByRecursion
	
	
	/**
	 * Do insertion sort
	 * @param array The array that to be sorted
	 * @param firstIndex The first index of an partial array to be sorted
	 * @param lastIndex The last index of an partial array to be sorted
	 * @param firstUnsorted The index of unsorted element in the partial array.
	 */
	private void doInsertionSort(T[] array, int firstIndex, int lastIndex, int firstUnsorted) {
		movingElement(array,firstIndex, lastIndex, firstUnsorted);	
		if(firstUnsorted < lastIndex) {
			doInsertionSort(array, firstIndex, lastIndex, firstUnsorted + 1);
		}
		
	}//end doInsertionSort
	
	/**
	 * compare and swap entries when necessary.
	 * @param firstIndex The first index of an partial array to be sorted
	 * @param lastIndex The last index of an partial array to be sorted
	 * @param array The target array
	 * @param indexOfChekingElement Index of the entry that is being checked
	 */
	private void movingElement(T[] array, int firstIndex, int lastIndex, int indexOfChekingElement) {
		
		if((indexOfChekingElement <= firstIndex) 
				|| (array[indexOfChekingElement].compareTo(array[indexOfChekingElement - 1]) >= 0))
			;
		else {
			T temp = array[indexOfChekingElement];
			array[indexOfChekingElement] = array[indexOfChekingElement - 1];
			array[indexOfChekingElement - 1] = temp;
			movingElement(array, firstIndex, lastIndex, indexOfChekingElement - 1);
		}//end else
		
	}//end comparingElements
	
	
	
	/**
	 * a function that uses iterative shell sort to sort an array.
	 * @param array
	 */
	public void shellSortByIteration(T[] array) {
		shellSortByIteration(array, 0, array.length - 1);
	}
	/**
	 * a function that uses iterative shell sort to sort an array.
	 * @param firstIndex The first index of an partial array to be sorted
	 * @param lastIndex The last index of an partial array to be sorted
	 * @param array The array that to be sorted
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public void shellSortByIteration(T[] array, int firstIndex, int lastIndex) {
		if(firstIndex > lastIndex) {
			throw new FirstIndexIsGreaterThanLastIndexException();
		}
		int k = 1;
		int index = firstIndex;
		int indexWhenSwap;
		while((2 * k + 1) <= lastIndex) {
			k = 2 * k + 1;
		}
		while(k > 0) {
			indexWhenSwap = index;
			while((indexWhenSwap >= firstIndex) 
					&& ((indexWhenSwap + k) <= lastIndex) 
					&& (array[indexWhenSwap].compareTo(array[indexWhenSwap + k]) > 0)) {

				T temp = array[indexWhenSwap];
				array[indexWhenSwap] = array[indexWhenSwap + 1];
				array[indexWhenSwap + 1] = temp;
				indexWhenSwap -= k;
			}//end nested while
			index++;
			if((index + k) > lastIndex) {
				k = k / 2;
				index = firstIndex;
			}
		}//end while
	}//end shellSortByIteration
	
	
	
	/**
	 * a function that uses recursive shell sort to sort an array.
	 * @param array The array that to be sorted
	 */
	public void shellSortByRecursion(T[] array) {
		shellSortByRecursion(array, 0, array.length - 1);
	}
	
	/**
	 * a function that uses recursive shell sort to sort an array.
	 * @param firstIndex The first index of an partial array to be sorted
	 * @param lastIndex The last index of an partial array to be sorted
	 * @param array The array that to be sorted
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public void shellSortByRecursion(T[] array, int firstIndex, int lastIndex) {
		if(firstIndex > lastIndex) {
			throw new FirstIndexIsGreaterThanLastIndexException();
		}
		int k = 1;
		while((2 * k + 1) <= lastIndex) {
			k = 2 * k + 1;
		}
		traversalElements(array, firstIndex, lastIndex, k, firstIndex);	
	}//end shellSortByRecursion
	
	
	/**
	 * a function goes over all elements in the array.
	 * @param array the target array
	 * @param firstIndex The first index of an partial array to be sorted
	 * @param lastIndex The last index of an partial array to be sorted
	 * @param k the space between the two elements
	 * @param index the entry that on the left of the other one
	 */
	private void traversalElements(T[] array, int firstIndex, int lastIndex, int k, int index) {
		if(k >= 1 && (index + k) <= lastIndex) {
			compareElements(array, firstIndex, k, index);
			traversalElements(array, firstIndex, lastIndex, k, index + 1);
		}
		else if(k > 1 && (index + k) > lastIndex) {
			traversalElements(array, firstIndex, lastIndex, k / 2, firstIndex);
		}
	}//end traversalElements
	
	/**
	 * compare and swap entries when necessary.
	 * @param array the target array
	 * @param firstIndex The first index of an partial array to be sorted
	 * @param k the space between the two entries
	 * @param index the entry on the left of the other one
	 */
	private void compareElements(T[] array, int firstIndex, int k, int index) {
		
		if(index >= firstIndex && array[index].compareTo(array[index + k]) > 0) {
			T temp = array[index];
			array[index] = array[index + k];
			array[index + k] = temp;
			compareElements(array, firstIndex, k, index - k);
		}
		
	}//end swapElements
	
	
	/**
	 * a function that uses iterative merge sort to sort an array.
	 * @param array The array that to be sorted
	 */
	public void mergeSortByIteration(T[] array) {
		mergeSortByIteration(array, 0, array.length - 1);
	}
	
	/**
	 * a function that uses iterative merge sort to sort an array.
	 * @param firstIndex The first index of an partial array to be sorted
	 * @param lastIndex The last index of an partial array to be sorted
	 * @param array The array that to be sorted
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public void mergeSortByIteration(T[] array, int firstIndex, int lastIndex) {
		if(firstIndex > lastIndex) {
			throw new FirstIndexIsGreaterThanLastIndexException();
		}
		int mid;
		int leftBoundary = 0;
		@SuppressWarnings("unchecked")
		T[] tempArr = (T[])new Comparable[lastIndex - firstIndex + 1];
		tempArray = tempArr;
		int range = 1;
		while(range <= lastIndex) {
			while(leftBoundary < lastIndex + 1 - range) {
				mid = range + leftBoundary - 1;
				if(lastIndex < leftBoundary + range * 2 -1) {
					combineMergeParts(array, leftBoundary, lastIndex, mid);
				}
				else {
					combineMergeParts(array, leftBoundary, leftBoundary + range * 2 -1, mid);
				}
				leftBoundary += range * 2;
			}
			leftBoundary = 0;
			range *= 2;
		}

	}//end mergeSortByIteration
		
	
	/**
	 * a function that uses recursive merge sort to sort an array.
	 * @param array The array that to be sorted
	 */
	public void mergeSortByRecursion(T[] array) {
		mergeSortByRecursion(array, 0, array.length - 1);
	}
	
	
	/**
	 * a function that uses recursive merge sort to sort an array.
	 * @param array The array that to be sorted
	 * @param firstIndex The first index of an partial array to be sorted
	 * @param lastIndex The last index of an partial array to be sorted
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public void mergeSortByRecursion(T[] array, int firstIndex, int lastIndex) {
		if(firstIndex > lastIndex) {
			throw new FirstIndexIsGreaterThanLastIndexException();
		}
		@SuppressWarnings("unchecked")
		T[] tempArr = (T[])new Comparable[lastIndex - firstIndex + 1];
		tempArray = tempArr;
		doMergeSort(array, firstIndex, lastIndex);
	}
	/**
	 * break a partial array into half
	 * @param array the target array
	 * @param firstIndex the starting point
	 * @param lastIndex the end point
	 */
	private void doMergeSort(T[] array, int firstIndex, int lastIndex) {

		if(lastIndex - firstIndex == 1) {
			if(array[firstIndex].compareTo(array[lastIndex]) > 0) {
				swap(array,firstIndex, lastIndex);
			}
		}
		else if(lastIndex > firstIndex) {
			int mid = (firstIndex + lastIndex) / 2;
			doMergeSort(array, firstIndex, mid);
			doMergeSort(array, mid + 1, lastIndex);	
			combineMergeParts(array,firstIndex, lastIndex, mid);
		}
		
	}//end merge
	
	
	/**
	 * a function that uses merge sort to sort two sorted partial arrays of an array.
	 * @param array the target array
	 * @param firstIndex the index of the first element in the left-side array
	 * @param lastIndex the index of the first element in the right-side array
	 * @param mid the boundary of the two arrays.
	 */
	private void combineMergeParts(T[] array, int firstIndex, int lastIndex, int mid) {

		int index = firstIndex;
		int pointer1 = firstIndex;
		int pointer2 = mid + 1;
		while(pointer1 <= mid && pointer2 <= lastIndex) {
			if(array[pointer1].compareTo(array[pointer2]) <= 0) {
				tempArray[index] = array[pointer1];
				pointer1++;
			}
			else {
				tempArray[index] = array[pointer2];
				pointer2++;
			}
			index++;
		}
		if(pointer1 > mid) {
			while(pointer2 <= lastIndex) {
				tempArray[index] = array[pointer2];
				index++;
				pointer2++;
			}
		}
		if(pointer2 > lastIndex) {
			while(pointer1 <= mid) {
				tempArray[index] = array[pointer1];
				index++;
				pointer1++;
			}
		}
		
		for(int i = firstIndex; i <= lastIndex; i++) {
			array[i] = tempArray[i];
		}
	}// end combineMergeParts
	
	/**
	 * a function that uses iterative quick sort to sort an array.
	 * @param array the target array
	 */
	public void quickSortByIteration(T[] array) {
		quickSortByIteration(array, 0, array.length - 1);
	}
	
	/**
	 * a function that uses iterative quick sort to sort an array.
	 * @param firstIndex The first index of an partial array to be sorted
	 * @param lastIndex The last index of an partial array to be sorted
	 * @param array the target array
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public void quickSortByIteration(T[] array, int firstIndex, int lastIndex) {
		if(firstIndex > lastIndex) {
			throw new FirstIndexIsGreaterThanLastIndexException();
		}
		LinkedDataStack<Integer> stack = new LinkedDataStack<>();
		stack.push(-1);
		stack.push(lastIndex);
		stack.push(firstIndex);
		int left;
		int right;
		int leftPointer;
		int rightPointer;
		T pivot;
		while(stack.peek() != -1) {
			left = stack.pop();
			leftPointer =left;
			right = stack.pop();
			rightPointer = right;
			pivot = array[(leftPointer + rightPointer) / 2];
			while(rightPointer >= leftPointer) {
				while(array[leftPointer].compareTo(pivot) < 0) {
					leftPointer++;
				}
				while(array[rightPointer].compareTo(pivot) > 0) {
					rightPointer--;
				}
				
				if(rightPointer >= leftPointer) {
					T temp = array[leftPointer];
					array[leftPointer] = array[rightPointer];
					array[rightPointer] = temp;
					leftPointer++;
					rightPointer--;
				}
			}
			if(rightPointer > left) {
				stack.push(rightPointer);
				stack.push(left);
			}
			
			if(right > leftPointer) {
				stack.push(right);
				stack.push(leftPointer);
			}

		}
	}// end quickSortByIteration
	
	
	/**
	 * a function that uses recursive quick sort to sort an array.
	 * @param array the target array.
	 */
	public void quickSortByRecursion(T[] array) {
		quickSortByRecursion(array, 0, array.length - 1);
	}
	
	/**
	 * a function that uses recursive quick sort to sort an array.
	 * @param array the target array
	 * @param firstIndex The index of the first unsorted element.
	 * @param lastIndex The index of the last unsorted element.
	 * @throws FirstIndexIsGreaterThanLastIndexException
	 */
	public void quickSortByRecursion(T[] array, int firstIndex, int lastIndex) {
		if(firstIndex > lastIndex) {
			throw new FirstIndexIsGreaterThanLastIndexException();
		}
		doQuickSort(array, firstIndex, lastIndex);
	}// end quickSortByRecursion

	
	/**
	 * a function that uses recursive quick sort to sort an array.
	 * @param array the target array
	 * @param firstIndex the lower bound
	 * @param lastIndex the upper pound
	 */
	private void doQuickSort(T[] array, int firstIndex, int lastIndex) {
		int left = firstIndex;
		int right = lastIndex;
		T pivot = array[(firstIndex + lastIndex) / 2];
		while(right >= left) {
			while(array[left].compareTo(pivot) < 0) {
				left++;
			}
			while(array[right].compareTo(pivot) > 0) {
				right--;
			}
				
			if(right >= left) {
				T temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			}
		}
			
		if(left < lastIndex) {
			doQuickSort(array, left, lastIndex);
		}
			
		if(right > firstIndex) {
			doQuickSort(array, firstIndex, right);
		}
			
	}// end doQuickSort

	public static void main(String[] args) {
	
		SortingAlgorithm<String> sort = new SortingAlgorithm<>();
		String[] arr = new String[1000];
		Random r = new Random();
		for(int i = 0; i < 1000; i++) {
			arr[i] = ""+r.nextInt(1000);
		}
		sort.quickSortByRecursion(arr);
		for(int i = 0; i < 1000; i++) {
			System.out.println(arr[i]);
		}
		
	}
}
