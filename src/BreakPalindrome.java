import java.util.Scanner;

/**
 * input {abccba}
 * output {aaccba}
 * need to convert a palindromic string to non-palindromic string
 * by replacing one character and the result string should be lexicographically small
 * @author ramsa
 */
public class BreakPalindrome{

	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		char[] input = scanner.nextLine().toCharArray();
		boolean replaced = false;
		String new_string = "";
		char prev=input[0];
		for(int i=0;i<input.length;i++) {
			if(!replaced) {
				if(input[i] >'a' && ((input.length/2 !=i) || (input.length %2 ==0))) {
					new_string += 'a';
					replaced = true;
				}else {
					new_string +=input[i];
				}
			}else {
				new_string +=input[i];
			}
		}
		if(new_string.equals(String.valueOf(input))) {
			System.out.println("");
		}else {
			System.out.println(new_string);
		}
	}
}
