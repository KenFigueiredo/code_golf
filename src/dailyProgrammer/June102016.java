//Ken Figueiredo - https://www.reddit.com/r/dailyprogrammer/comments/4nga90/20160610_challenge_270_hard_alien_invasion/
package dailyProgrammer;

import java.io.BufferedReader;
import java.io.IOException;

public class June102016 extends Common {
	
	BufferedReader reader;
	char[][] field;
	int fieldSize, landingZone;
	int xLoc, yLoc;
	int totalZones;
		
	public June102016(String fN){
		reader = loadFile(fN);
		
		try {
			totalZones = Integer.parseInt(reader.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(int i = 1; i <= totalZones; i++){
			System.out.print("Input #" + i);
			loadField();
			System.out.println(" (" + fieldSize + "x" + fieldSize + ")");
			landingZone = findLanding();
			System.out.println((landingZone*landingZone) + " dropships!");
			System.out.println();
			//printField();
			//System.out.println("****************************************************************************************************************************************************************************");
			
		}
	}
		
	public void loadField(){
		try {
			fieldSize = Integer.parseInt(reader.readLine());
			field = new char[fieldSize][fieldSize];
			String s;
			
			for(int i = 0; i < fieldSize; i++){
				s = reader.readLine();
				for(int j = 0; j < fieldSize; j++){
					field[i][j] = s.charAt(j);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int findLanding(){
		
		int max = 0, cur;
		
		for(int i = 0; i < fieldSize; i++){
			for(int j = 0; j < fieldSize; j++){
				if(field[i][j] == '-'){
					cur = checkNeighbors(i,j);
					if(cur > max){ 
						max = cur;
						xLoc = i;
						yLoc = j;
					}
				}
			}
		}
		
		return max;
	}
	
	public int checkNeighbors(int row, int col){
		int rowLen = 0, colLen = 0, squareSize = 1;
		int i = row, j = col;
		
		while(i < fieldSize){
			if(field[i][col] == 'X') break;
			rowLen++;
			i++;
		}

		while(j < fieldSize){
			if(field[row][j] == 'X') break;
			colLen++;
			j++;
		}
		
		int minDist = Math.min(rowLen, colLen);
		
		squareLabel:
			for(i = row+1; i < row+minDist; i++){
				for(j = col+1; j < col+minDist; j++){
					if(field[i][j] == 'X') break squareLabel;
				}
				squareSize++;
			}

		return squareSize;

	}
	
	public void printField(){

		for(int i = 0; i < fieldSize; i++){
			for(int j = 0; j < fieldSize; j++){
				
				if(i == xLoc && j == yLoc){
					for(int k = i; k < xLoc + landingZone; k++){
						for(int l = j; l < yLoc + landingZone; l++){
							field[k][l] = 'O';
						}
					}	
				}
				
				System.out.print(field[i][j]);
			}
			System.out.println();
		}
	}
}
