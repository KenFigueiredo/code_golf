package dailyProgrammer;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class June062016 extends Common {
	
	BufferedReader reader;
	
	public June062016(String fN){
		reader = loadFile(fN);
		int maxLen = 0;
		
		try {
			ArrayList<String> lines = new ArrayList<String>();
			
			while(reader.ready()){
				String s = reader.readLine();
				lines.add(s);
				if(s.length() > maxLen) maxLen = s.length();
			}
			
			char array[][];
			
			for(int i = 0; i < lines.size(); i++){
				System.out.println(lines.get(i));
			}
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
