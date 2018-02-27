import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class part1 {

	public static void main(String[] args) {
		
		FileReader fr = null;
		BufferedReader br = null;
		String line = "";
		
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
		
		int sum = 0;
		for(int i = 0; i < line.length(); i++) {
			if(i == line.length()-1) {
				if(Character.getNumericValue(line.charAt(i)) == Character.getNumericValue(line.charAt(0))) {
					sum += Character.getNumericValue(line.charAt(i));
				}
			}
			else {
				if (Character.getNumericValue(line.charAt(i)) == Character.getNumericValue(line.charAt(i + 1))) {
					sum += Character.getNumericValue(line.charAt(i));
				}
			}
		}
		System.out.println(sum);
	}

}
