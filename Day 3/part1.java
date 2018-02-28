
public class part1 {

	public static void main(String[] args) {
		int input = 289326;
		int number = 1;
		int x = 0, y = 0;
		int inc_x = 1, inc_y = 1;
		
		while(number != input) {
			//move right
			for(int i = 0; i < inc_x; i++) {
				number++;
				x++;
				if(number == input)
					break;
			}
			
			if(number == input)
				break;
			
			//move up
			for(int i = 0; i < inc_y; i++) {
				number++;
				y++;
				if(number == input)
					break;
			}
			
			if(number == input)
				break;
			
			inc_x++;
			inc_y++;
			
			//move left
			for(int i = 0; i < inc_x; i++) {
				number++;
				x--;
				if(number == input)
					break;
			}
			
			if(number == input)
				break;
			
			//move down
			for(int i = 0; i < inc_x; i++) {
				number++;
				y--;
				if(number == input)
					break;
			}
			
			if(number == input)
				break;
			inc_x++;
			inc_y++;
		}
		
		int distance = Math.abs(x) + Math.abs(y);
		System.out.print("Distance: ");
		System.out.print(distance);

	}

}