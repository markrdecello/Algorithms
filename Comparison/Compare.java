public class Compare{
	
	/*
	 *Method to perform Binary Search Algorithm
	 *Starts the search in the middle of the array
 	 *And begins searching left or right side of array
	 *Depending if greater or less than 
	 */	 
	public int binarySearch(int[] arr, int x){
		
		int low = 0, high = arr.length - 1, countBin = 1;

		System.out.println("\n\tBINARY SEARCH METHOD");
		while(low <= high){
			int mid = (low + high) / 2;

			if(arr[mid] == x){
				System.out.println("[" + countBin + "] Array: " + arr[mid] + " = Search Number: " + x);
				return mid;
			}
			
			if(arr[mid] < x){
				low = mid + 1;
				System.out.println("[" + countBin + "] Array: " + arr[mid] + " < Search Number: " + x + ". Increment low by 1");
			}else{
				high = mid - 1;
				System.out.println("[" + countBin + "] Array: " + arr[mid] + " > Search Number: " + x + ". decrement high by 1");
			}
			countBin++;
		}

		return -1;
	}

	/*
	 *Method to perform Linear Search Algorithm
	 *Checks if number is equal to any number in array
	 *Begins with first index and works its way up
	 */
	public int linearSearch(int[] arr, int x){
		int countLin = 1;
		System.out.println("\n\tLINEAR SEARCH METHOD");
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == x){
				System.out.println("[" + countLin + "] Array: " + arr[i] + " = Search Number: " + x);
				return i;
			}else{
				System.out.println("[" + countLin + "] Array: " + arr[i] + " != Search Number: " + x);
			}
			countLin++;
		}
		return -1;
	}

	//Prints out entire array
	public static void printArray(int[] arr){
		System.out.println("\n\tARRAYS");
		for(int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println("\n");
	}

	public static void main(String[] args){

		//Declare all variables
		Compare com = new Compare();
		int[] arr = {3, 20, 31, 35, 42, 60, 70, 71, 150, 200, 209};
		int searchFor = 42;
		
		//Call print method
		printArray(arr);
		System.out.println("SEARCH FOR: " + searchFor);

		//Call Linear and Binary Search Method
		int resultLinear = com.linearSearch(arr, searchFor);
		int resultBinary = com.binarySearch(arr, searchFor);

		System.out.println("\n\tLINEAR SEARCH");
		if(resultLinear == -1){
			System.out.println("Number not found");
		}else{
			System.out.println("The number is at index " + resultLinear);
		}

		System.out.println("\n\tBINARY SEARCH");
		if(resultBinary == -1){
			System.out.println("Number not found");
		}else{
			System.out.println("The number is at index " + resultBinary);
		}
	}
}
