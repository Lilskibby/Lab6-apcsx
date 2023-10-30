/**
 * A class that represents a Subtraction expression.
 * Implements Expression interface.
 *
 * @author Max Klot
 */
package rit.cs;

public class SubExpression implements Expression{
    private Expression left;
    private Expression right;

    /**
     * Constructor for an SubExpression object- sets private state
     * to corresponding left and right expressions.
     * @param left the left expression
     * @param right the right expression
     */
    public SubExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    //DivExpressions evaluate returns the subtraction of it's left and right
    //expressions evaluates.
    public int evaluate(){
        return this.left.evaluate() - this.right.evaluate();
    }

    //emit returns a String representation of the subtraction of the objects
    //left and right expressions.
    public String emit(){
        return "(" + left.emit() + " - " + right.emit() + ")";
    }
}
