/**
 * The expression interface represents a mathematical operation.
 * It is implemented by classes that represent add, divide,
 * subtract, modulus, and multiplication operations. Another represents
 * a variable, and another represents an integer.
 *
 * @author Max Klot
 */

package rit.cs;

import rit.stu.DerpException;

import java.util.ArrayList;
import java.util.HashMap;

public interface Expression {

    public int evaluate();

    public String emit();

    /**
     * Static method to parse an Expression from user input, recursively.
     * Base case: next item in input string is an integer.
     * Recursive case: next otem in input string is a mathematical operator.
     * Checks for DerpException.
     * @param strL ArrayList of type String, represents user input split by spaces(" ")
     * @param symtab A HashMap of variables provided via the file. Used to check and throw exceptions.
     * @param first A boolean value representing whether this is the first time the parse function has been called.
     * @return An expression, parsed from the user input.
     * @throws DerpException checks whether there are too many tokens, not enough tokens, or whether a variable exists.
     */
    public static Expression parse(ArrayList<String> strL, HashMap<String, Integer> symtab, boolean first) throws DerpException {
        String temp = strL.get(0);
        if(first){
            for (String str : strL
                  ) {
                if (str.matches("^[a-zA-Z].*")) {
                    if(!symtab.containsKey(str)) {
                        throw new DerpException(str + " does not exist silly!");
                    }
                }
            }
        }
        if (temp.matches("^[a-zA-Z].*")) {
            if(!symtab.containsKey(temp)) {
                throw new DerpException(temp + " does not exist silly!");
            }
        }
        int[] counter = count(strL);
        //System.out.println(counter[0]);
        //System.out.println(counter[1]);
        if(counter[0] < counter[1] - 1 && first){
            throw new DerpException("Extra tokens remain!");
        }
        if(counter[0] >= counter[1] && first){
            throw new DerpException("Not enough tokens silly!");
        }
        temp = strL.remove(0);
        return switch (temp) {
            case "+" -> new AddExpression(parse(strL, symtab, false), parse(strL, symtab, false));
            case "/" -> new DivExpression(parse(strL, symtab, false), parse(strL, symtab, false));
            case "-" -> new SubExpression(parse(strL, symtab, false), parse(strL, symtab, false));
            case "*" -> new MulExpression(parse(strL, symtab, false), parse(strL, symtab, false));
            case "%" -> new ModExpression(parse(strL, symtab, false), parse(strL, symtab, false));
            default -> {
                if (temp.matches("^[a-zA-Z].*")) {
                    yield new VariableExpression(temp, symtab.get(temp));
                }
                yield new IntExpression(Integer.parseInt(temp));
            }
        };
    }

    /**
     * The count method counts and returns how many numbers
     * and mathematical operators there are in a given arraylist
     * of Strings.
     * @param strL An arraylist of strings to iterate through.
     * @return A list of two integers, representing the number of
     * symbols and the number of integers, respectively
     */
    public static int[] count(ArrayList<String> strL){
        //System.out.println(strL);
        int symCount = 0;
        int numCount = 0;
        for(String str : strL){
            if (str.matches("^[a-zA-Z].*") || str.matches("-?\\d+(\\.\\d+)?")){
                numCount++;
            }
            else{
                symCount++;
            }

        }
        return new int[]{symCount, numCount};
    }
}
