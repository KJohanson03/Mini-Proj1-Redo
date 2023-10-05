//Code written by Kevin Johanson 9/7/23
//Ceaser Cipher 
// SamR CSC 207 Mini-project 1
//

public class CaeserCipher {

	public static void main(String[] args) {
			String plainText;
			String cipherText;

		    java.io.PrintWriter pen = new java.io.PrintWriter(System.out, true);
		   
			if (args.length != 2) { // checks to see if it has two arguments
				pen.println("Not the correct ammount of arguments (two required)");
			} else if(args.length == 2) { // checks for two arguments
				
				if (!((args[0].equals("encode")) || (args[0].equals("decode")))) {
					pen.println("Valid arguments are \"encode\" or \"decode\"");
					
				} else if (args[0].equals("encode")) {// checks if program is encoding 
				
					plainText = args[1];
					encode(plainText);
				} else if (args[0].equals("decode")) { // checks if program is decoding
		   
					cipherText = args[1];
					decode(cipherText);
			}
		   
		   
			}
			
	}

	//shows all possible Ceaser Cipher decodings of the string given
	public static void decode(String cipherText) {
		java.io.PrintWriter pen = new java.io.PrintWriter(System.out, true);
		pen.println("Decode: ");
		
		for (int n = 0; n <= 25; n++) {
			pen.print("n = " + n + ": ");
			
			for (int i = 0; i <= (cipherText.length()-1); i++) {
				char currentVar = cipherText.charAt(i); // gets the string[i]
				int currentInt = (int) currentVar; // converts char to int
				int newInt = ((currentInt - n) - 97) ; // subtracts the shifter and the base ascii value for lowercase #'s
				int wrapInt = ((((newInt % 26) + 26) % 26) + 97); // wraps the int around
				pen.print(  (char) wrapInt + " ");
			}
			pen.println();
		}
		
	}
	
	
	//shows all possible Ceaser Cipher encodings of the string given
	public static void encode(String plainText) {
		java.io.PrintWriter pen = new java.io.PrintWriter(System.out, true);
		pen.println("Encode: ");
		
		for (int n = 0; n <= 25; n++) {
			pen.print("n = " + n + ": ");
			
			for (int i = 0; i <= (plainText.length()-1); i++) {
				char currentVar = plainText.charAt(i); // gets the string[i]
				int currentInt = (int) currentVar; // converts char to int
				
				int newInt = ((currentInt + n) - 97) ; // subtracts the shifter and the base ascii value for lowercase #'s
				int wrapInt = ((((newInt % 26) + 26) % 26) + 97); // wraps the int around
				pen.print(  (char) wrapInt + " ");
			}
			pen.println();
		}		
	
	}
}









 
