public class LinearSearch{
	
	public static void main(String[] args){

		//The set of arrays
		int[] arr = {5, 8, 2, 15, 7, 6, 3, 4, 10};
		int x = 0;
		int findNum = 15;
		boolean found = false;

		//print statement to indicate the array's length and which number to search for
		System.out.println("\tThere are a set of " + arr.length + " numbers\n");
		System.out.println("Searching for the number " + findNum + " in the set...");

		/*Using a while loop to search for a certain number within the set of arrays
		/loop will break once found is true
		/if the search has gone through all the numbers, then print not found
		/else if statement will be used to search if number matches a number within array
		/then print the number and its path within the array
		*/
		while(!found){
			if(x > arr.length - 1){
				System.out.println("The number " + findNum + " is not in the array");
				found = true;
			}else if(arr[x] == findNum){
				found = true;
				System.out.println("The number " + findNum + " is located in path number " + (x+1));
			}
			//increment by 1 and continue loop
			x++;
		}

	}
}
