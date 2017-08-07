package dev.floresgaming.game.utils;

import java.io.BufferedReader;
import java.io.FileReader;

/*
 * a helper class that can assist us anywhere in the game
 */

public class Utils {
	
	/*
	 * reads file from a path using the StringBuilder and FileReader and returns that string
	 */
	public static String loadFileAsString(String path){
		StringBuilder builder = new StringBuilder();
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null) builder.append(line + "\n");
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return builder.toString();
	}
	
	/*
	 * reads all of the numbers in the file and returns them as an integer.
	 */
	public static int parseInt(String number){
		try{
			return Integer.parseInt(number);
		}catch(NumberFormatException e){
			e.printStackTrace();
			return 0;
		}
	}
}
