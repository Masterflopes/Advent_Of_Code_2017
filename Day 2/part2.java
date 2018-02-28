import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class part2 {

	public static void main(String[] args) {
		
		int size = 16;
		FileReader fr = null;
		BufferedReader br = null;
		String line = "";
		int[][] input = new int[size][size];
		int num = 0;
		
		try {
			fr = new FileReader("/home/nl/eclipse-java-workspace/Advent-of-code-2017/input.txt");
			br = new BufferedReader(fr);
			
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					while(true) {
						num = Character.getNumericValue(br.read());
						if(num != -1) {
							line += num;
						}
						else {
							input[i][j] = Integer.parseInt(line);
							line = "";
							break;
						}
					}
				}
			}
			br.close();
			fr.close();	
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}

		int sum = 0;
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				for(int n = j + 1; n < size; n++) {
					if(input[i][j] % input[i][n] == 0) {
						sum += (input[i][j] / input[i][n]);
						break;
					}
					else if(input[i][n] % input[i][j] == 0) {
						sum += (input[i][n] / input[i][j]);
						break;
					}
				}
			}

			
		}
		System.out.println(sum);		
	}

}
