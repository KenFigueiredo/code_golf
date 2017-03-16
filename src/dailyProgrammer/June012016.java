//Ken Figueiredo - https://www.reddit.com/r/dailyprogrammer/comments/4m3ddb/20160601_challenge_269_intermediate_mirror/
package dailyProgrammer;

import java.io.BufferedReader;
import java.io.IOException;

public class June012016 extends Common {
		
	private enum Direction{
		UP,DOWN,LEFT,RIGHT;	
	}
	
	private char[][] grid;
	private String encryptedString;
	private BufferedReader reader;
	
	public June012016(String fN){
		reader = loadFile(fN);
		init();
		System.out.print(encryptedString + " | " + decrypt());
	}
	
	public String decrypt(){
		String decryptedString = "";
		
		for(int i = 0; i < encryptedString.length(); i++){
			char cur = encryptedString.charAt(i);
			
			for(int j = 0; j < 15; j++){
				for(int k = 0; k < 15; k++){
					if(cur == grid[j][k]){
						decryptedString += sendLaze(j,k);
						break;
					}
				}
			}
		}
		
		return decryptedString;
	}
	
	public char sendLaze(int i, int j){
		char decrypt = 0;
		Direction dir = getDirection(i,j);
		
		do{		
			dir = checkDirection(dir, i,j);
				switch(dir){
					case UP: i--;
					break;
						
					case DOWN: i++;
					break;
						
					case LEFT: j--;
					break;
					
					case RIGHT: j++;
					break;
				}
		}while(inBounds(i,j));
		
		decrypt = grid[i][j];
		return decrypt;
	}
	
	public Direction getDirection(int i, int j){
		Direction d;
		if(i == 0) d = Direction.DOWN;
		else if(i == 14) d = Direction.UP;
		else if(j == 0) d = Direction.RIGHT;
		else d = Direction.LEFT; //if(j == 15)
		return d;
	}
	
	public Direction checkDirection(Direction d, int i, int j){
		if(grid[i][j] == '/'){
			switch(d){
				case UP: d = Direction.RIGHT;
				break;
					
				case DOWN: d = Direction.LEFT;
				break;
					
				case LEFT: d = Direction.DOWN;
				break;
				
				case RIGHT: d = Direction.UP;
				break;
			}
		}
		
		else if(grid[i][j] == 92){// '\' ->92
			switch(d){
				case UP: d = Direction.LEFT;
				break;
					
				case DOWN: d = Direction.RIGHT;
				break;
					
				case LEFT: d = Direction.UP;
				break;
				
				case RIGHT: d = Direction.DOWN;
				break;
			}
		}
		
		return d;		
	}
	
	public boolean inBounds(int i, int j){
		if(i > 0 && i < 14 && j > 0 && j < 14)
			return true;
		
		else
			return false;
	}
	
	public void init(){
		initGrid();
		readInput();
		printGrid();
	}
	
	public void initGrid(){
		grid = new char[][]{
			{' ','a','b','c','d','e','f','g','h','i','j','k','l','m',' '}, 
			{'A',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','n'},
			{'B',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','o'},
			{'C',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','p'},
			{'D',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','q'},
			{'E',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','r'},
			{'F',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','s'},
			{'G',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','t'},
			{'H',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','u'},
			{'I',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','v'},
			{'J',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','w'},
			{'K',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','x'},
			{'L',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','y'},
			{'M',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','z'},
			{' ','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',' '} 			
		};			   
	}
	
	public void readInput(){
		try {
			String line = "";			
			for(int i = 0; i < 13; i++){
				line = reader.readLine();
				for(int j = 0; j < 13; j++){			
					grid[i+1][j+1] = line.charAt(j);
				}
			}
			encryptedString = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void printGrid(){
		for(int i = 0; i < 15; i++){
			for(int j = 0; j < 15; j++){
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
	}
	

	

}
