import javafx.util.Pair;
import java.util.ArrayList;

public class part2 {

	static ArrayList <Pair<Pair<Integer,Integer>,Integer>> store = new ArrayList <Pair<Pair<Integer,Integer>,Integer>> ();
	
	
	public static int get_value(int x, int y) {
		int sum = 0;
		for(int i = 0; i < store.size(); i++) {
			if(store.get(i).getKey().getKey() == (x + 1) && store.get(i).getKey().getValue() == y) {
				sum += store.get(i).getValue().intValue();
			}
			else if(store.get(i).getKey().getKey() == (x + 1) && store.get(i).getKey().getValue() == (y + 1)) {
				sum += store.get(i).getValue().intValue();
			}
			else if(store.get(i).getKey().getKey() == x && store.get(i).getKey().getValue() == (y + 1)) {
				sum += store.get(i).getValue().intValue();
			}
			else if(store.get(i).getKey().getKey() == (x - 1) && store.get(i).getKey().getValue() == (y + 1)) {
				sum += store.get(i).getValue().intValue();
			}
			else if(store.get(i).getKey().getKey() == (x - 1) && store.get(i).getKey().getValue() == y) {
				sum += store.get(i).getValue().intValue();
			}
			else if(store.get(i).getKey().getKey() == (x - 1) && store.get(i).getKey().getValue() == (y - 1)) {
				sum += store.get(i).getValue().intValue();
			}
			else if(store.get(i).getKey().getKey() == x && store.get(i).getKey().getValue() == (y - 1)) {
				sum += store.get(i).getValue().intValue();
			}
			else if(store.get(i).getKey().getKey() == (x + 1) && store.get(i).getKey().getValue() == (y - 1)) {
				sum += store.get(i).getValue().intValue();
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int input = 289326;
		int number = 1;
		int x = 0, y = 0;
		int inc_x = 1;		
		int inc_y = 1;
		
		
		store.add(new Pair<Pair<Integer,Integer>,Integer> (new Pair<Integer,Integer> (x, y), number));
		
		
		while(number != input) {
			//move right
			for(int i = 0; i < inc_x; i++) {
				x++;
				number = get_value(x, y);
				store.add(new Pair<Pair<Integer,Integer>,Integer> (new Pair<Integer,Integer> (x, y), number));
				if(number > input)
					break;
			}
			
			if(number > input)
				break;
			
			//move up
			for(int i = 0; i < inc_y; i++) {
				y++;
				number = get_value(x, y);
				store.add(new Pair<Pair<Integer,Integer>,Integer> (new Pair<Integer,Integer> (x, y), number));
				if(number > input)
					break;
			}
			
			if(number > input)
				break;
			
			inc_x++;
			inc_y++;
			
			//move left
			for(int i = 0; i < inc_x; i++) {
				x--;
				number = get_value(x, y);
				store.add(new Pair<Pair<Integer,Integer>,Integer> (new Pair<Integer,Integer> (x, y), number));
				if(number > input)
					break;
			}
			
			if(number > input)
				break;
			
			//move down
			for(int i = 0; i < inc_x; i++) {
				y--;
				number = get_value(x, y);
				store.add(new Pair<Pair<Integer,Integer>,Integer> (new Pair<Integer,Integer> (x, y), number));
				if(number > input)
					break;
			}
			
			if(number > input)
				break;
			inc_x++;
			inc_y++;
		}
		
		System.out.print("Number: ");
		System.out.print(number);

	}

}