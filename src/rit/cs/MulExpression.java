/**
 * A class that represents a multiplication expression.
 * Implements Expression interface.
 *
 * @author Max Klot
 */
package rit.cs;

public class MulExpression implements Expression{

    private Expression left;
    private Expression right;

    /**
     * Constructor for a MulExpression object- sets private state
     * to corresponding left and right expressions.
     * @param left the left expression
     * @param right the right expression
     */
    public MulExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    //DivExpressions evaluate returns the product of it's left and right
    //expressions evaluates.
    public int evaluate(){
        return this.left.evaluate() * this.right.evaluate();
    }

    //emit returns a String representation of the multiplication of the objects
    //left and right expressions.
    public String emit(){
        return "(" + left.emit() + " * " + right.emit() + ")";
    }
}
