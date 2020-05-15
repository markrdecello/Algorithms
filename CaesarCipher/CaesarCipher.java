import java.util.Scanner;

//Gene Oliva, Mark Decello, Julius Lopez, Hanel Duran, Naglaa Saeid
//Professor Ngatchou
//Intro to Algorithms
//May 2nd, 2020

//This program is built to encrypt and decrypt messages. Give it a try!

public class CaesarCipher {

//Variables held to parse our messages.
static String encryptedText = " ";
static String decryptedText = " ";
static char letter;

//This method is used to encrypt any message. The message is scanned using a for loop and goes through phases of upper and lowercase letters.

   private static void encrypt(String text, int key) 
   {
    for(int m = 0; m < text.length(); m++) 
    {
      letter = text.charAt(m);
      
      if(letter >= 'A' && letter <= 'Z')
      {
        letter = (char)(letter + key % 26);
        
        if(letter > 'Z') {letter = (char)(letter - 'Z' + 'A' - 1);}
        
        encryptedText += letter;
      }
     
      else if(letter >= 'a' && letter <= 'z')
      {
        letter = (char)(letter + key % 26);
       
        if(letter > 'z') {letter = (char)(letter - 'z' + 'a' - 1);}
        
        encryptedText += letter;
      }
      
      else {
      encryptedText += letter;
      }
    }
     System.out.println("This is your encrypted message: " + encryptedText + "\n");
   } 
 
//This method is used to decrypt any message. The message is scanned using a for loop and goes through phases of upper and lowercase letters. 

   private static void decrypt(String text2, int key2) 
   {
    for(int m = 0; m < text2.length(); m++) 
    {
      letter = text2.charAt(m);
      
      if(letter >= 'A' && letter <= 'Z')
      {
        letter = (char)(letter - key2 % 26);
        
        if(letter < 'A') {letter = (char)(letter + 'Z' - 'A' + 1);}
        
        decryptedText += letter;
      }
     
      else if(letter >= 'a' && letter <= 'z')
      {
        letter = (char)(letter - key2 % 26);
        
        if(letter < 'a') {letter = (char)(letter + 'z' - 'a' + 1);}
        
        decryptedText += letter;
      }
      
      else {
      decryptedText += letter;
      }
    }
     System.out.println("This is your decrypted message: " + decryptedText + "\n");
   }
  
  //The main method helps drive our code. Two scanners are used due to a bug in the scanner where one of the inputs are skipped. It has been fixed.
  public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter the message you want to encrypt please..." + "\n");
     String text = sc.nextLine();
     System.out.println("Enter the shift key: ");
     int key = sc.nextInt();
     encrypt(text,key);
     Scanner sc2 = new Scanner(System.in);
     System.out.println("Enter the message you want to decrypt please..." + "\n");
     String text2 = sc2.nextLine();
     System.out.println("Enter the shift key: ");
     int key2 = sc2.nextInt();
     decrypt(text2,key2);
     
  }
}
