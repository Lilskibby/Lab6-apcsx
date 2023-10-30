package rit.stu;

import rit.cs.Expression;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DYI {

    //private hashmap of variables in provided file
    private HashMap<String, Integer> hashmap;

    /**
     * main method, instatiates new DYI object and calls mainloop.
     * @param args command line arguments from main method
     * @throws IOException from reading file in DYI construction- e.g. filenotfound && endofstream
     */
    public static void main(String[] args) throws IOException {
        DYI dyi = new DYI(args);
        dyi.mainLoop();
    }


    /**
     * the mainloop is a loop that prompts the user for input.
     * Prints symbol table state, calls expressions static parse method on input,
     * and prints exception or result of operation.
     */
    public void mainLoop() {
        System.out.println("Derp Your Interpreter v2.0 :)" +
                "\nSymbol Table:");
        for (Map.Entry<String, Integer> entry : hashmap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String line = input.nextLine();
            //System.out.println(Arrays.toString(line.split(" ")));
            if (line.equals("quit")) {
                break;
            }
            ArrayList<String> newInput = new ArrayList<>();
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
        String line;
        while ((line = in.readLine()) != null) {
            String[] line1 = line.split(" ");
            hashmap.put(line1[0], Integer.parseInt(line1[1]));
        }
        file.close();
        in.close();

    }
}
