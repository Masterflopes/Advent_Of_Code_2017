import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class part1 {

	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		String line = "";
		String buf = "";
		int sum = 0;
		ArrayList <String> store = new ArrayList<String> ();
		boolean igual = false;
		
		try {
			fr = new FileReader("/home/nl/eclipse-java-workspace/Advent-of-code-2017/src/input.txt");
			br = new BufferedReader(fr);
			
			line = br.readLine();
			while(line != null) {
				for(int i = 0; i < line.length(); i++) {
					if(line.charAt(i) != ' ' && (i < line.length() -1)) {
						buf += line.charAt(i);
					}
					else if(i == line.length() - 1) {
						buf += line.charAt(i);
						store.add(buf);
						buf = "";
					}
					else {
						store.add(buf);
						buf = "";
					}
				}
				for(int i = 0; i < store.size(); i++) {
					for(int j = i + 1; j < store.size(); j++) {
						if(store.get(i).equals(store.get(j)))
							igual = true;
					}
				}
				if(igual == false)
					sum++;
				
				store = new ArrayList<String> ();
				igual = false;
				buf = "";
				line = br.readLine();
			}
			br.close();
			fr.close();
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.print("Number of valid passphrases: ");
		System.out.println(sum);
	}

}
