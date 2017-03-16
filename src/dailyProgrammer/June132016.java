//Ken Figueiredo - https://www.reddit.com/r/dailyprogrammer/comments/4nvrnx/20160613_challenge_271_easy_critical_hit/
package dailyProgrammer;

import java.io.BufferedReader;
import java.io.IOException;

public class June132016 extends Common {
	
	BufferedReader reader;
	
	public June132016(String s){
		reader = loadFile(s);
		
		try{
			int n = Integer.parseInt(reader.readLine());
			
			for(int i = 0; i < n; i++){
				String[] t = reader.readLine().split(" ");
				int dieSide = Integer.parseInt(t[0]);
				int health = Integer.parseInt(t[1]);
				double p = findProbability(dieSide, health);
				System.out.println("D: " + dieSide + " | H: " + health + " | P: " + p);		
			}
			
		}catch(IOException e){
			System.out.println("Error reading file");
		}
	}
	
	public double findProbability(double d, double h){
		
		double p = 1;
		
		if((h == 1 && d > 0) || d == 1) return p;

		if((h-d) > 0){						
			while(h > 1){		
				if(h > d)
					p *= (1/d);
				
				else
					p *= (((d-h)+1) / d);		
				
				h-=d;
			}
			return p;
		}

		else
			return (1 / d);
	
	}
	
}
