
//Code written by Kevin Johanson 9/7/23
//Vigenere Cipher 
// SamR CSC 207 Mini-project 1
//


public class VigenereCipher {

	public static void main(String[] args) {
		String plainText;
		String cipherText;

	    java.io.PrintWriter pen = new java.io.PrintWriter(System.out, true);
	   
		if (args.length != 3) { // checks to see if it has two arguments
			pen.println("Not the correct ammount of arguments (three required)");
		} else if(args.length == 3) { // checks for two arguments
			
			if (!((args[0].equals("encode")) || (args[0].equals("decode")))) {
				pen.println("Valid arguments are \"encode\" or \"decode\"");
				
			} else if (args[0].equals("encode")) {// checks if program is encoding 
			
				plainText = args[1];
				
				encode(plainText, args[2]); // calls encode with the key and plaintext
				
				
			} else if (args[0].equals("decode")) { // checks if program is decoding
	   
				cipherText = args[1];
				
				decode(cipherText, args[2]); // calls encode with the key and cipherText
		}
	   
	   
		}
		
	}
	
	//requires two strings as arguments 
	//returns a String
	//replicates the second string given to the length of the first string
	//ex: replicate("hello", "hey") ---> "heyhe"
	public static String replicate(String cipher, String key) {
		String fullKey = key;
		
		for (int i = 0; fullKey.length() < cipher.length(); i++) {
			fullKey = fullKey + key.charAt(i%key.length());
		
		}
		
		return fullKey;
	}
	
	
	
	//requires two strings as arguments
	// uses a Vigenere cipher
	//encodes the first string given using the second one as a key 
	public static void encode(String plainText, String oldKey) {
		java.io.PrintWriter pen = new java.io.PrintWriter(System.out, true);
		pen.println("Encode: ");
		String key = replicate(plainText, oldKey); // replicates key to the length of the plainText;
		
		
		for (int i = 0; i < plainText.length(); i++) {
			char currentVar = plainText.charAt(i); // gets the string[i] for the plainText
			
			int currentKey = (int) key.charAt(i);
			int currentInt = (int) currentVar; // converts char to int
			
			int newInt = ((currentInt + currentKey) - 97 - 97); // adds the shifter and the base ascii value for lowercase #'s
			int wrapInt = ((((newInt % 26) + 26) % 26) + 97); // wraps the int around
			pen.print((char) wrapInt);
		}
		pen.flush();
			
	}
		
	
	
	// requires two strings as arguments 
	// decodes the text using a Vigenere cipher using the key
	public static void decode(String cipherText, String oldKey) {
		java.io.PrintWriter pen = new java.io.PrintWriter(System.out, true);
		pen.println("Decode: ");
		String key = replicate(cipherText, oldKey); // replicates key to the length of the plainText;
		
		
		for (int i = 0; i < cipherText.length(); i++) {
			char currentVar = cipherText.charAt(i); // gets the string[i] for the plainText
			
			
			int currentKey = (int) key.charAt(i);
			
			
			int currentInt = (int) currentVar; // converts char to int
			
			
			int newInt = (currentInt-97) - (currentKey - 97); // subtracts the shifter and the base ascii value for lowercase #'s
			
			
			int wrapInt = ((((newInt % 26) + 26) % 26) + 97); // wraps the int around
			
			
			pen.print((char) wrapInt);
		}
		pen.flush();
			
	}
	
	
}