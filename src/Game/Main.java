package Game;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][] board = new char[3][3];
		char player='X';
		
		for(int row=0;row<3;row++){
			for(int col=0;col<3;col++) {
				board[row][col]=' ';
			}
		}
		printBoard(board);
		boolean gameOver=false;
		
		Scanner sc=new Scanner(System.in);
		int ctr=0;
		
		while(!gameOver) {
			System.out.println("Enter row and column");
			int row=sc.nextInt();
			int col=sc.nextInt();
			
			
			if(row>=0 && row<3 && col >=0 && col<3 && board[row][col]==' ') {
				board[row][col]=player;
				gameOver = checkStatus(board,player);
				printBoard(board);
				if(gameOver) {
					System.out.println("Player "+player+" won" );
					break;
				}
				ctr++;
				player= player=='X' ?'O':'X';
			}
			else {
				System.out.println("Wrong input try again");
			}
			if(ctr>=9) {
				System.out.println("Game Draw");
             break;
			}
			
		}
			

	}

	private static void printBoard(char[][] board) {
		
		for(int row=0;row<3;row++) {
			for(int col=0;col<3;col++) {
				System.out.print(board[row][col]+"|");
			}
			System.out.println("");
		}
		
	}

	private static boolean checkStatus(char[][] board, char player) {
		
		for(int row=0;row<3;row++) {
			if(board[row][0]==player && board[row][1]==player && board[row][2]==player) {
				return true;
			}
		}
		
		
		for(int col=0;col<3;col++) {
			if(board[0][col]==player && board[1][col]==player && board[2][col]==player) {
				return true;
			}
		}
		
		if(board[0][0]==player && board[1][1]==player && board[2][2]==player) {
			return true;
		}
		if(board[0][2]==player && board[1][1]==player && board[2][0]==player) {
			return true;
		}
		
		
		return false;
	}

}
