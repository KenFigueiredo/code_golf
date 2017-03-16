//Ken Figueiredo - https://www.reddit.com/r/dailyprogrammer/comments/4lpygb/20160530_challenge_269_easy_basic_formatting/
package dailyProgrammer;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class May302016 extends Common {
	ArrayList<String> identifiers, operations;
	BufferedReader reader; 
	String fileName;
	
	public May302016(String fN){
		fileName = fN;
		reader = loadFile(fileName);
		initIdentifiers();
		
		try {
			boolean status = fixFormat();
			if(!status){
				System.out.println("ERROR: Misaligned logic keywords");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean fixFormat() throws IOException{
		if(reader != null){
			int n = Integer.parseInt(reader.readLine());
			int tabDistance = 0;
			
			for(int i = 0; i <= n; i++){
				String line = reader.readLine();
				line = line.replace("·", "");
				line = line.replace("»", "");
				
				if(decreaseTab(line)) tabDistance--;
				
				String tabbedLine = tabSize(tabDistance) + line;
				if(!line.equals("")) System.out.println(tabbedLine);	
				
				if(increaseTab(line)) tabDistance++;
				if(tabDistance < 0)return false;
				
			}
		}	
		return true;
	}
	
	public String tabSize(int tab){	
		String s = "";	
		for(int i = 0; i < tab; i++){
			s += "    ";
		}
		return s;
	}
	
	public boolean increaseTab(String s){
		String[] str = s.split("\\s+");
		if(identifiers.contains(str[0])){
			if(!str[0].equals("VAR") && !str[0].equals("ENDIF") && !str[0].equals("NEXT"))
				return true;
		}
		return false;		
	}
	
	public boolean decreaseTab(String s){
		String[] str = s.split("\\s+");
		if(identifiers.contains(str[0])){
			if(str[0].equals("ENDIF") || str[0].equals("NEXT")){
				return true;
			}
		}
		return false;		
	}
	
	public void initIdentifiers(){
		identifiers = new ArrayList<String>();
		identifiers.add("IF");
		identifiers.add("FOR");
		identifiers.add("VAR");
		identifiers.add("ENDIF");
		identifiers.add("NEXT");
	}
}

