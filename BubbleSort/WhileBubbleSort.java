public class WhileBubbleSort{

	public static void main(String[] args){
		int [] arr2 = {8, 5, 3, 9, 1, 6};
		int[] arr = {2, 1, 3, 4, 5, 6};
		int i = 0;
		int j = 0;
		boolean flag = true;

		System.out.println("\n\tWhile Loop with Bubble Sort\n");
		System.out.println("Unsorted Array:");
		System.out.print("\t");
		while(i < arr.length){
			System.out.print(arr[i] + " ");
			i++;
		}

		/*Loops through entire array
		 *Once array 
		 *
		 */
		while(flag){
			flag = false;
			i = 0;
			//Loop through entire array to sort numbers
			while(i < arr.length - 1 - j){
				if(arr[i] > arr[i+1]){
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					flag = true;
				}
				i++;
			}
			j++;
		}

		System.out.println("\n" + j + "\n");

		i = 0;
		System.out.println("\nSorted Array:");
		System.out.print("\t");
		while(i < arr.length){
			System.out.print(arr[i] + " ");
			i++;
		}
		System.out.println();
	}
}
