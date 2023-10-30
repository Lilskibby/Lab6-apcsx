/**
 * A class that represents a Variable expression.
 * Implements Expression interface.
 *
 * @author Max Klot
 */
package rit.cs;

public class VariableExpression implements Expression{
    private int value;

    private String identifier;

    /**
     * Constructor for a variable expression,
     * sets private state of value and identifier from parameters
     * @param identifier String identifier for variable
     * @param value int value of variable
     */
    public VariableExpression(String identifier, int value){
        this.identifier = identifier;
        this.value = value;
    }

    //evaluate returns the value of the variable expression
    public int evaluate(){
        return value;
    }

    //emit returns the String identifier of the variable expression
    public String emit(){
        return identifier;
    }
}
