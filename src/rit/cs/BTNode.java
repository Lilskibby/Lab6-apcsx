package rit.cs;

public class BTNode {

    private String data;
    private int value;
    private BTNode left;
    private BTNode right;
    public BTNode(String initialData, BTNode initialLeft, BTNode initialRight)
    {
        data = initialData;
        left = initialLeft;
        right = initialRight;
    }

    public BTNode(int initialData, BTNode initialLeft, BTNode initialRight)
    {
        value = initialData;
        left = initialLeft;
        right = initialRight;
    }

    public int getValue() {
        return value;
    }

    public BTNode getLeft() {
        return left;
    }

    public BTNode getRight() {
        return right;
    }

    public String getData() {
        return data;
    }
}
