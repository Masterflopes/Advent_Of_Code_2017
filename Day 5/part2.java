import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class part2 {

    public static void main(String[] args) {
        FileReader fr = null;
        BufferedReader br = null;
        String line = "";
        int step = 0;
        ArrayList <Integer> store = new ArrayList<Integer> ();

        try {
            fr = new FileReader("/Users/nunolopes/IdeaProjects/AdventOfCode/input.txt");
            br = new BufferedReader(fr);

            line = br.readLine();
            while(line != null) {
                store.add(Integer.parseInt(line));
                line = br.readLine();
            }
            br.close();
            fr.close();
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }

        int copy = 0;

        for(int i = 0; i < store.size(); ){
            if(i < 0 || i >= store.size()){
                break;
            }
            else {
                copy = store.get(i);
                if(copy >= 3){
                    store.set(i, copy - 1);
                }
                else{
                    store.set(i, copy + 1);
                }
                i = i + copy;
                step++;
            }
        }

        System.out.print("Number of steps: ");
        System.out.println(step);
    }

}
