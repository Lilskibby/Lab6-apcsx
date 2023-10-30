/**
 * A class that represents an addition expression.
 * Implements Expression interface.
 *
 * @author Max Klot
 */
package rit.cs;

import rit.cs.Expression;

public class AddExpression implements Expression {

    private Expression left;
    private Expression right;

    /**
     * Constructor for an AddExpression object- sets private state
     * to corresponding left and right expressions.
     * @param left the left expression
     * @param right the right expression
     */
    public AddExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    //AddExpressions evaluate returns the sum of it's left and right
    //expressions evaluates.
    public int evaluate(){
        return left.evaluate() + right.evaluate();
    }

    //emit returns a String representation of the addition of the objects
    //left and right expressions.
    public String emit(){
        return "(" + left.emit() + " + " + right.emit() + ")";
    }
}
