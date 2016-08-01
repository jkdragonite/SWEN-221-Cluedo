package ui;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextClient {

	public static void main(String args[]){
		Board board = new Board();
		boolean start = true;
		boolean gameInProgress = true;
		while (gameInProgress == true){

			Scanner in = new Scanner(System.in);			
						
			if (start){
				System.out.println("Welcome to Cluedo");
				System.out.println("Please select and action");
				System.out.println("1) Show Board");
				System.out.println("2) Move Player");
				System.out.println("3) Close Game");
				start = false;
			}
			
			int num = in.nextInt();
			
			if (num == 1){
				System.out.println(board.toString());
			}
			
			if (num == 3){
				gameInProgress = false;
			}
			
		}
	}
	
	
	
	

}
