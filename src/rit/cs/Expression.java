package rit.cs;

import rit.stu.DerpException;

import java.util.ArrayList;
import java.util.HashMap;

public interface Expression {

    public int evaluate();

    public String emit();


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
