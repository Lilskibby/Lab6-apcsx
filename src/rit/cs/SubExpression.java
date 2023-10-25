package rit.cs;

public class SubExpression implements Expression{
    private Expression left;
    private Expression right;

    public SubExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    public int evaluate(){
        return this.left.evaluate() - this.right.evaluate();
    }

    public String emit(){
        return "(" + left.emit() + " - " + right.emit() + ")";
    }
}
