public class LinearSearch{
	
	public static void main(String[] args){

		int[] arr = {5, 8, 2, 15, 7, 6, 3, 4, 10};
		int x = 0;
		int findNum = 15;
		boolean found = false;

		System.out.println("\tThere are a set of numbers from 1 to " + arr.length + "\n");
		System.out.println("Searching for the number " + findNum + " in the set...");

		while(!found){
			if(x > arr.length - 1){
				System.out.println("The number " + findNum + " is not in the array");
				found = true;
			}else if(arr[x] == findNum){
				found = true;
				System.out.println("The number " + findNum + " is located in path number " + (x+1));
			}
			x++;
		}

	}
}
