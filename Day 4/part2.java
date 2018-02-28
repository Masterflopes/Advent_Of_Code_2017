import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class part2 {

	public static boolean cmp_string(String a, String b) {
		ArrayList <Character> charA = new ArrayList <Character> ();
		ArrayList <Character> charB = new ArrayList <Character> ();
		
		for(int i = 0; i < a.length(); i++) {
			charA.add(a.charAt(i));
		}
		for(int i = 0; i < b.length(); i++) {
			charB.add(b.charAt(i));
		}
		for(int i = 0; i < charA.size(); i++) {
			for(int j = 0; j < charB.size(); j++) {
				if(charA.get(i) != ' ' && charB.get(j) != ' ') {
					if(charA.get(i) == charB.get(j)) {
						charA.set(i, ' ');
						charB.set(j, ' ');
					}
				}
			}
		}
		for(int i = 0; i < charA.size(); i++) {
			if(charA.get(i) != ' ') {
				return true;
			}
		}
		for(int i = 0; i < charB.size(); i++) {
			if(charB.get(i) != ' ') {
				return true;
			}
		}
		return false;
	}
	
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
						if(cmp_string(store.get(i),store.get(j)) == false)//store.get(i).equals(store.get(j)))
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