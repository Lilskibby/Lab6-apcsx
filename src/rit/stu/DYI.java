package rit.stu;
import rit.cs.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class DYI {
    public static void main(String[] args) throws FileNotFoundException {
        DYI dyi = new DYI();
        dyi.mainLoop(args);
    }

    public void mainLoop(String[] args) throws FileNotFoundException {
        HashMap<String, Integer> hashmap = parseFile(args);
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
    }
    public HashMap<String, Integer> parseFile(String[] args) throws FileNotFoundException {
        if (args.length == 0) {
            System.out.println("No file argument provided.");
            System.exit(1);
        }
        HashMap<String, Integer> hashmap = new HashMap<>();
        File file = null;
        try {
            file = new File(args[0]);
        } catch (Exception f) {
            System.out.println(f.getMessage());
            System.exit(1);
        }
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            String[] line = scan.nextLine().split(" ");
            hashmap.put(line[0], Integer.parseInt(line[1]));
        }
        return hashmap;
    }
}
