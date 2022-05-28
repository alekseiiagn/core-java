package corejava.chapter4.additional.operation;

public class Mult implements Operation{
    @Override
    public int getOperation(int a, int b) {
        return a*b;
    }
}
