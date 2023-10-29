package rit.stu;
import rit.cs.*;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class DYI {

    private HashMap<String, Integer> hashmap;
    public static void main(String[] args) throws IOException {
        DYI dyi = new DYI(args);
        dyi.mainLoop(args);
    }


    public void mainLoop(String[] args) throws FileNotFoundException {
        System.out.println("Derp Your Interpreter v2.0 :)" +
                "\nSymbol Table:");
        for (Map.Entry<String, Integer> entry : hashmap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        boolean flag = false, otherFlag = false;
        Scanner input = new Scanner(System.in);
        while (!flag) {
            System.out.print("> ");
            String line = input.nextLine();
            //System.out.println(Arrays.toString(line.split(" ")));
            if (line.equals("quit")) {
                break;
            }
            ArrayList<String> newInput = new ArrayList<String>();
            Collections.addAll(newInput, (line.split(" ")));
            //System.out.println(newInput);
            try {
                Expression root = Expression.parse(newInput, hashmap, true);
                System.out.println("Emit: " + root.emit());
                System.out.println("Evaluate: " + root.evaluate());
            } catch (DerpException d) {
                System.out.println(d.getMessage());
            }
        }
        System.out.println("byee");
    }
    public DYI(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("No file argument provided.");
            System.exit(1);
        }
        hashmap = new HashMap<>();
        FileReader file = null;
        try {
            file = new FileReader(args[0]);
        } catch (Exception f) {
            System.out.println(f.getMessage());
            System.exit(1);
        }
        BufferedReader in = new BufferedReader(file);
        String line = "";
        while ((line = in.readLine()) != null) {
            String[] line1 = line.split(" ");
            hashmap.put(line1[0], Integer.parseInt(line1[1]));
        }
        file.close();
        in.close();

    }
}
