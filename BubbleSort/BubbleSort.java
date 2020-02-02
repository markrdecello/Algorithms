public class BubbleSort{

	public static void main(String[] args){
		int[] arr = {6, 3, 19, 25, -11, 8, 5, 92, 1, 56, -12, 34};
		System.out.println("Current Numbers:");
		int arrLen = arr.length-1;
		System.out.print("\t");
		for(int x = 0; x <= arrLen; x++){
			System.out.print(arr[x] + " ");
		}
		System.out.println();
		for(int i = 0; i < arrLen; i++){
			for(int j = 0; j < arrLen-i; j++){
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}	
		}	
		System.out.println("Sorted  Numbers:");
		System.out.print("\t");
		for(int y = 0; y <= arrLen; y++){
			System.out.print(arr[y] + " ");
		}
		System.out.println();
	}
}
