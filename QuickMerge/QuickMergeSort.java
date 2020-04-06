public class QuickMergeSort{

	/*
	 * Sets ending array index to pivot
	 * places pivot in the correct position
	 * place all values less than pivot to left
	 * place all values greater than pivot to right
	 */
	public int partition(int arr[], int low, int high){
		
		int pivot = arr[high];
		int i = (low - 1);
		for(int j = low; j < high; j++){
			if(arr[j] < pivot){
				i++;

				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	/*
	 * Method that uses Quick Sort Algorithm recursively
	 * low is the starting index
	 * high is the ending index
	 * Recursively sorts elemts before partition and after
	 */
	public void quickSortRecursive(int arr[], int low, int high){
		
		if(low < high){
			int partIndex = partition(arr, low, high);

			quickSortRecursive(arr, low, partIndex - 1);
			quickSortRecursive(arr, partIndex + 1, high);
		}
	}

	/*
	 * Method that uses Quick Sort Algorithm Iterative
	 * Initializes top of stack
	 * Pushes initial values of low and high to stack
	 * Continues popping from stack while not empty
	 * If there are elements on left side of pivot, push left side to stack
	 * If there are elements on right side of pivot, push right side to stack
	 */
	public void quickSortIterative(int arr[], int low, int high){
		
		int[] stack = new int[high - low + 1];

		int top = -1;

		stack[++top] = low;
		stack[++top] = high;

		while(top >= 0){
			high = stack[top--];
			low = stack[top--];

			int pivot = partition(arr, low, high);

			if(pivot - 1 > 1){
				stack[++top] = low;
				stack[++top] = pivot - 1;
			}

			if(pivot + 1 < high){
				stack[++top] = pivot + 1;
				stack[++top] = high;
			}
		}
	}

	/*
	 * Method that uses Merge Sort Algorithm Recursively
	 * Splits left and right parts
	 * Merges left and right arrays
	 * Then collects any remaining elements
	 */
	public static void mergeSortRecursive(int[] arr){
		if(arr == null){
			return;
		}

		if(arr.length > 1){
			int mid = arr.length / 2;
			
			int[] left = new int[mid];
			for(int i = 0; i < mid; i++){
				left[i] = arr[i];
			}

			int[] right = new int[arr.length - mid];
			for(int i = mid; i < arr.length; i++){
				right[i-mid] = arr[i];
			}
			mergeSortRecursive(left);
			mergeSortRecursive(right);

			int i = 0;
			int j = 0;
			int k = 0;

			while(i < left.length && j < right.length){
				if(left[i] < right[j]){
					arr[k] = left[i];
					i++;
				}else{
					arr[k] = right[j];
					j++;
				}
				k++;
			}

			while(i < left.length){
				arr[k] = right[i];
				i++;
				k++;
			}

			while(j < right.length){
				arr[k] = right[j];
				j++;
				k++;
			}
		}
	}

	/*
	 * Method that uses Merge Sort Algorithm Iterative
	 * Merges subarrays in bottom up manner
	 * First merges subarrays of size 1 to create sorted subarrays of size 2
	 * Then merges subarrays of size 2 to create sorted subarrays of size 4, and so on
	 * Then finds ending point of left subarray
	 * Then merge subarrays
	 */
	public static void mergeSortIterative(int arr[], int n){
		int size;
		int leftStart;

		for(size = 1; size <= n - 1; size = 2*size){
			for(leftStart = 0; leftStart < n - 1; leftStart += 2*size){
				int mid = Math.min(leftStart + size - 1, n - 1);

				int rightEnd = Math.min(leftStart + 2*size - 1, n - 1);

				merge(arr, leftStart, mid, rightEnd);
			}
		}
	}

	/*
	 * Method to merge the two halves of an array
	 * left to mid and mid to right
	 * l = left, m = middle, r = right
	 */
	public static void merge(int arr[], int l, int m, int r){
		int i;
		int j;
		int k;
		int n1 = m - l + 1;
		int n2 = r - m;

		int left[] = new int[n1];
		int right[] = new int[n2];

		for(i = 0; i < n1; i++){
			left[i] = arr[l + i];
		}
		for(j = 0; j < n2; j++){
			right[j] = arr[m + 1 + j];
		}

		i = 0;
		j = 0;
		k = l;
		while(i < n1 && j < n2){
			if(left[i] <= right[j]){
				arr[k] = left[i];
				i++;
			}else{
				arr[k] = right[j];
				j++;
			}
			k++;
		}

		while(i < n1){
			arr[k] = left[i];
			i++;
			k++;
		}

		while(j < n2){
			arr[k] = right[j];
			j++;
			k++;
		}
	}

	/*
	 * Method to print all index in array
	 */
	public static void printArray(int arr[]){
		
		int n = arr.length;
		for(int i = 0; i < n; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	//Main Method
	public static void main(String[] args){

		int arr[] = {1, 78, 54, 90, 23, 4, 56, -6, 98, -6, 105, 2, 2};
		int n = arr.length;

		QuickMergeSort qm = new QuickMergeSort();

		System.out.println();
		System.out.println("\t\tArray");
		printArray(arr);
		System.out.println();
		
		qm.quickSortRecursive(arr, 0, n - 1);
		System.out.println("\tQuick Sort Recursive");
		printArray(arr);
		System.out.println();

		qm.quickSortIterative(arr, 0, n - 1);
		System.out.println("\tQuick Sort Iterative");
		printArray(arr);
		System.out.println();

		qm.mergeSortRecursive(arr);
		System.out.println("\tMerge Sort Recursive");
		printArray(arr);
		System.out.println();

		qm.mergeSortIterative(arr, n);
		System.out.println("\tMerge Sort Iterative");
		printArray(arr);
		System.out.println();

	}
}
