/**
 * A class that represents an Integer expression.
 * Implements Expression interface.
 *
 * @author Max Klot
 */
package rit.cs;

public class IntExpression implements Expression{
    private int value;

    /**
     * Constructor for Integer expression. Sets private state
     * to value provided.
     * @param value the value of the integer.
     */
    public IntExpression(int value){
        this.value = value;
    }

    //returns the value of the integer expression
    public int evaluate(){
        return value;
    }

    //returns a String representation of the IntExpression object's value.
    public String emit(){
        return "" + value;
    }
}
