package src.algorithm.sorting;

/**
 * This class contains various sorting algorithms
 */
public class Sorting {

	private static <T extends Comparable<T>> void swap(T A[], int i, int j) {
		T tmp = A[i];
		A[i]  = A[j];
		A[j]  = tmp;
	}
	

	/**
	 * Sorts the specified array according to the ordering induced by the compareTo() method in &Theta;(n<sup>2</sup>)
	 * <p>
	 * Implements the selectionsort algorithm.
	 * <ul>
	 * <li> Worst/Average/Best-case cost: &Theta;(n<sup>2</sup>)
	 * </ul>
	 * @param A the array to be sorted
	 * @param <T> class of the object in the array
	 */
	public static <T extends Comparable<T>> void selectionsort(T A[]) {

	}



	/**
	 * Sorts the specified array into ascending numerical order in &Theta;(n<sup>2</sup>)
	 * <p>
	 * Implements the selectionsort algorithm.
	 * <ul>
	 * <li> Worst/Average/Best-case cost: &Theta;(n<sup>2</sup>)
	 * </ul>
	 * @param A the array to be sorted
	 */
	public static void selectionsort(int A[]) {

	}

	/**
	 * Sorts the specified array according to the ordering induced by the compareTo() method in O(n<sup>2</sup>)
	 * <p>
	 * Implements the insertionsort algorithm.
	 * <ul>
	 * <li> Worst/Average-case cost: &Theta;(n<sup>2</sup>)
	 * <li> Best-case cost: &Theta;(n)
	 * </ul>
	 * @param A the array to be sorted
	 * @param <T> class of the object in the array
	 */
	public static <T extends Comparable<T>> void insertionsort(T A[]) {

	}

	/**
	 * Sorts the specified array into ascending numerical order in O(n<sup>2</sup>)
	 * <p>
	 * Implements the insertionsort algorithm.
	 * <ul>
	 * <li> Worst/Average-case cost: &Theta;(n<sup>2</sup>)
	 * <li> Best-case cost: &Theta;(n)
	 * </ul>
	 * @param A the array to be sorted
	 */
	public static void insertionsort(int A[]) {

	}

	/**
	 * Sorts the specified array according to the ordering induced by the compareTo() method in &Theta;(nlogn)
	 * <P>
	 * Implements the mergesort algorithm.
	 * <ul>
	 * <li> Worst/Average/Best-case cost: &Theta;(nlogn)
	 * </ul>
	 * @param A the array to be sorted
	 * @param <T> class of the object in the array
	 */
	public static <T extends Comparable<T>> void mergesort(T A[]) {
		
	}

 	/**
	 * Sorts the specified array into ascending numerical order in &Theta;(nlogn)
	 * <p>
	 * Implements the mergesort algorithm.
	 * <ul>
	 * <li> Worst/Average/Best-case cost: &Theta;(nlogn)
	 * </ul>
	 * @param A the array to be sorted
	 */
	public static void mergesort(int A[]) {

	}


	/**
	 * Sorts the specified array according to the ordering induced by the compareTo() method in O(n<sup>2</sup>) and O(nlogn) on the average
	 * <p>
	 * Implements the quicksort algorithm.
	 * <ul>
	 * <li> Worst-case cost:  &Theta;(n<sup>2</sup>)
	 * <li> Average/Best-case cost: &Theta;(nlogn)
	 * </ul>
	 * @param A the array to be sorted
	 * @param <T> class of the object in the array
	 */
	public static <T extends Comparable<T>> void quicksort(T A[]) {

	}

	/**
	 * Sorts the specified array into ascending numerical order in O(n<sup>2</sup>) and O(nlogn) on the average
	 * <p>
	 * Implements the quicksort algorithm.
	 * <ul>
	 * <li> Worst-case cost:  &Theta;(n<sup>2</sup>)
	 * <li> Average/Best-case cost: &Theta;(nlogn)
	 * </ul>
	 * @param A the array to be sorted
	 */
	public static void quicksort(int A[]) {

	}

	/**
	 * Sorts the specified array into ascending numerical order in &Theta;(n+k)
	 * <p>
	 * Implements the countingsort algrithm.
	 * <ul>
	 * <li> Worst/Average/Best-case cost: &Theta;(n+k), where k = max(<code>A</code>)-min(<code>A</code>)+1
	 * </ul>
	 * @param A the array to be sorted
	 */
	public static void countingsort(int A[]) {

	}

	/**
	 * Sorts the specified array according to the ordering induced by the compareTo() method in &Theta;(nlogn)
	 * <p>
	 * Implements the heapsort algorithm.
	 * <ul>
	 * <li> Worst/Average-cost: &Theta;(nlogn)
	 * <li> Best-case cost: &Theta;(n)	
	 * </ul>
	 * @param A the array to be sorted
	 * @param <T> class of the object in the array
	 */
		
	public static <T extends Comparable<T>> void heapsort(T A[]) {
		heapify(A, A.length - 1, 0);
		for (int c = (A.length - 1); c > 0; c--) {
			T k = findmax(A);
			deletemax(A, c);
			A[c] = k;
		}
	}
	
	private static <T extends Comparable<T>> void heapify(T A[], int n, int i) {
		if (i >= n) return;
		heapify(A, n, left(i));
		heapify(A, n, right(i));
		fixheap(A, n, i);
	}
	
	private static int left(int i) {
		return ( 2*i + 1 );
	}

	private static int right(int i) {
		return ( 2*i + 2 );
	}
			
	private static <T extends Comparable<T>> void fixheap(T A[], int c, int i) {
		int l = left(i), r = right(i);
		if (l > c) return;
		int max = l;
		if (r <= c && A[l].compareTo(A[r]) < 0)
			max = r;
		if (A[i].compareTo(A[max]) < 0) {
			swap(A, i, max);
			fixheap(A, c, max);
		}
	}
	
	private static <T extends Comparable<T>> T findmax(T A[]) {
		return A[0];
	}
	
	private static <T extends Comparable<T>> void deletemax(T A[], int c) {
		if (c <= 0) return;
		A[0] = A[c];
		c--;
		fixheap(A, c, 0);
	}		
					
}