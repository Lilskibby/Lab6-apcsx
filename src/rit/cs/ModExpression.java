package rit.cs;

public class ModExpression implements Expression{

    private Expression left;
    private Expression right;

    public ModExpression(Expression left, Expression right){
        this.left = left;
        this.right = right;
    }

    public int evaluate(){
        return 0;
    }

    public String emit(){
        return "";
    }
}
