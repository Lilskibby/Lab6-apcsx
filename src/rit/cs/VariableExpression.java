package rit.cs;

public class VariableExpression implements Expression{
    private int value;

    private String identifier;

    public VariableExpression(String identifier, int value){
        this.identifier = identifier;
        this.value = value;
    }

    public int evaluate(){
        return value;
    }

    public String emit(){
        return identifier;
    }
}
