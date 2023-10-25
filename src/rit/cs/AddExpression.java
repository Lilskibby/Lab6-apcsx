package rit.cs;

import rit.cs.Expression;

public class AddExpression implements Expression {

    private Expression left;
    private Expression right;

    public AddExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    public int evaluate(){
        return left.evaluate() + right.evaluate();
    }

    public String emit(){
        return "(" + left.emit() + " + " + right.emit() + ")";
    }
}
