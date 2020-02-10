public class PolishPeasant{


	public static void main(String[] args){
		int num1 = 50;
		int num2 = 30;
		int product = 0;

		//Just to label num1 and num2
		System.out.println("Num1\tNum2");
		System.out.println(num1 + "\t" + num2);
		
		//Reads if num2 is odd to check whether to add num1 to the total
		if(num2 % 2 == 1){
			product += num1;
		}

		//A loop to continue to read num2 and divide by half until num2 is 1
		//The if statement continues to add all of num1 when num2 is odd
		while(num2 != 1){
			if(num1 == 0 || num2 == 0){
				product = 0;
				break;
			}
			num2 = num2 / 2;
			num1 = num1 * 2;
			if(num2 % 2 == 1){
				product += num1;
			}
			System.out.println(num1 + "\t" + num2);
		}
		//Just to display the product of the two numbers
		System.out.println("---------------");
		System.out.println(product + "\t" + num2);
	}
}
