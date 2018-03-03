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
        ArrayList <ArrayList<Integer>> save = new ArrayList<> ();

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

        int max = 0;
        int max_index = 0;
        int add_value = 0;
        boolean encontrado = false;
        int equal_state_index = 0;

        while(!encontrado) {

            save.add(store);

            for (int i = 0; i < store.size(); i++) {
                if (store.get(i) > max) {
                    max = store.get(i);
                    add_value = max;
                    max_index = i;
                }
            }
            ArrayList <Integer> store2 = new ArrayList<>(store);

            store2.set(max_index,0);

            int n;
            if(max_index + 1 == store2.size())
                n = 0;
            else{
                n = max_index + 1;
            }

            for(int i = n; i <= store2.size(); i++){
                if(add_value == 0){
                    break;
                }
                if (i == store2.size()) {
                    i = -1;
                }
                else{
                    store2.set(i,store2.get(i) + 1);
                    add_value--;
                }
            }

            for(int i = 0; i < save.size(); i++) {
                if (compare_array(save.get(i),store2)) {
                    encontrado = true;
                    equal_state_index = i;
                }
            }

            store = new ArrayList<>(store2);
            max = 0;
            step++;
        }

        System.out.print("Number of cycles: ");
        System.out.println(step - equal_state_index);
    }

    public static boolean compare_array(ArrayList<Integer> a1, ArrayList<Integer> a2){
        boolean igual = true;
        for(int i = 0; i < a1.size(); i++){
            if(a1.get(i) != a2.get(i))
                igual = false;
        }
        return igual;
    }

}
