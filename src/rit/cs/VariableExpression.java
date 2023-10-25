package rit.cs;

public class VariableExpression implements Expression{
    private Expression left;
    private Expression right;

    private String identifier;

    public VariableExpression(String identifier, Expression left, Expression right){
        this.identifier = identifier;
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
