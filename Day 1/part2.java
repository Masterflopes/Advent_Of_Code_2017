import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class part2 {

	public static void main(String[] args) {
		
		FileReader fr = null;
		BufferedReader br = null;
		String line = "";
		int jump = 0;
		
		try {
			fr = new FileReader("/home/nl/eclipse-java-workspace/Advent-of-code-2017/input.txt");
			br = new BufferedReader(fr);
			line = br.readLine();
			br.close();
			fr.close();	
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		jump = line.length() /2;
		
		int sum = 0;
		for(int i = 0; i < line.length(); i++) {
			if (Character.getNumericValue(line.charAt(i)) == Character.getNumericValue(line.charAt((i + jump) % line.length()))) {
				sum += Character.getNumericValue(line.charAt(i));
			}
		}
		System.out.println(sum);
	}

}
