package rit.cs;

public class DivExpression implements Expression{

    private Expression left;
    private Expression right;

    public DivExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    public int evaluate(){
        return this.left.evaluate() / this.right.evaluate();
    }

    public String emit(){
        return "(" + left.emit() + " / " + right.emit() + ")";
    }
}
