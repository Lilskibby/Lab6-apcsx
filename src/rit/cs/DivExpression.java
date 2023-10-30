/**
 * A class that represents a Division expression.
 * Implements Expression interface.
 *
 * @author Max Klot
 */
package rit.cs;

public class DivExpression implements Expression{

    private Expression left;
    private Expression right;


    /**
     * Constructor for a DivExpression object- sets private state
     * to corresponding left and right expressions.
     * @param left the left expression
     * @param right the right expression
     */
    public DivExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    //DivExpressions evaluate returns the quotient of it's left and right
    //expressions evaluates.
    public int evaluate(){
        return this.left.evaluate() / this.right.evaluate();
    }

    //emit returns a String representation of the division of the objects
    //left and right expressions.
    public String emit(){
        return "(" + left.emit() + " / " + right.emit() + ")";
    }
}
