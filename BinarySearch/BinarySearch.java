public class BinarySearch{

	public int binarySearch(int arr[], int x){

		int low = 0, high = arr.length - 1;

		while(low <= high){
			int mid = (low + high) / 2;

			/*
			 *Check if x is equal to arr[mid]
			 *If true, then number is found
			 *search completed
			 */
			if(arr[mid] == x){
				return mid;
			}
			/*
			 *Check if x is greater than mid
			 *If true, then increment mid by 1
			 *Else, decrement by 1
			 */
			if(arr[mid] < x){
				low = mid + 1;
			}else{
				high = mid - 1;
			}
		}

		//Return negative if number not found
		return -1;
	}

	//A method to print out the array
	public static void printArray(int[] arr, int length){
		System.out.print("Here are the array of numbers: ");
		for(int i = 0; i < length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args){

		BinarySearch bs = new BinarySearch();
		int[] arr = {3, 20, 31, 35, 42, 60, 70, 71};
		int length = arr.length;
		int searchFor = 71;
		printArray(arr, length);
		int result = bs.binarySearch(arr, searchFor);
		
		if(result == -1){
			System.out.println("Number not found!");
		}else{
			System.out.println("Number is found in index " + result);
		}
	}
}
